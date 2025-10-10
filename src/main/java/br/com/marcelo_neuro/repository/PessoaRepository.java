package br.com.marcelo_neuro.repository;

import br.com.marcelo_neuro.entity.Pessoa;

public class PessoaRepository {

    public Pessoa find() {
        return new Pessoa(1L, "Felipe", "1");
    }
}
