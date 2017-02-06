package com.codefoundry.codeforces.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringSetQueries {

	public StringSetQueries() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int noOfQueries = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Set<String> queries = new HashSet<String>();
		
		
		for(int i = 0; i < noOfQueries; i++){
			
			String in[] = br.readLine().split(" ");
			
			int queryType= Integer.valueOf(in[0]);
			
			String queryString = in[1];		
			
			if(queryType == 1){
			  sb.append(queryString);	
			  queries.add(queryString);

			}
			
			if(queryType == 2){		
				
				String s = sb.toString();
				queries.remove(queryString);
				
				s = s.replaceAll(queryString, "");		
				
				sb = new StringBuilder(s);		

				
			}
			
	       if(queryType == 3){	
	    	   int count = 0;

	    	   
	    	   for(String s : queries){
	    		   
	    		   int startIndex = 0;
	    		   
	    		   while(startIndex != -1){
	    			    startIndex = queryString.indexOf(s, startIndex);
	    			    
	    			    if(startIndex >= 0){
	    			    	startIndex++;
	    			    	 count++;
	    			    }
	    			    
	    			   
	    		   }    		   
	    	   }
	    	   
	    	  
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	    	 
	
	    bw.write(String.valueOf(count));
	    bw.write("\n");	  
	     bw.flush();
	    	   
	    	   
			}
		}
		
		
		

	}

}
