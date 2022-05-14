
package com.jbk.springboot_simple.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.springboot_simple.entity.SortingById;
import com.jbk.springboot_simple.entity.SortingByMarks;
import com.jbk.springboot_simple.entity.SortingByName;
import com.jbk.springboot_simple.entity.Student;

@RestController
public class StudentController {

	List<Student> list = new ArrayList<>();

	// {"id":101,"name":"ramesh","marks":"85"} is json string sent by client
	// (postman)
	// @RequestBody will create Student class object using above JSON String

	@PostMapping(value = "/saveStudent")
	public boolean saveStudent(@RequestBody Student student) {

		list.add(student);

		return true;

	}

	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudent() {

		return list;

	}
	// Browser :-localhost:8080/getAllStudent/101

	// In Postman used request methods like >>Get ,Post ,Put and Delete
	// {sid} is path variable . path - url - address
	// path variable sid value is 101 .
	// @PathVariable annotation assign value of path variable sid to local variable

	@GetMapping(value = "/getStudent/{id}")
	public Student getStudentById(@PathVariable int id) {

		Student student = null;
		for (Student std : list) {

			if (std.getStudentId() == id) {
				student = std;

				break;
			}

		}
		return student;

	}

	@PutMapping(value = "/updateStudent")
	public String updateStudent(@RequestBody Student student) {// 101

		String msg = "Student Not Exists";

		for (Student std : list) {

			if (std.getStudentId() == student.getStudentId()) {
				list.remove(std);
				list.add(student);
				msg = "Updated";
				break;
			}
		}

		return msg;
	}

	@DeleteMapping(value = "/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) { // id =103 delete

		String msg = "Student Not Exists";

		for (Student std : list) {
			if (std.getStudentId() == id) {

				list.remove(std);
				msg = "Deleted";
				break;
			}

		}
		return msg;

	}

	@GetMapping(value = "/getStudentById")
	public TreeSet<Student> getStudentById() {
		TreeSet<Student> treeSet = new TreeSet<Student>(new SortingById());
		treeSet.addAll(list);

		return treeSet;

	}

	@GetMapping(value = "/getStudentByName")
	public TreeSet<Student> getStudentByName() {
		TreeSet<Student> treeSet = new TreeSet<Student>(new SortingByName());
		treeSet.addAll(list);

		return treeSet;

	}

	@GetMapping(value = "/getStudentByMarks")
	public TreeSet<Student> getStudentByMarks() {
		TreeSet<Student> treeSet = new TreeSet<Student>(new SortingByMarks());
		treeSet.addAll(list);

		return treeSet;

	}

}