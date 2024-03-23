package Application;

import Class.BankAccountClass;

public class Main {

	public static void main(String[] args) {
		
		BankAccountClass[] accounts = new BankAccountClass[3];
		
		accounts[0] = new BankAccountClass(10, 250, "Poupança");
		
		accounts[1] = new BankAccountClass(11, 350, "Poupança");
		
		accounts[2] = new BankAccountClass(12, 450, "Poupança");

	}

}
