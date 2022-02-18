package com.milonsheikh.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.milonsheikh.springorm.dao.StudentDao;
import com.milonsheikh.springorm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-conf.xml");
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		//Insert
		Student student =new Student(10111,"MIL","DHAKA");
		int result = studentDao.insert(student);
		System.out.println("Number of record inserted= "+result);
		
		//Get the single data
		Student singleStudent = studentDao.getSingleStudent(101);
		System.out.println(singleStudent);
		
		//Get the all data
//		List<Student> allStudents = studentDao.getAllStudents();
//		System.out.println(allStudents);
		
		//Delete single data
//		studentDao.deleteStudent(102);
		
		//Update data
//		Student student =new Student(101,"MAMUN","DHAKA");
//		studentDao.updateStudent(student);
	}
}
