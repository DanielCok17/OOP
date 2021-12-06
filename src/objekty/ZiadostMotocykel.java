package objekty;

import java.io.Serializable;

import akcie.ChybnyVstupException;

/**
* Trieda ZiadostMotocykel predstavuje ziadost o registraciu motocykla, dedi od abstraktnej triedy Ziadost
* @author Daniel
* 
*/
public class ZiadostMotocykel extends Ziadost implements Serializable {
	private static final long serialVersionUID = 0;

	
	/**
	 * 
	 * Tato metoda ziska data z GUI zadane pouzivatelom, vytvori instanciu tried Motocykel a Uzivatel.
	 * Pouziva sa tu polymorfizmus, lebo sa posiela typ Motocykel do konstruktora Uzivatel, ktory akceptuje Vozidlo
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
								String kategoria) throws ChybnyVstupException {
					if (meno.equals("") ||  priezvisko.equals("") ||  pohlavie.equals("") || datumNarodenia.equals("") || cisloOP.equals("")
					|| trvalyPobyt.equals("") || heslo.equals("") ||
					obcianstvo.equals("") || email.equals("") || znacka.equals("") || VIN.equals("")
					|| spz.equals("") || kategoria.equals(""))
						throw new ChybnyVstupException();
					
				//POLYMORFIZMUS
				vozidlo= new Motocykel(znacka,rok,VIN,vykon,km,eu,spz,emisie,kategoria);
				user = new Uzivatel(meno,priezvisko,pohlavie,datumNarodenia,cisloOP,trvalyPobyt,obcianstvo,email,heslo,vozidlo);
				
	}
}
