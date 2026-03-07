package com.capgemini.jdbc_jpa_hibernate_assessment.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "order_number")
    private String orderNumber;
	
	@Column(name = "product_name")
    private String productName;
	
	@Column(name = "quantity")
    private int quantity;
	
	@Column(name = "price")
    private double price;
	
	@Column(name = "order_date")
    private LocalDate orderDate;
    
    @OneToOne(mappedBy = "order")
    private Customer customer;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public LocalDate getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate)
	{
		this.orderDate = orderDate;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, orderDate, orderNumber, price, productName, quantity);
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderNumber, other.orderNumber)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productName, other.productName) && quantity == other.quantity;
	}

	@Override
	public String toString()
	{
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", productName=" + productName + ", quantity="
				+ quantity + ", price=" + price + ", orderDate=" + orderDate + "]";
	}
}