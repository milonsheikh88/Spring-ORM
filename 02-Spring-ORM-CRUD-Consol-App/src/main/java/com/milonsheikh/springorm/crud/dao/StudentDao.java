package com.milonsheikh.springorm.crud.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.milonsheikh.springorm.crud.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//insert Data
	@Transactional
	public int insert(Student student) {
		Integer i =(Integer) hibernateTemplate.save(student);	
		return i;
	}

	//Get the single data
	public Student getSingleStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//Get the all data
	public List<Student> getAllStudents(){		
		List<Student> students = hibernateTemplate.loadAll(Student.class);	
		return students;
	}
	
	//Delete single data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		hibernateTemplate.delete(student);
	}
	
	//Update data
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);;
	}
	
	
}
