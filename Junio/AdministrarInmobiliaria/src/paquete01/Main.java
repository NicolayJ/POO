/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

import java.util.ArrayList;
import java.util.Scanner;
import paquete03.Barrio;
import paquete03.LecturaSecuencialBarrio;

public class Main {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        String archivoBarrios = "data/losbarrios.dat";

        System.out.print("Nombre del barrio: ");
        String nombBar = tecla.nextLine();

        LecturaSecuencialBarrio lecturaBarrio = 
                new LecturaSecuencialBarrio(archivoBarrios);
        lecturaBarrio.establecerListaBarrio();
        ArrayList<Barrio> listaBarrios = lecturaBarrio.obtenerListaBarrio();

        Barrio bar = null;

        for (Barrio b : listaBarrios) {
            if (b.obtenerNombreBarrio().equalsIgnoreCase(nombBar)) {
                bar = b;
                break;
            }
        }
        
        if (bar != null) {
            System.out.println("Barrio encontrado: " + bar.obtenerNombreBarrio() +
                    ", " + bar.obtenerReferencia());
        } else {
            System.out.println("Barrio no encontrado.");
        }

        tecla.close();
    }
    
}
