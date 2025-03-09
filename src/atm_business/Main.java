package atm_business;

public class Main {

	public static void main(String[] args) {
		System.out.println("ATM app started");
		AtmService atmService = new AtmService();
		atmService.start();
	}

}
