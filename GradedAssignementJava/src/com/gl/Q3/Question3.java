package com.gl.Q3;

import java.util.Arrays;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the number in the array");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int sum=Arrays.stream(arr).filter(x->x%2!=0).map(x->x*x).sum(); 
	     System.out.println("SUM: " + sum);
		

	}

	

}
