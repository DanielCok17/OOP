package Package_1;

import java.util.ArrayList;

public class Neprecleny_tovar extends Tovar {

	public Neprecleny_tovar(String nazov_tovaru, boolean preclene,int clo) {
		super(nazov_tovaru, preclene,clo);
		
		
	}
	public void plateni_cla(int clo) {
		clo += 100;
		System.out.println("Clo nezaplatene,treba zaplatit " + clo + " €");
	}
	
	
	
	
	
}
