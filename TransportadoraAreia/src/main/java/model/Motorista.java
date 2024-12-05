package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_motorista")
@EntityListeners(dao.EntityLogListener.class)
public class Motorista extends Pessoa {

    private float salario;
    private String cpf;
    private String cnh;

    @OneToOne
    @JoinColumn(name = "caminhao_id")
    private Caminhao caminhao;

    private String senha;

    // Getters e Setters
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método toString para exibição no ComboBox
    @Override
    public String toString() {
        return this.getNome();
    }
}
