package bonusCalculator;

import employee.Employee;

public class StandardBonusCalculator implements BonusCalculator {
    public double calculateBonus(Employee employee) {
        return employee.calculateBonus();
    }
}
