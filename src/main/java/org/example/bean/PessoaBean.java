package org.example.bean;

import org.example.model.Pessoa;
import org.example.service.PessoaService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PessoaBean implements Serializable {
    @Inject
    private PessoaService pessoaService;

    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private boolean editando;

    public void init() {
        pessoa = new Pessoa();
        listarPessoas();
    }

    public void novaPessoa() {
        pessoa = new Pessoa();
        editando = false;
    }

    public void salvarPessoa() {
        if (editando) {
            pessoaService.atualizarPessoa(pessoa);
        } else {
            pessoaService.salvarPessoa(pessoa);
        }
        pessoa = new Pessoa();
        listarPessoas();
        editando = false;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa salva", "Pessoa salva com sucesso"));
    }

    public void editarPessoa(Long id) {
        pessoa = pessoaService.encontrarPessoaPorId(id);
        editando = true;
    }

    public void excluirPessoa(Long id) {
        pessoaService.excluirPessoa(id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída", "Pessoa excluída com sucesso"));
    }

    public void cancelarEdicao() {
        pessoa = new Pessoa();
        editando = false;
    }

    public void listarPessoas() {
        pessoas = pessoaService.listarPessoas();
    }

    public PessoaBean() {
        pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}