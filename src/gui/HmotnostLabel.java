package gui;

import akcie.*;
import javafx.scene.control.*;
/**
 * Trieda HmotnostLabel je Observer, dedi od triedy Label a implementuje rozhranie SledovatelRegistracie.
 * Pozoruje aky typ Vozidla je vybrany v ChoiceBox
 * @author Daniel
 *
 */
public class HmotnostLabel extends Label implements SledovatelRegistracie{
	private Registracia reg;

	
	public HmotnostLabel(String text,Registracia r) {
		super(text);
		this.reg=r;
	}
	
	/**
	 * Ak je zvoleny Kamion, cize n==1, tak HmotnostLabel je viditelny
	 */
	public void upovedom(int n) {
		if (n==1)
			this.setVisible(true);
		else 
			this.setVisible(false);
	}

}
