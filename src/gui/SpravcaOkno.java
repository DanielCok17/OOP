package gui;

import java.io.IOException;

import akcie.PosudenieZiadosti;
import akcie.Registracia;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objekty.Uzivatel;
/**
 * Trieda GUI. Toto okno sa zobrazi po prihlaseni sa Admina. Moze v nom vidiet doteraz podane ziadosti v ListView,
 *  tie co uz potvrdil su zobrazene zelenou, a tie co zamietol cervenou farbou. Neposudene ziadosti su biele.
 *  Moze vybrat konkretneho pouzivatela a pozriet si jeho ziadost.
 * @author Daniel
 *
 */
public class SpravcaOkno extends Application {
	private Label zoznamZiadostiL = new Label("Podane ziadosti: ");
	private ScrollPane skrol = new ScrollPane();
	private Button naspat = new Button("Naspat");
	private Button vyber = new Button("Vyber");

	@Override
	public void start(Stage spravcaScreen) {
		
		Pane pane= new FlowPane();
		Registracia z1 = new Registracia();
		
		try {
			z1.nacitaj();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ObservableList<Uzivatel> ludia = FXCollections.observableArrayList(z1.dajLudi());
		ListView<Uzivatel> zobrazLudi = new ListView<Uzivatel>(ludia);
		zobrazLudi.getSelectionModel().selectFirst();
		
		
		zobrazLudi.setCellFactory(param -> new ListCell<Uzivatel>() {
		    @Override
		    protected void updateItem(Uzivatel u, boolean empty) {
		        super.updateItem(u, empty);

		        if (empty || u == null) {
		            setText(null);
		            setStyle(null);
		        } else {
		            setText(u.toString());
		            if(u.getState() == 1)
		            	setStyle("-fx-background-color: green;");
		            else if(u.getState() == -1)
		            	setStyle("-fx-background-color: red;");
		        }
		    }
		});
		
		((FlowPane) pane).setHgap(1000);
        ((FlowPane) pane).setVgap(5);
        pane.setPadding(new Insets(15,15,15,15));
		
		pane.getChildren().add(zoznamZiadostiL);
		pane.getChildren().add(zobrazLudi);
		pane.getChildren().add(vyber);
		pane.getChildren().add(naspat);
		
		skrol.setContent(pane);
		
		naspat.setOnAction(e->{
			HomeScreen home = new HomeScreen();
			home.start(spravcaScreen);
		});
		
		vyber.setOnAction(e->{
			PosudenieZiadostiOkno posOkno = new PosudenieZiadostiOkno();
			PosudenieZiadosti pos = new PosudenieZiadosti(zobrazLudi.getSelectionModel().getSelectedItem(),
														zobrazLudi.getSelectionModel().getSelectedIndex());
			posOkno.getPos(pos);
			posOkno.start(spravcaScreen);
			
		});
		
		spravcaScreen.setScene(new Scene(skrol, 1000, 500));
		spravcaScreen.show();
	}

}
