package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            //get instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: " + tempInstructor);
            System.out.println("luv2code: Courses" + tempInstructor.getCourses());

            //close the session
            session.close();
            //commit transaction


            System.out.println("luv2code: Courses" + tempInstructor.getCourses());

            System.out.println("luv2code: Done");

        }finally {
            session.close();
            factory.close();
        }

    }


}
