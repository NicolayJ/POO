/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

public class LibretaNotas {

    private String nombreEstudiante;
    private double calificacion01;
    private double calificacion02;
    private double calificacion03;
    private double promedioNota;
    
    // Los constructores pueden tener el mismo nombre pero debe varias sus parametros
    public LibretaNotas(String n, double c1, double c2, double c3) {
        nombreEstudiante = n;
        calificacion01 = c1;
        calificacion02 = c2;
        calificacion03 = c3;
    }

    public LibretaNotas(String n, double c1, double c2) {
        nombreEstudiante = n;
        calificacion01 = c1;
        calificacion02 = c2;
        calificacion03 = 10;
    }
    
    public void establecerNombreEstudiante(String x) {
        nombreEstudiante = x;
    }

    public void establecerCalificacion01(double x) {
        calificacion01 = x;
    }

    public void establecerCalificacion02(double x) {
        calificacion02 = x;
    }

    public void establecerCalificacion03(double x) {
        calificacion03 = x;
    }

    public void calcularPromedioNotas() {
        promedioNota = (calificacion01 + calificacion02 + calificacion03) / 3;
    }

    public String obtenerNombreEstudiante() {
        return nombreEstudiante;
    }

    public double obtenerCalificacion01() {
        return calificacion01;
    }

    public double obtenerCalificacion02() {
        return calificacion02;
    }

    public double obtenerCalificacion03() {
        return calificacion03;
    }

    public double obtenerPromedioNotas() {
        return promedioNota;
    }
    @Override
    public String toString(){
        String cadena = String.format("LIBRETAS DE CALIFICACIONES \n"
                + " Nombre del Estudiante: %s\n"
                + " Calificacion 1: %.3f\n"
                + " Calificacion 2: %.3f\n"
                + " Calificacion 3: %.3f\n"
                + " Promedio Final: %.3f\n",
                nombreEstudiante,
                obtenerCalificacion01(),
                obtenerCalificacion02(),
                obtenerCalificacion03(),
                obtenerPromedioNotas());
        return cadena;
    }
}
