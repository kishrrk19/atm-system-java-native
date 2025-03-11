package co.simplon.atm_business.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.atm_business.atm.Card;

public class BankAccountRepository {

	private final String FILE_PATH = "src/bank_data.csv";
	private List<Account> accounts = new ArrayList<>();
	
	public BankAccountRepository() {
		try(BufferedReader reader = new BufferedReader(new FileReader(this.FILE_PATH))){
			String line;
			while((line = reader.readLine()) !=null) {
				String[] data = line.split(",");
				accounts.add(new Account(Integer.parseInt(data[0]), Integer.parseInt(data[1]), "LOCKED".equals(data[2])));
			}
		}catch (IOException e) {
			System.out.println("Error to get bank data" + e.getMessage());
		}
//		accounts.add(new Account(123, 5000, false));
//		accounts.add(new Account(456, 1000, true));
//		accounts.add(new Account(789, 1000, true));
	}
	
	public Account findByAccountNumber(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}
	
	public int getBalanceByAccountNumer(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account.getBalance();
			}
		}
		return 0;// exception for 0 à écrire
	}
	
	public String withdraw(int accountNum, int amount) {
		for(Account account : accounts) {
			if(account.getAccountNumber()== accountNum) {
				if(account.getBalance() >= amount) {
					int newBalance = account.getBalance()- amount;
					account.setBalance(newBalance);
					return "Your withdraw completed: New balance is " + newBalance;
				}else {
					return "Not enough balance";
				}
			}
		}
		return "Error: Account not found";
	}

	public void saveAccounts() {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.FILE_PATH))){
			for(Account account : accounts) {
					writer.write(account.getAccountNumber() + "," + account.getBalance() + "," + (account.isLocked? "LOCKED" : "INLOCKED"));
					writer.newLine();
				}
		} catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		}
		
	}
	
}
