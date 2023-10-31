package employee;

public class EmployeeProxy implements Workable{
    private Employee employee;

    public EmployeeProxy(String name, int id, double salary) {
        // Delay the creation of the real employee object
        employee = new Employee(name, id, salary);
    }

    @Override
    public void work() {
        // Delegate the work to the real employee
        employee.work();
    }
}
