public class SeniorEmployeeBonusCalculator implements BonusCalculator {
    public double calculateBonus(Employee employee) {
        return employee.calculateBonus() * 2;
    }
}
