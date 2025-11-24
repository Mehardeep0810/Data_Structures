package Assignment.objectmodeling;

import java.util.*;

class Account {
    private int accountNumber;
    private double balance;
    private Bank bank; 

    public Account(int accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.bank = bank;
    }

    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Bank getBank() { return bank; }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Customer class
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Account " + acc.getAccountNumber() +
                               " at " + acc.getBank().getName() +
                               " has balance: " + acc.getBalance());
        }
    }
}

// Bank class
class Bank {
    private String name;
    private List<Customer> customers;
    private int accountCounter = 1000;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Account openAccount(Customer customer) {
        Account newAccount = new Account(accountCounter++, this);
        customer.addAccount(newAccount);
        System.out.println("Opened account " + newAccount.getAccountNumber() +
                           " for " + customer.getName() + " at " + name);
        return newAccount;
    }

    public void showCustomers() {
        System.out.println("Bank: " + name + " has customers:");
        for (Customer c : customers) {
            System.out.println(" - " + c.getName());
        }
    }
}

// Demo
public class AssociationDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("Punjab Bank");

        Customer c1 = new Customer("Mehardeep");
        Customer c2 = new Customer("Aman");

        bank1.addCustomer(c1);
        bank2.addCustomer(c2);

        Account acc1 = bank1.openAccount(c1);
        Account acc2 = bank2.openAccount(c2);
        Account acc3 = bank1.openAccount(c1); 

        acc1.deposit(5000);
        acc2.deposit(3000);
        acc3.deposit(2000);

        c1.viewBalance();
        c2.viewBalance();

        bank1.showCustomers();
        bank2.showCustomers();
    }
}
