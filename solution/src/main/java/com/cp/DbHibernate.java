package com.cp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DbHibernate {
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    public List<Customer> getCustomers() {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            List<Customer> result = session.createQuery("FROM Customer").list();

            transaction.commit();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
           throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public int addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            int generatedId = (int) session.save(customer);

            transaction.commit();

            return generatedId;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public void close() {
        if (!sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
