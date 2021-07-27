package com.dio.live.controller;

import com.dio.live.dto.EmpresaDTO;
import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    
    @Autowired
    private EmpresaService service;


    @PostMapping
    public Empresa create(@RequestBody EmpresaDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")    
    public Empresa getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Empresa> getEmpresas() {
        return service.getAll();
    }
    
    @PutMapping("/{id}") 
    public Empresa update(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        return service.update(id,dto);        
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
