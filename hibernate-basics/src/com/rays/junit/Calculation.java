package com.rays.junit;

public class Calculation {

	public static int findMax(int arr[]) {

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
}