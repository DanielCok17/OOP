package akcie;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Vlastna vynimka, vyhodi ju vtedy ak je zadany chybny vstup od pouzivatela
 * @author Daniel
 *
 */
public class ChybnyVstupException extends Exception {
	private static final long serialVersionUID = 0;
	
	/**
	 * Vyhodi Alert s vypisom
	 */
	public ChybnyVstupException() {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Chyba");
		a.setContentText("Zadajte spravne udaje!");
		a.showAndWait();
	}
	
}
