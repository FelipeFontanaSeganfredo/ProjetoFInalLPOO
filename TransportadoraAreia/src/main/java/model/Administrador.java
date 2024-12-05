
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_admin")
@EntityListeners(dao.EntityLogListener.class) // Usado para salvar os logs.
public class Administrador extends Pessoa{

// atributos    
    private String cpf;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

// getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

// toString
    @Override
    public String toString() {
        return super.toString() + "Administrador{" + "cpf=" + cpf + '}';
    }
    
// métodos especiais
    // public Pedido cadastraPedido(){}
    // public Cliente cadastraCliente(){}
    // public Motorista cadastraMotorista(){}
    // public Viagem agendaViagem(){}
}
