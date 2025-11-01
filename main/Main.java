package main;

import java.util.*;
import agregar_videojuegos.Agregar_videojuegos;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        //NOTA MENTAL MEJORAR NECESARIAMENTE RAPIDO LOS ARRAYS BIDIMENSIONALES SI O SI, PORQUE LA IA EN ESTE APARTADO A HECHO MAS QUE TU...
        String[][] rendimiento_anual = {
                { "0", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" },
                { "PC", "", "", "", "", "", "", "", "", "", "", "", "" },
                { "Xbox", "", "", "", "", "", "", "", "", "", "", "", "" },
                { "PlayStation", "", "", "", "", "", "", "", "", "", "", "", "" },
                { "Nintendo", "", "", "", "", "", "", "", "", "", "", "", "" }
        };

        Agregar_videojuegos[] objetos_juegos = new Agregar_videojuegos[10];
        int contador_juegos = 0;

        while (flag) {
            System.out.println("""
                    ==== GESTOR DE TIENDA DE VIDEOJUEGOS ====
                    1. Agregar videojuego
                    2. Listar videojuegos
                    3. Buscar videojuego por nombre
                    4. Actualizar stock
                    5. Eliminar videojuego
                    6. Mostrar estadísticas
                    7. Mostrar ventas por plataformas
                    8. Salir
                    """);

            int opcion;
            do {
                System.out.print("Ingrese una opción (1-8): ");
                opcion = sc.nextInt();
            } while (opcion < 1 || opcion > 8);

            switch (opcion) {
                case 1:
                    if (contador_juegos < objetos_juegos.length) {
                        System.out.print("\n==== AGREGAR VIDEOJUEGO ====\n");
                        System.out.print("Nombre: ");
                        String nombre = sc.next();
                        System.out.print("Plataforma: ");
                        String plataforma = sc.next();
                        System.out.print("Precio (€): ");
                        double precio = sc.nextDouble();
                        System.out.print("Stock: ");
                        int stock = sc.nextInt();

                        objetos_juegos[contador_juegos] = new Agregar_videojuegos(nombre, plataforma, precio, stock);
                        contador_juegos++;

                        System.out.println("Videojuego agregado correctamente.\n");
                    } else {
                        System.out.println("Límite de 10 videojuegos alcanzado.\n");
                    }
                    break;

                case 2:
                    System.out.println("\n==== LISTA DE VIDEOJUEGOS ====");
                    for (int i = 0; i < objetos_juegos.length; i++) {
                        if (objetos_juegos[i] != null) {
                            System.out.println(objetos_juegos[i].mostrarInfo());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n==== BUSCAR VIDEOJUEGO ====");
                    System.out.print("Escriba el nombre del videojuego: ");
                    String buscar = sc.next();

                    boolean encontrado = false;
                    for (int i = 0; i < objetos_juegos.length; i++) {
                        if (objetos_juegos[i] != null && objetos_juegos[i].getNombre().equalsIgnoreCase(buscar)) {
                            System.out.println("Videojuego encontrado:");
                            System.out.println(objetos_juegos[i].mostrarInfo());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún videojuego con ese nombre.\n");
                    }
                    break;

                case 4:
                    System.out.println("\n==== ACTUALIZAR STOCK ====");
                    System.out.print("Escriba el nombre del videojuego: ");
                    String actualizar = sc.next();

                    boolean modificado = false;
                    for (int i = 0; i < objetos_juegos.length; i++) {
                        if (objetos_juegos[i] != null && objetos_juegos[i].getNombre().equalsIgnoreCase(actualizar)) {
                            System.out.print("¿Desea agregar o quitar unidades? (agregar/quitar): ");
                            String accion = sc.next();

                            if (accion.equalsIgnoreCase("quitar")) {
                                System.out.print("¿Cuántas unidades desea quitar?: ");
                                int quitar = sc.nextInt();
                                if (objetos_juegos[i].getStock() >= quitar) {
                                    objetos_juegos[i].setStock(objetos_juegos[i].getStock() - quitar);
                                    System.out.println("Stock actualizado correctamente.\n");
                                } else {
                                    System.out.println("No hay suficiente stock.\n");
                                }
                            } else if (accion.equalsIgnoreCase("agregar")) {
                                System.out.print("¿Cuántas unidades desea agregar?: ");
                                int agregar = sc.nextInt();
                                objetos_juegos[i].setStock(objetos_juegos[i].getStock() + agregar);
                                System.out.println("Stock actualizado correctamente.\n");
                            }
                            modificado = true;
                            break;
                        }
                    }
                    if (!modificado) {
                        System.out.println("No se encontró el videojuego indicado.\n");
                    }
                    break;

                case 5:
                    System.out.println("\n==== ELIMINAR VIDEOJUEGO ====");
                    System.out.print("Escriba el nombre del videojuego a eliminar: ");
                    String eliminar = sc.next();

                    boolean borrado = false;
                    for (int i = 0; i < objetos_juegos.length; i++) {
                        if (objetos_juegos[i] != null && objetos_juegos[i].getNombre().equalsIgnoreCase(eliminar)) {
                            System.out.print("¿Seguro que desea eliminarlo? (si/no): ");
                            String respuesta = sc.next();
                            if (respuesta.equalsIgnoreCase("si")) {
                                objetos_juegos[i] = null;
                                System.out.println("Videojuego eliminado correctamente.\n");
                            }
                            borrado = true;
                            break;
                        }
                    }
                    if (!borrado) {
                        System.out.println("No se encontró el videojuego indicado.\n");
                    }
                    break;

                case 6:
                    System.out.println("\n==== ESTADÍSTICAS ====");
                    int total_juegos = 0;
                    double suma_precios = 0;
                    int total_stock = 0;

                    for (int i = 0; i < objetos_juegos.length; i++) {
                        if (objetos_juegos[i] != null) {
                            total_juegos++;
                            suma_precios += objetos_juegos[i].getPrecio();
                            total_stock += objetos_juegos[i].getStock();
                        }
                    }

                    double precio_medio = (total_juegos > 0) ? (suma_precios / total_juegos) : 0;
                    int porcentaje_ocupado = (total_juegos * 100) / objetos_juegos.length;

                    System.out.println("Videojuegos registrados: " + total_juegos);
                    System.out.println("Precio medio: " + precio_medio + " €");
                    System.out.println("Stock total: " + total_stock + " unidades");
                    System.out.println("Capacidad ocupada del inventario: " + porcentaje_ocupado + "%\n");
                    break;

                case 7:
                    //LO MISMO QUE EN EL ARRAY DE 2 DIMENSIONES TENEMOS QUE MEJORAR LA LOGICA Y LA VISTA ESPACIAL
                    System.out.println("\n==== VENTAS POR PLATAFORMAS ====");
                    for (int i = 1; i < rendimiento_anual.length; i++) {
                        for (int j = 1; j < rendimiento_anual[i].length; j++) {
                            int numero = (int) (Math.random() * 101); //RECORDAR PORQUE LO VAS A TENER QUE BUSCAR OTRA VEZ ... RECUERDA
                            rendimiento_anual[i][j] = String.valueOf(numero);
                        }
                    }

                    for (int i = 0; i < rendimiento_anual.length; i++) {
                        for (int j = 0; j < rendimiento_anual[i].length; j++) {
                            System.out.print(rendimiento_anual[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;

                case 8:
                    System.out.println("\nHasta pronto...");
                    flag = false;
                    break;
            }
        }

        sc.close();
    }
}
