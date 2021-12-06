package akcie;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Vlastna Vynimka, je vyhodena ak je zadana kombinacia loginu a hesla nespravna
 * @author Daniel
 *
 */
public class ZlyLoginException extends Exception{
	private static final long serialVersionUID = 0;

	/**
	 * Vyhodi alert s vypisom
	 */
	public ZlyLoginException() {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Chyba");
		a.setContentText("Nespravne prihlasovacie udaje");
		a.showAndWait(); 
	}
}
