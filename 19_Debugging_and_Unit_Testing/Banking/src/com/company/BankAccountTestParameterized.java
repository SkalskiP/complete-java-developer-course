/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      26.02.18 17:53
 *  Project       :      Banking
 *  ==========================================================
 */

package com.company;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount account;
    private double amount;
    private boolean brunch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean brunch, double expected) {
        this.amount = amount;
        this.brunch = brunch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.15, true, 1325.15},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}

        });
    }

    @org.junit.Test
    public void deposit() throws Exception {
        account.deposit(amount, brunch);
        assertEquals(expected, account.getBalance(), 0.1);
    }
}
