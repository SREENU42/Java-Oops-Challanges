
// 🔟 Employee Payroll System (Advanced)
// Base class Employee:
// •	name, id
// •	abstract calculateSalary()
// Subclasses:
// •	FullTimeEmployee (basic + bonus)
// •	PartTimeEmployee (hourlyRate + totalHours)
// •	ContractEmployee (fixed monthly + no benefits)
// PayrollProcessor:
// •	printPaySlip(Employee e)
// Task:
// Process all employees using a single reference type

abstract class Employee {
    protected String name;
    protected int id;
    
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public abstract double calculateSalary();
    
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}

class FullTimeEmployee extends Employee {
    private double basicSalary;
    private double bonus;
    
    FullTimeEmployee(String name, int id, double basicSalary, double bonus) {
        super(name, id);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }
    @Override 
    public double calculateSalary() {
        return basicSalary + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int totalHours;
    
    PartTimeEmployee(String name, int id, double hourlyRate, int totalHours) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.totalHours = totalHours;
    }
    @Override
    public double calculateSalary() {
        return hourlyRate*totalHours;
    }
}

class ContractEmployee extends Employee {
    private double fixedMonthly;
    
    ContractEmployee(String name, int id, double fixedMonthly) {
        super(name, id);
        this. fixedMonthly = fixedMonthly;
    }
    @Override
    public double calculateSalary() {
        return fixedMonthly;
    }
}

class PayRollProcessor {
    
    public void printPaySlip(Employee e) {
        System.out.println("============PAY SLIP===========");
        System.out.println("Employee Name: "+e.getName());
        System.out.println("Employee Id: "+e.getId());
        System.out.println("Employee Salary: "+e.calculateSalary());
        System.out.println("===============================");
    }
}

public class PayRollSystem {
    
    public static void main (String[] args) {
        Employee e1 = new FullTimeEmployee("PAUL", 101,50000.0,2000.0);
        Employee e2 = new PartTimeEmployee("MOUNICA", 102, 10000.0, 10);
        Employee e3 = new ContractEmployee("NANCY",103, 50000.0);
        
        PayRollProcessor pp = new PayRollProcessor();
        
        pp.printPaySlip(e1);
        pp.printPaySlip(e2);
        pp.printPaySlip(e3);
    }
}