
public class M1 {
	public static void main(String args[]) {
		int[] a = { 99, 0, 33, 27, 87, 80, 65, 77, 39, 88 };
		System.out.print("Zu sortierendes Array:" + " ");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		sortiere(a, 0, a.length - 1);
		System.out.print("Sortiertes Array:" + " ");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
	
	}
	
	static void sortiere(int []array, int begin, int end) {
		if(begin<end) {
			int pivotIndex = 1;
			int pivot = array[end];
			int begintemp = begin;
			int endtemp = end;
			
			while(true) {
				while(array[begintemp]> pivot) {
					begintemp++;
				}
				while(array[endtemp]< pivot) {
					endtemp--;
				}
				
				if(begintemp < endtemp) {
					int hilf = array[begintemp];
					array[begintemp] = array[endtemp];
					array[endtemp] = hilf;
				} else {
					pivotIndex = endtemp;
					break;
				}
			}
			sortiere(array, begin, pivotIndex-1);
			sortiere(array, pivotIndex +1, end);
		}
	}
}
