package br.com.marcelo_neuro.dto;

public class PessoaDTO {
    private Long id;
    private String name;
    private String cpf;

    public PessoaDTO(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public PessoaDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
