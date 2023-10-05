package bonusCalculator;

import employee.Employee;

public interface BonusCalculator {
    // Open-Closed Principle
    double calculateBonus(Employee employee);
}
