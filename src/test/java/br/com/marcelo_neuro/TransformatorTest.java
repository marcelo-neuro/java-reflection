package br.com.marcelo_neuro;

import br.com.marcelo_neuro.dto.PessoaDTO;
import br.com.marcelo_neuro.entity.Pessoa;
import br.com.marcelo_neuro.refl.Transformator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {
    public final Transformator transformator;
    public Pessoa pessoa;

    public TransformatorTest() {
        transformator = new Transformator();
    }

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa(1L, "Felipe", "1");
    }

    @Test
    public void shouldTransform() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PessoaDTO pessoaDTO = transformator.transform(pessoa, PessoaDTO.class);

        Assertions.assertAll("Todos os campos devem ser correspondentes.",
                () -> Assertions.assertEquals(1L, pessoaDTO.getId()),
                () -> Assertions.assertEquals("Felipe", pessoaDTO.getName()),
                () -> Assertions.assertEquals("1", pessoaDTO.getCpf()));
    }

    @Test
    public void shouldTransformWhenNullField() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        pessoa.setCpf(null);
        PessoaDTO pessoaDTO = transformator.transform(pessoa, PessoaDTO.class);

        Assertions.assertAll("Todos os campos devem ser correspondentes.",
                () -> Assertions.assertEquals(1L, pessoaDTO.getId()),
                () -> Assertions.assertEquals("Felipe", pessoaDTO.getName()),
                () -> Assertions.assertNull(pessoaDTO.getCpf()));
    }
}
