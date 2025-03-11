package co.simplon.atm_business;

import co.simplon.atm_business.atm.AtmService;

public class Main {

	public static void main(String[] args) {
		System.out.println("ATM app started");
		AtmService atmService = new AtmService();
		atmService.start();
	}

}
