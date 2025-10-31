package main;

import java.util.*;
import agregar_videojuegos.Agregar_videojuegos;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        Agregar_videojuegos objetos_juegos[] = new Agregar_videojuegos[10];

        String[] nombres = new String[10];
        String[] plataformas = new String[10];
        double[] precios = new double[10];
        int[] stock = new int[10];

        int contador_juegos = 0;
        while (flag) {
            System.out.print("==== GESTOR DE TIENDA DE VIDEOJUEGOS ====\n" +
                    "1. Agregar videojuego\n" +
                    "2. Listar videojuegos\n" +
                    "3. Buscar videojuego por nombre\n" +
                    "4. Actualizar stock\n" +
                    "5. Eliminar videojuego\n" +
                    "6. Mostrar estadísticas\n" +
                    "7. Mostrar ventas por plataformas (array bidimensional)\n" +
                    "8. Salir\n" + "");
            int pedir;
            do {
                System.out.print("Ingrese una opción: ");
                pedir = sc.nextInt();
            } while (pedir < 1 || pedir > 8);

            switch (pedir) {
                case 1:
                    if (nombres.length < 10 || nombres.length > 0) {
                        System.out.print("==== AGREGAR VIDEOJUEGO ====\n");
                        System.out.print("Nombre: ");
                        String nombre = sc.next();
                        System.out.print("Plataforma: ");
                        String plataforma = sc.next();
                        System.out.print("Precio (€): ");
                        double precio = sc.nextDouble();
                        System.out.print("Stock: ");
                        int stock_juego = sc.nextInt();
                        Agregar_videojuegos v1 = new Agregar_videojuegos(nombre, plataforma, precio, stock_juego);
                        System.out.println("Video-Juego agregado correctamente!");

                        contador_juegos++;

                        objetos_juegos[contador_juegos] = v1;

                        nombres[contador_juegos] = v1.getNombre();
                        plataformas[contador_juegos] = v1.getPlataforma();
                        precios[contador_juegos] = v1.getPrecio();
                        stock[contador_juegos] = v1.getStock();
                    } else {
                        System.out.println("Has introducido 10 videojuegos.\nLimite alcanzado");
                    }
                    break;
                case 2:
                    if (objetos_juegos != null) {
                        System.out.print("=== LISTA DE JUEGOS ===");
                        for (int i = 0; i < objetos_juegos.length; i++) {
                            objetos_juegos[i].mostrarInfo();
                        }
                    } else {
                        System.out.println("No hay ningun juego guardado");
                    }
                    break;
                case 3:
                    System.out.println("=== BUSCADOR DE JUEGOS ===");
                    System.out.print("Escribe el nombre del juego: ");
                    String nombre_buscador = sc.next();

                    for (int i = 0; i < nombres.length; i++) {
                        if (nombres[i].toLowerCase() == nombre_buscador.toLowerCase()) {
                            System.out.println("Juego encontrado!");
                            objetos_juegos[i].mostrarInfo();
                        } else {
                            System.out.println("Juego no encontrado");
                        }
                    }
                    break;
                case 4:
                    System.out.println("=== ACTUALIZAR STOCK ===");
                    System.out.print("Escribe el nombre del juego: ");
                    String nombre_actualizar = sc.next();
                    Agregar_videojuegos objeto_agregarQuitar;
                    for (int i = 0; i < nombres.length; i++) {
                        if (nombres[i].toLowerCase() == nombre_actualizar.toLowerCase()) {
                            objeto_agregarQuitar = objetos_juegos[i];
                            String quitar_agregar;
                            do {
                                System.out.println("Quieres agregar o quitar unidades? ");
                                quitar_agregar = sc.next();
                            } while (quitar_agregar.toLowerCase() != "quitar"
                                    || quitar_agregar.toLowerCase() != "agregar");

                            if (quitar_agregar.toLowerCase() == "quitar") {
                                System.out.print("Cuantas unidades quieres quitar? ");
                                int unidades_quitar = sc.nextInt();
                                if (objeto_agregarQuitar.getStock() > unidades_quitar) {
                                    objeto_agregarQuitar.setStock(-unidades_quitar);
                                } else {
                                    System.out.println("No tienes tanto stock para quitar");
                                }
                            }

                            if (quitar_agregar.toLowerCase() == "agregar") {
                                System.out.print("Cuantas unidades quiere agregar? ");
                                int unidades_agregar = sc.nextInt();
                                objeto_agregarQuitar.setStock(+unidades_agregar);
                            }
                        }
                    }

                    System.out.println("STOCK ACTUALIZADO!");
                    break;
                case 5:
                    System.out.println("=== ELIMINAR JUEGO ===");
                    System.out.print("Escribe el nombre del juego: ");
                    String juego_borrar = sc.next();
                    Agregar_videojuegos objeto_eliminar;
                    for (int i = 0; i < nombres.length; i++) {
                        if (nombres[i].toLowerCase() == juego_borrar.toLowerCase()) {
                            objeto_eliminar = objetos_juegos[i];
                            System.out.println(
                                    "Estas seguro de que quiere eliminar el objeto: " + objeto_eliminar.getNombre());
                            String respuesta = sc.next();
                            if (respuesta.toLowerCase() == "si" || respuesta.toLowerCase() == "sí") {
                                objetos_juegos[i] = null;
                                nombres[i] = null;
                                plataformas[i] = null;
                                precios[i] = 0;
                                stock[i] = 0;
                                System.out.println("VideoJuego eliminado correctamente!");
                            }
                        }
                    }

                    break;
                case 6:
                    System.out.println("=== ESTADISTICAS ===");
                    for (int i = 0; i < nombres.length; i++) {
                        int contador = 0;
                        if (nombres[i] != null) {
                            contador++;
                        }
                        System.out.print("Hay " + contador + " videojuegos registrados en el inventario");
                    }

                    for (int i = 0; i < precios.length; i++) {
                        double media = 0;
                        if (precios[i] != 0) {
                            media += precios[i];
                        }
                        System.out.println("El precio medio es de " + media + "€");
                    }

                    for (int i = 0; i < stock.length; i++) {
                        int unidades = 0;
                        if (stock[i] != 0) {
                            unidades += stock[i];
                        }
                        System.out.println("Stock total disponible: " + unidades + " unidades");
                    }

                    for (int i = 0; i < objetos_juegos.length; i++) {
                        int contador = 0;
                        if (objetos_juegos[i] != null) {
                            contador++;
                        }
                        int operacion = (contador / objetos_juegos.length) * 100;
                        System.out.println("Capacidad del inventario: " + operacion + "% ocupado");
                    }

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Hasta pronto...");
                    flag = false;
                    break;
            }
        }

        sc.close();
    }
}
