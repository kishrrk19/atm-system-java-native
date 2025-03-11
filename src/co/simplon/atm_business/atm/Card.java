package co.simplon.atm_business.atm;

public class Card {

	private int cardNumber;
	private int pinCode;
	private int accountNumber;
	private boolean isLocked;
	
	public Card(int cardNumber, int pinCode, int accountNumber, boolean isLocked) {
		this.cardNumber = cardNumber;
		this.pinCode = pinCode;
		this.accountNumber = accountNumber;
		this.isLocked= isLocked;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public boolean isLocked() {
		return this.isLocked;
	}
	
	public void unlock() {
		this.isLocked = false;
	}
}
