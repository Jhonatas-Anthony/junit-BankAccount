package Usecase;

import Class.BankAccountClass;

public class WithdrawUsecase {
    public void withdraw(BankAccountClass bankAccount, double amount) {
        // Subtract the withdrawn amount from the monetary value
        bankAccount.value -= amount;
    }
}