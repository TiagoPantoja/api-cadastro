package org.example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.example.model.Endereco;
import org.example.repository.EnderecoRepository;

import java.util.List;

@Stateless
public class EnderecoService {

    @Inject
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.salvar(endereco);
    }

    public Endereco atualizarEndereco(Endereco endereco) {
        return enderecoRepository.atualizar(endereco);
    }

    public void excluirEndereco(Long id) {
        enderecoRepository.excluir(id);
    }

    public Endereco encontrarEnderecoPorId(Long id) {
        return enderecoRepository.encontrarPorId(id);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.listarEnderecos();
    }
}