
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
abstract class Employee {
    protected String name;
    protected int id;
    protected double basicSalary;

    //constructor
    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    // Method for calculate
    public double calculateSalary() throws InvalidSalaryException {
        if (basicSalary < 3000) {
            throw new InvalidSalaryException("Salary cannot be less than 3000!");
        }
        return basicSalary;
    }

    // Abstract method 
    public abstract void applyBenefits();
}

abstract class Benefits {
    public abstract void applyBenefits();
}
interface Performance {
    void evaluatePerformance();
    void promoteEmployee();
}
class Manager extends Employee implements Performance {
    private double bonus;

    public Manager(String name, int id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() throws InvalidSalaryException {
        return super.calculateSalary() + bonus;
    }

    // Implementing abstract method
    @Override
    public void applyBenefits() {
        System.out.println("Benefits applied for Manager: Health Insurance and Stock Options.");
    }

    // Implementing interface methods
    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluating Manager's performance...");
    }

    @Override
    public void promoteEmployee() {
        System.out.println("Promoting Manager...");
    }
}

class Developer extends Employee implements Performance {
    private double overtimePay;

    public Developer(String name, int id, double basicSalary, double overtimePay) {
        super(name, id, basicSalary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double calculateSalary() throws InvalidSalaryException {
        return super.calculateSalary() + overtimePay;
    }

    // Implementing abstract method 
    @Override
    public void applyBenefits() {
        System.out.println("Benefits applied for Developer: Health Insurance and Learning Allowance.");
    }

    // Implementing interface methods
    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluating Developer's performance...");
    }

    @Override
    public void promoteEmployee() {
        System.out.println("Promoting Developer...");
    }
}

public class manage {
    public static void main(String[] args) {
        try {
            Manager manager = new Manager("md shafik", 101, 2000, 2000);
            Developer developer = new Developer("md", 102, 4000, 500);
            System.out.println("Manager's Salary: " + manager.calculateSalary());
            manager.applyBenefits();
            manager.evaluatePerformance();
            manager.promoteEmployee();

            System.out.println();

            System.out.println("Developer's Salary: " + developer.calculateSalary());
            developer.applyBenefits();
            developer.evaluatePerformance();
            developer.promoteEmployee();

        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
