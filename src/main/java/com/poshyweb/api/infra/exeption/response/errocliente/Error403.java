package com.poshyweb.api.infra.exeption.response.errocliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(HttpStatus.FORBIDDEN)
public class Error403 extends RuntimeException{
    private Date timesTemp;
    private String message;
    private String detalis;
}
