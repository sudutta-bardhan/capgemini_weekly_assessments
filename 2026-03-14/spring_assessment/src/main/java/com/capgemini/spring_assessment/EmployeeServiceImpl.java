package com.capgemini.spring_assessment;

public class EmployeeServiceImpl implements EmployeeService
{
    private Employee employee;

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    @Override
    public void addEmployee()
    {
        System.out.println("Employee Added");
    }

    @Override
    public void updateEmployee()
    {
        System.out.println("Employee Updated");
    }

    @Override
    public void deleteEmployee()
    {
        System.out.println("Employee Deleted");
    }

    @Override
    public void getEmployee()
    {
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());

        Address address = employee.getAddress();

        System.out.println("City: " + address.getCity());
        System.out.println("State: " + address.getState());
        System.out.println("Country: " + address.getCountry());
        System.out.println("Pincode: " + address.getPincode());
    }
}