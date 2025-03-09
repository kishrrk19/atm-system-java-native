package atm_business;

public class AccountInfo {

	private int accountNumber;
	private int balance;
	private boolean isLocked;
	
	public AccountInfo(int accountNumber, int balance, boolean isLocked) {
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
