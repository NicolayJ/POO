package paquete1;

import paquete2.Automotor;
import java.util.Scanner;

public class EjecutorDos {

    public static void main(String[] args) {

        Scanner tecla = new Scanner(System.in);

        int anio;
        double valor;
        String cedula, marca, opcion, cadenaFinal = "";

        boolean bandera = true;

        while (bandera) {

            System.out.print("Numero De Cedula: ");
            cedula = tecla.nextLine();
            System.out.print("Marca Del Vehiculo: ");
            marca = tecla.nextLine();
            System.out.print("Anio Del Fabricante: ");
            anio = tecla.nextInt();
            System.out.print("Valor Del Vehiculo: $ ");
            valor = tecla.nextDouble();
            System.out.println("-----------------------------------------");

            Automotor autos = new Automotor(cedula, marca, anio, valor);

            autos.calcularValorMatricula();

            cadenaFinal += String.format("VALOR DE LA MATRICULA"
                    + " Cedula: %s\n"
                    + " Marca Del Vehiculo: %s\n"
                    + " Anio De Fabricacion: %d\n"
                    + " Valor Del Vehiculo: $ %.3f\n\n",
                    autos.obtenerCedula(),
                    autos.obtenerMarcaVehiculo(),
                    autos.obtenerAnioFabricacion(),
                    autos.obtenerValorVehiculo(),
                    autos.obtenerValorMatricula());

            tecla.nextLine();

            System.out.println("Desea ingresar mas vendedores. Ingrese n para salir");
            opcion = tecla.nextLine();
            if (opcion.equals("n")) {
                System.out.println("\nSaliendo...\n");
                bandera = false;
            }
        }
        System.out.printf("%s", cadenaFinal);
    }
}
