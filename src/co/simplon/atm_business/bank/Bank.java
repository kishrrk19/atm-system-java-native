package co.simplon.atm_business.bank;

public class Bank {
	
	private BankAccountRepository bankRepo = new BankAccountRepository();
	
	public Bank(){
	}

	public int getBalanceByAccountNumer(int accountNum) {
		return bankRepo.getBalanceByAccountNumer(accountNum);
	}
	
	public String withdraw(int accountNum, int amount) {
		return bankRepo.withdraw(accountNum, amount);
	}

	public void saveDataAndExit() {
		bankRepo.saveAccounts();
		
	}
}
