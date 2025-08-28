
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Student where id=?1");
        query.setParameter(1,105);

        int rowsAffected = query.executeUpdate();

        transaction.commit();

        System.out.println("Rows affected = "+rowsAffected);


        session.close();
        sf.close();


    }
}
