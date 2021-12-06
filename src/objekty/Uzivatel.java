package objekty;

import java.io.Serializable;

/**
 * Trieda Uzivatel reprezentuje pouzivatela, so vsetkymi atributmi potrebnymi na podanie ziadosti.
 * Obsahuje aj Vozidlo, ktore dany pouzivatel chce zaregistrovat = agregacia.
 * Metody tejto triedy su len getters a setters
 * @author Daniel
 *
 */
public class Uzivatel implements Serializable {
	public static final long serialVersionUID = 0;

	private String meno;
	private String priezvisko;
	private String pohlavie;
	private String datumNarodenia;
	private String cisloOP;
	private String trvalyPobyt;
	private String obcianstvo;
	private String email;
	private String heslo;
	private int accepted;
	private Vozidlo vozidlo;
	
	/**
	 * Konstruktor triedy Uzivatel
	 * @param meno meno
	 * @param priezvisko priezvisko
	 * @param pohlavie pohlavie
	 * @param datumNarodenia datumN arodenia
	 * @param cisloOP cislo obcianskeho preukazu
	 * @param trvalyPobyt trvaly Pobyt
	 * @param obcianstvo obcianstvo
	 * @param email email
	 * @param heslo heslo
	 * @param vozidlo vozidlo, ktore chce zaregistrovat
	 */
	public Uzivatel( String meno,
					 String priezvisko,
					 String pohlavie,
					 String datumNarodenia,
					 String cisloOP,
					 String trvalyPobyt,
					 String obcianstvo,
					 String email,
					 String heslo,
					//POLYMORFIZMUS
					 Vozidlo vozidlo) {
		
		this.meno=meno;
		this.priezvisko=priezvisko;
		this.pohlavie=pohlavie;
		this.datumNarodenia=datumNarodenia;
		this.cisloOP=cisloOP;
		this.trvalyPobyt=trvalyPobyt;
		this.obcianstvo=obcianstvo;
		this.email=email;
		this.heslo=heslo;
		this.vozidlo=vozidlo;
		this.accepted=0;
	}
	
	
	public void Accept() {
		this.accepted=1;
	}
	
	public void Reject() {
		this.accepted= -1;
	}
	
	
	public int getState() {
		return this.accepted;
	}
	
	public String toString() {
		String fullName = new String(this.meno+" "+this.priezvisko);
		return fullName;
	}
	
	public String getFullName() {
		String fullName = new String(this.meno+" "+this.priezvisko);
		return fullName;
	}
	
	public String getPohlavie() {
		return this.pohlavie;
	}
	
	public String getDatum() {
		return this.datumNarodenia;
	}
	
	public String getOP() {
		return this.cisloOP;
	}
	
	public String getPobyt() {
		return this.trvalyPobyt;
	}
	
	public String getObcianstvo() {
		return this.obcianstvo;
	}
	
	public String getMail() {
		return this.email;
	}
	
	public String getHeslo() {
		return this.heslo;
	}
	
	public Vozidlo getCar() {
		return this.vozidlo;
	}
}
