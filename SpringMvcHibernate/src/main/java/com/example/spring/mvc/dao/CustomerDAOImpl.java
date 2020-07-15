package com.example.spring.mvc.dao;

import com.example.spring.mvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired //.xml'de ayarlanan session factory icin injection yapılıyor
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    public List<Customer> getCustomers() {

        session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer",Customer.class);

        List<Customer> customerList = query.getResultList();

        return customerList;
    }

    @Override
    public Customer getCustomer(int id) {

        session = sessionFactory.getCurrentSession();

        return session.get(Customer.class,id);

    }

    @Override
    public void addCustomer(Customer customer) {
        session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);

    }

    @Override
    public void deleteCustomer(int id) {
        session = sessionFactory.getCurrentSession();


        Query query = session.createQuery("delete from Customer where id=:customerId");

        query.setParameter("customerId",id);

        query.executeUpdate();

    }
}
