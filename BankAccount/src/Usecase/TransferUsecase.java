package Usecase;

import Class.BankAccountClass;

public class TransferUsecase {
    public void transfer(BankAccountClass bankAccount, BankAccountClass recipientAccount, double amount) {
        // Withdraw the amount from the current account and deposit it into the recipient's account
        WithdrawUsecase w = new WithdrawUsecase();
        DepositUsecase d = new DepositUsecase();
        w.withdraw(bankAccount, amount);
        d.deposit(recipientAccount, amount);
    }
}