package com.jbk.springboot_simple.entity;

import java.util.Comparator;

import com.jbk.springboot_simple.entity.Student;

public class SortingByMarks implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.marks > s2.marks)
			return 1;
		else if (s1.marks < s2.marks)
			return -1;	
		else
		    return 0;
	}


}
