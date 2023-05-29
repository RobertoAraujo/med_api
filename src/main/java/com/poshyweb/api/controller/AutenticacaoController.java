package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.autenticacao.AutenticacaoDTO;
import com.poshyweb.api.dominio.dto.autenticacao.TokenJWTDto;
import com.poshyweb.api.dominio.entity.UsuarioEntyti;
import com.poshyweb.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicoController.class.getName());
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(path = "/insert")
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dto){
        var token = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authenticate = manager.authenticate(token);
        var userTokenJWT = tokenService.gerarToken((UsuarioEntyti) authenticate.getPrincipal());
        LOGGER.info(userTokenJWT);
        return ResponseEntity.ok(new TokenJWTDto(userTokenJWT));
    }
}
