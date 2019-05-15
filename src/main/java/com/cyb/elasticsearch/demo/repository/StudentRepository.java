package com.cyb.elasticsearch.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.cyb.elasticsearch.demo.domain.Student;

@Repository
public interface StudentRepository extends
		ElasticsearchRepository<Student, Integer> {

	Page<Student> findStudentByName(String name, Pageable pageable);

}
