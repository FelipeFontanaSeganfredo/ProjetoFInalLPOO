
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_viagem")
public class Viagem {
    
// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String localOrigem;
    private String localDestino;
    
    @OneToOne
    @JoinColumn(name = "motorista_id")    
    private Motorista motorista;
    @OneToOne
    @JoinColumn(name = "cliente_id")    
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "carga_id") 
    private Carga carga;

// getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        return "Viagem{" + "id=" + id + ", localOrigem=" + localOrigem + ", localDestino=" + localDestino + ", motorista=" + motorista + ", cliente=" + cliente + ", carga=" + carga + '}';
    }

}
