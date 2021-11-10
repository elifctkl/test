import java.util.Arrays;

public class Sortiere {

	public static void sortiereMitQuicksortAusBeschreibung(char[] a, int begin, int end) {
		System.out.println(
				"Aufruf von sortiereMitQuicksortAusBeschreibung: \n" + "begin = " + begin + " und end = " + end + ".");
		if (end - begin <= 0) {
			System.out.println("(Teil-)Array ist sortiert.");
		} else {
			int li = begin;
			int re = end;
			int m = (begin + end) / 2;
			System.out.println("partitioniere nun: " + Arrays.toString(Arrays.copyOfRange(a, begin, end + 1)));
			System.out.println("Der Index des Pivot-Elementes ist " + m + ". Pivot-Element ist " + a[m]);
			int pivot = a[m];
			while (li <= re) {
				while (a[li] > pivot) { // "<" für aufsteigend statt absteigend sortieren
					li++;
				}
				while (a[re] < pivot) { // ">" für aufsteigend statt absteigend sortieren
					re--;
				}
				if (li <= re) {
					char hilfe = a[li];
					a[li] = a[re];
					a[re] = hilfe;
					li++;
					re--;
				}
			}
			System.out
					.println("partitionierter Teil ist nun: " + Arrays.toString(Arrays.copyOfRange(a, begin, end + 1)));

			sortiereMitQuicksortAusBeschreibung(a, begin, re);
			sortiereMitQuicksortAusBeschreibung(a, li, end);
		}
	}

	public static void sortiereMitQuickSortAusVorlesung(char[] a, int begin, int end) {
		System.out.println(
				"Aufruf von sortiereMitQuickSortAusVorlesung: \n" + "begin = " + begin + " und end = " + end + ".");

		if (end - begin > 0) {
			int pivotIndex = partitioniere(a, begin, end);
			sortiereMitQuickSortAusVorlesung(a, begin, pivotIndex - 1);
			sortiereMitQuickSortAusVorlesung(a, pivotIndex + 1, end);
		}
	}

	private static int partitioniere(char[] a, int left, int right) {
		int pivotValue = choosePivot(a, left, right);

		System.out.println("partitioniere nun: " + Arrays.toString(Arrays.copyOfRange(a, left, right + 1)));
		System.out.println("left: " + left + " right:" + right + " pivotValue:" + pivotValue);

		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (a[j] >= pivotValue) { // "<=" für aufsteigend statt absteigend sortieren
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, right);
		System.out.println("partitionierter Teil ist nun: " + Arrays.toString(Arrays.copyOfRange(a, left, right + 1)));
		return i + 1;

	}

	private static void swap(char[] a, int i, int j) {
		System.out.println("swap " + a[i] + " " + a[j]);
		char temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	private static int choosePivot(char[] a, int left, int right) {
		return a[right];
	}

	public static void sortiereMitMergeSort(char[] a, char[] helpA, int begin, int end) {
		System.out.println("Aufruf von sortiereMitMergeSort: \n" + "begin = " + begin + " und end = " + end + ".");

		if (end - begin > 0) {
			int middle = (begin + end) / 2;
			sortiereMitMergeSort(a, helpA, begin, middle);
			sortiereMitMergeSort(a, helpA, middle + 1, end);
			mergeParts(a, begin, middle, end, helpA);
			System.out.println("left: " + begin + " end:" + end + " middle:" + middle);
			System.out.println("Gemergter Teil ist nun: " + Arrays.toString(Arrays.copyOfRange(a, begin, end)));
		}
	}

	private static void mergeParts(char[] a, int left, int middle, int right, char[] helpa) {
		for (int i = left; i <= right; i++) {
			helpa[i] = a[i];
		}
		int i = left;
		int j = middle + 1;
		int k = left;
		while (i <= middle && j <= right) { // alternative: use for-loop
			if (helpa[i] >= helpa[j]) { // "<=" für aufsteigend statt absteigend sortieren
				a[k] = helpa[i];
				i++;
			} else {
				a[k] = helpa[j];
				j++;
			}
			k++;
		}
		while (i <= middle) { // Copy rest of first half, if needed
			a[k] = helpa[i];
			k++;
			i++;
		}
		while (j < right) { // Copy rest of second half, if needed
			a[k] = helpa[j];
			k++;
			j++;
		}
	}

	public static void sortiere(char[] a, int begin, int end) {

		// sortiereMitQuicksortAusBeschreibung(a, begin, end);
		// sortiereMitQuickSortAusVorlesung(a, begin, end);
		sortiereMitMergeSort(a, new char[a.length], begin, end);
	}

	static int BinarySearchRecReverse(int[] A, int searchvalue, int bottom, int top) {
		// Invarianten: searchvalue >= A[i] for all i < bottom,
		// searchvalue < A[i] for all i > top
		if (top < bottom)
			if (A[top] == searchvalue)
				return top;
			else
				return -1;
		int mid = bottom + ((top - bottom) / 2);
		if (A[mid] < searchvalue) // ">" für aufsteigend statt absteigend sortieren
			return BinarySearchRecReverse(A, searchvalue, bottom, mid - 1);
		else
			return BinarySearchRecReverse(A, searchvalue, mid + 1, top);
	}

	public static void main(String[] args) {
		char[] a = { 'z', 'b', 'k', 'g', 'x', 'v', 'r', 't', 'm', 'y' };

		System.out.println("Zu sortierendes Array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print("" + a[i] + " ");
		}
		System.out.println("");
		sortiere(a, 0, a.length - 1);
		System.out.println("Sortiertes Array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print("" + a[i] + " ");
		}
		int[] searchArray = { 99, 90, 79, 75, 70, 60, 55, 37, 23, 17, 16, 9, 8, 6, 5, 1 };
		int searchvalue = 5;
		int foundPosition = BinarySearchRecReverse(searchArray, searchvalue, 0, searchArray.length - 1);

		System.out.println();
		System.out.println(foundPosition == -1 ? "searchvalue " + searchvalue + " nicht gefunden"
				: "searchvalue " + searchvalue + " an Position " + foundPosition + " gefunden!");

	}

}
