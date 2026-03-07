package com.capgemini.jdbc_jpa_hibernate_assessment.dao;

import com.capgemini.jdbc_jpa_hibernate_assessment.entity.Order;

public interface OrderDao
{
    String saveOrder(Order order);

    String updateOrder(Order order);

    String deleteOrderById(int id);

    Order getOrderById(int id);

}