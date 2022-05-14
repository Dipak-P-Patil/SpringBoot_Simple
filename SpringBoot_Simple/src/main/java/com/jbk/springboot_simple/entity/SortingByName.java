package com.jbk.springboot_simple.entity;



import java.util.Comparator;

import com.jbk.springboot_simple.entity.Student;

public class SortingByName implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		
	 return s1.studentName.compareTo(s2.studentName);
	
	}


}
	
	

	   	
	
	
	

