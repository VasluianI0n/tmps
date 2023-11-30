package bonusCalculator;

import employee.Employee;

public class EmployeeBonusCalculator implements BonusCalculator{
    @Override
    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.1;
    }
}
