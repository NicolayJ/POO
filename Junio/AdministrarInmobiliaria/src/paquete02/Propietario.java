/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

import java.io.Serializable;

/**
 *
 * @author reroes
 */

public class Propietario implements Serializable{

    private String nombres;
    private String apellidos;
    private String identificacion;

    public Propietario(String nom, String apel, String id) {
        nombres = nom;
        apellidos = apel;
        identificacion = id;
    }

    public void establecerNombres(String nom) {
        nombres = nom;
    }

    public void establecerApellidos(String apel) {
        apellidos = apel;
    }

    public void establecerIdentificacion(String id) {
        identificacion = id;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }
}
