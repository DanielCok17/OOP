package objekty;

import java.io.Serializable;
/**
 * Trieda Auto reprezentuje osobny automobil, dedi od abstraktnej triedy Vozidlo
 * @author Daniel
 * 
 */
public class Auto extends Vozidlo implements Serializable{
	public static final long serialVersionUID = 0;
	
	/**
	 * Konstruktor triedy Auto
	 * @param znacka znacka
	 * @param rokVyroby rok Vyroby
	 * @param vin vin
	 * @param vykon vykon
	 * @param km najazdene km
	 * @param eu ci je vozidlo z krajiny europskej unie
	 * @param spz spz
	 * @param emisie miera emisii
	 */
	public Auto(String znacka,
					int rokVyroby,
					String vin,
					int vykon,
					int km,
					boolean eu,
					String spz,
					int emisie) {
		super(  znacka,
				rokVyroby,
				vin,
				vykon,
				km,
				eu,
				spz,
				emisie);
	}

	public String toString() {
		return "Osobny automobil";
	}

	//VISITOR
	/**
	 * Vzor VISITOR:
	 * predstavuje: visit(Element).
	 * Cena za registraciu auta z krajiny EU je 100e, pre ine krajiny 300e
	 */
	public void dajCenuRegistracie(Cena c) {
		if(this.getEU())
			this.setCena(100);
		else 
			this.setCena(100*3);
	}
}
