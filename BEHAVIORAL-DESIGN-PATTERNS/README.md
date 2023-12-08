# Laboratory Work Nr.4 Behavioral Design Patterns
## Course: Tehnici si Mecanisme de Proiectare Software
## Author: Vasluian Ion
****
## Theory

Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

Some examples from this category of design patterns are:

1. Chain of Responsibility
2. Command
3. Interpreter
4. Iterator
5. Mediator
6. Observer
7. Strategy
****
## Implementation

### Observer Design Pattern
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

```java
interface BonusObserver {
    void update(double bonus);
}

class BonusObservable {
    private List<BonusObserver> observers = new ArrayList<>();

    public void addObserver(BonusObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BonusObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(double bonus) {
        for (BonusObserver observer : observers) {
            observer.update(bonus);
        }
    }
}

class BonusLogger implements BonusObserver {
    public void update(double bonus) {
        System.out.println("Bonus logged: " + bonus);
    }
}

```
The BonusObservable class acts as the subject, and BonusLogger is the observer. The subject maintains a list of observers (BonusObserver), and observers can subscribe to receive updates.
In the DesignPatternsExample class, an instance of BonusObservable is created, and a BonusLogger is added as an observer. Later, when the bonus is calculated, the observers are notified.
### Command Design Pattern
The Command pattern encapsulates a request as an object, thereby parameterizing clients with different requests, queuing requests, and providing additional functionality like undo/redo operations.

```java
interface BonusCommand {
    void execute();
}

class BonusCommandImpl implements BonusCommand {
    private BonusCalculator bonusCalculator;
    private Employee employee;

    public BonusCommandImpl(BonusCalculator bonusCalculator, Employee employee) {
        this.bonusCalculator = bonusCalculator;
        this.employee = employee;
    }

    public void execute() {
        double bonus = bonusCalculator.calculateBonus(employee);
        System.out.println("Bonus calculated: " + bonus);
    }
}

```
The BonusCommand interface declares the execute method, and BonusCommandImpl is a concrete command that encapsulates the request to calculate the bonus.
In the DesignPatternsExample class, an instance of BonusCommandImpl is created with a StandardBonusCalculator and an Employee. The execute method is called to perform the bonus calculation.

### State Design Pattern

The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

```java
class EmployeeContext {
    private BonusState bonusState;

    public EmployeeContext(BonusState bonusState) {
        this.bonusState = bonusState;
    }

    public void setBonusState(BonusState bonusState) {
        this.bonusState = bonusState;
    }

    public void requestBonus() {
        bonusState.handleBonus(this);
    }
}

interface BonusState {
    void handleBonus(EmployeeContext context);
}

class StandardBonusState implements BonusState {
    public void handleBonus(EmployeeContext context) {
        System.out.println("Standard bonus requested");
        // Implement logic for standard bonus calculation
        context.setBonusState(this);
    }
}

class SeniorBonusState implements BonusState {
    public void handleBonus(EmployeeContext context) {
        System.out.println("Senior bonus requested");
        // Implement logic for senior bonus calculation
        context.setBonusState(this);
    }
}

```

### Test Case Class
In the TestCase.java class I updated it so that it shows the functionality of all the previously implemented Behavioral Design Patterns:

```java
public static void main(String[] args) {

        // Observer example
        BonusObservable bonusObservable = new BonusObservable();
        BonusLogger bonusLogger = new BonusLogger();
        bonusObservable.addObserver(bonusLogger);

        // Command example
        Employee employee = new Employee("John Doe", 1, 50000.0);
        StandardBonusCalculator standardCalculator = new StandardBonusCalculator(employee);
        BonusCommand bonusCommand = new BonusCommandImpl(standardCalculator, employee);

        // State example
        EmployeeContext employeeContext = new EmployeeContext(new StandardBonusState());
        employeeContext.requestBonus();  // Outputs: Standard bonus requested

        // Execute bonus calculation and notify observers
        bonusCommand.execute();
        bonusObservable.notifyObservers(employee.calculateBonus());  // Outputs: Bonus logged: {calculated bonus}
    }


```
****
