package com.capgemini.jdbc_jpa_hibernate_assessment.dao;


import java.util.*;
import javax.persistence.*;

import com.capgemini.jdbc_jpa_hibernate_assessment.entity.Customer;

public class CustomerDaoImpl implements CustomerDao
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public String saveCustomer(Customer customer)
    {
    	EntityTransaction transaction = entityManager.getTransaction();
        
    	transaction.begin();
    	entityManager.persist(customer);
    	transaction.commit();

        return "Customer Saved Successfully";
    }

    @Override
    public String updateCustomer(Customer customer)
    {
    	EntityTransaction transaction = entityManager.getTransaction();
        
    	transaction.begin();
    	entityManager.merge(customer);
    	transaction.commit();

        return "Customer Updated Successfully";
    }

    @Override
    public String deleteCustomerById(int id)
    {
        Customer customer = entityManager.find(Customer.class, id);

        if(customer != null)
        {
            EntityTransaction transaction = entityManager.getTransaction();
            
            transaction.begin();
            entityManager.remove(customer);
            transaction.commit();

            return "Customer Deleted Successfully";
        }
        return "Customer Not Found with this id";
    }

    @Override
    public Customer getCustomerById(int id)
    {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getCustomerByEmail(String email)
    {
    	String jpqlQuery = "SELECT c FROM Customer c WHERE c.email=:email";
        TypedQuery<Customer> query = entityManager.createQuery(jpqlQuery, Customer.class);

        query.setParameter("email", email);

        return query.getSingleResult();
    }
}