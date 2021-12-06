package objekty;

import java.io.Serializable;

/**
 * Abstraktna trieda Vozidlo reprezentuje vozidlo so vsetkymi potrebnymi atributmi.
 * Metody su len getters a setters.
 * Obsahuje tiez 2 abstraktne metody ktore ktore treba implementovat
 * Je tu vzor Visitor, tato trieda predstavuje triedu Visitor
 * @author Daniel
 * 
 */
public abstract class Vozidlo implements Serializable {
	public static final long serialVersionUID = 0;
	
	private String znacka;
	private int rokVyroby;
	private String VIN;
	private int vykon;
	private int km;
	private boolean eu;
	private String spz;
	private int emisie;
	private int cenaRegistracie;
	/**
	 * Konstruktor triedy Vozidlo
	 * @param znacka znacka
	 * @param rokVyroby rok Vyroby
	 * @param vin vin
	 * @param vykon vykon
	 * @param km najazdene km
	 * @param eu ci je vozidlo z krajiny europskej unie
	 * @param spz spz
	 * @param emisie miera emisii
	 */
	public Vozidlo(String znacka, int rokVyroby, String vin, int vykon, int km, boolean eu, String spz, int emisie) {
		this.znacka=znacka;
		this.rokVyroby=rokVyroby;
		this.VIN=vin;
		this.vykon=vykon;
		this.km=km;
		this.eu=eu;
		this.spz=spz;
		this.emisie=emisie;
	}
	

	public abstract String toString();
	
	public String getZnacka() {
		return this.znacka;
	}
	
	public int getRok() {
		return this.rokVyroby;
	}
	
	public String getVIN() {
		return this.VIN;
	}
	
	public int getVykon() {
		return this.vykon;
	}
	
	public int getKM() {
		return this.km;
	}
	
	public boolean getEU() {
		return this.eu;
	}
	
	public String getSPZ() {
		return this.spz;
	}
	
	public int getEmisie() {
		return this.emisie;
	}
	
	public void setCena(int cena) {
		this.cenaRegistracie=cena;
	}
	
	public int getCena() {
		return this.cenaRegistracie;
	}
	/**
	 * VZOR VISITOR 
	 * visit(Element)
	 */
	public abstract void dajCenuRegistracie(Cena c);

}
