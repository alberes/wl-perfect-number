package io.github.alberes.wlperfectnumber.controllers.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

@Schema(name = "StandardError")
public class StandardErrorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

    private List<FieldErrorDto> fields;

    public StandardErrorDto() {
    }

    public StandardErrorDto(Long timestamp, Integer status, String error, String message, String path, List<FieldErrorDto> fields) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fields = fields;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FieldErrorDto> getFields() {
        return fields;
    }

    public void setFields(List<FieldErrorDto> fields) {
        this.fields = fields;
    }
}