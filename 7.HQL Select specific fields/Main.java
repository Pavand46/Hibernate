package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Query query = session.createQuery("select name, marks from Student");
        List<Object[]> students = query.list();

        for(Object[] student : students){
            System.out.println(student[0] + " got "+student[1] +" Marks.");
        }

        session.close();

        sf.close();

    }
}
