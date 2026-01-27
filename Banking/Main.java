package Banking;

public class Main {
    public static void main(String[] args) {

        Account a1 = new SavingsAccount("Simson", 1000, 101);
        Account a2 = new CurrentAccount("Meeka", 2000, 202);

        a1.deposit(500);
        a1.withdraw(300);
        a1.calculateInterest();
        a1.display();
        a2.deposit( 1000);
        a2.withdraw(3500);
        a2.calculateInterest();
        a2.display();
    }
}


abstract class Account {

    private String name;
    protected double balance;
    private final int accNo;

    static final String BANK_NAME = "HDFC_BANK";

    public Account(String name, double balance, int accNo) {
        this.name = name;
        this.balance = balance;
        this.accNo = accNo;
    }


    public String getName() {
        return name;
    }

    public int getAccNo() {
        return accNo;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void display() {
        System.out.println(
            "Bank: " + BANK_NAME +
            ", AccNo: " + accNo +
            ", Name: " + name +
            ", Balance: " + balance
        );
    }


    public abstract void calculateInterest();
}

class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String name, double balance, int accNo) {
        super(name, balance, accNo);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        System.out.println("Savings Interest: " + interest);
    }
}

class CurrentAccount extends Account {

    public CurrentAccount(String name, double balance, int accNo) {
        super(name, balance, accNo);
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Account");
    }
}