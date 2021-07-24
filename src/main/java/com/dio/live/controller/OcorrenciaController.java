package com.dio.live.controller;

import com.dio.live.dto.OcorrenciaDTO;
import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    OcorrenciaService service;

    @GetMapping
    public List<Ocorrencia> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Ocorrencia create(@RequestBody OcorrenciaDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public Ocorrencia getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Ocorrencia update(@PathVariable Long id, @RequestBody OcorrenciaDTO dto) {
        return service.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
