/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;

public class Departamento implements Serializable{
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double valorAlicuotaMensual;
    private double costoFinal;
    private Barrio barrio;
    private String nombreEdificio;
    private String ubicacionDepartamento;
    
    public Departamento(Propietario propi, double precioMetro,double valorAlicuota,
            double numMetros,double costoF, Barrio bar, String nombEdi, String ubiDepa){
        propietario = propi;
        precioMetroCuadrado = precioMetro;
        valorAlicuotaMensual = valorAlicuota;
        numeroMetrosCuadrados = numMetros;
        costoFinal = costoF;
        barrio = bar;
        nombreEdificio = nombEdi;
        ubicacionDepartamento = ubiDepa;
    }
    
    public void establecerPropietario(Propietario propi){
        propietario = propi;
    }
    
    public void establecerPrecioMetroCuadrado(double precioMetro){
        precioMetroCuadrado = precioMetro;
    }
    
    public void establecerNumeroMetrosCuadrados(double numMetros){
        numeroMetrosCuadrados = numMetros;
    }
    
    public void establecerValorAlicuotaMensual(double valAl){
        valorAlicuotaMensual = valAl;
    }
    
    public void calcularCostoFinal() {
        costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * 12 * 5);
    }
    
    public void establecerBarrio(Barrio barr){
        barrio = barr;
    }
    
    public void establecerNombreEdificio(String nombEdi){
        nombreEdificio = nombEdi;
    }
    
    public void establecerUbicacionDepartamento(String ubicDepa){
        ubicacionDepartamento = ubicDepa;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioMetroCuadrado(){
        return precioMetroCuadrado;
    }
    
    public double obtenterNumeroMetrosCuadrados(){
        return numeroMetrosCuadrados;
    }
    
    public double obtenterValorAlicuotaMensual(){
        return valorAlicuotaMensual;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    public Barrio obtenerBarrio(){
        return barrio;
    }
    
    public String obtenerNombreEdificio(){
        return nombreEdificio;
    }
    
    public String obtenerUbicacionDepartamento(){
        return ubicacionDepartamento;
    }
}
