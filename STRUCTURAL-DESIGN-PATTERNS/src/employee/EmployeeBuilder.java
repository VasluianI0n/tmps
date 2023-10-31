package employee;

public class EmployeeBuilder {
    private String name;
    private int id;
    private double salary;

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        return new Employee(name, id, salary);
    }
}
