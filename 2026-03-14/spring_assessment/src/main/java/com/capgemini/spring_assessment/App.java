package com.capgemini.spring_assessment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeService service = (EmployeeService) context.getBean("employeeService");

        service.getEmployee();
    }
}