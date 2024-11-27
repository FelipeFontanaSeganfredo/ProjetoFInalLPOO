
package model;

public class Motorista extends Pessoa{

// atributos
    private float salario;
    private String cnh;
    private Caminhao caminhao;
    
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
        return "Motorista{" + "salario=" + salario + ", cnh=" + cnh + ", caminhao=" + caminhao + '}';
    }
    
// métodos especiais
    // public void realizarViagem(){}
    
}
