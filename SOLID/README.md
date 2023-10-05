# Laboratory Work Nr.1 SOLID Principles
## Course: Tehnici si Mecanisme de Proiectare Software
## Author: Vasluian Ion
****
## Theory
SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. 
The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and 
Dependency Inversion Principle. Each principle addresses a specific aspect of software design, such as the organization of responsibilities, 
the handling of dependencies, and the design of interfaces. By following these principles, software developers can create more modular, testable, 
and reusable code that is easier to modify and extend over time. These principles are widely accepted and adopted in the software development community 
and can be applied to any object-oriented programming language.
****
## Tasks
    1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).

    2. Select a domain area for the sample project.

    3. Define the main involved classes and think about what instantiation mechanisms are needed.

    4. Respect SOLID Principles in your project.

****
## Implementation
I chose Java for this task, working in IntelliJ since it's the most comfortable IDE I have used so far.

In my project, I have a class Employee, which shows us the Single Responsibility Principle:
```java
public class Employee {
    // Single Responsibility Principle
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Getter and setter methods for each attribute
    // ...

    public double calculateBonus() {
        return salary * 0.1;
    }

}
```
I have not yet set the getter and setter methods, since that will be done in the future laboratories in order to complete the tasks, so for now I typed just a reminder
Our Single Responsibility Principle (SRP) states that "A module should be responsible to one, and only one, actor". The Employee class has a single responsibility, which is managing employee information and calculating bonuses.

Next we have Open-Closed Principle (OCP), which I made by using interface BonusCalculator:
```java
public interface BonusCalculator {
    // Open-Closed Principle
    double calculateBonus(Employee employee);
}
```
and implementing it into 2 other classes, each with a different function:
```java
public class StandardBonusCalculator implements BonusCalculator {
    public double calculateBonus(Employee employee) {
        return employee.calculateBonus();
    }
}
```

```java
public class SeniorEmployeeBonusCalculator implements BonusCalculator {
    public double calculateBonus(Employee employee) {
        return employee.calculateBonus() * 2;
    }
}
```

For the Liskov Substitution Principle (LSP), I made a class called Manager, which extends Employee, which basically means that the Manager class is a subclass of Employee, and it can be used interchangeably without breaking the program's behavior:
```java
public class Manager extends Employee {
    // Liskov Substitution Principle
    private String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    public Employee[] hire_employee(String name, Employee[] employees){

        return  employees;
    }

    public Employee[] fire_employee(String name, Employee[] employees){

        return employees;
    }
}
```

Interface Segregation Principle (ISP) states that the user should choose himself which interfaces to use and which to not, without being needed to implement unneeded methods:
```java
public interface Eatable {
    public void eat();
}

public interface Workable {
    void work();
}

public class Worker implements Workable, Eatable{
    public void eat() {
        System.out.println("I'm on my break now. Don't disturb me!");
    }
    public void work() {
        System.out.println("Anything task you want me to do?");
        String answer = System.console().readLine();
        if(!answer.equalsIgnoreCase("no")){
            System.out.println("Okay, I will work on that too");
        }
    }
}

public class Robot implements Workable{
    public void work() {
        System.out.println("I'm a working robot!");
    }
}
```

And the last one, Dependency Inversion Principle (DIP), states that "high-level modules should depend on abstractions rather than low-level modules". That's why in class BonusService I used BonusCalculator interface, allowing me to inject different implementations (e.g., StandardBonusCalculator or SeniorEmployeeBonusCalculator) without changing the BonusService class itself:
```java
public class BonusService {

    //Dependency Inversion Principle
    private BonusCalculator bonusCalculator;

    public BonusService(BonusCalculator bonusCalculator) {
        this.bonusCalculator = bonusCalculator;
    }

    public double calculateBonus(Employee employee) {
        return bonusCalculator.calculateBonus(employee);
    }
}
```

In the TestCase.java I tested everything if it works at is should, therefore proving the principles to work:
```java
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
    }
    
}
```
****
