# Laboratory Work Nr.2 Creational Design Patterns
## Course: Tehnici si Mecanisme de Proiectare Software
## Author: Vasluian Ion
****
## Theory
Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

Some examples of this kind of design patterns are:

1. Singleton

2. Builder
    
3. Prototype
    
4. Object Pooling
    
5. Factory Method
    
6. Abstract Factory
****
## Tasks
1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).

2. Select a domain area for the sample project.

3. Define the main involved classes and think about what instantiation mechanisms are needed.

4. Based on the previous point, implement at least 2 creational design patterns in your project.

****
## Implementation

First of all I rearranged all my code into packages, adding bonusCalculator and employee packages, containing the classes that are related to it.
For Singleton Design Pattern I made a class Configuration:
```java
public class Configuration {

    private static Configuration instance;

    private Configuration() {
        // Private constructor to prevent instantiation
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

}
```
which ensures that only 1 instance of configuration is created.

For Builder Design Pattern I made EmployeeBuilder and ManagerBuilder, which ensures a flexible way to create Employee and Manager classes.
```java
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
```

For the Prototype Design Pattern I made a EmployeePrototype class, which allows me to clone Employee objects:

```java
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
```

Object Pooling Design Pattern creates a pool of objects for their reusage later. So I made a EmployeePool of Employee objects:
```java
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
                    .setName("New Employee")
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
```
For Factory Method Design I made 1 interface and 1 class (EmployeeFactory and ManagerFactory), which is used to create Employee objects:
```java
package employee;

public interface EmployeeFactory {
    Employee createEmployee();
}

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
```

And finally for Abstract Factory Design Pattern I made also 1 interface and 1 class (AbstractEmployeeFactory and ManagerAbstractFactory), which is used to create both Employee Objects and BonusCalculator objects as well:
```java
package employee;

import bonusCalculator.BonusCalculator;

public interface AbstractEmployeeFactory {
    Employee createEmployee();
    BonusCalculator createBonusCalculator();
}

package employee;

import bonusCalculator.BonusCalculator;
import bonusCalculator.SeniorEmployeeBonusCalculator;

public class ManagerAbstractFactory implements AbstractEmployeeFactory{
    public Employee createEmployee() {
        return new ManagerBuilder()
                .setName("New Manager")
                .setId(0)
                .setSalary(0.0)
                .setDepartment("New Department")
                .build();
    }

    public BonusCalculator createBonusCalculator() {
        return new SeniorEmployeeBonusCalculator();
    }
}
```

In the TestCase.java file I added verification for the design patterns:
```java
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
```
****
