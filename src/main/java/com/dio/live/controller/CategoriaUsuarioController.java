package com.dio.live.controller;

import java.util.List;

import com.dio.live.dto.CategoriaUsuarioDTO;
import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;

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
@RequestMapping("/categorias")
public class CategoriaUsuarioController {
    @Autowired
    CategoriaUsuarioService service;


    @GetMapping
    public List<CategoriaUsuario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CategoriaUsuario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuarioDTO dto) {
        return service.create(dto);
    }
    
    @PutMapping("/{id}")
    public CategoriaUsuario update(@PathVariable Long id, @RequestBody CategoriaUsuarioDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
