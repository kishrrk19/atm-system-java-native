package atm_business;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {

	private List<AccountInfo> accounts = new ArrayList<>();
	
	public BankRepository() {
		accounts.add(new AccountInfo(123456, 5000, false));
		accounts.add(new AccountInfo(789012, 1000, true));
	}
	
	public AccountInfo findByCardNumber(Card card) {
		for (AccountInfo account : accounts) {
			if (account.getAccountNumber() == card.getCardNumber()) {
				return account;
			}
		}
		return null;
	}
	
}
