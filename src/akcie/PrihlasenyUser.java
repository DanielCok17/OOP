package akcie;

import objekty.Uzivatel;
/**
 * Trieda PrihlasenyUser je controller k triede PrihlasenyUserOkno.
 * Predstavuje okno pouzivatela v atribute user po prihlaseni.
 * @author Daniel
 *
 */
public class PrihlasenyUser {
	private Uzivatel user;
	
	public PrihlasenyUser(Uzivatel user) {
		this.user=user;
	}
	
	public Uzivatel getUser() {
		return this.user;
	}
	
	public int isAccepted() {
		return this.user.getState();
	}
}
