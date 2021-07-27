package com.dio.live.service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.List;

import com.dio.live.config.exceptions.EmpresaException;
import com.dio.live.dto.EmpresaDTO;
import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpresaService {

    private String notFoundMessage = "O elemento com id %d não foi encontrado";

    @Autowired    
    private EmpresaRepository repository;

    @Autowired
    private ModelMapper mapper;


    public Empresa create(EmpresaDTO dto) {
        Empresa empresa = convertToEntity(dto);
        return repository.save(empresa);
    }
    
    public Empresa getById(Long id) {
        Optional<Empresa> opt = repository.findById(id);
        if (opt.isEmpty())
                ThrowEmpresaException(opt,id);
        return opt.get();
    }

    public List<Empresa> getAll() {
        return repository.findAll();
    }

    public Empresa update(Long id, EmpresaDTO dto) {
        Optional<Empresa> opt = repository.findById(id);
        if (opt.isEmpty())
                ThrowEmpresaException(opt, id);
        Empresa atualizar = opt.get();
        atualizar.setDescricao(dto.getDescricao());
        atualizar.setCnpj(dto.getCnpj());
        atualizar.setEndereco(dto.getEndereco());
        atualizar.setBairro(dto.getBairro());
        atualizar.setCidade(dto.getCidade());
        atualizar.setEstado(dto.getEstado());
        atualizar.setTelefone(dto.getTelefone());
        return repository.save(atualizar);

    }


    public void delete(Long id) {
        Optional<Empresa> opt = repository.findById(id);
        if (opt.isEmpty())
                ThrowEmpresaException(opt,id);
        repository.deleteById(id);
    }

    private Empresa convertToEntity(EmpresaDTO dto) {
        Empresa empresa = this.mapper.map(dto, Empresa.class);
        return empresa;
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        EmpresaDTO dto = this.mapper.map(empresa,EmpresaDTO.class);
        return dto;
    }

    private void ThrowEmpresaException(Optional<Empresa> opt, Long id) {
        Supplier<EmpresaException> empresaSupplier = () -> {
          String message = String.format(notFoundMessage, id);
          return new EmpresaException(message);
        };
        opt.orElseThrow(empresaSupplier);
    }



}
