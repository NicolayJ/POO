/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;
import paquete2.LibretaNotas;

public class Ejecutor {
    
    public static void main(String[] args) {
        
        LibretaNotas libreta1 = new LibretaNotas("Diego", 10, 10,10);
        // Aunque no se envie parametros es necesario llamar el calcularPromedio
        libreta1.calcularPromedioNotas(); 
            
        LibretaNotas libreta2 = new LibretaNotas("Dalinda", 5, 8);
        libreta2.calcularPromedioNotas();

        
        System.out.printf("%s\n", libreta1);
        System.out.printf("%s\n",libreta2);
    }
}
