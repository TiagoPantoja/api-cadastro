package org.example;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;
import org.example.service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");

        when(pessoaRepository.salvar(pessoa)).thenReturn(pessoa);

        Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);

        Assertions.assertEquals(pessoa, pessoaSalva);
    }
}

