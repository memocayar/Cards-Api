package com.example.Cards.Api.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){

        super(message);
    }
    /**
    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String heading; // nombre del campo
    private String value; // valor del campo

    public ResourceNotFoundException(String resourceName, String heading, String value) {
        super(String.format("%s No encontrado : %s : '%s'", resourceName,heading,value));
        this.resourceName = resourceName;
        this.heading = heading;
        this.value = value;
    }**/
}