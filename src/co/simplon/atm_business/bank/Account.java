package co.simplon.atm_business.bank;

public class Account {

	private int accountNumber;
	private int balance;
	
	public Account(int accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public int getAccountNumber(){
		return this.accountNumber;
	};
	
	
//	public boolean verifyBalance(int checkAmount) {
//		return checkAmount<=this.balance;
//	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int newBalance) {
		this.balance= newBalance;
	}
	
	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}
	
}
