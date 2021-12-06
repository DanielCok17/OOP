package objekty;

import java.io.Serializable;
/**
 * Abstraktna trieda Ziadost reprezentuje ziadost, obsahuje Uzivatela a Vozidlo
 * @author Daniel
 * 
 */
public abstract class Ziadost implements Serializable {
	private static final long serialVersionUID = 0;
	protected Uzivatel user;
	protected Vozidlo vozidlo;
	
	public Uzivatel getUser() {
		return this.user;
	}	
}