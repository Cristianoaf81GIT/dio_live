package com.dio.live.config.exceptions;

import java.io.Serializable;

public class CategoriaUsuarioException extends RuntimeException  implements Serializable {

    private static final long serialVersionUID = 1L;

    public CategoriaUsuarioException() {
    }

    public CategoriaUsuarioException(String message) {
        super(message);
    }

    public CategoriaUsuarioException(Throwable cause) {
        super(cause);
    }

    public CategoriaUsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoriaUsuarioException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
