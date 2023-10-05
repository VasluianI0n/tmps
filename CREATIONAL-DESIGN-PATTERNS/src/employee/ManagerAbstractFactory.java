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
