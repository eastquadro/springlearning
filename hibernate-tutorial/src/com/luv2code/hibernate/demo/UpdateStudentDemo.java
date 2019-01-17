package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            int studentId = 0;

            session = factory.getCurrentSession();
            session.beginTransaction();
            //find out the student's id: primaryKey
            System.out.println("Saved student. Generated id: " + studentId);

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: "+ studentId);

            Student myStudent = session.get(Student.class, studentId);

            //Updating student
            System.out.println("Updating student ...");
            myStudent.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();

            //new code
            // new session for updating all students
            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Uppdate email for all students");

            session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();

            //commit transaction
            session.getTransaction().commit();


            System.out.println("Done");

        }finally {
            factory.close();
        }

    }
}
