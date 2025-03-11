package co.simplon.atm_business.atm;

public class Card {

	private int cardNumber;
	private int pinCode;
	private int accountNumber;
	
	public Card(int cardNumber, int pinCode, int accountNumber) {
		this.cardNumber = cardNumber;
		this.pinCode = pinCode;
		this.accountNumber = accountNumber;
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
}
