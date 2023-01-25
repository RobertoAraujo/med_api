package com.poshyweb.api.exeption;

public class MensagemExeption extends Exception {
    public MensagemExeption(String nome) {
        super("Medico(a) " + nome + "Não encontrado ou não cadastrado!");
    }

    public MensagemExeption(String message, Throwable cause) {
        super("Não foi possivel cadastrar o medico"+ message +"", cause);
    }
}
