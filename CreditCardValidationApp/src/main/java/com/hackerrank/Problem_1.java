package com.hackerrank;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem_1 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("enter the number");
		int n = scanner.nextInt();
		int[] ar = new int[n];

		System.out.println("enter " + n + "  number of digit in array");
		for (int i = 0; i < n; i++) {
			int arItem = scanner.nextInt();
			ar[i] = arItem;
		}
		int result = sockMerchant(n, ar);
		System.out.println("number of pairs  " + result);
		scanner.close();
	}

	private static int sockMerchant(int n, int[] ar) {

		int num_pairs = 0;
		if (ar.length == 0)
			return num_pairs;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ar.length; i++) {
			if (!set.contains(ar[i])) {
				set.add(ar[i]);
			} else {
				num_pairs++;
				set.remove(ar[i]);
			}
		}
		return num_pairs;
	}

}
