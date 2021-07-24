package com.dio.live.service;

import com.dio.live.config.exceptions.JornadaException;
import com.dio.live.dto.JornadaTrabalhoDTO;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class JornadaService {

    private JornadaRepository jornadaRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    private String notFoundMessage = "O elemento com id %d não foi encontrado";

    public JornadaTrabalho save(JornadaTrabalhoDTO jornadaTrabalho) {
        JornadaTrabalho jornada = this.convertToEntity(jornadaTrabalho);
        return this.jornadaRepository.save(jornada);
    }

    public JornadaTrabalho update(JornadaTrabalhoDTO jornadaTrabalho, long id) {
        Optional<JornadaTrabalho> opt = this.jornadaRepository
                .findById(id);
        if (opt.isEmpty()) {
            ThrowJornadaException(opt, id);
        }
        JornadaTrabalho jornadaAtualizacao = opt.get();
        jornadaAtualizacao.setDescricao(jornadaTrabalho.getDescricao());
        return this.jornadaRepository.save(jornadaAtualizacao);
    }

    public void delete(long id) {
        Optional<JornadaTrabalho> opt = this.jornadaRepository
                .findById(id);
        if (opt.isEmpty()) {
            ThrowJornadaException(opt, id);
        }
        this.jornadaRepository.deleteById(id);
    }

    public List<JornadaTrabalho> list() {
        List<JornadaTrabalho> lista = this.jornadaRepository.findAll();
        return lista;
    }

    public JornadaTrabalho getById(long id) {
        Optional<JornadaTrabalho> opt = this.jornadaRepository.findById(id);
        if (opt.isEmpty()) {
            ThrowJornadaException(opt, id);
        }
        return opt.get();
    }

    private JornadaTrabalho convertToEntity(JornadaTrabalhoDTO dto) {
        JornadaTrabalho jornadaTrabalho = this.mapper.map(dto, JornadaTrabalho.class);
        return jornadaTrabalho;
    }

    private JornadaTrabalhoDTO convertToDTO(JornadaTrabalho jornada) {
        JornadaTrabalhoDTO dto = this.mapper.map(jornada,JornadaTrabalhoDTO.class);
        return dto;
    }

    private void ThrowJornadaException(Optional<JornadaTrabalho> opt, Long id) {
        Supplier<JornadaException> jornadaExceptionSupplier = () -> {
          String message = String.format(notFoundMessage, id);
          return new JornadaException(message);
        };
        opt.orElseThrow(jornadaExceptionSupplier);
    }
}
