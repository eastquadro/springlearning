package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            //get the instructor detail object
            int theId = 3;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            System.out.println("Instructor associated with detail: " + tempInstructorDetail.getInstructor() );

            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            //delete the instructor detail

            //remove the associated object reference
            //break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

            System.out.println("Done");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }


}
