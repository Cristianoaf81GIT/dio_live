package com.dio.live.config.exceptions;

import java.io.Serializable;

public class DefaultError implements Serializable {

    private static final long serialVersionUID = -9026918710358417494L;

    private Integer status;
    private String message;
    private Long timeStamp;

    public DefaultError(Integer status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
