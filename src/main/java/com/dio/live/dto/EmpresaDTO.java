package com.dio.live.dto;

import lombok.Data;

@Data
public class EmpresaDTO {
    private Long id;
    private String descricao;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
}

