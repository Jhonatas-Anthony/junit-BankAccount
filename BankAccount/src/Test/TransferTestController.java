package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import Controller.TransferController;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Class.BankAccountClass;

class TransferTestController {
	private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    
	/**
	 * Should test the fail if amount is equal than zero
	 */
	@Test 
	void transferWithZeroOrLess(){
		BankAccountClass[] accounts = new BankAccountClass[2];
		accounts[0] = new BankAccountClass(10, 250, "Poupança");
		accounts[1] = new BankAccountClass(11, 350, "Poupança");
		
		TransferController c = new TransferController();
		c.transfer(accounts[0], accounts[1], 0);
		
		assertEquals("Invalid amount", outputStreamCaptor.toString().trim());
		assertEquals(accounts[0].getValue(), 250);
		assertEquals(accounts[1].getValue(), 350);
	}
	
	/**
	 * Should test the fail if amount is less than zero
	 */
	@Test 
	void transferWithNegative(){
		BankAccountClass[] accounts = new BankAccountClass[2];
		accounts[0] = new BankAccountClass(10, 250, "Poupança");
		accounts[1] = new BankAccountClass(11, 350, "Poupança");

		TransferController c = new TransferController();
		c.transfer(accounts[0], accounts[1], -10);
		
		assertEquals("Invalid negative amount", outputStreamCaptor.toString().trim());
		assertEquals(accounts[0].getValue(), 250);
		assertEquals(accounts[1].getValue(), 350);
	}
	
	/**
	 * Should test the fail if amount is greater than account balance
	 */
	@Test 
	void transferWithAmountGreaterBalance(){
		BankAccountClass[] accounts = new BankAccountClass[2];
		accounts[0] = new BankAccountClass(10, 250, "Poupança");
		accounts[1] = new BankAccountClass(11, 350, "Poupança");
		
		TransferController c = new TransferController();
		c.transfer(accounts[0], accounts[1], 255);
		
		assertEquals("Insufficient funds", outputStreamCaptor.toString().trim());
		assertEquals(accounts[0].getValue(), 250);
		assertEquals(accounts[1].getValue(), 350);
	}
	
	/**
	 * Should test the success on transfer - controller
	 */
	@Test 
	void transfer(){
		BankAccountClass[] accounts = new BankAccountClass[2];
		accounts[0] = new BankAccountClass(10, 250, "Poupança");
		accounts[1] = new BankAccountClass(11, 350, "Poupança");
		TransferController c = new TransferController();
		c.transfer(accounts[0], accounts[1], 100);
		
		assertEquals(accounts[0].getValue(), 150);
		assertEquals(accounts[1].getValue(), 450);
	}

}
