package sorts.comparison.com;


public class MergeSortPP {

	public static int temp = 0;
	public static int mid = 0;
	

	public static void merge(int[] array, int q) {
		int size = array.length;
		 if (size <= 4) {
			return;
		}

		else if (size % 4 == 0 && q % 2 == 0) {
			mid = size / 2;
		}

		else if (q % 2 == 0) {
			mid = q * 2;
			mid = size - mid;
		}

		else {
			mid = q * 2 + 2;
			mid = size - mid;
		}

		// Split left part
		int[] left = new int[mid];

		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}

		// Split right part

		int[] right = new int[size-mid];

		for (int i = mid; i < size; i++) {
			right[i - mid] = array[i];
			}
		
		merge(left, mid / 4);
		merge(right, right.length / 4);

		int i = 0;
		int j = 0;
		int k = 0;

		// Merge left and right arrays
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		// Collect remaining elements
		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	

	public static void swap(int index1, int index2, int numbers[]) {
		temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}
	
			/* 5 Comparison's To Sort Every Quadruples */
	public static void quadrupleSort(int[] array,int size,int remainder) {
		
	
		for (int i = remainder; i < size; i = i + 4) {
			
			if (array[i] > array[i + 2]) {
//array[0] and array[2]
				swap(i, i + 2, array);
			}

			if (array[i + 1] > array[i + 3]) {
// array[1] and array[3]
				swap(i + 1, i + 3, array);
			}

			if (array[i] > array[i + 1]) {
// array[0] and array[1]
				swap(i, i + 1, array);
			}

			if (array[i + 2] > array[i + 3]) {
//array[2] and array[3]
				swap(i + 2, i + 3, array);
			}
			if (array[i + 1] > array[i + 2]) {
//array[1] and array[2]
				swap(i + 1, i + 2, array);
				
			}

		}
		
	}

	public static void sort(int[] array) {
		int size=array.length;
		int remainder = size % 4;
		int k = size / 4;

			if (remainder >= 2) {
				// sort two elements
				if (remainder == 2) {
					if (array[0] > array[1]) {
						swap(0, 1, array);
					}
				}
				// Sort 3 Elements if remainder is 3
				else {
					if (array[0] > array[1])
						swap(0, 1, array);
					if (array[1] > array[2])
						swap(1, 2, array);
					if (array[0] > array[1])
						swap(0, 1, array);
				}
			}
			
		/* 5 Comparison's To Sort Every Quadruples */
			quadrupleSort(array, size,remainder);
			
		// Merge All Sorted Quadruples and Remainder Elements
			merge(array, k);
		

	}

}