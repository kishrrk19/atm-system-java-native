package co.simplon.atm_business.atm;

import co.simplon.atm_business.bank.Account;
import co.simplon.atm_business.bank.Bank;
import co.simplon.atm_business.bank.BankAccountRepository;

public class Operation {
	
	private final BankAccountRepository respository = new BankAccountRepository();
	private final BankCardRepository cardRepo = new BankCardRepository();
	private final Bank bank = new Bank();
	
	//private int balance;
	
	public Operation() {};
	
	public String checkPin(int cardNumber, int pin) {
		return cardRepo.findByCardNumberAndValidatePin(cardNumber, pin);
		
	}
	
	public int getAccountNumberByCard(int cardNumber) {
		Card currentCard = cardRepo.findByCardNumber(cardNumber);
		return currentCard.getAccountNumber();
	}
	
	public Account authenticateCard(int accountNumber) {//call bank
		return respository.findByAccountNumber(accountNumber);
	}
	
	public String requestWithdrawToBank(int accountNum, int amount) {
		 return bank.withdraw(accountNum, amount);

//		if(account.getBalance() >= amount) {
//			account.withdraw(amount);
//			System.out.println("Your withdraw completed: New balance is " + account.getBalance());
//			return false;
//		}else {
//			System.out.println("There are not enough money");
//			return true;
//		}
	}
	
	public void requestBalanceToBank(int accountNumber) {
		int balance =bank.getBalanceByAccountNumer(accountNumber);
		System.out.println("Account Number:" + accountNumber + ". Balance : " + balance +"euro.");
	}
	
//	public void unlockCard(Account account) {
//		if(account.isLocked()) {
//			account.unlock();
//		System.out.println("Your card is safely unlocked.");
//		}else {
//			System.out.println("Your card is already unlocked.");
//		}
//		
//	}

	public void requestExitToBank() {
		bank.saveDataAndExit();
		
	}
}
