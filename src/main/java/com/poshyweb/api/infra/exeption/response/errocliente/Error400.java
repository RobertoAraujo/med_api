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
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Error400 extends RuntimeException {
    private Date timesTemp = new Date();
    private String message = "Pagina não encontrada! ";
    private String detalis;

}
