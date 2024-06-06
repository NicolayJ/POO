/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;
import paquete02.Propietario;
import paquete04.Ciudad;

public class Casa implements Serializable{
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double costoFinal;
    private Ciudad ciudad;
    private int numeroCuartos;
    
    public Casa(Propietario propi, double precioMetro, double numMetros,
            Ciudad urbe, int numCuartos){
        propietario = propi;
        precioMetroCuadrado = precioMetro;
        numeroMetrosCuadrados = numMetros;
        ciudad = urbe;
        numeroCuartos = numCuartos;
    }
    
    public void establecerPropietario(Propietario propi){
        propietario = propi;
    }
    
    public void establecerPrecioMetroCuadrado(double precio){
        precioMetroCuadrado = precio;
    }
    
    public void establecerNumeroMetrosCuadrados(double numMetros){
        numeroMetrosCuadrados = numMetros;
    }
    
    public void calcularCostoFinal() {
        costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado) + 3000;
    }
    
    public void establecerCiudad(Ciudad urbe){
        ciudad = urbe;
    }
    
    public void establecerNumeroCuartos(int numCuartos){
        numeroCuartos = numCuartos;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioMetroCuadrado(){
        return precioMetroCuadrado;
    }
    
    public double obtenerNumeroMetroCuadrado(){
        return numeroMetrosCuadrados;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public int obtenerNumeroCuartos(){
        return numeroCuartos;
    }
}