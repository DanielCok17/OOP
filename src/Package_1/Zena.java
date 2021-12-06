package Package_1;

public class Zena extends Turista{

	public Zena(int konto) {
		super(konto);
		// TODO Auto-generated constructor stub
	}
	public void kontrola_konta(int konto) {
		konto -=10;
		System.out.println("Tvoje konto je :" + konto + " €");
	}
	
}
