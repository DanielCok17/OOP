package objekty;
//Visitor
/**
 * Trieda Cena predstavuje cenu za registraciu vozidla.
 * Je tu uplatneny vzor Visitor, tato trieda v nom predstavuje Element
 * @author Daniel
 *
 */
public class Cena {
	private Vozidlo vehicle;
	
	/**
	 * Konstruktor Cena
	 * @param v Vozidlo v sa priradi k Cena
	 */
	public Cena(Vozidlo v) {
		this.vehicle=v;
	}
	
	/**
	 * Vzor Visitor:
	 * predstavuje metodu visitor.visit()
	 * vypocita cenu pre konkretne vozidlo
	 */
	public void vypocitajCenu() {
		this.vehicle.dajCenuRegistracie(this);
	}
	
}
