package co.simplon.atm_business.bank;

public class Account {

	private int accountNumber;
	private int balance;
	public boolean isLocked;
	
	public Account(int accountNumber, int balance, boolean isLocked) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.isLocked = isLocked;
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
	
	public boolean isLocked() {
		return this.isLocked;
	}
	
	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}
	
	public void unlock() {
		this.isLocked = false;
	}
	
}
