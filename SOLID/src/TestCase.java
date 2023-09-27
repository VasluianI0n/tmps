public class TestCase {

    public static void main(String[] args) {
        Employee employee = new Employee("John", 1, 50000.0);
        Manager manager = new Manager("Alice", 2, 80000.0, "HR");

        BonusService bonusService = new BonusService(new StandardBonusCalculator());
        double employeeBonus = bonusService.calculateBonus(employee);

        BonusService seniorBonusService = new BonusService(new SeniorEmployeeBonusCalculator());
        double managerBonus = seniorBonusService.calculateBonus(manager);

        System.out.println("Employee Bonus: " + employeeBonus);
        System.out.println("Manager Bonus: " + managerBonus);
    }
    
}
