package employee;

import employee.Employee;

public class Manager extends Employee {
    // Liskov Substitution Principle
    private String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    public Employee[] hire_employee(String name, Employee[] employees){

        return  employees;
    }

    public Employee[] fire_employee(String name, Employee[] employees){

        return employees;
    }
}
