//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        char arr[] = {'z', 'b', 'k', 'g', 'x', 'v', 'r', 't', 'm', 'y'};
        System.out.println("Zu sortierendes Array: ");
        for(int i = 0; i<arr.length; i++) {
        	System.out.print(new String(arr[i] + " "));
        }
        System.out.println("");
        sortiere(arr, 0, arr.length-1);
        System.out.println("Sortiertes Array: ");
        for(int i =0; i< arr.length; i++) {
        	System.out.print(new String(arr[i] + " "));
        }
        //quicksort(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
    }
    										//links  //rechts
    public static char teile(char arr[], int begin, int end) {
        
        //1. Pivot ermitteln
        int pivot = arr[(begin+end)/2];
        
        //2. While schleife erstellen um von links und rechts die jeweils falsch sortierten Elemente zu ermitteln
        while(begin <= end) {
            
            //3. die Elemente links werden geprueft ob diese kleiner als das pivot sind.
            //Sind sie es nicht, so wird sich der Standort (links) gemerkt
            while(arr[begin] > pivot) {
                begin++;
            }
            
            //4. die Elemente rechts werden geprueft ob diese groesser als das pivot sind.
            //Sind sie es nicht, so wird sich der Standort (rechts) gemerkt
            while(arr[end] < pivot) {
                end--;
            }
            
            //5. jetzt werden die beiden Stellen die sich gemerkt wurden, miteinander getauscht
            if(begin <= end) {
                int tmp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = (char) tmp;
                begin++;
                end--;
            }
        }
        //6. die linke Stelle wird zurueck gegeben
        return (char) begin;
    }
    
    //7. nun wird der endgueltige QuickSort gebildet
    public static void sortiere(char arr[], int begin, int end) {
        
        //8. wir ermitteln durch die methode teilung() den standort an dem zuletzt sortiert wurde (also die mitte)
        int index = teile(arr,begin,end);
        
        //9. hier wird die Methode so lange rekursiv aufgerufen, bis die linke seite vom Pivot sortiert ist
        if(begin < index -1) {
            sortiere(arr,begin, index-1);
        }
        
        //10. hier wird die Methode so lange rekursiv aufgerufen, bis die rechte seite vom Pivot sortiert ist
        if(index < end) {
            sortiere(arr,index,end);
        }
        
    }

}
