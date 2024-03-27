package org.example;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;
import org.example.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceIntegrationTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    public void testListarPessoas() {
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(1L);
        pessoaMock.setNome("João");
        List<Pessoa> mockPessoas = Collections.singletonList(pessoaMock);
        when(pessoaRepository.listarPessoas()).thenReturn(mockPessoas);

        List<Pessoa> pessoas = pessoaService.listarPessoas();

        assertEquals(1, pessoas.size());
        Pessoa primeiraPessoa = pessoas.get(0);
        assertEquals(1L, primeiraPessoa.getId());
        assertEquals("João", primeiraPessoa.getNome());
    }
}
