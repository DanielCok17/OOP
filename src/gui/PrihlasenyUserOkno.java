package gui;



import akcie.PrihlasenyUser;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import objekty.Auto;
import objekty.Kamion;
import objekty.Motocykel;
/**
 * Trieda GUI. Toto okno sa zobrazi po uspesnom prihlaseni sa pouzivatela.
 * Pouzivatel moze vidiet svoju ziadost ktoru podal a jej stav.
 * Ak bola potvrdena, zobrazi sa aj cena ktoru ma zaplatit.
 * @author Daniel
 *
 */
public class PrihlasenyUserOkno extends Application{
	
	
	private Label stav = new Label();
	private Button naspat = new Button("Naspat");
	private PrihlasenyUser pu;
	private Label info = new Label("Vasa ziadost:");
	private ScrollPane skrol = new ScrollPane();
	
	public PrihlasenyUserOkno(PrihlasenyUser pu) {
		this.pu=pu;
	}

	
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		
		((FlowPane) pane).setHgap(1000);
        ((FlowPane) pane).setVgap(5);
                
        pane.setPadding(new Insets(15,15,15,15));
        
        ObservableList<String> clovek = FXCollections.observableArrayList("Meno a Priezvisko: "+pu.getUser().toString(),"Datum narodenia: "+pu.getUser().getDatum(),
				"Pohlavie: "+pu.getUser().getPohlavie(),"Cislo obcianskeho: "+pu.getUser().getOP(),"Trvaly pobyt: "+pu.getUser().getPobyt(),
				"Obcianstvo: "+ pu.getUser().getObcianstvo(),"eMail: "+pu.getUser().getMail());
		ListView<String> zobrazCloveka = new ListView<String>(clovek);
		
		String str=new String();
		//RTTI
		if(pu.getUser().getCar() instanceof Motocykel)
			str=new String("Kategoria motocykla: "+((Motocykel)pu.getUser().getCar()).getKategoriaMoto());		
		if(pu.getUser().getCar() instanceof Kamion)
			str=new String("Hmotnost (ton): "+((Kamion)pu.getUser().getCar()).getHmotnost());
		if(pu.getUser().getCar() instanceof Auto)
			str=new String("");
		
		ObservableList<Object> auto = FXCollections.observableArrayList("Kategoria vozidla: "+pu.getUser().getCar().toString(),"Znacka vozidla: "+pu.getUser().getCar().getZnacka(),"Rok vyroby: "+pu.getUser().getCar().getRok(),
				"VIN: "+pu.getUser().getCar().getVIN(),"Najazdene KM: "+pu.getUser().getCar().getKM(),"Vykon (kW): "+pu.getUser().getCar().getVykon(),
				"Miera emisii: "+pu.getUser().getCar().getEmisie(),"Krajina povodu z EU: "+pu.getUser().getCar().getEU(),"SPZ: "+pu.getUser().getCar().getSPZ(),
				str);
		ListView<Object> zobrazAuto = new ListView<Object>(auto);
		
		skrol.setContent(pane);
		zobrazCloveka.setMaxHeight(200);
		zobrazAuto.setMaxHeight(250);
		
		pane.getChildren().add(stav);
		pane.getChildren().add(info);
		pane.getChildren().add(zobrazCloveka);
		pane.getChildren().add(zobrazAuto);
		pane.getChildren().add(naspat);
		
		stav.setFont(new Font(30));
		
		if(pu.isAccepted()==1)
			stav.setText("Vasa ziadost o registraciu vozidla bola akceptovana!\nCena registracie:"+pu.getUser().getCar().getCena()+"€");
		else if(pu.isAccepted()==-1)
			stav.setText("Vasa ziadost o registraciu vozidla bola zamietnuta!");
		else 
			stav.setText("Vasa ziadost o registraciu vozidla este nebola posudena!");

		primaryStage.setScene(new Scene(skrol, 1000, 500));
		primaryStage.show();
		
		naspat.setOnAction(e->{
			HomeScreen home = new HomeScreen();
			home.start(primaryStage);
		});
		
		

	}

}
