package atm_business;

public class Operation {
	
	private final BankRepository respository = new BankRepository();
	
	//private int balance;
	
	public Operation() {};
	
	public AccountInfo authenticateCard(Card card) {
		return respository.findByCardNumber(card);
	}
	
	public boolean withdraw(AccountInfo account, int amount) {
		if(account.getBalance() >= amount) {
			account.withdraw(amount);
			System.out.println("Your withdraw completed: New balance is " + account.getBalance());
			return false;
		}else {
			System.out.println("There are not enough money");
			return true;
		}
	}
	
	public void requestBalance(AccountInfo account) {
		System.out.println("Account Number:" + account.getAccountNumber() + ". Balance : " + account.getBalance() +"euro.");
	}
	
	public void unlockCard(AccountInfo account) {
		if(account.isLocked()) {
			account.unlock();
		System.out.println("Your card is safely unlocked.");
		}else {
			System.out.println("Your card is already unlocked.");
		}
		
	}
}
