
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_caminhao")
public class Caminhao {
    
// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "motorista_id") // Coluna na tabela Caminhao que referencia Motorista    
    private Motorista motorista;
    
    @OneToOne
    @JoinColumn(name = "carga_id") // Coluna na tabela Caminhao que referencia Carga
    private Carga carga;
    
    private Boolean disponivel;

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Boolean getDisponivel() {
        return disponivel;
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

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

// toString
    @Override
    public String toString() {
        return "Caminhao: " + id;
    }

}
