
package model;

public class Administrador extends Pessoa{

// atributos    
    private String cpf;

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
    
    // cadastraPedido();
    // cadastraCliente();
    // cadastraMotorista();
    // agendaViagem();
}
