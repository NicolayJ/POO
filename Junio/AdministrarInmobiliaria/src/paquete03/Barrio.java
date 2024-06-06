/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.io.Serializable;

/**
 *
 * @author reroes
 */

public class Barrio implements Serializable{
    
    private String nombreBarrio;
    private String referencia;
    
    public Barrio(String nombBarrio, String ref){
        nombreBarrio = nombBarrio;
        referencia = ref; 
    }
    
    public void establecerNombreBarrio(String nomBarrio){
        nombreBarrio = nomBarrio;
    }
    
    public void establecerReferencia(String ref){
        referencia = ref;
    }
    
    public String obtenerNombreBarrio(){
        return nombreBarrio;
    }
    
    public String obtenerReferencia(){
        return referencia;
    }
}
