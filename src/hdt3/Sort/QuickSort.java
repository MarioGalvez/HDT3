/*
 * Ordena una serie de datos que implementen la interfaz Comparable
 * utilizando el algoritmo de QuickSort.
 * 
 * Basado en el libro de texto utilizado en el curso.
 * Java Structures, de Duane A. Bailey.
 * 
 */
package Sort;

import java.util.Arrays;

/**
 *
 * @author Mario Gálvez
 */

public class QuickSort implements Sort{
    
    /** 
     * @descripcion: Obtiene la cantidad de datos a odenar y llama al metodo principal.
     * @nombre: Ordenar()
     * @parametro: dato Comparable[]
     * @retorno: 
     * @preCondiciones: 
     * @postCondiciones: 
     */    
    @Override
    public void Ordenar(Comparable[] dato){
                        
        //System.out.println("\tDatos sin ordenar: " + Arrays.toString(dato) );
        
        OrdenarRapido(dato, dato.length - 1,  0);
        
        //System.out.println("\tDatos ordenados:   " + Arrays.toString(dato) );        
        
    }
    
    /** 
     * @descripcion: Intercambia los valores de dato[izquierda] con dato[derecha]
     * @nombre: Intercambiar()
     * @parametro: dato Comparable[], derecha entero, izquierda entero.
     * @retorno: 
     * @preCondiciones: 
     * @postCondiciones: dato[izquierda] := dato[derecha]; dato[derecha] : = dato[izquierda] 
     */      
    private void Intercambiar(Comparable[] dato, int derecha, int izquierda){
    
        Comparable temporal = dato[izquierda];
        dato[izquierda] = dato[derecha];
        dato[derecha] = temporal;
     
    }
    
    /** 
     * @descripcion: Coloca los datos mayores a la derecha del pivote y los menores a la izquierda.
     * @nombre: Particionar()
     * @parametro: dato Comparable[], derecha entero, izquierda entero.
     * @retorno: ultima posicion del valor mas a la izquierda.
     * @preCondiciones: izquierda <= derecha
     * @postCondiciones: dato[izquierda] colocado en la posicion indicada. {retorno}
     */      
    private int Particionar(Comparable[] dato,  int derecha, int izquierda){
        
        while (true){
            
            while (izquierda < derecha && dato[izquierda].compareTo(dato[derecha]) < 0)
                derecha--;
            if (izquierda < derecha )
                Intercambiar(dato, derecha,izquierda++);
            else return izquierda;
            
            
            while (izquierda < derecha && dato[izquierda].compareTo(dato[derecha]) < 0)
                izquierda++;
            if (izquierda < derecha )
                Intercambiar(dato,derecha--, izquierda);
            else return derecha;            
        }
    }
    
    /** 
     * @descripcion: Realiza recursivamente el mismo procedimiento hasta que los datos esten ordenados.
     * @nombre: OrdenarRapido() {Quick Sort}
     * @parametro: dato Comaparable[], derecha entero, izquierda entero.
     * @retorno: 
     * @preCondiciones: izquierda <= derecha
     * @postCondiciones: datos ordenados
     */      
    private void OrdenarRapido(Comparable[] dato, int derecha, int izquierda){
        
        int pivote;
        
        if (izquierda >= derecha)
            return;
        
        pivote = Particionar(dato, derecha, izquierda);
        OrdenarRapido(dato, pivote-1, izquierda);
        OrdenarRapido(dato, derecha, pivote+1);
        
    }
}    


