package sorts.comparison.com;

import java.util.ArrayList;
import java.util.List;

public class AmeeqSort {

	static int temp = 0;
	static int mid = 0;

	public static void merge(int[] array, int q) {

		if (array.length <= 4) {
			return;
		}

		else if (array.length % 4 == 0 && q % 2 == 0) {
			mid = array.length / 2;
		}

		else if (q % 2 == 0) {
			mid = q * 2;
			mid = array.length - mid;
		}

		else {
			mid = q * 2 + 2;
			mid = array.length - mid;
		}

		// Split left part
		int[] left = new int[mid];

		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}

		// Split right part
		int[] right = new int[array.length - mid];

		for (int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];

		}
		merge(left, left.length / 4);
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

	public static void main(String[] args) {

int[] numbers= {117, 50, 49, 35, 153, 174, 99, 172, 10, 102, 165, 55, 85, 189, 199, 5, 74, 64, 198, 161, 83, 34, 46, 45, 54, 4, 178};

		int k = numbers.length / 4;
		int remainder = numbers.length % 4;

		if (remainder >= 2) {
//sort two elements
			if (remainder == 2) {
				if (numbers[0] > numbers[1]) {
					swap(0, 1, numbers);
				}
			}
//Sort 3 Elements if remainder is 3
			else {
				if (numbers[0] > numbers[1])
					swap(0, 1, numbers);
				if (numbers[1] > numbers[2])
					swap(1, 2, numbers);
				if (numbers[0] > numbers[1])
					swap(0, 1, numbers);

			}

		}
	//	long startTime = System.nanoTime();
		quadrupleSort(numbers, remainder);
		merge(numbers, k);
	//	long endTime = System.nanoTime();
		//long duration = (endTime - startTime);
		//System.out.println(duration);
		System.out.println(numbers);

	}

	public static void quadrupleSort(int a[], int remainder) {
		int j = 0;
		for (int i = remainder; i < a.length; i = i + 4) {
			j = i;
			if (a[i] > a[j + 2]) {
//a[0] and a[2]
				swap(i, j + 2, a);
			}

			if (a[i + 1] > a[j + 3]) {
// a[1] and a[3]
				swap(i + 1, j + 3, a);
			}

			if (a[i] > a[j + 1]) {
// a[0] and a[1]
				swap(i, j + 1, a);
			}

			if (a[i + 2] > a[j + 3]) {
//a[2] and a[3]
				swap(i + 2, j + 3, a);
			}
			if (a[i + 1] > a[j + 2]) {
//a[1] and a[2]
				swap(i + 1, j + 2, a);
			}

		}
	}

	public static void swap(int index1, int index2, int numbers[]) {
		temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}

}
