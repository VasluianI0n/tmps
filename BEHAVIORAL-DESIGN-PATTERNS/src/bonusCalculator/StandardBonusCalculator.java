package bonusCalculator;

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
