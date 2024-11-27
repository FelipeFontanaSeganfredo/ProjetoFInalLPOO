
package model;

import java.util.*;

public abstract class Pessoa {
    
// atributos
    private int id;
    private String nome;
    private Date dataNascimento;
    private String email;
    private String telefone;

// getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

// método toString
    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email + ", telefone=" + telefone + '}';
    }
    
}
