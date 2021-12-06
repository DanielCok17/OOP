package akcie;
/**
 * Trieda LoginAdmin predstavuje controller k triede LoginAdminOkno
 * @author Daniel
 *
 */
public class LoginAdmin {
	/**
	 * Metoda kontroluje ci je zadane spravne heslo a login
	 * @throws ZlyLoginException : Vlastna vynimka, je vyhodena ak je zadany nespravny login alebo heslo
	 */
	public void prihlas(String id,String heslo) throws ZlyLoginException{		
		if(!id.equals("admin") || !heslo.equals("admin")) 
			throw new ZlyLoginException() ;
	}
}
