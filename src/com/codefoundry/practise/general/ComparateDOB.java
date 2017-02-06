package com.codefoundry.practise.general;

import java.util.Comparator;

public class ComparateDOB implements Comparator<Employee> {

	public ComparateDOB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employee o1, Employee o2) {		
		return o1.getDob().compareTo(o2.getDob());
	}

}
