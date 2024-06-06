/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

/**
 *
 * @author dj931
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import paquete06.AppendingObjectOutputStream;

public class EscrituraSecuencialBarrio {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registroBarrio;
    
    
    public EscrituraSecuencialBarrio(String nombreArc) {
        nombreArchivo = nombreArc;
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroPropietario( Barrio p) {
        registroBarrio = p;
    }

    public void establecerSalida() {
        File f = new File(nombreArchivo);

        try {
            if (f.exists() == false) {
                salida = new AppendingObjectOutputStream(
                        new FileOutputStream(nombreArchivo));
            }

            salida = new AppendingObjectOutputStream(
                    new FileOutputStream(nombreArchivo, true));
           
            salida.writeObject(registroBarrio); // envía el registro como 
            // objeto al archivo
            salida.close();

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        } // fin de catch
    }

}
    

