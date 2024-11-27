
package model;

public class Pedido {

// atributos
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
