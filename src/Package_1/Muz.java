package Package_1;

public class Muz extends Turista {

	public Muz(int konto) {
		super(konto);
		// TODO Auto-generated constructor stub
	}
	
	public void kontrola_konta(int konto) {
		konto -=20;
		System.out.println("Tvoje konto je :" + konto + " €");
	}

}
