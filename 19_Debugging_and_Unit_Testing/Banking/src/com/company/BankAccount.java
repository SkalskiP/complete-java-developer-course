/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      25.02.18 22:06
 *  Project       :      Banking
 *  ==========================================================
 */

package com.company;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    // The brunch argument is true if the customer is performing the transaction
    // at a branch, with a teller,
    // It's false if the customer is performing the transaction at an ATM.
    public double deposit(double amount, boolean branch) {
        this.balance += amount;
        return this.balance;
    }

    // The brunch argument is true if the customer is performing the transaction
    // at a branch, with a teller,
    // It's false if the customer is performing the transaction at an ATM.
    public double withdraw(double amount, boolean branch) {
        this.balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    // More methods that use firstName, lastName and perform   other functions
}
