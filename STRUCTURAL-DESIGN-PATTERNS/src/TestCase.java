import bonusCalculator.*;
import employee.*;

public class TestCase {

    public static void main(String[] args) {

        // Adapter example
        Employee employee = new Employee("John Doe", 1, 50000.0);
        EmployeeAdapter adapter = new EmployeeAdapter(employee);
        System.out.println("Full Name: " + adapter.getFullName());

        // Bridge example
        BonusCalculatorBridge standardCalculator = new StandardBonusCalculator(employee);
        BonusCalculatorBridge seniorCalculator = new SeniorEmployeeBonusCalculator(employee);
        System.out.println("Standard Bonus: " + standardCalculator.calculateBonus());
        System.out.println("Senior Bonus: " + seniorCalculator.calculateBonus());

        // Facade example
        BonusCalculator standardBonusCalculator = new EmployeeBonusCalculator();
        EmployeeFacade facade = new EmployeeFacade("Alice Smith", 2, 80000.0, standardBonusCalculator);
        double bonus = facade.calculateBonus();
        System.out.println("Employee Bonus: " + bonus);

        // Proxy example
        EmployeeProxy proxy = new EmployeeProxy("Bob", 3, 60000.0);
        proxy.work();
    }


    }


    

