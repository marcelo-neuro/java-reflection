package br.com.marcelo_neuro;

import br.com.marcelo_neuro.service.PessoaService;

import java.lang.reflect.InvocationTargetException;

public class JavaReflectionApplication {
    private static final PessoaService pessoaService = new PessoaService();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(pessoaService.list());
    }
}