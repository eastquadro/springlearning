package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            System.out.println("Saving the course...");
            session.save(tempCourse);
            System.out.println("Save the course: " + tempCourse);

            Student student1 = new Student("John", "Doe", "john@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);

            System.out.println("\nSaving students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + tempCourse.getStudents());
            session.getTransaction().commit();

            System.out.println("Done");

        }finally {
            session.close();
            factory.close();
        }

    }


}
