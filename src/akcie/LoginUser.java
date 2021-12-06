package akcie;

import java.io.IOException;
import java.util.List;

import objekty.Uzivatel;
/**
 * Trieda LoginUser predstavuje conroller k triede LoginUserOkno
 * @author Daniel
 *
 */
public class LoginUser {
	private Registracia z = new Registracia();
	private List<Uzivatel> ludia;
	private Uzivatel user;

	/**
	 * V konstruktori sa nacita zo serializovaneho suboru zoznam pouzivatelov
	 */
	public LoginUser() {
		try {
			z.nacitaj();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.ludia=z.dajLudi();
	}
	
	/**
	 * Tato metoda overi ci bola zadana kombinacia emailu a hesla spravna. Ak je prihlasenie uspesne, tak priradi atributu user Uzivatela, ktory sa prihlasil
	 * @param mail Mail ktory zadal pouzivatel
	 * @param heslo Heslo ktore zadal pouzivatel
	 * @throws ZlyLoginException Vlastna vynimka, je vyhodena vtedy ak bol zadany nespravny email alebo heslo.
	 */
	public void prihlas(String mail, String heslo) throws ZlyLoginException{
		boolean ok= false;
		for(Uzivatel u : ludia) {
			if(u.getMail().equals(mail) && u.getHeslo().equals(heslo)) {
				ok=true;
				this.user=u;
				break;
			}
		}
		if (ok==false)
			throw new ZlyLoginException();
	}
	
	public Uzivatel getUser() {
		return this.user;
	}
}
