package atm_business;

import java.util.Scanner;
import atm_business.Operation;

public class AtmService {
	
	private final Scanner scanner = new Scanner(System.in);
	private final Operation operation = new Operation();
	private AccountInfo currentAccount;
	private  boolean doWithdraw = true;
	
	public void start() {
		authenticateCard();
		while (true) {
			showMenu();
			int choice = getUserChoice();
			handleChoice(choice);
		}
	}
	
	private void authenticateCard() {
		System.out.println("Please enter you card number");
		int cardNumber = scanner.nextInt();
		scanner.nextLine();
		
		Card card = new Card(cardNumber);
		
		currentAccount = operation.authenticateCard(card);
		if(currentAccount == null) {
			System.out.println("Unvalid card number");
			authenticateCard();
		}else {
			System.out.println("You are authenticated.");
		}
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
		case 1 -> operation.requestBalance(currentAccount);
		 case 2 -> requestAmount();
		case 3 -> operation.unlockCard(currentAccount);
		case 4 -> exitAtm();
		default -> System.out.println("Your choice is not valid.");
		}
	}
	
	private void requestAmount() {
		while(this.doWithdraw) {
			System.out.println("Please enter amount");
		int amount = scanner.nextInt();
		scanner.nextLine();
		this.doWithdraw= operation.withdraw(currentAccount, amount);
		}
		this.doWithdraw = true;
		
		}
		
	
	private void exitAtm() {
		System.out.println("Good bye");
		System.exit(0);
	}

}
