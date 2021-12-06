package objekty;

import java.io.Serializable;
/**
 * Class Kamion represents a truck, it inherits from abstract class Vozidlo 
 * Trieda Kamion predstavuje kamion, dedi od abstraktnej triedy Vozidlo
 * @author Daniel
 * 
 */
public class Kamion extends Vozidlo implements Serializable{
	public static final long serialVersionUID = 0;

	private int hmotnost;
	
	/**
	 * Konstruktor triedy Kamion
	 * @param znacka znacka
	 * @param rokVyroby rok Vyroby
	 * @param vin vin
	 * @param vykon vykon
	 * @param km najazdene km
	 * @param eu ci je vozidlo z krajiny europskej unie
	 * @param spz spz
	 * @param emisie miera emisii
	 * @param hmotnost hmotnost kamionu
	 */
	public Kamion(String znacka,
			int rokVyroby,
			String vin,
			int vykon,
			int km,
			boolean eu,
			String spz,
			int emisie,
			int hmotnost) {

		super(  znacka,
				rokVyroby,
				vin,
				vykon,
				km,
				eu,
				spz,
				emisie);
		this.hmotnost=hmotnost;
	}

	public String toString() {
		return "Kamion";
	}
	
	public int getHmotnost() {
		return this.hmotnost;
	}
	
	//VISITOR
		/**
		 * VISITOR design pattern: 
		 * visit(Element).
		 * Cena za registraciu kamionu z krajiny EU je 200e, z ostatnych krajin 600e
		 */
	public void dajCenuRegistracie(Cena c) {
		if(this.getEU())
			this.setCena(200);
		else 
			this.setCena(200*3);
	}
}
