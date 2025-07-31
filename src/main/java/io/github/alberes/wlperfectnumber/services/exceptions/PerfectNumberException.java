package io.github.alberes.wlperfectnumber.services.exceptions;

import io.github.alberes.wlperfectnumber.controllers.exceptions.dto.FieldErrorDto;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumberException extends RuntimeException{

    private List<FieldErrorDto> fields;

    public PerfectNumberException(String msg) {
        super(msg);
    }

    public PerfectNumberException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PerfectNumberException(String msg, List<FieldErrorDto> fields) {
        super(msg);
        this.fields = fields;
    }

    public List<FieldErrorDto> getFields() {
        if(this.fields == null){
            fields = new ArrayList<FieldErrorDto>();
        }
        return fields;
    }

}