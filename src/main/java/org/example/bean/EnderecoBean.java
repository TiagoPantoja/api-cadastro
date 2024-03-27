package org.example.bean;

import org.example.service.EnderecoService;
import org.example.model.Endereco;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EnderecoBean implements Serializable {
    @Inject
    private EnderecoService enderecoService;

    private Endereco endereco;
    private List<Endereco> enderecos;
    private boolean editando;

    public void init() {
        endereco = new Endereco();
        listarEnderecos();
    }

    public void novoEndereco() {
        endereco = new Endereco();
        editando = false;
    }

    public void salvarEndereco() {
        if (editando) {
            enderecoService.atualizarEndereco(endereco);
        } else {
            enderecoService.salvarEndereco(endereco);
        }
        endereco = new Endereco();
        listarEnderecos();
        editando = false;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Endereço salvo"));
    }

    public void editarEndereco(Long id) {
        endereco = enderecoService.encontrarEnderecoPorId(id);
        editando = true;
    }

    public void excluirEndereco(Long id) {
        enderecoService.excluirEndereco(id);
        listarEnderecos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Endereço excluído"));
    }

    public void cancelarEdicao() {
        endereco = new Endereco();
        editando = false;
    }

    public void listarEnderecos() {
        enderecos = enderecoService.listarEnderecos();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}
