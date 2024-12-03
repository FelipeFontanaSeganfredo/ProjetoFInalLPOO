
package model;

import jakarta.persistence.*;

// Comentei algumas coisas ainda não implementadas

@Entity
@Table(name = "tb_motorista")
@EntityListeners(util.EntityLogListener.class)
public class Motorista extends Pessoa{

// atributos
    private float salario;
    private String cpf;
    private String cnh;

    @OneToOne
    @JoinColumn(name = "caminhao_id")
    private Caminhao caminhao;

    private String senha;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
    
// getters e setters 
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
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
    
// toString
    @Override
    public String toString() {
    //    return "Motorista{" + "salario=" + salario + ", cnh=" + cnh + ", caminhao=" + caminhao + '}';
          return "Teste";
    }
    
// métodos especiais
    // public void realizarViagem(){}
    
}
