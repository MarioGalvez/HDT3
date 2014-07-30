
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * Universidad del Valle de Guatemala
 * Estructuras de Datos y Algoritmos
 * 
 *  Mario Gálvez    10113
 * 
 * Genera un archivo con datos generados aleatoriamente.
 */

/**
 *
 * @author Mario Gálvez
 * 
 */
public class Generador {
    
    /**
     * Genera un archivo con números aleatorios.
     * @param nombreArchivo Nombre del archivo con el que se guardan los datos.
     * @param cantidad Cantidad de datos a escribir.
     */
    public static void generarArchivo( String nombreArchivo, int cantidad ){
        try {
            // Abrir el archivo
            FileWriter fw = new FileWriter(nombreArchivo);
            BufferedWriter out = new BufferedWriter(fw);
            Random generador = new Random();
            generador.setSeed( System.currentTimeMillis() );

            // Escribir los datos en el archivo
            for (int n = 0; n != cantidad; ++n) {
                try {
                    out.write( Integer.toString( generador.nextInt() ) );
                    out.newLine();
                } catch (IOException ex) {
                    System.out.println("No se pudo escribir al archivo.");
                }
            }
            
            out.close();
            fw.close();
        } catch (IOException iOException) {
            System.out.println("No se pudo abrir el archivo: " + nombreArchivo);
        }
    }
}
