
package model;

public class Carga {
    
// atributos
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
        return "Carga{" + "id=" + id + ", peso=" + peso + ", volume=" + volume + '}';
    }
    
}
