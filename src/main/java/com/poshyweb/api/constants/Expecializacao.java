package com.poshyweb.api.constants;

public enum Expecializacao {
    ORTOPEDIA("Ortopedia"), CLINICO_GERAL("Clinico Geral"),
    CARDIOLOGISTA("Cardiologista"), DERMATOLOGISTA("Dermatologista");

    private String descricao;

    Expecializacao(String descricao) {
        this.descricao = descricao;
    }
}
