package co.simplon.atm_business.atm;

import java.util.Scanner;

public class AtmService {
	
	private final Scanner scanner = new Scanner(System.in);
	private final Operation operation = new Operation();
	//private Account currentAccount;
	private boolean doWithdraw = true;
	private int currentCardNumber;
	//private Card currentCard;
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
		this.outputMessage("Please enter your card number");
		this.currentCardNumber = scanner.nextInt();
		scanner.nextLine();
		
		this.outputMessage("Please enter PIN code");
		int pinCode = scanner.nextInt();
		scanner.nextLine();
		
		String validPinResponse = operation.checkPin(this.currentCardNumber, pinCode);
		
		if(validPinResponse == "PIN Correct") {
			this.outputMessage(validPinResponse);
		}else {
			this.outputMessage(validPinResponse);
			validatePin();
		}
	}
	
	private void getAccountNumber() {
		accountNumber = operation.getAccountNumberByCard(this.currentCardNumber);
		//currentAccount = operation.authenticateCard(this.accountNumber);
	}
	
	private void showMenu() {
		this.outputMessage("Enter the number of operation which you would like to do :");
		this.outputMessage("1 : Display Balance");
		this.outputMessage("2 : Withdraw");
		this.outputMessage("3 : Finish service and remove your card");
	}

	private int getUserChoice() {
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}
	
	private void handleChoice(int choice) {
		switch (choice) {
		case 1 -> requestBalance(this.accountNumber);
		case 2 -> requestAmount();
		case 3 -> exitAtm();
		default -> this.outputMessage("Your choice is not valid."); 
		}
	}
	
	private void requestBalance(int accountNumber) {
		String message = this.operation.requestBalanceToBank(accountNumber);
		this.outputMessage(message);
	}
	
	private void requestAmount() {
		while (this.doWithdraw) {
			this.outputMessage("Please enter amount");
			int amount = scanner.nextInt();
			scanner.nextLine();
			this.withdrawMessage = operation.requestWithdrawToBank(this.accountNumber, amount);
			if (this.withdrawMessage == "Not enough balance") {
				this.outputMessage(this.withdrawMessage);
				this.doWithdraw = true;
			} else {
				this.outputMessage(this.withdrawMessage);
				this.doWithdraw = false;
			}
		}
		this.doWithdraw= true;
	}
		
	private void outputMessage(String message) {
		System.out.println(message);
	}
	
	private void exitAtm() {
		operation.requestExitToBank();
		this.outputMessage("Good bye");
		System.exit(0);
	}

}
