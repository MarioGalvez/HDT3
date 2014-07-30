/*
 * Universidad del Valle de Guatemala
 * Estructuras de Datos y Algoritmos
 * 
 *  Mario Gálvez    10113
 *  
 * 
 * Hoja de trabajo 3
 * Implementa varios algoritmos de ordenamiento de datos y mide los tiempos
 * para encontrar sus complejidades.
 */

import Sort.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Mario Gálvez
 */
public class Analizador {

    /**
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        String nombreArchivo = "datosOrdenados.txt";
        int cantidadDatos = 2000;
        
        // Generar los números aleatorios
        // Generador.generarArchivo( nombreArchivo, cantidadDatos );
        
        // Ordenar los datos
        Comparable[] datosOriginales = leerArchivo( nombreArchivo, cantidadDatos );
        Comparable[] d1, d2, d3, d4;
        d1 = datosOriginales.clone();
        d2 = datosOriginales.clone();
        d3 = datosOriginales.clone();
        d4 = datosOriginales.clone();
        
        probarAlgoritmo( new BubbleSort(), d1 );
        probarAlgoritmo( new MergeSort(), d2 );
        probarAlgoritmo( new QuickSort(), d3 );
        probarAlgoritmo( new SelectionSort(), d4 );
        
        // Comprobar que los datos sean iguales
        if( Arrays.equals(d1, d2) && Arrays.equals(d2, d3) && Arrays.equals(d3, d4) ){
            System.out.println("Los datos se ordenaron bien :)");
        } else {
            System.out.println("Los datos no se ordenaron bien :(");
        }
    }
    
    /**
     * Prueba un algoritmo con los datos leidos desde un archivo.
     * @param algoritmo Algoritmo a utilizar.
     */
    public static void probarAlgoritmo( Sort algoritmo, Comparable[] datos ){
        algoritmo.Ordenar(datos);
    }
    
    /**
     * Lee un archivo de datos numéricos y los convierte en un arreglo de
     * Comparable.
     * @param nombreArchivo Nombre del archivo a leer.
     * @return Arreglo con los datos leidos.
     */
    private static Comparable[] leerArchivo( String nombreArchivo, int cantidad ){
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        try {
            // Abrir el archivo
            FileInputStream fis = new FileInputStream(nombreArchivo);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));

            String linea;
            
            int leidos = 0;
            while ( (linea = buf.readLine()) != null && leidos != cantidad ) {
                Integer numero = Integer.parseInt(linea);
                retorno.add(numero);
                ++leidos;
            }
        } catch (IOException iOException) {
            System.out.println( "No se pudo abrir el archivo: " + nombreArchivo );
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Número inválido");
        }
        
        return retorno.toArray( new Comparable[0] );
    }
}
