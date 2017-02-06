package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinSubstring2 {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
	//	String input1 = in.nextLine();
	//	String input2 = in.nextLine();
		
		int[][] postions = {{0,4},{6,3},{1,5},{6,4},{7,2}};
		
		GetVisibleCount(10,5, postions );

		}

	public static int GetVisibleCount(int input1,int input2,int[][] input3){
		
		
		
		
		
		class Pojo {
			Integer start;
			Integer end;
			public Pojo(Integer start, Integer end) {
				super();
				this.start = start;
				this.end = end;
			}
			public Integer getStart() {
				return start;
			}
			public void setStart(Integer start) {
				this.start = start;
			}
			public Integer getEnd() {
				return end;
			}
			public void setEnd(Integer end) {
				this.end = end;
			}
		}
		
		List<Pojo> elements = new LinkedList<Pojo>();
		
		int length = input3.length;
		
		for(int i=0; i<length; i++){
			
			int start = input3[i][0];
			int end = input3[i][1];
			
			for(Pojo p : elements){				
				if(start <= p.getStart() && end >= p.getEnd()) {
					elements.remove(p);	
				}
			}
			
			Pojo pojo = new Pojo(start, end);	
			elements.add(pojo);			
		}		
		

		//System.out.println(elements.size());
		
		return elements.size();	
		
	}	
	
}
