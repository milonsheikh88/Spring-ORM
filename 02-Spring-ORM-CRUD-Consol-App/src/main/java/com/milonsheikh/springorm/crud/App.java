package com.milonsheikh.springorm.crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.milonsheikh.springorm.crud.dao.StudentDao;
import com.milonsheikh.springorm.crud.entities.Student;
import com.mysql.cj.jdbc.BlobFromLocator;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-conf.xml");
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		boolean go=true;
		while (go) {
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all student");
			System.out.println("PRESS 3 for get single student");
			System.out.println("PRESS 4 for delete student");
			System.out.println("PRESS 5 for update student");
			System.out.println("PRESS 6 for exit");

			try {
				int input = Integer.parseInt(br.readLine());
				
				
				switch (input) {
				
				case 1:
//					Add new student
					
					System.out.println("Enter user id: ");
					int uId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name: ");
					String uName = br.readLine();
					
					System.out.println("Enter user City: ");
					String uCity = br.readLine();
					
					Student student =new Student(uId,uName,uCity);
					int result = studentDao.insert(student);
					System.out.println(result+" Student added");
					System.out.println("*********************************");
					System.out.println();
					
					break;
					
				case 2:
//					display all student
					System.out.println("*********************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("------------------------------------------------------");
						System.out.println(
								"ID: "+st.getStudentId()+"; "+
								"Name: "+st.getStudentName()+"; "+
								"City: "+st.getStudentCity()+";");
						System.out.println("------------------------------------------------------");
					}
					System.out.println("*********************************");
					break; 
				case 3:
//					get single student
					System.out.println("Enter user id: ");
					int seraceId = Integer.parseInt(br.readLine());
					Student singleStudent = studentDao.getSingleStudent(seraceId);
					
					System.out.println("------------------------------------------------------");
					System.out.println(
							"ID: "+singleStudent.getStudentId()+"; "+
							"Name: "+singleStudent.getStudentName()+"; "+
							"City: "+singleStudent.getStudentCity()+";");
					System.out.println("------------------------------------------------------");
					break; 
				case 4:
//					delete student
					System.out.println("Enter user id: ");
					int deleteId = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(deleteId);
					System.out.println(deleteId+ " Student deleted...");
					break; 
					
				case 5:
//					update student
					System.out.println("Enter user id: ");
					int updateId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name: ");
					String updateName = br.readLine();
					
					System.out.println("Enter user City: ");
					String updateCity = br.readLine();
					
					Student updatetudent =new Student(updateId,updateName,updateCity);
					studentDao.updateStudent(updatetudent);
					break; 
				case 6:
//					exit program
					go=false;
					break; 
				}
				
				
			} catch (Exception e) {
				System.out.println("Invalid input try with anather one!!");
				System.out.println(e.getMessage());

			}
			
		}
		
		System.out.println("Thank you for using my application");	
		System.out.println("See you soon!!!");	
		
		//Insert
//		Student student =new Student(101,"MAMUN","DHAKA");
//		int result = studentDao.insert(student);
//		System.out.println("Number of record inserted= "+result);
		
		//Get the single data
//		Student singleStudent = studentDao.getSingleStudent(101);
//		System.out.println(singleStudent);
		
		//Get the all data
//		List<Student> allStudents = studentDao.getAllStudents();
//		System.out.println(allStudents);
		
		//Delete single data
//		studentDao.deleteStudent(101);
		
		//Update data
//		Student student =new Student(101,"MAMUN","DHAKA");
//		studentDao.updateStudent(student);
	}
}
