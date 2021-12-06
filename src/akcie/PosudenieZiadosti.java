package akcie;

import objekty.Uzivatel;
/**
 * Trieda posudenie ziadosti je controller k triede PosudenieZiadostiOkno.
 * Admin posudzuje konkretnu ziadost pouzivatela ktory je v atribute posudzovanyUser.
 * @author Daniel
 *
 */
public class PosudenieZiadosti {
	public Uzivatel posudzovanyUser;
	public int index;

	public PosudenieZiadosti(Uzivatel u, int index) {
		this.posudzovanyUser=u;
		this.index=index;
	}
	
}
