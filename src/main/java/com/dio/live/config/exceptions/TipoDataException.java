package com.dio.live.config.exceptions;

import java.io.Serializable;

public class TipoDataException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public TipoDataException() {
    }

    public TipoDataException(String message) {
        super(message);
    }

    public TipoDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public TipoDataException(Throwable cause) {
        super(cause);
    }

    public TipoDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
