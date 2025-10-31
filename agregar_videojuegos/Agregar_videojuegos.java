package agregar_videojuegos;

public class Agregar_videojuegos {
    private static int id = 0;
    private String nombre;
    private String plataforma;
    private double precio;
    private int stock;
    private int id_juego;

    public Agregar_videojuegos(String nombre, String plataforma, double precio, int stock) {
        this.id_juego = id;
        id++;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.stock = stock;

    }

    public int getId_juego() {
        return this.id_juego;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String mostrarInfo(){
        return ("ID: " + this.id_juego +
        "\nNombre: " + this.nombre +
        "\nPlataforma: " + this.plataforma +
        "\nPrecio: " + this.precio +
        "\nStock: " + this.stock +"\n");
    }
}
