package gui;

import akcie.LoginUser;
import akcie.PrihlasenyUser;
import akcie.ZlyLoginException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
/**
 * Trieda GUI. Toto okno sa zobrazi po kliknuti na tlacidlo "Login pouzivatel".
 * Pouzivatel tu zada svoj email a heslo a moze si po prihlaseni pozriet stav svojej ziadosti.
 * @author Daniel
 *
 */
public class LoginUserOkno extends Application{
	
	private TextField mail = new TextField();
	private PasswordField heslo = new PasswordField();
	private Label mailL = new Label("Email: ");
	private Label hesloL = new Label("Heslo: ");
	private Button prihlasit = new Button("Prihlasit sa");
	private Button naspat = new Button("Naspat");
	private Label hint = new Label("sample user mail: novak@gmail.com, heslo: novak");
	LoginUser login = new LoginUser();
	
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		
		pane.getChildren().add(mailL);
		pane.getChildren().add(mail);
		pane.getChildren().add(hesloL);
		pane.getChildren().add(heslo);
		pane.getChildren().add(prihlasit);
		pane.getChildren().add(naspat);
		pane.getChildren().add(hint);
		hint.setPadding(new Insets(10,900,10,10));
		
		primaryStage.setScene(new Scene(pane, 1000, 500));
		primaryStage.show();
		
		naspat.setOnAction(e->{
			HomeScreen home = new HomeScreen();
			home.start(primaryStage);
		});
		
		
		
		prihlasit.setOnAction(e->{
			try {
				login.prihlas(mail.getText(), heslo.getText());
				PrihlasenyUser user = new PrihlasenyUser(login.getUser());
				PrihlasenyUserOkno okno = new PrihlasenyUserOkno(user);
				okno.start(primaryStage);
			}
			catch(ZlyLoginException ex){
				
			}
		});

	}

}
