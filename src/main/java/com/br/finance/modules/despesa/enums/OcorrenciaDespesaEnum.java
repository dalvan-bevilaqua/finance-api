package com.br.finance.modules.despesa.enums;

public enum OcorrenciaDespesaEnum {

    FIXA("F", "Fixa"),
    ESPORADICA("E", "Esporádica");

    private final String codigo;
    private final String descricao;

    OcorrenciaDespesaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
