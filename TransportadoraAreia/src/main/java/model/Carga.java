
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_carga")
public class Carga {
    
// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float peso;
    private float volume;

// getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

// toString

    @Override
    public String toString() {
        return Integer.toString(id);
    }
    
    
}
