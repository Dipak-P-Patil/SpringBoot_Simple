package com.jbk.springboot_simple.entity;

import java.util.Comparator;

import com.jbk.springboot_simple.entity.Student;

public class SortingById implements Comparator<Student> {

	   @Override
		public int compare(Student s1, Student s2) {
		if (s1.studentId > s2.studentId)
		  return 1;
		else if (s1.studentId < s2.studentId)
			return -1;
		else 
		   return 0;		
	}
	
	
}
