package com.codefoundry.hackerrank.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemainingFactors {

	public RemainingFactors() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		int newNum = num*num;
		
		int count = 0;
		
		for(int i=1; i< num; i++ ){
			
			if(newNum % i == 0 && num % i != 0){
				count++;
			}
		}
		System.out.println(count) ;

	}

}
