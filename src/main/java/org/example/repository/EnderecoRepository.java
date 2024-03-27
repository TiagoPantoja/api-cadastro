package org.example.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.model.Endereco;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class EnderecoRepository {
    private static final Logger logger = Logger.getLogger(EnderecoRepository.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public Endereco salvar(Endereco endereco) {
        entityManager.persist(endereco);
        return endereco;
    }

    public Endereco atualizar(Endereco endereco) {
        return entityManager.merge(endereco);
    }

    public void excluir(Long id) {
        Endereco endereco = entityManager.find(Endereco.class, id);
        if (endereco != null) {
            entityManager.remove(endereco);
        }
    }

    public Endereco encontrarPorId(Long id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> listarEnderecos() {
        TypedQuery<Endereco> query = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class);
        return query.getResultList();
    }

    public Endereco salvarLog(Endereco endereco) {
        entityManager.persist(endereco);
        logger.info("Endereço salvo com sucesso: " + endereco.getLogradouro());
        return endereco;
    }

    public Endereco atualizarLog(Endereco endereco) {
        Endereco enderecoAtualizado = entityManager.merge(endereco);
        logger.info("Endereço atualizado com sucesso: " + enderecoAtualizado.getLogradouro());
        return enderecoAtualizado;
    }

    public void excluirLog(Long id) {
        Endereco endereco = entityManager.find(Endereco.class, id);
        if (endereco != null) {
            entityManager.remove(endereco);
            logger.info("Endereço excluído com sucesso: " + endereco.getLogradouro());
        } else {
            logger.warning("Endereço não encontrado para exclusão: " + id);
        }
    }
}
