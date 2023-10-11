package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing an account
abstract class Account {
    public abstract float getBalance(); // Abstract method to get the balance
}

// Concrete class representing a Deposit Account
class DepositAccount extends Account {
    private String accountNo; // Account number
    private float accountBalance; // Account balance

    // Constructor to initialize account number and balance
    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    // Method to get the balance
    public float getBalance() {
        return accountBalance;
    }
}

// Concrete class representing a Savings Account
class SavingsAccount extends Account {
    private String accountNo; // Account number
    private float accountBalance; // Account balance

    // Constructor to initialize account number and balance
    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    // Method to get the balance
    public float getBalance() {
        return accountBalance;
    }
}

// Composite class representing a group of accounts
class CompositeAccount extends Account {
    private float totalBalance; // Total balance of all accounts
    private List<Account> accountList = new ArrayList<Account>(); // List of accounts

    // Method to get the total balance
    public float getBalance() {
        totalBalance = 0;
        for (Account account : accountList) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    // Method to add an account to the list
    public void addAccount(Account acc) {
        accountList.add(acc);
    }

    // Method to remove an account from the list
    public void removeAccount(Account acc) {
        accountList.remove(acc);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();

        // Adding deposit accounts and savings account to the composite account
        compositeAccount.addAccount(new DepositAccount("DA001", 100));
        compositeAccount.addAccount(new DepositAccount("DA002", 150));
        compositeAccount.addAccount(new SavingsAccount("SA001", 200));

        // Getting the total balance of all accounts in the composite account
        float totalBalance = compositeAccount.getBalance();
        System.out.println("Total Balance : " + totalBalance);
    }
}
