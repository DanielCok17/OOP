package akcie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import objekty.Uzivatel;
import objekty.Ziadost;

/**
 * Trieda Registracia predstavuje controller k triede RegistraciaOkno.
 * Obsahuje zoznam Uzivatelov, ktori si podali Ziadost
 * Obsahuje vzor Observer - predstavuje Subject.
 * Je tu vyuzity polymorfizmus, metoda setZiadost prijima nadtyp Ziadost, ale posielaju sa tam rozne typy ziadosti
 * @author Daniel
 *
 */
public class Registracia implements Serializable{
	public static final long serialVersionUID = 0;
	private Ziadost z;
	private List<Uzivatel> ludia=new ArrayList<Uzivatel>();
	
	//POLYMORFIZMUS
	/**
	 * K registracii sa priradi konkretna Ziadost z, do zoznamu ludi sa prida Uzivatel zo Ziadosti
	 * @param z Ziadost ktoru priradim k registracii
	 */
	public void setZiadost(Ziadost z) {
		this.z=z;
		ludia.add(z.getUser());
	}
	
	//OBSERVER
	/**
	 * Zoznam sledovatelov
	 */
	transient private List<SledovatelRegistracie> sledovatelia = new ArrayList<SledovatelRegistracie>();

	/**
	 * Metoda vzoru Observer, prida sledovatel do zoznamu sledovatelov
	 * @param sledovatel
	 */
	public void pridajSledovatela(SledovatelRegistracie sledovatel) {
		sledovatelia.add(sledovatel);
	}

	/**
	 * Metoda vzoru Observer, upovedomi vsetkych sledovatelov v zozname
	 * @param n
	 */
	public void upovedomSledovatelov(int n) {
		for (SledovatelRegistracie s : sledovatelia)
			s.upovedom(n);
	}
	
	/**
	 * Pri zmene hodnoty kategorie vozidla sa upovedomia sledovatelia
	 * @param n Cislo vybranej kategorie vozidla
	 */
	public void zmenaKategorie(int n) {
		upovedomSledovatelov(n);
	}
	/**
	 * Ulozenie do suboru data.out cez serializaciu
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void uloz() throws ClassNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.out"));
		out.writeObject(this);
		out.close();
	}
	
	/**
	 * Nacitanie serializovanych dat
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void nacitaj() throws ClassNotFoundException, IOException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.out"));
		Registracia nacitanaZiadost = (Registracia) in.readObject();
		in.close();
		ludia = nacitanaZiadost.ludia;
	}
	
	/**
	 * 
	 * @return Vracia zoznam Uzivatelov
	 */
	public List<Uzivatel> dajLudi() {
		return ludia;
	}
}
