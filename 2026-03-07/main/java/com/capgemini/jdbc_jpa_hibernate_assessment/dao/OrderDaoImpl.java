package com.capgemini.jdbc_jpa_hibernate_assessment.dao;

import javax.persistence.*;
import com.capgemini.jdbc_jpa_hibernate_assessment.entity.Order;


public class OrderDaoImpl implements OrderDao
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public String saveOrder(Order order)
    {

        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        entityManager.persist(order);
        transaction.commit();

        return "Order Saved";
    }

    @Override
    public String updateOrder(Order order)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        entityManager.merge(order);
        transaction.commit();

        return "Order Updated";
    }

    @Override
    public String deleteOrderById(int id)
    {
        Order order = entityManager.find(Order.class, id);

        if(order != null)
        {
            EntityTransaction transaction = entityManager.getTransaction();
            
            transaction.begin();
            entityManager.remove(order);
            transaction.commit();

            return "Order Deleted";
        }
        return "Order Not Found";
    }

    @Override
    public Order getOrderById(int id)
    {
        return entityManager.find(Order.class, id);
    }
}