
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_estoque")
public class Estoque {

// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int volume;
    private String nome;

    
// getters e setters
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

// toString
    @Override
    public String toString() {
        return "Estoque{" + "id=" + id + ", volume=" + volume + '}';
    }
    
}
