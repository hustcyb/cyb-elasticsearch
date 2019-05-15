package com.cyb.elasticsearch.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.elasticsearch.demo.domain.Student;
import com.cyb.elasticsearch.demo.repository.StudentRepository;

@RequestMapping("students")
@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("{id}")
	public Optional<Student> getById(@PathVariable Integer id) {
		return studentRepository.findById(id);
	}

	@GetMapping
	public Page<Student> pageByName(String name, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return studentRepository.findStudentByName(name, pageRequest);
	}
	
	@PostMapping
	public void save(@RequestBody Student student) {
		studentRepository.save(student);
	}
}
