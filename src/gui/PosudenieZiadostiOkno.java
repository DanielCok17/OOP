package gui;

import java.io.IOException;
import java.util.List;

import akcie.PosudenieZiadosti;
import akcie.Registracia;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objekty.Auto;
import objekty.Cena;
import objekty.Kamion;
import objekty.Motocykel;
import objekty.Uzivatel;
/**
 * Trieda GUI. Toto je okno spravcu. Zobrazi sa po vybrani konretnej ziadosti. Admin v nom moze vidiet vsetky zadane udaje
 * o cloveku aj o vozidle, zobrazene v dvoch ListView. Moze ziadost odmietnut alebo potvrdit. Ak uz bola odmietnuta alebo potvrdena, uz nema moznost menit
 * stav tejto ziadosti. Po akceptovani/zamietnuti sa zmena ulozi a serializuje.
 * Vyuzivam tu RTTI, ak chcem vypisat typ Vozidla, tak zistim to cez instanceof.
 * Pri akceptovani ziadosti volam metodu vzoru Visitor, na vypocet ceny ziadosti.
 * 
 * @author Daniel
 *
 */
public class PosudenieZiadostiOkno extends Application{
	private Label udajePersonL = new Label("Udaje o ziadatelovi: ");
	private Label udajeCarL = new Label("Udaje o vozidle: ");
	private Label stav = new Label();
	private ScrollPane skrol = new ScrollPane();
	private Separator separator1 = new Separator();
	private Button akceptuj = new Button("Schval ziadost");
	private Button zamietni = new Button("Zamietni ziadost");
	private Button naspat = new Button("Naspat");
		
	private PosudenieZiadosti pos;
	public void getPos(PosudenieZiadosti posZ) {
		this.pos=posZ;
	}

	
	
	@Override
	public void start(Stage posudenieOkno) {
		Pane pane = new FlowPane();
		((FlowPane) pane).setHgap(1000);
        ((FlowPane) pane).setVgap(5);
                
        pane.setPadding(new Insets(15,15,15,15));
        
		ObservableList<String> clovek = FXCollections.observableArrayList("Meno a Priezvisko: "+pos.posudzovanyUser.getFullName(),"Datum narodenia: "+pos.posudzovanyUser.getDatum(),
				"Pohlavie: "+pos.posudzovanyUser.getPohlavie(),"Cislo obcianskeho: "+pos.posudzovanyUser.getOP(),"Trvaly pobyt: "+pos.posudzovanyUser.getPobyt(),
				"Obcianstvo: "+ pos.posudzovanyUser.getObcianstvo(),"eMail: "+pos.posudzovanyUser.getMail());
		ListView<String> zobrazCloveka = new ListView<String>(clovek);
		
		String str=new String();
		//RTTI
		if(pos.posudzovanyUser.getCar() instanceof Motocykel)
			str=new String("Kategoria motocykla: "+((Motocykel)pos.posudzovanyUser.getCar()).getKategoriaMoto());		
		if(pos.posudzovanyUser.getCar() instanceof Kamion)
			str=new String("Hmotnost (ton): "+((Kamion)pos.posudzovanyUser.getCar()).getHmotnost());
		if(pos.posudzovanyUser.getCar() instanceof Auto)
			str=new String("");
		
		ObservableList<Object> auto = FXCollections.observableArrayList("Kategoria vozidla: "+pos.posudzovanyUser.getCar().toString(),"Znacka vozidla: "+pos.posudzovanyUser.getCar().getZnacka(),"Rok vyroby: "+pos.posudzovanyUser.getCar().getRok(),
				"VIN: "+pos.posudzovanyUser.getCar().getVIN(),"Najazdene KM: "+pos.posudzovanyUser.getCar().getKM(),"Vykon (kW): "+pos.posudzovanyUser.getCar().getVykon(),
				"Miera emisii: "+pos.posudzovanyUser.getCar().getEmisie(),"Krajina povodu z EU: "+pos.posudzovanyUser.getCar().getEU(),"SPZ: "+pos.posudzovanyUser.getCar().getSPZ(),
				str);
		ListView<Object> zobrazAuto = new ListView<Object>(auto);

		Registracia reg = new Registracia();
		
		try {
			reg.nacitaj();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Uzivatel> ludia = reg.dajLudi();
		
					
		pane.getChildren().add(udajePersonL);
		separator1.setPrefWidth(200);
		pane.getChildren().add(zobrazCloveka);
		pane.getChildren().add(separator1);
		pane.getChildren().add(udajeCarL);
		pane.getChildren().add(zobrazAuto);
		pane.getChildren().add(akceptuj);
		pane.getChildren().add(zamietni);
		pane.getChildren().add(stav);
		pane.getChildren().add(naspat);
		
		if(pos.posudzovanyUser.getState()==1 || pos.posudzovanyUser.getState()==-1) {
			akceptuj.setVisible(false);
			zamietni.setVisible(false);
			if(pos.posudzovanyUser.getState()==1)
				stav.setText("Tato ziadost uz bola potvrdena.");
			else
				stav.setText("Tato ziadost uz bola zamietnuta.");
		}
		
		skrol.setContent(pane);
		zobrazCloveka.setMaxHeight(200);
		zobrazAuto.setMaxHeight(250);
		
		akceptuj.setOnAction(e->{
			pos.posudzovanyUser.Accept();
			//VISITOR
			Cena c = new Cena(pos.posudzovanyUser.getCar());
			c.vypocitajCenu();
			//
			ludia.set(pos.index, pos.posudzovanyUser);
			try {
				reg.uloz();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Schvalene");
			a.setContentText("Ziadost o registraciu vozidla dovezeneho zo zahranicia bola schvalena.");
			a.showAndWait(); 
			
			SpravcaOkno spr = new SpravcaOkno();
			spr.start(posudenieOkno);
			});
		
		zamietni.setOnAction(e->{
			pos.posudzovanyUser.Reject();
			ludia.set(pos.index, pos.posudzovanyUser);
			try {
				reg.uloz();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Zamietnute");
			a.setContentText("Ziadost o registraciu vozidla dovezeneho zo zahranicia bola zamietnuta.");
			a.showAndWait(); 
			
			SpravcaOkno spr = new SpravcaOkno();
			spr.start(posudenieOkno);
			});
		
		naspat.setOnAction(e->{
			SpravcaOkno okno= new SpravcaOkno();
			okno.start(posudenieOkno);
		});
		
		posudenieOkno.setScene(new Scene(skrol, 1000, 500));
		posudenieOkno.show();
		
		
	}
	
}