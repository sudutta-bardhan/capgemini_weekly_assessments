package com.capgemini.jdbc_jpa_hibernate_assessment.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
    private int id;

	@Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
	private String gender;

    @Column(name = "phone")
	private long phone;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public long getPhone()
	{
		return phone;
	}

	public void setPhone(long phone)
	{
		this.phone = phone;
	}

	public LocalDate getRegistrationDate()
	{
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate)
	{
		this.registrationDate = registrationDate;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(customerName, email, gender, id, phone, registrationDate);
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
		Customer other = (Customer) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && id == other.id && phone == other.phone
				&& Objects.equals(registrationDate, other.registrationDate);
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", customerName=" + customerName + ", email=" + email + ", gender=" + gender
				+ ", phone=" + phone + ", registrationDate=" + registrationDate + "]";
	}
}