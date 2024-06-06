/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

/**
 *
 * @author reroes
 */
import java.io.Serializable;

public class Ciudad implements Serializable {

    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(String ciu, String pro) {
        nombreCiudad = ciu;
        nombreProvincia = pro;
    }

    public void establecerNombreCiudad(String ciu) {
        nombreCiudad = ciu;
    }

    public void establecerNombreProvinciai(String pro) {
        nombreProvincia = pro;
    }

    public String obtenenerNombreCiudad() {
        return nombreCiudad;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }
}
