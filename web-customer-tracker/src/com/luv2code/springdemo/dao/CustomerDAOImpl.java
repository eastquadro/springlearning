package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        //get a current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //crate a query


        // execute query and get rusult set
        List<Customer> customers = currentSession.createQuery("from Customer", Customer.class).list();

        //return the results

        return customers;
    }
}
