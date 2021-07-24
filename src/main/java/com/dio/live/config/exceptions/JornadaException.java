package com.dio.live.config.exceptions;

import java.io.Serializable;

public class JornadaException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = -7984910529869048018L;

    public JornadaException() {
        super();
    }

    public JornadaException(String message) {
        super(message);
    }

    public JornadaException(String message, Throwable cause) {
        super(message, cause);
    }

    public JornadaException(Throwable cause) {
        super(cause);
    }

    protected JornadaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
