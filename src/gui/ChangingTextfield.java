package gui;

import akcie.SledovatelRegistracie;
import akcie.Registracia;
import javafx.scene.control.TextField;

/**
 * Trieda ChangingTextField je Observer, dedi od triedy TextField a implementuje rozhranie SledovatelRegistracie.
 * Pozoruje aky typ Vozidla je vybrany v ChoiceBox
 * @author Daniel
 *
 */
public class ChangingTextfield extends TextField implements SledovatelRegistracie{
	private Registracia reg;
	
	public ChangingTextfield(Registracia r) {
		super();
		this.reg=r;
	}

	/**
	 * Ak je vybrany Kamion alebo Motocykel, cize n==1 || n==2, tak zobrazi tento Textfield 
	 * ktory sluzi u motocykla na kategoriu, a u kamionu na hmotnost
	 */
	public void upovedom(int n) {
		if (n==1 || n==2)
			this.setVisible(true);
		else 
			this.setVisible(false);
	}

}
