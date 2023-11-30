package employee;

import bonusCalculator.BonusCalculator;

public interface AbstractEmployeeFactory {
    Employee createEmployee();
    BonusCalculator createBonusCalculator();
}
