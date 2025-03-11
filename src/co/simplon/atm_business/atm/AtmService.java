package co.simplon.atm_business.atm;

import java.util.Scanner;

import co.simplon.atm_business.bank.Account;

public class AtmService {
	
	private final Scanner scanner = new Scanner(System.in);
	private final Operation operation = new Operation();
	private Account currentAccount;
	private boolean doWithdraw = true;
	private int currentCardNumber;
	private Card currentCard;
	private int accountNumber;
	private String withdrawMessage;
	
	public void start() {
		validatePin();
		getAccountNumber();
		while (true) {
			showMenu();
			int choice = getUserChoice();
			handleChoice(choice);
		}
	}
	
	private void validatePin() {
		System.out.println("Please enter your card number");
		this.currentCardNumber = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Please enter PIN code");
		int pinCode = scanner.nextInt();
		scanner.nextLine();
		
		String validPinResponse = operation.checkPin(this.currentCardNumber, pinCode);
		
		if(validPinResponse == "PIN Correct") {
			System.out.println(validPinResponse);
			
		}else {
			System.out.println(validPinResponse);
			validatePin();
		}
	}
	
	private void getAccountNumber() {
		accountNumber = operation.getAccountNumberByCard(this.currentCardNumber);
		//currentAccount = operation.authenticateCard(this.accountNumber);
	}
	
	private void showMenu() {
		System.out.println("Enter the number of operation which you would like to do :");
		System.out.println("1 : Display Balance");
		System.out.println("2 : Withdraw");
		System.out.println("3 : Unlock your card for your first time");
		System.out.println("4 : Finish service and remove your card");
	}

	private int getUserChoice() {
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}
	
	private void handleChoice(int choice) {
		switch (choice) {
		case 1 -> operation.requestBalanceToBank(this.accountNumber);
		 case 2 -> requestAmount();
		case 3 -> operation.unlockCard(currentAccount);
		case 4 -> exitAtm();
		default -> System.out.println("Your choice is not valid.");
		}
	}
	
	private void requestAmount() {
		while (this.doWithdraw) {
			System.out.println("Please enter amount");
			int amount = scanner.nextInt();
			scanner.nextLine();
			this.withdrawMessage = operation.requestWithdrawToBank(this.accountNumber, amount);
			if (this.withdrawMessage == "Not enough balance") {
				System.out.println(this.withdrawMessage);
				this.doWithdraw = true;
			} else {
				System.out.println(this.withdrawMessage);
				this.doWithdraw = false;
			}
		}
		this.doWithdraw= true;
	}
		
	
	private void exitAtm() {
		operation.requestExitToBank();
		System.out.println("Good bye");
		System.exit(0);
	}

}
