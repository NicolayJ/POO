package paquete2;

public class Automotor {

    private String cedula;
    private String marcaVehiculo;
    private int anioFabricacion;
    private double valorVehiculo;
    private double valorMatricula;
    private int anioAntiguedad;

    public Automotor(String ced, String marca, int anio, double valor) {

        cedula = ced;
        marcaVehiculo = marca;
        anioFabricacion = anio;
        valorVehiculo = valor;

    }

    public Automotor(String ced, String marca, int anio) {

        cedula = ced;
        marcaVehiculo = marca;
        anioFabricacion = anio;
        valorVehiculo = 15000;

    }

    public void establecerCedula(String ced) {
        cedula = ced;
    }

    public void establecerMarcaVehiculo(String marca) {
        marcaVehiculo = marca;
    }

    public void establecerAnioFabricacion(int anio) {
        anioFabricacion = anio;
    }

    public void establecerValorVehiculo(double valor) {
        valorVehiculo = valor;
    }
    public void calcularValorMatricula() {
        valorMatricula = (0.00002 * valorVehiculo) * (2024 - anioFabricacion);
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerMarcaVehiculo() {
        return marcaVehiculo;
    }

    public int obtenerAnioFabricacion() {
        return anioFabricacion;
    }

    public double obtenerValorVehiculo() {
        return valorVehiculo;
    }

    public double obtenerValorMatricula() {
        return valorMatricula;
    }

    @Override
    public String toString() {

        String cadena = String.format("\nVALOR DE LA MATRICULA\n"
                + " Cedula: %s\n"
                + " Marca Del Vehiculo: %s\n"
                + " Anio De Fabricacion: %d\n"
                + " Valor Del Vehiculo: $ %.3f\n"
                + " Valor de Matricula: $ %.3f\n",
                obtenerCedula(), obtenerMarcaVehiculo(),
                obtenerAnioFabricacion(), obtenerValorVehiculo(),
                obtenerValorMatricula());

        return cadena;
    }
}
