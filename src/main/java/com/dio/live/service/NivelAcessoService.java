package com.dio.live.service;

import java.util.Optional;
import java.util.List;

import com.dio.live.config.exceptions.NivelAcessoException;
import com.dio.live.dto.NivelAcessoDTO;
import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelAcessoService {

    private String notFoundMessage = "O elemento com id %d não foi encontrado";

    @Autowired 
    private NivelAcessoRepository repository;
    @Autowired 
    private ModelMapper mapper;

    public NivelAcesso create(NivelAcessoDTO dto) {
        NivelAcesso novo = converteToEntity(dto);
        return repository.save(novo);
    } 

    public NivelAcesso update(Long id, NivelAcessoDTO dto) {
        Optional<NivelAcesso> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ThrowNivelAcessoException(opt, id);
        }
        NivelAcesso atualizar = opt.get();
        atualizar.setDescricao(dto.getDescricao());
        return repository.save(atualizar);
    }

    public void delete(Long id) {
        Optional<NivelAcesso> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ThrowNivelAcessoException(opt, id);
        }
        repository.deleteById(id);
    }

    public NivelAcesso getOne(Long id) {
        Optional<NivelAcesso> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ThrowNivelAcessoException(opt, id);
        }
        return repository.findById(id).get();
    }

    public List<NivelAcesso> getAll() {
        return repository.findAll();
    }

    private NivelAcesso converteToEntity(NivelAcessoDTO dto) {
        NivelAcesso nivelAcesso = mapper.map(dto, NivelAcesso.class);
        return  nivelAcesso;
    }

    private NivelAcessoDTO convertToDTO(NivelAcesso nivelAcesso) {
        NivelAcessoDTO dto = mapper.map(nivelAcesso, NivelAcessoDTO.class);
        return dto;
    }

    private void ThrowNivelAcessoException(Optional<NivelAcesso> opt, Long id) {
        String message = String.format(notFoundMessage, id);
        opt.orElseThrow(() -> new NivelAcessoException(message));
    }

}
