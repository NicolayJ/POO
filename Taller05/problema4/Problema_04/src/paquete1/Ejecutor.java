/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import paquete2.ManejoCheques;

public class Ejecutor {
    public static void main(String[] args) {
        
        ManejoCheques cheques1 = new ManejoCheques("Dayanna",
                "Banco del Pacifico", 285.50);
        cheques1.calcularComision();
        
        ManejoCheques cheques2 = new ManejoCheques("Carlos", 725);
        cheques2.calcularComision();
        
        System.out.printf("%s\n",cheques1);
        System.out.printf("%s\n",cheques2);
    }
}
