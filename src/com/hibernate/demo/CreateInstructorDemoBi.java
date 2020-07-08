package com.hibernate.demo;

import com.entities.Instructor;
import com.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemoBi {
    public static void main(String[] args) {

        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {


            session.beginTransaction();

            InstructorDetail instructorDetail =
                    session.get(InstructorDetail.class, 12123);

            System.out.println("Instructor Detail: " + instructorDetail);
            System.out.println();
            System.out.println("Associated Instructor: " + instructorDetail.getInstructor());

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
