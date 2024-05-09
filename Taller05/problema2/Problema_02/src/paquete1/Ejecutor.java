/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1; 

import paquete2.InformacionDocentes;

public class Ejecutor {
    public static void main(String[] args) {
        
        InformacionDocentes info1 = new InformacionDocentes(
                "Doris", "Carrion",821.5,"1103796542");
        info1.calcularSueldoTotal();
        
        InformacionDocentes info2 = new InformacionDocentes(
                "Diego", "Jimenez", "1155019763");
        info2.calcularSueldoTotal();
        
        System.out.printf("%s\n",info1);
        
        System.out.printf("%s\n",info2);

    }
}
