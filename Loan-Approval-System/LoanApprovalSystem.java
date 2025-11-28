// ________________________________________
// 4️⃣ Bank Loan Approval System
// Abstract Class: Loan
// Fields:
// •	customerName
// •	loanAmount
// Abstract method:
// •	calculateInterest()
// Subclasses:
// •	HomeLoan
// •	EducationLoan
// •	PersonalLoan
// Task:
// Given loan type + amount, calculate interest dynamically using runtime polymorphism.
// -----------------------------------------------------------------------------

import java.lang.*;

abstract class Loan{
    String customerName;
    double loanAmount;
    Loan(String customerName, double loanAmount){
        this.customerName = customerName;
        this.loanAmount = loanAmount;
    }
    
    abstract void calculateInterest();
}
// --------------------------Home Loan------------------------------
class HomeLoan extends Loan{
    HomeLoan(String customerName, double loanAmount){
        super(customerName, loanAmount);
    }
    @Override
    void calculateInterest(){
        double total = loanAmount+(loanAmount*0.01);
        System.out.println("=====Home Loan Details======");
        System.out.println("Home Loan is Approved for Customer Name:"+ customerName);
        System.out.println("Total Amount With Interest:"+total);
    }
}
// -------------------------Educational Loan------------------------------
class EducationalLoan extends  Loan{
    EducationalLoan(String customerName, double loanAmount){
        super(customerName, loanAmount);
    }
    @Override
    void calculateInterest(){
        double total = loanAmount+(loanAmount*0.02);
        System.out.println("=====Educational Loan Details======");
        System.out.println("Educational Loan Approved for Customer Name:"+ customerName);
        System.out.println("Total Amount With Interest:"+total);
    }
}
// -------------------------Personal Loan------------------------------
class PersonalLoan extends Loan{
    PersonalLoan(String customerName, double loanAmount){
        super(customerName, loanAmount);
        System.out.println("Education Loan is Approver For Customer Name:"+ customerName);
        System.out.println("Loan Amount:"+loanAmount);
    }
    @Override
    void calculateInterest(){
        double total = loanAmount+(loanAmount*0.03);
        System.out.println("=====Personal Loan Details======");
        System.out.println("Personal Loan Approved For Customer Name:"+ customerName);
        System.out.println("Total Amount With Interest:"+total);
    }
}
// ----------------------Loan Approval System------------------------------
class LoanApprovalSystem{
    public static void main (String[] args) {
        
        Loan loan1 = new HomeLoan("Sreenu", 3000000.0);
        Loan loan2 = new EducationalLoan("Venu", 300000.0);
        Loan loan3 = new PersonalLoan("Mani", 200000.0);
        
        loan1. calculateInterest();
        loan2. calculateInterest();
        loan3. calculateInterest();
    }
}













