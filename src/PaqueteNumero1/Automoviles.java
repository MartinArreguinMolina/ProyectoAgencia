package PaqueteNumero1;
import java.text.NumberFormat;


public class Automoviles {

    private int precio;
    private String color;
    private String id;
    private String marca;

    public Automoviles(String marca, String color, String matricula, int precio) {
        this.precio = precio;
        this.color = color;
        this.id = matricula;
        this.marca = marca;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String toString() {
        System.out.println("::::::::::::::::::::::::::::::::");
        System.out.println("Marca : " + getMarca() + "\n" + "Color : " + getColor() + "\n" + "Matricula : " + getId() + "\n" + "Precio : " + NumberFormat.getCurrencyInstance().format(getPrecio()));
        System.out.println("::::::::::::::::::::::::::::::::");
        return "";
    }

}
