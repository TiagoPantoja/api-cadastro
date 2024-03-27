package org.example;

import org.example.model.Endereco;
import org.example.repository.EnderecoRepository;
import org.example.service.EnderecoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarEndereco() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua A");

        when(enderecoRepository.salvar(endereco)).thenReturn(endereco);

        Endereco enderecoSalvo = enderecoService.salvarEndereco(endereco);

        Assertions.assertEquals(endereco, enderecoSalvo);
    }
}