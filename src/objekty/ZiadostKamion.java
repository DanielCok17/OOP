package objekty;

import java.io.Serializable;

import akcie.ChybnyVstupException;


/**
 * Trieda ZiadostKamion reprezentuje ziadost o zaregistrovanie kamionu, dedi od abstraktnej triedy Ziadost
 * @author Daniel
 * 
 */
public class ZiadostKamion extends Ziadost implements Serializable{
	private static final long serialVersionUID = 0;

	
	/**
	 * 
	 * Tato metoda ziska data z GUI zadane pouzivatelom, vytvori instanciu tried Kamion a Uzivatel.
	 * Pouziva sa tu polymorfizmus, lebo sa posiela typ Kamion do konstruktora Uzivatel, ktory akceptuje Vozidlo
	 * @throws ChybnyVstupException : vlastna vynimka, ktora je zachytena ked pouzivatel necha nejaky udaj nevyplneny
	 */
	public void poziadaj (String meno,
							String priezvisko,
							String pohlavie,
							String datumNarodenia,
							String cisloOP,
							String trvalyPobyt,
							String obcianstvo,
							String email,
							String heslo,
							String znacka,
							int rok,
							String VIN,
							int vykon,
							int km,
							boolean eu,
							String spz,
							int emisie,
							int hmotnost) throws ChybnyVstupException {
				if (meno.equals("") ||  priezvisko.equals("") ||  pohlavie.equals("") || datumNarodenia.equals("") || cisloOP.equals("")
				|| trvalyPobyt.equals("") || heslo.equals("") ||
				obcianstvo.equals("") || email.equals("") || znacka.equals("") || VIN.equals("")
				|| spz.equals(""))
					throw new ChybnyVstupException();
				
				//POLYMORFIZMUS
				vozidlo= new Kamion(znacka,rok,VIN,vykon,km,eu,spz,emisie,hmotnost);
				user = new Uzivatel(meno,priezvisko,pohlavie,datumNarodenia,cisloOP,trvalyPobyt,obcianstvo,email,heslo,vozidlo);
	}
}
