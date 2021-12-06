package objekty;

import java.io.Serializable;

/**
 * Trieda Motocykel reprezentuje motocykel, dedi od abstraktnej triedy Vozidlo
 * @author Daniel
 * 
 */
public class Motocykel extends Vozidlo implements Serializable{
	public static final long serialVersionUID = 0;

	private String kategoriaMoto;
	
	/**
	 * Konstruktor triedy Motocykel
	 * @param znacka znacka
	 * @param rokVyroby rok Vyroby
	 * @param vin vin
	 * @param vykon vykon
	 * @param km najazdene km
	 * @param eu ci je vozidlo z krajiny europskej unie
	 * @param spz spz
	 * @param emisie miera emisii
	 * @param kategoria kategoria motocykla
	 */
	public Motocykel(String znacka,
					int rokVyroby,
					String vin,
					int vykon,
					int km,
					boolean eu,
					String spz,
					int emisie,
					String kategoria) {
		
		super(  znacka,
				rokVyroby,
				vin,
				vykon,
				km,
				eu,
				spz,
				emisie);
		this.kategoriaMoto=kategoria;
	}

	public String toString() {
		return "Motocykel";
	}

	public String getKategoriaMoto() {
		return this.kategoriaMoto;
	}
	
	//VISITOR
	/**
	 * VISITOR design pattern:
	 * visit(Element).
	 * Cena za registraciu motocykla z EU je 50e, z inek krajiny 150e
	 */
	public void dajCenuRegistracie(Cena c) {
		if(this.getEU())
			this.setCena(50);
		else 
			this.setCena(50*3);
	}

}
