/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

/**
 *
 * @author dj931
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete06.AppendingObjectInputStream;

public class LecturaSecuencialCasa {
    
    private ObjectInputStream entrada;
    private ArrayList<Casa> casa;
    private String nombreArchivo;

    public LecturaSecuencialCasa(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new AppendingObjectInputStream(
                        new FileInputStream(n)); // FileOutputStream
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Contructor. Error al abrir el archivo." + ioException);
            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCasa() {
        // 
        casa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casa.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Establecer. Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("Establecer.  No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("Establecer. No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Casa> obtenerListaCasa() {
        return casa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Ciudades\n";
        for (int i = 0; i < obtenerListaCasa().size(); i++) {
            Casa p = obtenerListaCasa().get(i);
            cadena = String.format("%sNombres del propietario: %s\n"
                    + "Apellidos del propietario: %s\n"
                    + "Identificacion: %s\n"
                    + "Precio del metro cuadrado: $%.2f\n"
                    + "Numero de metros cuadrados: %.2f\n"
                    + "Costo Final: $%.2f\n"
                    + "Nombre de la ciudad: %s\n"
                    + "Nombre de la provincia: %s\n"
                    + "Numero de Cuartos: %d\n", cadena,
                    p.obtenerPropietario().obtenerNombres(),
                    p.obtenerPropietario().obtenerApellidos(),
                    p.obtenerPropietario().obtenerIdentificacion(),
                    p.obtenerPrecioMetroCuadrado(),
                    p.obtenerNumeroMetroCuadrado(),
                    p.obtenerCostoFinal(),
                    p.obtenerCiudad().obtenenerNombreCiudad(),
                    p.obtenerCiudad().obtenerNombreProvincia(),
                    p.obtenerNumeroCuartos());
        }

        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}

