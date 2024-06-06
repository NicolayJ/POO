/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

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
public class LecturaSecuencialBarrio {
    
    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrio;
    private String nombreArchivo;
    private String barriosId;
    private Barrio buscarBarrio;

    public LecturaSecuencialBarrio(String n) {
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

    public void establecerListaBarrio() {
        // 
        barrio = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrio.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

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
    
    public void establecerIdBarrio(String b){
        barriosId = b;
    }
    
    public void establecerBuscarbarrio(){
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    System.out.println(registro.obtenerNombreBarrio());
                    if(registro.obtenerNombreBarrio().equals(barrio)){
                        buscarBarrio = registro;
                        break;
                    }
                    
                } catch (EOFException endOfFileException) {
                    return;
                    
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }
    
    public ArrayList<Barrio> obtenerListaBarrio() {
        return barrio;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerIdBarrio(){
        return barriosId; 
    }    
    
    public Barrio obtenerBuscarBarrio(){
        return buscarBarrio;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Barrios\n";
        for (int i = 0; i < obtenerListaBarrio().size(); i++) {
            Barrio p = obtenerListaBarrio().get(i);
            cadena = String.format("%s\tNombre del Barrio: %s\n"
                    + "\tReferencia: %s\n", cadena,
                    p.obtenerNombreBarrio(),
                    p.obtenerReferencia());
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

