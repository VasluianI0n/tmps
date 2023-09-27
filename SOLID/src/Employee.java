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
