package bonusCalculator;

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
