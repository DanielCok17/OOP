package gui;

import akcie.LoginAdmin;
import akcie.ZlyLoginException;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.Insets;

/**
 * Trieda GUI. Je to okno ktore sa zobrazi po kliknuti na tlacidlo "Login Spravca".
 * Spravca tu zadava svoje prihlasovacie udaje.
 * Pouzivam tu referenciu na metodu, pri kliknuti na tlacidlo "Naspat", ktore nas vrati na HomeScreen.
 * Pouzivam tu vhniezdenu triedu cez ktoru vykonavam stlacenie tlacidla "Prihlasit sa"
 * @author Daniel
 *
 */
public class LoginAdminOkno extends Application{
	private TextField id = new TextField();
	private PasswordField heslo = new PasswordField();
	private Label idL = new Label("ID spravcu: ");
	private Label hesloL = new Label("Heslo: ");
	private Button prihlasit = new Button("Prihlasit sa");
	private Button naspat = new Button("Naspat");
	private Label hint = new Label("id: admin, heslo: admin");
	
	LoginAdmin log = new LoginAdmin();
	@Override
	public void start(Stage loginOkno) {
		FlowPane pane = new FlowPane();
		
		
		pane.getChildren().add(idL);
		pane.getChildren().add(id);
		pane.getChildren().add(hesloL);
		pane.getChildren().add(heslo);
		pane.getChildren().add(prihlasit);
		pane.getChildren().add(naspat);
		pane.getChildren().add(hint);
		hint.setPadding(new Insets(10,1000,10,10));
		
		

		//cez referenciu na metodu
		EventHandler<ActionEvent> a = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				HomeScreen spat = new HomeScreen();
				spat.start(loginOkno);
			}
		};
		naspat.setOnAction(a::handle);


		/**
		 * Vhniezdena trieda, obsahuje metodu handle, ktora sa vykona po kliknuti na tlacidlo Prihlasit sa
		 * @author Andrej Valicek
		 *
		 */
		class Prihlas implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				try {
					log.prihlas(id.getText(), heslo.getText());
					SpravcaOkno s = new SpravcaOkno();	
					s.start(loginOkno);
				} catch(ZlyLoginException ex) {
					
				}
			}
		}
		prihlasit.setOnAction(new Prihlas());
		
			
		
		loginOkno.setScene(new Scene(pane, 1000, 500));
		loginOkno.show();

	}

}
