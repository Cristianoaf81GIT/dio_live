package com.dio.live.config.exceptions;

import java.io.Serializable;

public class NivelAcessoException extends RuntimeException implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public NivelAcessoException() {
        super();
    }

    public NivelAcessoException(String message) {
        super(message);
    }

    public NivelAcessoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NivelAcessoException(Throwable cause) {
        super(cause);
    }

    protected NivelAcessoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
