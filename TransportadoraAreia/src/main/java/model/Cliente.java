
package model;

public class Cliente extends Pessoa{

// atributos
    private String cnpj;

// getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

// método toString
    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "cnpj=" + cnpj + '}';
    }
   
}
