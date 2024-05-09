/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import paquete2.LibretaNotas;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        boolean bandera = true;
        while (bandera) {
            System.out.println("--------o MENU:");
            System.out.println("1. Crear objeto Estudiante (2 calificaciones)");
            System.out.println("2. Crear objeto Estudiante (3 calificaciones)");
            System.out.println("3. Salir");
            System.out.println("---------------------------------------------");
            System.out.print("Ingrese una opcion: ");
            int opcion = tecla.nextInt();

            if (opcion == 1) {
                System.out.println("=========================================");
                System.out.print("  Ingrese nombre del estudiante: ");
                String nombre = tecla.next();
                System.out.print("  Ingrese calificacion 1: ");
                double calificacion1 = tecla.nextDouble();
                System.out.print("  Ingrese calificacion 2: ");
                double calificacion2 = tecla.nextDouble();

                LibretaNotas estudiante = new LibretaNotas(nombre, calificacion1, 
                        calificacion2);
                estudiante.calcularPromedioNotas();

                System.out.printf("%s",estudiante);
            } else if (opcion == 2) {
                System.out.println("=========================================");
                System.out.print("Ingrese nombre del estudiante: ");
                String nombre = tecla.next();
                System.out.print("  Ingrese calificacion 1: ");
                double calificacion1 = tecla.nextDouble();
                System.out.print("  Ingrese calificacion 2: ");
                double calificacion2 = tecla.nextDouble();
                System.out.print("  Ingrese calificacion 3: ");
                double calificacion3 = tecla.nextDouble();

                LibretaNotas estudiante = new LibretaNotas(nombre, calificacion1,
                        calificacion2, calificacion3);
                estudiante.calcularPromedioNotas();

                System.out.printf("%s",estudiante);
            } else if (opcion == 3) {
                System.out.println("Saliendo...");
                bandera = false;
            } else {
                System.out.println("Ingrese una opcion existente");
            }
        }
    }
}
