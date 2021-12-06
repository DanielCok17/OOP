package gui;

import akcie.SledovatelRegistracie;
import akcie.Registracia;
import javafx.scene.control.Label;
/**
 * Trieda KategoriaLabel je Observer, dedi od triedy Label a implementuje rozhranie SledovatelRegistracie.
 * Pozoruje aky typ Vozidla je vybrany v ChoiceBox 
 * @author Daniel
 *
 */
public class KategoriaLabel extends Label implements SledovatelRegistracie{
	private Registracia reg;

	public KategoriaLabel(String text,Registracia r) {
		super(text);
		this.reg=r;
	}
	/**
	 * Ak je zvoleny Motocykel, cize n==2, tak KategoriaLabel je viditelny
	 */
	public void upovedom(int n) {
		if(n==2)
			this.setVisible(true);
		else
			this.setVisible(false);
	}

}
