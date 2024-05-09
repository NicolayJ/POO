/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import paquete2.Automotor;

public class Ejecutor {
    public static void main(String[] args) {
        
        Automotor auto1 = new Automotor("1167723495", "Hyundai", 
                2014, 35000);
        auto1.calcularValorMatricula();
        
        Automotor auto2 = new Automotor("1168437512", "Toyota");
        auto2.calcularValorMatricula();
        
        System.out.printf("%s\n",auto1);
        System.out.printf("%s\n",auto2);
    }
}
