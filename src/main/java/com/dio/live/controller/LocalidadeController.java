package com.dio.live.controller;

import java.util.List;

import com.dio.live.dto.LocalidadeDTO;
import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    private LocalidadeService service;

    @PostMapping()
    public Localidade create(@RequestBody LocalidadeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Localidade update(@PathVariable Long id, @RequestBody LocalidadeDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/lista")
    public List<Localidade> getAll() {
        return service.getAll();
    } 
    
    @GetMapping("/{id}")
    public Localidade getOne(@PathVariable Long id) {
        return service.getById(id);
    }

}

