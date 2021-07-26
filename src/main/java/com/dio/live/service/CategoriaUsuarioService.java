package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.config.exceptions.CategoriaUsuarioException;
import com.dio.live.dto.CategoriaUsuarioDTO;
import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaUsuarioService {
    private String notFoundMessage = "O elemento com id %d não foi encontrado";

    @Autowired
    private CategoriaUsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<CategoriaUsuario> getAll() {
        return repository.findAll();
    }

    public CategoriaUsuario getById(Long id) {
        Optional<CategoriaUsuario> opt = repository.findById(id);
        if (opt.isEmpty()) 
            ThrowCategoriaUsuarioException(opt, id);
        return opt.get();
    }

    public CategoriaUsuario create(CategoriaUsuarioDTO dto) {
        CategoriaUsuario cat = converteToEntity(dto);
        return repository.save(cat);
    }
    
    public CategoriaUsuario update(Long id, CategoriaUsuarioDTO dto) {
        Optional<CategoriaUsuario> opt = repository.findById(id);
        if (opt.isEmpty())
            ThrowCategoriaUsuarioException(opt, id);
        CategoriaUsuario atualizacao = opt.get();
        atualizacao.setDescricao(dto.getDescricao());
        return repository.save(atualizacao);
    }

    public void delete(Long id) {
        Optional<CategoriaUsuario> opt = repository.findById(id);
        if (opt.isEmpty())
            ThrowCategoriaUsuarioException(opt, id);
        repository.deleteById(id);
    }

    private CategoriaUsuario converteToEntity(CategoriaUsuarioDTO dto) {
        CategoriaUsuario CategoriaUsuario = mapper.map(dto, CategoriaUsuario.class);
        return  CategoriaUsuario;
    }

    private CategoriaUsuarioDTO convertToDTO(CategoriaUsuario CategoriaUsuario) {
        CategoriaUsuarioDTO dto = mapper.map(CategoriaUsuario, CategoriaUsuarioDTO.class);
        return dto;
    }

    private void ThrowCategoriaUsuarioException(Optional<CategoriaUsuario> opt, Long id) {
        String message = String.format(notFoundMessage, id);
        opt.orElseThrow(() -> new CategoriaUsuarioException(message));
    }
}
