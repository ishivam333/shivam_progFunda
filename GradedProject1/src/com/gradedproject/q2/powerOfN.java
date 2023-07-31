package com.gradedproject.q2;

import java.util.Scanner;

public class powerOfN {	
	public static long pow(int x,int n) {
		if(n==0) {
		return 1;	
		}
		return pow(x,n-1)*x;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the base number X:");
		int x=sc.nextInt();
		System.out.println("Enter the power N = ");
		int n=sc.nextInt();
		if(n<0) {
			System.out.println("please enter positive number for power N ");
		}
		else {
		System.out.println("X power N is:"+pow(x,n));
		}

	}

}
