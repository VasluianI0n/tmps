package employee;

public class ManagerBuilder {
    private String name;
    private int id;
    private double salary;
    private String department;

    public ManagerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ManagerBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ManagerBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public ManagerBuilder setDepartment(String department){
        this.department = department;
        return this;
    }

    public Manager build() {
        return new Manager(name, id, salary, department);
    }
}
