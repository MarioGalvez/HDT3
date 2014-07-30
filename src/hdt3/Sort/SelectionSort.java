/*
 * @Descripción: El ordenamiento por inserción toma un elemento y se compara todos los elementos k 
 * mayor a menor. Este elemento es k+1 y se detiene la comparación cuando encuentra un elemento menor
 * @Pre-condiciones:Obtener un conjunto de elementos
 * @Post-condiciones:
 * http://en.literateprograms.org/Insertion_sort_(Java)
 */

package Sort;

/**
 *
 * @author Mario Gálvez
 */
public class SelectionSort implements Sort {
//  
    @Override
    public void Ordenar( Comparable[] datos ){
     for (int i=0; i < datos.length; i++) {
        /* Insert a[i] into the sorted sublist */
        Object v = datos[i];
        int j;
        for (j = i - 1; j >= 0; j--) {
            if (((Comparable)datos[j]).compareTo(v) <= 0) break;
            datos[j + 1] = datos[j];
        }
        datos[j + 1] = (Comparable) v;
    }
  
  
 }
}

