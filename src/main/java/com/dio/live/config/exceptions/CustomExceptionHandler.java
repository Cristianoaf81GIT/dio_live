package com.dio.live.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;


@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(JornadaException.class)
    public ResponseEntity<DefaultError> jornadaError(
            JornadaException e,
            HttpServletResponse resp
    ){
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(OcorrenciaException.class)
    public ResponseEntity<DefaultError> ocorrenciaError(
        OcorrenciaException e,
        HttpServletResponse resp
    ) {
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(TipoDataException.class)
    public ResponseEntity<DefaultError> TipoDataError(
            TipoDataException e,
            HttpServletResponse resp
    ) {
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CategoriaUsuarioException.class)
    public ResponseEntity<DefaultError> categoriaUsuarioError(
            CategoriaUsuarioException e,
            HttpServletResponse resp
    ) {
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }
   
    @ExceptionHandler(EmpresaException.class)
    public ResponseEntity<DefaultError> EmpresaError(
                    EmpresaException e, 
                    HttpServletResponse response
    ) {
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NivelAcessoException.class)
    public ResponseEntity<DefaultError> nivelAcessoError(
                    NivelAcessoException e, 
                    HttpServletResponse response
    ) {
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(LocalidadeException.class)
    public ResponseEntity<DefaultError> LocalidadeError(
                    LocalidadeException e, 
                    HttpServletResponse response
    ) {
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = e.getMessage();
        Long timeStamp = Instant.now().getEpochSecond();
        DefaultError error = new DefaultError(status,message,timeStamp);
        return ResponseEntity.status(status).body(error);
    }
}
