package com.dio.live.config.exceptions;

import java.io.Serializable;

public class EmpresaException extends RuntimeException implements Serializable {
   
     private static final long serialVersionUID = 1L; 
  
     public EmpresaException() {
        super();
     }

     public EmpresaException(String message) {
        super(message);
     }

     public EmpresaException(String message, Throwable cause) {
        super(message, cause);
     }

     public EmpresaException(Throwable cause) {
        super(cause);
     }

     protected EmpresaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
     } 
  
}
