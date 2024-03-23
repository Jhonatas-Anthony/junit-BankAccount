package Controller;

import Class.BankAccountClass;
import Usecase.DepositUsecase;

public class DepositController {
    public void deposit(BankAccountClass bankAccount, double amount) {
    	DepositUsecase d = new DepositUsecase();
    	d.deposit(bankAccount, amount);
    }
}