package com.dio.live.config.exceptions;

import java.io.Serializable;

public class OcorrenciaException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public OcorrenciaException() {
        super();
    }

    public OcorrenciaException(String message) {
        super(message);
    }

    public OcorrenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcorrenciaException(Throwable cause) {
        super(cause);
    }

    protected OcorrenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
