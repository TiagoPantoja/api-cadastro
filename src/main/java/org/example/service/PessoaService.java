package org.example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;

import java.util.List;

@Stateless
public class PessoaService {

    @Inject
    private PessoaRepository pessoaRepository;

    @Inject
    private EntityManager entityManager;

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.salvar(pessoa);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return pessoaRepository.atualizar(pessoa);
    }

    public void excluirPessoa(Long id) {
        pessoaRepository.excluir(id);
    }

    public Pessoa encontrarPessoaPorId(Long id) {
        return pessoaRepository.encontrarPorId(id);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.listarPessoas();
    }
}