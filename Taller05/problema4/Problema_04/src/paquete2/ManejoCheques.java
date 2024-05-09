/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;


public class ManejoCheques {
    private String nombreCliente;
    private String nombreBanco;
    private double valorCheque;
    private double comision;
    
    public ManejoCheques(String nom, String banc, double valor){
        nombreCliente = nom;
        nombreBanco = banc;
        valorCheque = valor;
    }
    
    public ManejoCheques(String nom, double valor){
        nombreCliente = nom;
        nombreBanco = "Banco de Loja";
        valorCheque = valor;
    }
    
    public void establecerNombreCliente(String nom){
        nombreCliente = nom;
    }
    
    public void establecerNombreBanco(String banco){
        nombreBanco = banco;
    }
    
    public void establecerValorCheque(double valorCh){
        valorCheque = valorCh;
    }
    
    public void calcularComision(){
        comision = valorCheque * 0.00003;
    }
    
    public String obtenerNombreCliente(){
        return nombreCliente;
    }
    
    public String obtenerNombreBanco(){
        return nombreBanco;
    }
    
    public double obtenerValorCheque(){
        return valorCheque;
    }
    
    public double obtenerComision(){
        return comision;
    }
    
    public String toString(){
        String cadena = String.format("MANEJO DE CHEQUES \n"
                + " Nombre del cliente: %s\n"
                + " Nombre del banco: %s\n"
                + " Valor del cheque: $ %.2f\n"
                + " Comision que cobra el banco: $ %.3f\n",
                obtenerNombreCliente(),
                obtenerNombreBanco(),
                obtenerValorCheque(),
                obtenerComision());
        
        return cadena;
    }
}
