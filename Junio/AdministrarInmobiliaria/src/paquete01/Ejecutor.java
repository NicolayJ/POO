/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.ArrayList;
import java.util.Scanner;
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {

        Scanner tecla = new Scanner(System.in);

        String archivoPropie = "data/lospropietarios.dat";
        String archivoBarrios = "data/losbarrios.dat";
        String archivoCiudades = "data/lasciudades.dat";
        String archivoCasa = "data/miscasas.dat";
        String archivoDepa = "data/misdepartamentos.dat";

        String opcion;
        int seleccion;

        boolean bandera = true;
        do {
            mostrarMenu();
            seleccion = tecla.nextInt();
            tecla.nextLine();

            System.out.println("----------------------------");
            switch (seleccion) {
                case 1:
                    agregarPropietario(tecla, archivoPropie);
                    break;
                case 2:
                    mostrarPropietario(archivoPropie);
                    break;
                case 3:
                    agregarBarrio(tecla, archivoBarrios);
                    break;
                case 4:
                    mostrarBarrio(archivoBarrios);
                    break;
                case 5:
                    agregarCiudad(tecla, archivoCiudades);
                    break;
                case 6:
                    mostrarCiudad(archivoCiudades);
                    break;
                case 7:
                    agregarCasa(tecla, archivoPropie, archivoCasa, archivoCiudades);
                    break;
                case 8:
                    mostrarCasa(archivoCasa);
                    break;
                case 9:
                    agregarDepartamento(tecla, archivoDepa, archivoPropie, archivoBarrios);
                    break;
                case 10:
                    mostrarDepartamento(archivoDepa);
                    break;
                default:
                    System.out.println("Ingrese una opcion del 1 al 10");
            }
            System.out.println("Desea salir del sistema? (Si/No): ");
            opcion = tecla.nextLine();
            if ("Si".equalsIgnoreCase(opcion)) {
                bandera = false;
            }
        } while (bandera);
        System.out.println("Saliendo del sistema, gracias por preferirnos...");

    }

    public static void mostrarMenu() {
        System.out.println("\t\t     SISTEMA DE GESTION\n"
                + "-------------------------- MENU -------------------------\n");
        System.out.println("\t1 --> Ingresar propietario");
        System.out.println("\t2 --> Mostrar lista de propietario");
        System.out.println("\t3 --> Ingresar barrio");
        System.out.println("\t4 --> Mostrar lista de barrio");
        System.out.println("\t5 --> Ingresar ciudad");
        System.out.println("\t6 --> Mostrar lista de ciudad");
        System.out.println("\t7 --> Ingresar casa");
        System.out.println("\t8 --> Mostrar lista de casa");
        System.out.println("\t9 --> Ingresar departamento");
        System.out.println("\t10 --> Mostrar lista de departamento");
        System.out.print("-------------------------------------------------------\n"
                + "Ingrese el numero de las opciones disponibles (1 - 10): ");
    }

    public static void agregarPropietario(Scanner tecla, String archivoPropie) {

        String nombres, apellidos, identificacion;

        System.out.print("Nombres del propietario: ");
        nombres = tecla.nextLine();
        System.out.print("Apellidos Del Propietario: ");
        apellidos = tecla.nextLine();
        System.out.print("Identificacion Del Propietarios: ");
        identificacion = tecla.nextLine();

        Propietario propietario = new Propietario(
                nombres,
                apellidos,
                identificacion);

        EscrituraSecuencialPropietario archivoPro
                = new EscrituraSecuencialPropietario(archivoPropie);
        archivoPro.establecerRegistroPropietario(propietario);
        archivoPro.establecerSalida();
    }

    public static void mostrarPropietario(String archivoPropie) {

        LecturaSecuencialPropietario lectura
                = new LecturaSecuencialPropietario(archivoPropie);
        lectura.establecerListaPropietario();

        System.out.println(lectura);
    }

    public static void agregarBarrio(Scanner tecla, String archivoBarrios) {
        String nombreBarrio, referencia;

        System.out.print("Nombres Del Barrio:  ");
        nombreBarrio = tecla.nextLine();
        System.out.print("Referencia:  ");
        referencia = tecla.nextLine();

        Barrio barrio = new Barrio(nombreBarrio, referencia);

        EscrituraSecuencialBarrio archivoBar
                = new EscrituraSecuencialBarrio(archivoBarrios);

        archivoBar.establecerRegistroPropietario(barrio);
        archivoBar.establecerSalida();
    }

    public static void mostrarBarrio(String archivoBarrios) {

        LecturaSecuencialBarrio lectura
                = new LecturaSecuencialBarrio(archivoBarrios);
        lectura.establecerListaBarrio();

        System.out.println(lectura);
    }

    public static void agregarCiudad(Scanner tecla, String archivoCiudades) {
        String nombreCiudad, nombrePronvicia;

        System.out.print("Nombre De La Ciudad:  ");
        nombreCiudad = tecla.nextLine();
        System.out.print("Nombre De La Provincia:  ");
        nombrePronvicia = tecla.nextLine();

        Ciudad ciudades = new Ciudad(nombreCiudad, nombrePronvicia);

        EscrituraSecuencialCiudad archivoCiudad
                = new EscrituraSecuencialCiudad(archivoCiudades);
        archivoCiudad.establecerRegistroCiudad(ciudades);
        archivoCiudad.establecerSalida();
    }

    public static void mostrarCiudad(String archivoCiudades) {

        LecturaSecuencialCiudad lectura
                = new LecturaSecuencialCiudad(archivoCiudades);
        lectura.establecerListaCiudad();

        System.out.println(lectura);
    }

    public static void agregarCasa(Scanner tecla, String archivoPropie,
            String archivoCasa, String archivoCiudades) {

        String id, nombCiu;
        int numCuartos;
        double precioMetroCua, numMetroCuad;

        System.out.print("Identificacion: ");
        id = tecla.nextLine();

        LecturaSecuencialPropietario propi
                = new LecturaSecuencialPropietario(archivoPropie);
        propi.establecerIdentificador(id);
        propi.establecerBuscarPropietario();
        Propietario propietario = propi.obtenerBuscarPropietario();

        System.out.println("---------------o");
        System.out.print("Precio por metro cuadrado: ");
        precioMetroCua = tecla.nextDouble();
        System.out.print("Numero de metros cuadrados: ");
        numMetroCuad = tecla.nextDouble();
        System.out.print("Numero de cuartos: ");
        numCuartos = tecla.nextInt();
        tecla.nextLine();
        System.out.println("---------------o");
        System.out.print("Nombre de la ciudad: ");
        nombCiu = tecla.nextLine();

        LecturaSecuencialCiudad urbe
                = new LecturaSecuencialCiudad(archivoCiudades);
        urbe.establecerIdentificador(nombCiu);
        urbe.establecerBuscarCiudad();
        Ciudad ciudades = urbe.obtenerBuscarCiudad();

        Casa casa = new Casa(propietario, precioMetroCua,
                numMetroCuad, ciudades, numCuartos);
        casa.calcularCostoFinal();

        EscrituraSecuencialCasa archivo
                = new EscrituraSecuencialCasa(archivoCasa);
        archivo.establecerRegistroCasa(casa);
        archivo.establecerSalida();

    }

    public static void mostrarCasa(String archivoCasa) {

        LecturaSecuencialCasa lectura
                = new LecturaSecuencialCasa(archivoCasa);
        lectura.establecerListaCasa();

        System.out.println(lectura);

    }

    public static void agregarDepartamento(Scanner tecla, String archivoDepa,
            String archivoPropie, String archivoBarrios) {

        String nombBar, nombEdi, ubiEdi, id;
        double precioMetroCua, numMetroCuads, valorAlicuotaMen;

        System.out.print("Identificacion del propietario: ");
        id = tecla.nextLine();

        LecturaSecuencialPropietario propietario
                = new LecturaSecuencialPropietario(archivoPropie);
        propietario.establecerIdentificador(id);
        propietario.establecerBuscarPropietario();

        Propietario propi = propietario.obtenerBuscarPropietario();

        System.out.print("---------------------------o\n");
        System.out.print("Precio por metro cuadrado: $ ");
        precioMetroCua = tecla.nextDouble();
        System.out.print("Numero de metros cuadrados: ");
        numMetroCuads = tecla.nextDouble();
        System.out.print("Valor alicuota mensual: ");
        valorAlicuotaMen = tecla.nextDouble();
        tecla.nextLine();
        System.out.print("---------------------------o\n");
        System.out.print("Nombre del barrio: ");
        nombBar = tecla.nextLine();

        LecturaSecuencialBarrio lecturaBarrio
                = new LecturaSecuencialBarrio(archivoBarrios);
        lecturaBarrio.establecerListaBarrio();
        ArrayList<Barrio> listaBarrios = lecturaBarrio.obtenerListaBarrio();

        Barrio bar = null;

        for (Barrio b : listaBarrios) {
            if (b.obtenerNombreBarrio().equalsIgnoreCase(nombBar)) {
                bar = b;
                break;
            }
        }

        if (bar == null) {
            System.out.println("Barrio no encontrado.");
            return;
        }

        System.out.print("Referencia: ");
        String refer = tecla.nextLine();

        System.out.print("---------------------------o\n");
        System.out.print("Nombre del edificio: ");
        nombEdi = tecla.nextLine();
        System.out.print("Ubicacion del edificio: ");
        ubiEdi = tecla.nextLine();

        Departamento departamento = new Departamento(propi,
                precioMetroCua,
                valorAlicuotaMen,
                numMetroCuads,
                precioMetroCua,
                bar,
                nombEdi,
                ubiEdi);
        departamento.calcularCostoFinal();

        EscrituraSecuencialDepartamento archivoDeparta
                = new EscrituraSecuencialDepartamento(archivoDepa);
        archivoDeparta.establecerRegistroDepartamento(departamento);
        archivoDeparta.establecerSalida();
    }

    public static void mostrarDepartamento(String archivoDepa) {

        LecturaSecuencialDepartamento lectura
                = new LecturaSecuencialDepartamento(archivoDepa);
        lectura.establecerListaDepartamento();

        System.out.println(lectura);

    }
}
