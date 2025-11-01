package agregar_videojuegos;

public class Agregar_videojuegos {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String plataforma;
    private double precio;
    private int stock;

    public Agregar_videojuegos(String nombre, String plataforma, double precio, int stock) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
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

    public String mostrarInfo() {
        return "ID: " + id +
                "\nNombre: " + nombre +
                "\nPlataforma: " + plataforma +
                "\nPrecio: " + precio + "€" +
                "\nStock: " + stock + " unidades" +
                "\n-------------------------\n";
    }

}
