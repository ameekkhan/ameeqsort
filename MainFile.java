package sorts.comparison.com;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainFile {

	/* 1 Million random integers, from 0 to 10000 range */
	public static int[] arr1 = new int[1000000];

	public static void readMyInputFile() throws IOException {
		int ctr = 0;
		Scanner scanner = new Scanner(new File("D:/Learning/Sorts/numbers1M.txt"));
		while (scanner.hasNextInt()) {
			arr1[ctr++] = scanner.nextInt();
		}
		scanner.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		long startTime = 0l, endTime = 0l, totalTime = 0l, avg = 0l;
		
		System.out.println("Size of list is :"+ arr1.length);

		
		readMyInputFile();
		startTime = System.nanoTime();
		MergeSortPP.sort(arr1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of MergeSort++ in milli seconds: " + totalTime / 1000000);
		
		
		
		readMyInputFile();
		startTime = System.nanoTime();
		Timsort.sort(arr1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of Timsort in milli seconds: " + totalTime / 1000000);
		
	

		readMyInputFile();
		startTime = System.nanoTime();
		MergeSort.sort(arr1, 0, arr1.length-1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of MergeSort in milli seconds: " + totalTime / 1000000);
		

		readMyInputFile();
		startTime = System.nanoTime();
		QuickSort.sort(arr1, 0, arr1.length-1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of QuickSort in milli seconds: " + totalTime / 1000000);
		

		readMyInputFile();
		startTime = System.nanoTime();
		HeapSort.sort(arr1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of HeapSort in milli seconds: " + totalTime / 1000000);
		

		readMyInputFile();
		startTime = System.nanoTime();
		DualPivotQuickSort.sort(arr1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of DualPivotQuickSort in milli seconds: " + totalTime / 1000000);
		
		
		readMyInputFile();
		startTime = System.nanoTime();
		IntroSort.sort(arr1);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(" Execution Time of IntroSort in milli seconds: " + totalTime / 1000000);
		

	}

}
