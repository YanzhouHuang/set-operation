

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

// main driver
public class TestSet {

	public static void main(String[] args) throws FileNotFoundException  {

	
		Scanner inFile1 = new Scanner(new File("src/data1.txt"));
		Scanner inFile2 = new Scanner(new File("src/data2.txt"));

		// read two files
		int a = inFile1.nextInt();
		int[] array1 = new int[a];
		for (int i = 0; i < a; i++) {
			array1[i] = inFile1.nextInt();
		}
		Set A = new Set(array1);
		int b = inFile2.nextInt();
		int[] array2 = new int[b];
		for (int i = 0; i < b; i++) {
			array2[i] = inFile2.nextInt();
		}
		Set B = new Set(array2);
		System.out.print("Set A: ");
		printArray(array1);
		System.out.print("Set B: ");
		printArray(array2);

		// output
		System.out.print("A union B: ");
		printSet(A.union(B));
		System.out.print("A intersection B: ");
		printSet(A.intersection(B));
		System.out.print("(A - B): ");
		printSet(A.difference(B));
		System.out.print("(U - A): ");
		printSet(A.complement(B));
		System.out.print("(U - B): ");
		printSet(B.complement(A));
		System.out.print("(A * B): ");
		printSet(A.product(B));
	}
 
	// use to print set class
	public static void printSet(Set a) {
		int[] tmp1 = reArray(a.getContent());
		for (int i = 0; i < tmp1.length; i++) {
			System.out.print(tmp1[i] + " ");
		}
		System.out.println();

	}
	
	// use to print array
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
		System.out.println();
	}

	// remove 0s from array
	public static int[] reArray(int[] array) {
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0)
				array[j++] = array[i];
		}
		int[] newArray = new int[j];
		System.arraycopy(array, 0, newArray, 0, j);
		return newArray;
	}

}
