/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

/**
 *
 * @author dj931
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AppendingObjectInputStream extends ObjectInputStream {

    public AppendingObjectInputStream(FileInputStream fileInputStream) throws IOException {
        super(fileInputStream);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        // No leer el encabezado del flujo
        // reset();
    }
}
