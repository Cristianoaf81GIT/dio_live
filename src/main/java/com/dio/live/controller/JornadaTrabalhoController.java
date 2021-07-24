package com.dio.live.controller;

import com.dio.live.dto.JornadaTrabalhoDTO;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import com.dio.live.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;


    @GetMapping()
    public List<JornadaTrabalho> listarJornadas() {
        return this.jornadaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getJornada(@PathVariable("id") long id) {
        JornadaTrabalho jornada = this.jornadaService.getById(id);
        if (jornada == null)
            return new ResponseEntity<>(
                    Messages.JORNADA_NAO_ENCONTRADA,
                    HttpStatus.NOT_FOUND
            );
        return new ResponseEntity<>(jornada,HttpStatus.OK);
    }

    @PostMapping()
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalhoDTO jornada) {
        return this.jornadaService.save(jornada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJornada(
            @RequestBody JornadaTrabalhoDTO jornada,
            @PathVariable(value = "id") long id
    ) {
        JornadaTrabalho jornadaAtualizada = this.jornadaService.update(jornada,id);
        if (jornadaAtualizada == null) {
            return new ResponseEntity<>(
                    Messages.JORNADA_NAO_ENCONTRADA,
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(jornadaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJornada(@PathVariable(value="id") long id) {
        this.jornadaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
