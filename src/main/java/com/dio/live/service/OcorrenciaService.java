package com.dio.live.service;

import com.dio.live.config.exceptions.OcorrenciaException;
import com.dio.live.dto.OcorrenciaDTO;
import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    private String notFoundMessage = "O elemento com id %d não foi encontrado";

    @Autowired
    private OcorrenciaRepository repository;

    @Autowired
    ModelMapper mapper;

    public List<Ocorrencia> getAll() {
        List<Ocorrencia> ocorrencias = repository.findAll();
        return ocorrencias;
    }

    public Ocorrencia save(OcorrenciaDTO dto) {
        Ocorrencia newOcorrencia = converteToEntity(dto);
        return this.repository.save(newOcorrencia);
    }

    public Ocorrencia getById(Long id) {
        Optional<Ocorrencia> opt = repository.findById(id);
        if (opt.isEmpty())
            ThrowOcorrenciaException(opt,id);
        return opt.get();
    }

    public Ocorrencia update(Long id, OcorrenciaDTO dto) {
        Optional<Ocorrencia> opt = repository.findById(id);
        if (opt.isEmpty())
            ThrowOcorrenciaException(opt,id);
        Ocorrencia update = opt.get();
        update.setNome(dto.getNome());
        update.setDescricao(dto.getDescricao());
        return repository.save(update);
    }

    public void remove(Long id) {
        Optional<Ocorrencia> opt = repository.findById(id);
        if (opt.isEmpty())
            ThrowOcorrenciaException(opt,id);
        repository.deleteById(id);
    }

    private Ocorrencia converteToEntity(OcorrenciaDTO dto) {
        Ocorrencia ocorrencia = mapper.map(dto, Ocorrencia.class);
        return  ocorrencia;
    }

    private OcorrenciaDTO convertToDTO(Ocorrencia ocorrencia) {
        OcorrenciaDTO dto = mapper.map(ocorrencia, OcorrenciaDTO.class);
        return dto;
    }

    private void ThrowOcorrenciaException(Optional<Ocorrencia> opt, Long id) {
        String message = String.format(notFoundMessage, id);
        opt.orElseThrow(() -> new OcorrenciaException(message));
    }
}
