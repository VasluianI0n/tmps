import bonusCalculator.BonusCalculator;
import bonusCalculator.BonusService;
import bonusCalculator.SeniorEmployeeBonusCalculator;
import bonusCalculator.StandardBonusCalculator;
import employee.*;

public class TestCase {

    public static void main(String[] args) {
        Employee employee = new Employee("John", 1, 50000.0);
        Manager manager = new Manager("Alice", 2, 80000.0, "HR");

        BonusService bonusService = new BonusService(new StandardBonusCalculator());
        double employeeBonus = bonusService.calculateBonus(employee);

        BonusService seniorBonusService = new BonusService(new SeniorEmployeeBonusCalculator());
        double managerBonus = seniorBonusService.calculateBonus(manager);

        System.out.println("Employee Bonus: " + employeeBonus);
        System.out.println("Manager Bonus: " + managerBonus);



        //CREATIONAL DESIGN PATTERNS

        // Singleton example
        Configuration config1 = Configuration.getInstance();
        Configuration config2 = Configuration.getInstance();
        System.out.println(config1 == config2); // Should print "true"

        // Builder example
        Employee employeeb = new EmployeeBuilder()
                .setName("John")
                .setId(1)
                .setSalary(50000.0)
                .build();

        // Prototype example
        EmployeePrototype prototype = new EmployeePrototype(employeeb);
        Employee clone = prototype.cloneEmployee();

        // Object Pooling example
        EmployeePool employeePool = new EmployeePool(3);
        Employee emp1 = employeePool.acquire();
        Employee emp2 = employeePool.acquire();
        Employee emp3 = employeePool.acquire();
        employeePool.release(emp1);
        employeePool.release(emp2);

        // Factory Method example
        EmployeeFactory managerFactory = new ManagerFactory();
        Employee managerF = managerFactory.createEmployee();

        // Abstract Factory example
        AbstractEmployeeFactory managerAbstractFactory = new ManagerAbstractFactory();
        Employee abstractManager = managerAbstractFactory.createEmployee();
        BonusCalculator bonusCalculator = managerAbstractFactory.createBonusCalculator();
    }


    
}
