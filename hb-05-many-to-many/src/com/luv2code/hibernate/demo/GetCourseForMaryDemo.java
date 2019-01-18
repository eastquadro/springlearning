package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseForMaryDemo {
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
            int theId = 2;
            //get the student mary from database
            Student student = session.get(Student.class,theId);

            System.out.println("\nLoaded student: "+ student);
            System.out.println("Courses: " + student.getCourses());

            session.getTransaction().commit();

            System.out.println("Done");

        }finally {
            session.close();
            factory.close();
        }

    }


}
