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

public class LecturaSecuencialDepartamento {
    
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamento;
    private String nombreArchivo;

    public LecturaSecuencialDepartamento(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);

        if (f.exists()) {
            try 
            {
                entrada = new AppendingObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Contructor. Error al abrir el archivo." + ioException);
            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaDepartamento() {
        
        departamento = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();  //casting
                    departamento.add(registro); // casting - se esta enviandoel registo al array
                    
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

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return departamento;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Departamentos\n";
        for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
            Departamento p = obtenerListaDepartamento().get(i);
            try {
                cadena = String.format("%sNombres del propietario: %s\n"
                        + "Apellidos del propietario: %s\n"
                        + "Identificacion: %s\n"
                        + "Numero de metro cuadrado: %.2f\n"
                        + "Numero de metros cuadrados: %.2f\n"
                        + "Valor alicuota mensual: %.2f\n"
                        + "Costo final: %.2f\n"
                        + "Nombre del Barrio: %s\n"
                        + "Referencia: %s\n"
                        + "Nombre del edificio: %s\n"
                        + "Ubicacion del departamento: %s\n"
                        , cadena,
                        p.obtenerPropietario().obtenerNombres(),
                        p.obtenerPropietario().obtenerApellidos(),
                        p.obtenerPropietario().obtenerIdentificacion(),
                        p.obtenerPrecioMetroCuadrado(),
                        p.obtenterNumeroMetrosCuadrados(),
                        p.obtenterValorAlicuotaMensual(),
                        p.obtenerCostoFinal(),
                        p.obtenerBarrio().obtenerNombreBarrio(),
                        p.obtenerBarrio().obtenerReferencia(),
                        p.obtenerNombreEdificio(),
                        p.obtenerUbicacionDepartamento());
            }catch (Exception e){
                    System.out.println(e);
            }
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

