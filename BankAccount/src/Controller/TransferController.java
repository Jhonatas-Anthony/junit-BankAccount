package Controller;

import Class.BankAccountClass;
import Usecase.TransferUsecase;

public class TransferController {
    public void transfer(BankAccountClass bankAccount, BankAccountClass recipientAccount, double amount) {
        // Withdraw the amount from the current account and deposit it into the recipient's account
        if (amount == 0){
            System.out.println("Invalid amount");
        }
        else if (amount < 0){
            System.out.println("Invalid negative amount");
        }
        else if(amount > bankAccount.value){
            System.out.println("Insufficient funds");
        }
        else {
        	TransferUsecase t = new TransferUsecase();
        	t.transfer(bankAccount, recipientAccount, amount);
            //bankAccount.withdraw(amount);
            //recipientAccount.deposit(amount);
        }
        
    }
}