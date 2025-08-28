package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.setId(102);
        s1.setName("Raja");
        s1.setMarks(44);

        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Student s2 = session.find(Student.class, 102);

        session.remove(s2);
        transaction.commit();

        System.out.println(s2);

        session.close();

        sf.close();

    }
}
