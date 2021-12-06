package gui;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
/**
 * Trieda GUI. Predstavuje okno ktore sa zobrazi pri spusteni aplikacie. Obsahuje 3 tlacidla.
 * @author Daniel
 *
 */
public class HomeScreen extends Application{
	
	private Button pouzivatel = new Button("Podat ziadost");
	private Button spravca = new Button("Login Spravca");
	private Button loginUser = new Button("Login pouzivatel");


	@Override
	public void start(Stage hlavneOkno){
		
		hlavneOkno.setTitle("Hranièná kontrola!");
		
		FlowPane pane = new FlowPane();
		
		pane.getChildren().add(pouzivatel);
		pane.getChildren().add(loginUser);
		pane.getChildren().add(spravca);
		
		pouzivatel.setOnAction(e -> {
			RegistraciaOkno registracia = new RegistraciaOkno();
			registracia.start(hlavneOkno);;
		});
		
		spravca.setOnAction(e->{
			LoginAdminOkno login = new LoginAdminOkno();
			login.start(hlavneOkno);
		});
		
		loginUser.setOnAction(e->{
			LoginUserOkno logU = new LoginUserOkno();
			logU.start(hlavneOkno);
		});
		
		hlavneOkno.setScene(new Scene(pane, 1000, 500));
		hlavneOkno.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
