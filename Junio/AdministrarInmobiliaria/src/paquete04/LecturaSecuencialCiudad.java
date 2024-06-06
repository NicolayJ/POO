/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete06.AppendingObjectInputStream;

/**
 *
 * @author dj931
 */
public class LecturaSecuencialCiudad {
    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudades;
    private String nombreArchivo;
    private String identificacion;
    private Ciudad buscarCiudad;

    public LecturaSecuencialCiudad(String n) {
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

    public void establecerListaCiudad() {
        ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
                } catch (EOFException endOfFileException) {
                    break; // se llegó al fin del archivo
                } catch (IOException | ClassNotFoundException ex) {
                    System.err.println("Establecer. Error al leer el archivo: " + ex);
                }
            }
            cerrarArchivo();
        }
    }
    
    public void establecerIdentificador(String id) {
        identificacion = id;
    }
    
    public void establecerBuscarCiudad() {
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();

                    if (registro.obtenenerNombreCiudad().equals(identificacion)) {
                        buscarCiudad = registro;
                        break;
                    }
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Establecer. Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("Establecer.  No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("Establecer. No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }
    }

    public ArrayList<Ciudad> obtenerListaCiudad() {
        return ciudades;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public String obtenerIdentificacion(){
        return identificacion;
    }
    
    public Ciudad obtenerBuscarCiudad(){
        return buscarCiudad;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Ciudades\n";
        for (int i = 0; i < obtenerListaCiudad().size(); i++) {
            Ciudad p = obtenerListaCiudad().get(i);
            cadena = String.format("%sNombre de la ciudad: %s\n"
                    + "Nombre de la provincia: %s\n", cadena,
                    p.obtenenerNombreCiudad(),
                    p.obtenerNombreProvincia());
        }

        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        }
    }
}