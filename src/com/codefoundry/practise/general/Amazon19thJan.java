/**
 * 
 */
package com.codefoundry.practise.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vipul
 *
 */
public class Amazon19thJan {

	/**
	 * 
	 */
	public Amazon19thJan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
		 	String line = br.readLine();
	        String[] separated = line.split(",");
	        
	        line = br.readLine();
	        int retain = Integer.parseInt(line);
	        
	        line = br.readLine();
	        int delete = Integer.parseInt(line);
	        
	        
	        List<String> result = new ArrayList<>();
	        
	        int start = 0;
	        boolean isFinished = false;
	        
	        while(true) {
	        	
	        	int i = start;
	        	
	        	for(i = start; i < (start + retain); i++){	        		
	        		
	        		 if(i > (separated.length - 1)) {
	        			 break;
	        		 }	        		
	        		result.add(separated[i]);  
	        		        		
	        	}
	        	start = i;	        
	        	
	        	for(i = start; i < (start + delete); i++){   	
	        	
	        		
	        		 if(i > (separated.length - 1)) {
	        			 break;
	        		 } 
	        	}
	        	start = i;	        	
	        	 if(start > (separated.length - 1)) {
        			 break;
        		 }
	        	
	        }
	        StringBuilder sb = new StringBuilder();
	        for(String k : result){
	        	sb.append(k);
	        	sb.append(",");
	        }
	        System.out.print(sb.substring(0, sb.length()-1));	
	        
	}

}
