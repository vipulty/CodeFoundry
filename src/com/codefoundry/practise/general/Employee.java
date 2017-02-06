/**
 * 
 */
package com.codefoundry.practise.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * @author vipul
 *
 */
public final class Employee implements Comparable{
	
	

	private  String name;
	
	private  Double salary;
	
	private Date dob;

	

	/**
	 * 
	 */
	public Employee(String name, double salary,   Date dob) {
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Employee other = (Employee) obj;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 // List<Employee> employeeList = new ArrayList<Employee>();	
	  
		 TreeSet<Employee> employeeList = new TreeSet<Employee>();	
		
	  employeeList.add(new Employee("vipul", new Double(100), new Date()));
	  employeeList.add(new Employee("arun", new Double(100), new Date()));	
	  
	//  Collections.sort(employeeList, new ComparateDOB());
	  
	  for(Employee e : employeeList){
		 System.out.println(e.getSalary()); 
	  }
	
	}


	@Override
	public int compareTo(Object o) {
		Employee employee = (Employee) o;	
		
		return this.getSalary().compareTo(employee.getSalary());			
	}
	
	
	public String getName() {
		return name;
	}
	

	public Double getSalary() {
		return salary;
	}
	

	public Date getDob() {
		return new Date(dob.getTime());
	}
	

}
