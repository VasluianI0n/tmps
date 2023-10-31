# Laboratory Work Nr.3 Structural Design Patterns
## Course: Tehnici si Mecanisme de Proiectare Software
## Author: Vasluian Ion
****
## Theory
Structural design patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient. These patterns focus on, how the classes inherit from each other and how they are composed from other classes.
There are following 7 types of structural design patterns:

1. Adapter Pattern -> Adapting an interface into another according to client expectation.
2. Bridge Pattern -> Separating abstraction (interface) from implementation.
3. Composite Pattern -> Allowing clients to operate on hierarchy of objects.
4. Decorator Pattern -> Adding functionality to an object dynamically.
5. Facade Pattern -> Providing an interface to a set of interfaces.
6. Flyweight Pattern -> Reusing an object by sharing it.
7. Proxy Pattern -> Representing another object.

These design patterns are about organizing different classes and objects to form larger structures and provide new functionality.

****
## Implementation

First of all I had to add an Adapter Design Pattern, and I chose to make EmployeeAdapter:
```java
public class EmployeeAdapter {
    private Employee employee;

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
    }

    public String getFullName() {
        return employee.getName();
    }
}
```
in this way you can get the name with the function from upper.

For Bridge Structural Pattern I made BonusCalculatorBridge and changed the 2 BonusCalculators, adding a new default one as well: 
```java
public interface BonusCalculatorBridge {

    double calculateBonus();

}

import employee.Employee;

public class EmployeeBonusCalculator implements BonusCalculator{
    @Override
    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.1;
    }
}

import employee.Employee;

public class SeniorEmployeeBonusCalculator implements BonusCalculatorBridge {
    private Employee employee;

    public SeniorEmployeeBonusCalculator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public double calculateBonus() {
        return employee.calculateBonus() * 2;
    }
    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.2; // Adjust the bonus calculation as needed
    }
}

import employee.Employee;

public class StandardBonusCalculator implements BonusCalculatorBridge{
    private Employee employee;

    public StandardBonusCalculator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public double calculateBonus() {
        return employee.calculateBonus();
    }

    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.1;
    }
}
```

For the Facade Structural Pattern I made a EmployeeFacade class, which hides the complexity of calculating everything, leaving just the functions to use:

```java
import bonusCalculator.BonusCalculator;

public class EmployeeFacade {
    private Employee employee;
    private BonusCalculator bonusCalculator;

    public EmployeeFacade(String name, int id, double salary, BonusCalculator bonusCalculator) {
        this.employee = new Employee(name, id, salary);
        this.bonusCalculator = bonusCalculator;
    }

    public double calculateBonus() {
        return bonusCalculator.calculateBonus(employee);
    }
}
```

Proxy Design Pattern creates proxy for the Workable interface. It delegates the work to the real employee object but allows for additional control or behavior.
```java
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
```

In the TestCase.java file I added verification for the design patterns:
```java
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
```
****
