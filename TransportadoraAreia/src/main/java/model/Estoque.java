
package model;

public class Estoque {

// atributos    
    private int id;
    private int volume;
    
// getters e setters
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
