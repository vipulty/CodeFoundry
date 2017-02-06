package com.codefoundry.practise.general;

import java.util.ArrayList;
import java.util.List;

public class NumberOfPairs {

	public NumberOfPairs() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		

	}
	
	
	 static int numberOfPairs(int[] a, long k) {
		 
		
		 
		 class Pos {
			 int x;
			 int y;
			public Pos(int x, int y) {
				super();
				this.x = x;
				this.y = y;
			}
		 }
		 List<Pos> post = new ArrayList<>(); 
		 int  j = 1;
		 
		 int count = 0;
		 
		 for(int i = 0; i< a.length; i++){
			
			 
			 for(int m = j; m< a.length; m++){
				 
				 int sum = a[i] + a[m];
				 
				 if(sum == k){
					 
					 boolean should = true;
					
						 
					 for(Pos p : post){
						
						 if(p.x == a[i] || (p.x == a[i])){
							 if(p.y == a[m] || (p.y == a[m])){
								 should = false; 
							 } 
						 }
						 
					 }
						 
					 if(should) {
						 post.add(new Pos(a[i], a[m]));
						 count++; 
					 }			
					 
				 }
				 
			 }
			 j++;
		 }
		
		 
		 
		 return count;


	 }

}
