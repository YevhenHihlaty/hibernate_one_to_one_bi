package com.hibernate.demo;

import com.entities.Instructor;
import com.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DelateInstructorDemoBi {
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
                    session.get(InstructorDetail.class, 2);
            if(instructorDetail != null){
                //also delete instrutorDetal
                //CascadeType.ALL
                instructorDetail.getInstructor().setInstructorDetail(null);
                session.delete(instructorDetail);
            }
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
