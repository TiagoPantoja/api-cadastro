package org.example;

import org.example.model.Endereco;
import org.example.repository.EnderecoRepository;
import org.example.service.EnderecoService;
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
public class EnderecoServiceIntegrationTest {
    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @Test
    public void testListarEnderecos() {
        Endereco enderecoMock = new Endereco();
        enderecoMock.setId(1L);
        enderecoMock.setLogradouro("Rua A");
        List<Endereco> mockEnderecos = Collections.singletonList(enderecoMock);
        when(enderecoRepository.listarEnderecos()).thenReturn(mockEnderecos);

        List<Endereco> enderecos = enderecoService.listarEnderecos();

        assertEquals(1, enderecos.size());
        Endereco primeiroEndereco = enderecos.get(0);
        assertEquals(1L, primeiroEndereco.getId());
        assertEquals("Rua A", primeiroEndereco.getLogradouro());
    }
}
