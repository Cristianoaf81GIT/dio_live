package com.dio.live.controller;

import java.util.List;

import com.dio.live.dto.NivelAcessoDTO;
import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/niveisacesso")
public class NivelAcessoController {
    
    @Autowired
    private NivelAcessoService service;


    @PostMapping 
    public NivelAcesso create(@RequestBody NivelAcessoDTO dto){
        return service.create(dto);
    }
    
    @PutMapping("/{id}")
    public NivelAcesso update(@PathVariable Long id, @RequestBody NivelAcessoDTO dto) {
        return service.update(id, dto);
    }  

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public NivelAcesso getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping("/lista")
    public List<NivelAcesso> getAll() {
        return service.getAll();
    }

}
