package com.codefoundry.hackerrank.string;

public class Replace {

	public Replace() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str1 = "Need some space  ";
		
		char[] c = str1.toCharArray();
		
		
		replaceSpace(c, c.length);

	}
	
	
	static void replaceSpace(char[] str, int len) {  
		
		int last = 0;
		
		for(int i = len-1; i > 0 ; i--){
			
			//System.out.println(str[i]);
			
			if(str[i] == ' '){
				continue;
			}
			else {
				last = i;
				break;
			}
		}
		System.out.println(last);
        int i = 1;
        
        for(char s : str){
        	
        	i++;
        	
        	if(i >= last){
        		continue;
        	}
        	
        	if(str[i] != ' '){
        		System.out.println(s);
        	} else {
        		System.out.println("%");
        		System.out.println("2");
        		System.out.println("0");
        	}      	
        	
           	
        	
         	
      
        }        
      
    }

}
