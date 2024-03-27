package org.example.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.model.Pessoa;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PessoaRepository {
    private static final Logger logger = Logger.getLogger(PessoaRepository.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public Pessoa salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        return entityManager.merge(pessoa);
    }

    public void excluir(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
        }
    }

    public Pessoa encontrarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> listarPessoas() {
        TypedQuery<Pessoa> query = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return query.getResultList();
    }

    public Pessoa salvarLog(Pessoa pessoa) {
        entityManager.persist(pessoa);
        logger.info("Pessoa salva com sucesso: " + pessoa.getNome());
        return pessoa;
    }

    public Pessoa atualizarLog(Pessoa pessoa) {
        Pessoa pessoaAtualizada = entityManager.merge(pessoa);
        logger.info("Pessoa atualizada com sucesso: " + pessoaAtualizada.getNome());
        return pessoaAtualizada;
    }

    public void excluirLog(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
            logger.info("Pessoa excluída com sucesso: " + pessoa.getNome());
        } else {
            logger.warning("Pessoa não encontrada para exclusão: " + id);
        }
    }

    public Pessoa encontrarPorIdLog(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa != null) {
            logger.info("Pessoa encontrada: " + pessoa.getNome());
        } else {
            logger.warning("Pessoa não encontrada: " + id);
        }
        return pessoa;
    }
}
