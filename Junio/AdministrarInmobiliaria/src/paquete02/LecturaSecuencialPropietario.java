/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

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
public class LecturaSecuencialPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietario;
    private String nombreArchivo;
    private String identificacion;
    private Propietario buscarPropietario;

    public LecturaSecuencialPropietario(String n) {
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

    public void establecerListaPropietario() {

        propietario = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietario.add(registro);
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

    public void establecerIdentificador(String id) {
        identificacion = id;
    }

    public void establecerBuscarPropietario() {
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
              
                    if (registro.obtenerIdentificacion().equals(identificacion)) {
                        buscarPropietario = registro;
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

    public ArrayList<Propietario> obtenerListaPropietario() {
        return propietario;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    public Propietario obtenerBuscarPropietario() {
        return buscarPropietario;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Prpietarios\n";
        for (int i = 0; i < obtenerListaPropietario().size(); i++) {
            Propietario p = obtenerListaPropietario().get(i);
            cadena = String.format("%s\tPropietario %d: %s %s %s\n", 
                    cadena, (i+1),
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerIdentificacion());
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
