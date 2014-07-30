/*
 * Universidad del Valle de Guatemala
 * Estructuras de Datos y Algoritmos
 * 
 * Mario Gálvez     10113
 * 
 * Especifica la interfaz que deben de implementar todos los algoritmos
 * de búsqueda.
 */

package Sort;

/**
 *
 * @author Mario Gálvez
 */
public interface Sort {
    /**
     * Recibe un arreglo de datos que implementen la interfaz Comparable 
     * para ordenarlos en orden no descendente.
     * @param datos Arreglo de datos a ordenar.
     */
    public void Ordenar( Comparable[] datos );
}
