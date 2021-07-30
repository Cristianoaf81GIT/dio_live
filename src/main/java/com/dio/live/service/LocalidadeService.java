package com.dio.live.service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.List;

import com.dio.live.config.exceptions.LocalidadeException;
import com.dio.live.config.exceptions.NivelAcessoException;
import com.dio.live.dto.LocalidadeDTO;
import com.dio.live.model.Localidade;
import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.repository.NivelAcessoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService {
    
    @Autowired
    private LocalidadeRepository repository;

    @Autowired
    private NivelAcessoRepository nivelacessoRepo;

    @Autowired
    private ModelMapper mapper;

    private String notFoundMessage = "O elemento com id %d não foi encontrado";
    private String nivelAcessoNotFoundMessage = "O nível de acesso com o id %d não foi encontrado";
    
    public Localidade create(LocalidadeDTO dto) {
        Localidade localidade = convertToEntity(dto);
        return repository.save(localidade);
    }

    public Localidade update(Long id, LocalidadeDTO dto) {
        Optional<Localidade> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ThrowLocalidadeException(opt, id);
        }

        Localidade atualizar = opt.get();
        atualizar.setDescricao(dto.getDescricao());
        Optional<NivelAcesso> nivelacessoOpt = nivelacessoRepo.findById(dto.getNivelAcessoId());
        if (nivelacessoOpt.isEmpty()) {
            ThrowNivelAcessoException(nivelacessoOpt,dto.getNivelAcessoId()); 
        }
        atualizar.setNivelAcesso(nivelacessoOpt.get());
        return repository.save(atualizar);
    }

    public List<Localidade> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        Optional<Localidade> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ThrowLocalidadeException(opt, id);
        }
        repository.deleteById(id);
    }

    public Localidade getById(Long id) {
        Optional<Localidade> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ThrowLocalidadeException(opt, id);
        }

        return opt.get();
    }


    private Localidade convertToEntity(LocalidadeDTO dto) {
        Localidade localidade = this.mapper.map(dto, Localidade.class);
        return localidade;
    }

    private LocalidadeDTO convertToDTO(Localidade localidade) {
        LocalidadeDTO dto = this.mapper.map(localidade,LocalidadeDTO.class);
        return dto;
    }

    private void ThrowLocalidadeException(Optional<Localidade> opt, Long id) {
        Supplier<LocalidadeException> localidadeExceptionSupplier = () -> {
          String message = String.format(notFoundMessage, id);
          return new LocalidadeException(message);
        };
        opt.orElseThrow(localidadeExceptionSupplier);
    }

    private void ThrowNivelAcessoException(Optional<NivelAcesso> opt, Long id) {
        String message = String.format(nivelAcessoNotFoundMessage, id);
        opt.orElseThrow(() -> new NivelAcessoException(message));
    }


}
