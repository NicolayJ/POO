/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

public class InformacionDocentes {
    private String nombre;
    private String apellido;
    private double sueldoBasico;
    private double sueldoTotal;
    private String cedula;
    
    public InformacionDocentes(String nom, String apell, double sueldBas,String ced){
        nombre = nom;
        apellido = apell;
        sueldoBasico = sueldBas;
        cedula = ced;
    }
    
    public InformacionDocentes(String nom, String apell, String ced){
        nombre = nom;
        apellido = apell;
        sueldoBasico = 460;
        cedula = ced;
    }
    
    public void establecerNombre(String nom){
        nombre = nom;
    }
    
    public void establecerApellidos(String apel){
        apellido = apel;
    }
    
    public void establecerSueldoBasico(double suelBas){
        sueldoBasico = suelBas;
    }
    
    public void calcularSueldoTotal(){
        sueldoTotal = sueldoBasico + (sueldoBasico * 0.20);
    }
    
    public void establecerCedula(String ced){
        cedula = ced;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public String obtenerApellido(){
        return apellido;
    }
    
    public double obtenerSueldoBasico(){
        return sueldoBasico;
    }
    
    public double obtenerSueldoTotal(){
        return sueldoTotal;
    }
    
    public String obtenerCedula(){
        return cedula;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("INFORMACION\n"
                + " Nombre: %s\n"
                + " Apellido: %s\n"
                + " Cedula: %s\n"
                + " Sueldo basico: $ %.2f\n"
                + " Sueldo total: $ %.2f\n",
                obtenerNombre(),
                obtenerApellido(),
                obtenerCedula(),
                obtenerSueldoBasico(),
                obtenerSueldoTotal());
        return cadena;
    }
    
}
