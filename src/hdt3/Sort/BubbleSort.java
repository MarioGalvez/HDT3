package Sort;

/**
 * Clase que implementa un algoritmo bubble sort. Basado en el ejemplo del
 * usuario Mashound de Java-Samples
 * <http://www.java-samples.com/showtutorial.php?tutorialid=220>
 * @author Mario Gálvez
 */
public class BubbleSort implements Sort {
    
    @Override
    public void Ordenar (Comparable[] lista) {
        Comparable t;
        for (int i=0; i<lista.length-1;i++){
            for (int j= i+1; j<lista.length;j++) {
                if (lista[i].compareTo(lista[j])>0) {
                    t=lista[i];
                    lista[i]=lista[j];
                    lista[j]=t;   
                }
            }
        }

    }
}
