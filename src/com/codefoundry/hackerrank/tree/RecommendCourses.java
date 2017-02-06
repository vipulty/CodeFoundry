/**
 * 
 */
package com.codefoundry.hackerrank.tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author vipul
 *
 */
public class RecommendCourses {

	/**
	 * 
	 */
	public RecommendCourses() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecommendCourses s = new RecommendCourses();

	}

	
	
	public List<String> getRankedCourses(String user) {
		
		
		class ValueComparator implements Comparator<String> {
		    Map<String, Integer> base;

		    public ValueComparator(Map<String, Integer> base) {
		        this.base = base;
		    }

		    public int compare(String a, String b) {
		    	
		    	if (base.get(a) > base.get(b)) {
		            return -1;
		        } else if (base.get(a) < base.get(b)) {
		            return +1;
		        }  {  
		    	 return 0;
		        } 
		   }
		}	    
		
		List<String> coursesSuggested = new LinkedList<String>();
		
		List<String> userCourse = 	getAttendedCoursesForUser(user);
		
		Map<String, Integer> courseMap = new HashMap<String, Integer>();
		
		List<String> directFriends = getDirectFriendsForUser(user);
		
		for(String directFriend : directFriends){
			
			List<String> courses = 	getAttendedCoursesForUser(directFriend);
			
			for(String course : courses) { 
				
				if(userCourse.contains(course)){
					continue;
				}

				
				if(courseMap.get(course) == null){
					courseMap.put(course, 1);
				} else {
					Integer count = courseMap.get(course);
					courseMap.remove(course);
					
					count = count + 1;
					courseMap.put(course, count);
				}				
			}
			
			List<String> inDirectFriends = getDirectFriendsForUser(directFriend); 
			
			for(String inDirectFriend : inDirectFriends){ 
				
				courses = 	getAttendedCoursesForUser(inDirectFriend);
				
				for(String course : courses) { 
					
					if(userCourse.contains(course)){
						continue;
					}
					
					if(courseMap.get(course) == null){
						courseMap.put(course, 1);
					} else {	
						Integer count = courseMap.get(course);
						courseMap.remove(course);						
						count = count + 1;
						courseMap.put(course, count);
					}		
				}					
			}		
	       
		}	
		for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {	
			
			System.out.println("c = " + entry.getKey() + ", v = " + entry.getValue());
			
		}
		
		ValueComparator bvc = new ValueComparator(courseMap);
        
        TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(bvc);			
		
		for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {	
			
			sortedMap.put(entry.getKey(), entry.getValue());		
			
		}
		
		Set<String> s = sortedMap.keySet();
		
		for(String s1 : s) {
			if(coursesSuggested.contains(s1)){
				continue;
			}
			coursesSuggested.add(s1);
		}
		
		return coursesSuggested;
	
	}
	
	public List<String> getDirectFriendsForUser(String user) {
		return null;
		
	}
	
	public List<String> getAttendedCoursesForUser(String user) {
		return null;		
	}
}
