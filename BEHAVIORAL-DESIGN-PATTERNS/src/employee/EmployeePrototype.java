package employee;

public class EmployeePrototype {
    private Employee employeePrototype;

    public EmployeePrototype(Employee employee) {
        this.employeePrototype = employee;
    }

    public Employee cloneEmployee() {
        return new Employee(employeePrototype.getName(), employeePrototype.getId(), employeePrototype.getSalary());
    }

}
