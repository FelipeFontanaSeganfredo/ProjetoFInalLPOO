
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_viagem")
public class Viagem {
    
// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double valor;
    private Double distancia;

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
    
    @OneToOne
    @JoinColumn(name = "motorista_id")    
    private Motorista motorista;
    @OneToOne
    @JoinColumn(name = "cliente_id")    
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "carga_id") 
    private Carga carga;
    
    @ManyToOne
    @JoinColumn (name = "destino_id")
    private Destino destino;

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Destino getDestino() {
        return destino;
    }

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
        return "Viagem{" + "id=" + id + ", motorista=" + motorista + ", cliente=" + cliente + ", carga=" + carga + '}';
    }

}
