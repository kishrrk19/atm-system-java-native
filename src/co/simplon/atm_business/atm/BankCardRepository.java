package co.simplon.atm_business.atm;

import java.util.ArrayList;
import java.util.List;

public class BankCardRepository {
private List<Card> cards  = new ArrayList<>();
	
	public BankCardRepository() {
		cards.add(new Card(123456, 1234, 123, false));
		cards.add(new Card(789012, 5678, 456, true));
		cards.add(new Card(345678, 9012, 789, true));
	}
	
	public String findByCardNumberAndValidatePin(int inputCardNumber, int pin) {
		for (Card card : cards) {
			if (card.getCardNumber() == inputCardNumber) {
				 if(card.getPinCode()== pin) {
					 if(card.isLocked()) {
						 card.unlock();
					 }
					 return "PIN Correct";
				 }else {
					 return "PIN is not correct";
				 }
			}
		}
		return "Error of your card number or PIN";
	}

	public Card findByCardNumber(int cardNumber) {
		for(Card card : cards) {
			if(card.getCardNumber() == cardNumber) {
				return card;
			}
		}
		return null;
	}

}
