package com.test;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
		boolean flag = false;
		for(int i=0; i<arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
		
}
