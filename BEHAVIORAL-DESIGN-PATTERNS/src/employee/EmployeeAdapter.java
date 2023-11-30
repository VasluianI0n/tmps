package employee;

import employee.Employee;

public class EmployeeAdapter {
    private Employee employee;

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
    }

    public String getFullName() {
        return employee.getName();
    }
}