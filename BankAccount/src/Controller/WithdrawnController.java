package Controller;

import Class.BankAccountClass;
import Usecase.WithdrawUsecase;

public class WithdrawnController {
    public void withdraw(BankAccountClass bankAccount, double amount) {
        if (bankAccount.value > amount){
        	WithdrawUsecase w = new WithdrawUsecase();
            w.withdraw(bankAccount, amount);
        }
        else {
            System.out.println("Insufficient funds");
        }
    }
}