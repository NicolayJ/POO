/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

public class Automotor {
    private String cedulaDuenio;
    private String marcaVehiculo;
    private int anioFabricacion;
    private double valorVehiculo;
    private double valorMatricula;
    
    public Automotor(String ced, String marca, int anio, double valor){
        cedulaDuenio = ced;
        marcaVehiculo = marca;
        anioFabricacion = anio;
        valorVehiculo = valor;
    }
    
    public Automotor(String ced, String marca){
        cedulaDuenio = ced;
        marcaVehiculo = marca;
        anioFabricacion = 2000;
        valorVehiculo = 7500;
    }
    
    public void establecerCedulaDuenio(String ced){
        cedulaDuenio = ced;
    }
    
    public void establecerMarcaVehiculo(String marca){
        marcaVehiculo = marca;
    }
    
    public void establecerAnioFabricacion(int anio){
        anioFabricacion = anio;
    }
    
    public void establecerValorVehiculo(double valorVe){
        valorVehiculo = valorVe;
    }
    
    public void calcularValorMatricula(){
        valorMatricula = valorVehiculo * 0.00002 * (2024 - anioFabricacion); 
    }
    
    public String obtenerCedulaDuenio(){
        return cedulaDuenio;
    }
    
    public String obtenerMarcaVehiculo(){
        return marcaVehiculo;
    }
    
    public int obtenerAnioFabricacion(){
        return anioFabricacion;
    }
    
    public double obtenerValorVehiculo(){
        return valorVehiculo;
    }
    
    public double obtenerMatricula(){
        return valorMatricula;
    }
    
    public String toString(){
        String cadena = String.format("INFORMACION DEL VEHICULO\n"
                + " Cedula del duenio: %s\n"
                + " Marca del vehiculo: %s\n"
                + " Anio de Fabricacion: %d\n"
                + " Valor del vehiculo: $ %.2f\n"
                + " Valor de la matricula: $ %.2f\n",
                obtenerCedulaDuenio(),
                obtenerMarcaVehiculo(),
                obtenerAnioFabricacion(),
                obtenerValorVehiculo(),
                obtenerMatricula());
        
        return cadena;
    }
}
