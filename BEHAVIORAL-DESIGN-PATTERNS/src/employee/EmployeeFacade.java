package employee;

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
