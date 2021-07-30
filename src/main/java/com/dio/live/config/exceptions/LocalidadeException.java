package com.dio.live.config.exceptions;

import java.io.Serializable;

public class LocalidadeException extends RuntimeException implements Serializable {
      private static final long serialVersionUID = 1L;

      public LocalidadeException() {
        super();
      } 

      public LocalidadeException(String message) {
        super(message);
      }
    
      public LocalidadeException(String message, Throwable cause) {
        super(message, cause);
      }
    

      public LocalidadeException(Throwable cause) {
        super(cause);
      }

      protected LocalidadeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
      }
}

