
package model;

public class Caminhao {
    
// atributos
    private int id;
    private Motorista motorista;
    private Carga carga;
    
// getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

// toString
    @Override
    public String toString() {
        return "Caminhao{" + "id=" + id + ", motorista=" + motorista + ", carga=" + carga + '}';
    }
    
}
