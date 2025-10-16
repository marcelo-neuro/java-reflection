package br.com.marcelo_neuro.service;

import br.com.marcelo_neuro.dto.PessoaDTO;
import br.com.marcelo_neuro.entity.Pessoa;
import br.com.marcelo_neuro.refl.Transformator;
import br.com.marcelo_neuro.repository.PessoaRepository;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {

    PessoaRepository pessoaRepository = new PessoaRepository();
    Transformator transformator = new Transformator();

    public PessoaDTO list() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = pessoaRepository.find();
        PessoaDTO pessoaDTO = transformator.transform(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }
}
