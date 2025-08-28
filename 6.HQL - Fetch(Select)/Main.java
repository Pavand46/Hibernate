package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.setId(106);
        s1.setName("Yash");
        s1.setMarks(42);

        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();
        
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();

        System.out.println(students);

        session.close();

        sf.close();

    }
}
