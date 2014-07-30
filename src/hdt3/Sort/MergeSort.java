/*
 * Ordena una serie de datos que implementen la interface Comparable
 * utilizando un algoritmo por mezcla (Merge Sort).
 * 
 * Basado en la propuesta encontrada en Cormen, T et al., (2009),
 * Introduction to Algorithms, Tercera Edición, Instituto Tecnológico
 * de Massachusetts, Massachusetts.
 */

package Sort;

import java.util.Arrays;

/**
 *
 * @author Mario Gálvez
 */
public class MergeSort implements Sort {
    public Comparable[] LadoA, LadoB;
    /**
     * Ordena una lista de datos en orden ascendente (no-descedente).
     * @param datos Listado de elementos que implementan la interfaz
     * Comparable.
     */
    @Override
    public void Ordenar( Comparable[] datos ){
        // Se copia todo el arreglo dos veces para asegurar que el ladoA
        // y el ladoB tengan al menos la cantidad de datos necesarios y 
        // mantengan también el mismo tipo de datos.
        LadoA = datos.clone();
        LadoB = datos.clone();
        
        // System.out.println("\tDATOS INICIALES: " + Arrays.toString(datos) );
        Ordenamiento( datos, 0, datos.length );
        // System.out.println("\tDATOS ORDENADOS: " + Arrays.toString(datos) );
    }
    
    /**
     * Mezcla dos subarreglos contiguos de la lista de datos. Los subarreglos
     * estan dados por los rangos [primero, medio) y [medio, ultimo).
     * @param datos Listado de elementos que implementan la interfaz
     * Comparable
     * @param primero Índice del primer elemento de la lista.
     * @param medio Índice del elemento medio, que marca la separación entre
     * los subarreglos.
     * @param ultimo Índice del siguiente elemento después del último.
     */
    private void Mezclar( Comparable[] datos, int primero, int medio, int ultimo ){
        int cantA = medio - primero;   // Rango [primero, medio)
        int cantB = ultimo - medio;    // Rango [medio, ultimo)
        
        // Copiar los datos de cada subarreglo
        for( int i = 0; i != cantA; i++ )
            LadoA[i] = datos[primero + i];
        for( int j = 0; j != cantB; j++ )
            LadoB[j] = datos[medio + j];
        
        // Realizar la mezcla
        int actualA = 0;
        int actualB = 0;
        
        for( int k = 0; k != (ultimo-primero); ++k ){
            // Revisar que no se hayan acabado los datos de algun lado
            if( actualA == cantA ){
                datos[primero + k] = LadoB[actualB];
                actualB++;
                continue;
            } else if( actualB == cantB ) {
                datos[primero + k] = LadoA[actualA];
                actualA++;
                continue;
            }
            
            // Comparar los datos de cada lado para saber cuál agregar
            if( LadoA[actualA].compareTo( LadoB[actualB] ) <= 0 ){
                datos[primero + k] = LadoA[actualA];
                actualA++;
            } else {
                datos[primero + k] = LadoB[actualB];
                actualB++;
            }
        }
    }
    
    /**
     * Función recursiva que ordena los elementos en la lista dada. La 
     * lista se encuentra en el rango [primero, ultimo).
     * @param datos Listado de elementos que implementan la interfaz
     * Comparable
     * @param primero Índice del primer elemento de la lista.
     * @param ultimo Índice del siguiente elemento después del último.
     */
    private void Ordenamiento( Comparable[] datos, int primero, int ultimo ){
        if( primero < (ultimo-1) ){
            int medio = (primero + ultimo) / 2;
            Ordenamiento( datos, primero, medio );  // Rango [primero, medio)
            Ordenamiento( datos, medio, ultimo );   // Rango [medio, ultimo)
            Mezclar( datos, primero, medio, ultimo );
        }
    }
}
