package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinSubstring {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.nextLine();
		
		System.out.println(input1 + " " + input2);
		
		GetSubString(input1,input2);

		}

	public static String GetSubString(String input1,String input2){
		
		class Pojo implements Comparable<Pojo>{
			
			Character c;
			List<Integer> pos;
			
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((c == null) ? 0 : c.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pojo other = (Pojo) obj;
				if (c == null) {
					if (other.c != null)
						return false;
				} else if (!c.equals(other.c))
					return false;
				return true;
			}
	
			
			public Pojo(Character c, List<Integer> pos) {
				super();
				this.c = c;
				this.pos = pos;
			}
			public Character getC() {
				return c;
			}
			public void setC(Character c) {
				this.c = c;
			}
			public List<Integer> getPos() {
				return pos;
			}
			public void setPos(List<Integer> pos) {
				this.pos = pos;
			}
			@Override
			public int compareTo(Pojo o) {
				
				Collections.sort(pos);
				
				List<Integer> pos1 = o.getPos();
				
				Collections.sort(pos1);
                
				return pos.get(0).compareTo(pos1.get(0));
			}		
		}
		
		List<Pojo> lists = new ArrayList<Pojo>();
		
		char[] charinput1 =  input1.toCharArray();
		
		int counter = 0;	
		
		for(char c : charinput1){	
			
			String cS = "" + c;
			
			if(!input2.contains(cS)){
				counter++;
				continue;
			}
			
			List<Integer> arrayList = new ArrayList<Integer>();
			Pojo pojo = new Pojo(c, arrayList);	
			
			//System.out.println("c = "  +   c);
			
              
			if(!lists.contains(pojo)){				
				arrayList.add(counter);				
				lists.add(pojo);
			} else {
			//	System.out.println("Exit");
				int k = lists.indexOf(pojo);				
				List<Integer> existarrayList = lists.get(k).getPos();
				existarrayList.add(counter);
				Pojo nexpojo = new Pojo(c, existarrayList);	
				lists.add(nexpojo);
			} 			
			counter++;
		}	
		
		
		
		Collections.sort(lists);
		
		for(Pojo p : lists){	 
			//System.out.println(p.getC()  + " " + p.getPos());
		}
		
		
		
		Pojo first = lists.get(0);
		Pojo last = lists.get(lists.size()-1);
		
		List<Integer> firstpos = first.getPos();
		List<Integer>  lastpos =last.getPos();
		
		Collections.sort(firstpos);
		Collections.sort(lastpos);
		
		Integer i = firstpos.get(0);
		Integer k = firstpos.get(firstpos.size()-1);
		//System.out.println("i = "  +  i);
		//System.out.println("k = "  +  k);
		
		Integer l = lastpos.get(0);
		Integer m = lastpos.get(lastpos.size()-1);
		//System.out.println("l = "  +  l);
		//System.out.println("m = "  +  m);
		
		List<Pojo> diffs = new ArrayList<>();
		
		String shrotest = null;
		
		
		String resutlt1 = input1.substring(i, m+1);
		String resutlt2 = input1.substring(k, m+1);
		

		String resutlt3 = input1.substring(i, l+1);
		String resutlt4 = input1.substring(k, l+1);
		
		if(resutlt1.length() > resutlt2.length()){
			shrotest = resutlt2;
		} else {
			shrotest = resutlt1;
		}
		
        if(shrotest.length() > resutlt3.length()){
        	shrotest = resutlt3;
		} else {
			shrotest = resutlt4;
		}	

     //   System.out.println("shrotest = "  + shrotest);
		return shrotest;
		
	}	
	
}
