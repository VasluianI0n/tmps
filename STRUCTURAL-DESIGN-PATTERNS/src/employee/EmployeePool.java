package employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeePool {
    private List<Employee> pool;
    private int maxPoolSize;

    public EmployeePool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.pool = new ArrayList<>();
    }

    public Employee acquire() {
        if (pool.isEmpty()) {
            return new EmployeeBuilder()
                    .setName("New employee.Employee")
                    .setId(pool.size() + 1)
                    .setSalary(0.0)
                    .build();
        } else {
            return pool.remove(0);
        }
    }

    public void release(Employee employee) {
        if (pool.size() < maxPoolSize) {
            pool.add(employee);
        }
    }
}
