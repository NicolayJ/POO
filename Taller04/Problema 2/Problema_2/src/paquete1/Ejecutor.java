package paquete1;

import paquete2.Automotor;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {

        Scanner tecla = new Scanner(System.in);

        int anio, i = 0, numVehiculos;
        double valor;
        String cadenaFinal = "", cedula, marca;

        System.out.print("Numero de iteraciones: ");
        numVehiculos = tecla.nextInt();

        while (i < numVehiculos) {

            tecla.nextLine();
            System.out.println("------------------------------");
            System.out.print("  Numero De Cedula: ");
            cedula = tecla.nextLine();
            System.out.print("  Marca Del Vehiculo: ");
            marca = tecla.nextLine();
            System.out.print("  Anio Del Fabricante: ");
            anio = tecla.nextInt();
            System.out.print("  Valor Del Vehiculo: $ ");
            valor = tecla.nextDouble();

            Automotor autos = new Automotor(cedula, marca, anio, valor);

            autos.calcularValorMatricula();

            cadenaFinal += autos.toString();

            i++;
        }
        System.out.printf("%s\n", cadenaFinal);
    }
}
