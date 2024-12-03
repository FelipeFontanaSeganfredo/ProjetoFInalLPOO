
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

// getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

// toString
    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + '}';
    }
    
}
