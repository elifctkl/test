import javax.swing.JOptionPane;

public class b {
    public static void main(String[] args) {
        int[] array = { 99,90,79,75,70,60,55,37,23,17,16,9,8,6,5,1};
        
        for(int x : array) {
            System.out.print(x + " ");
        }
        
        int searchvalue = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie eine Zahl ein"));
        int ergebnis = binarySearch(array, searchvalue, 0, array.length - 1);
        System.out.println(ergebnis);
        if (ergebnis == -1)
            JOptionPane.showMessageDialog(null, "Zahl konnte nicht gefunden werden!");
        else 
            JOptionPane.showMessageDialog(null, "Die Position der gesuchten Zahl ist " + ergebnis + ".");

    }

    static int binarySearch(int[] array, int searchvalue, int bottom, int top) {
        int mid = bottom + ((top - bottom) / 2);

        System.out.println("\nbottom: " + bottom);
        System.out.println("mid: " + mid);
        System.out.println("top: " + top);
        if (array[mid] == searchvalue) {
            return mid;
        }
        if (array[mid] < searchvalue)
            return binarySearch(array, searchvalue, bottom, mid-1);
        else if (array[mid] > searchvalue)
            return binarySearch(array, searchvalue, mid-1, top);
        else
            return -1;
    
    }
}
