package com.codefoundry.hackerrank.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JesseAndProfit {

	
	public static void main(String[] args) {
		
		class ShareInfo implements Comparable<ShareInfo> {
			@Override
			public String toString() {
				return "shareInfo [day=" + day + ", price=" + price + "]";
			}

			Integer day;
			
			Integer price;

			public ShareInfo(Integer day, Integer price) {
				super();
				this.day = day;
				this.price = price;
			}

			@Override
			public int compareTo(ShareInfo o) {				
				return price.compareTo(o.price);
			}
		}
		
		
		Scanner in = new Scanner(System.in);
		int noOfDays = in.nextInt();
		
		int noOfTestCases = in.nextInt();
		
		List<ShareInfo> shareValues = new ArrayList<ShareInfo>();
		
		for(int i = 0; i < noOfDays; i++){
			
			int value = in.nextInt();			
			shareValues.add(new ShareInfo(i, value));
		}
		
		Collections.sort(shareValues);	
		//System.out.println(shareValues) ;
		List<ShareInfo> results = new LinkedList<ShareInfo>();
		
		for(int i = 0; i < noOfTestCases; i++){
			
			
			
			int profit = in.nextInt();	
			
			int startIndex = 0;
			int endIndex = shareValues.size()-1;
			
			int minDayDifference = Integer.MAX_VALUE;
			int buyDay = 0;
			int sellDay = 0;
			
			boolean isResult = false;
			
			while(startIndex < endIndex){
				
			//	System.out.println(startIndex + " " + endIndex) ;
				
				ShareInfo startIndexShareInfo = shareValues.get(startIndex);
				ShareInfo endIndexShareInfo = shareValues.get(endIndex);
				//System.out.println("values = " + startIndexShareInfo.price + " " + endIndexShareInfo.price) ;
				
				if(startIndexShareInfo.day < endIndexShareInfo.day){
					
					if( (endIndexShareInfo.price - startIndexShareInfo.price) == profit){
						
						if( (endIndexShareInfo.day - startIndexShareInfo.day) < minDayDifference){
							buyDay = startIndexShareInfo.day + 1;
							sellDay = endIndexShareInfo.day + 1;
							
							minDayDifference = endIndexShareInfo.day - startIndexShareInfo.day;
							//System.out.println("minDayDifference = " + minDayDifference) ;
							isResult = true;
						}
						
					}
				}
				
				if( (endIndexShareInfo.price - startIndexShareInfo.price) > profit){ 
					startIndex++;
				}
				
				if( (endIndexShareInfo.price - startIndexShareInfo.price) < profit){ 
					startIndex = 0;
					endIndex--;
				}
				
				if( (endIndexShareInfo.price - startIndexShareInfo.price) == profit){ 
					startIndex++;			
				}			
			}
			
			if(isResult){
				results.add(new ShareInfo(buyDay, sellDay));	
			}else {
				results.add(new ShareInfo(-1, -1));
			}			
			
			//System.out.println(buyDay + " " + sellDay) ;
			
		}
		
		for(ShareInfo s : results){
			
			if(s.day == -1){
				System.out.println(-1) ;	
			}else {
				System.out.println(s.day + " " + s.price) ;	
			}	
		}

	}

}
