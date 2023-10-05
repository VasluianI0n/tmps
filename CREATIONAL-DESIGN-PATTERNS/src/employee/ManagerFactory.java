package employee;

public class ManagerFactory implements EmployeeFactory{

        public Employee createEmployee() {
            return new ManagerBuilder()
                    .setName("New Manager")
                    .setId(0)
                    .setSalary(0.0)
                    .setDepartment("New Department")
                    .build();
        }

}
