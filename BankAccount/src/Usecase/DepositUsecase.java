package Usecase;

import Class.BankAccountClass;

public class DepositUsecase {
    public void deposit(BankAccountClass bankAccount, double amount) {
        // Add the deposited amount to the monetary value
        bankAccount.value += amount;
    }
}