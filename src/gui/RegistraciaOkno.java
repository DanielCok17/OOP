package gui;

import java.io.IOException;

import akcie.ChybnyVstupException;
import akcie.Registracia;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;
import objekty.Ziadost;
import objekty.ZiadostAuto;
import objekty.ZiadostKamion;
import objekty.ZiadostMotocykel;
import javafx.geometry.Insets;
/**
 * Toto je GUI.
 * Okno po kliknuti na tlacidlo "Podat ziadost".
 * V tomto okne pouzivatel zada svoje osobne udaje, a udaje o vozidle ktore chce zaregistrovat.
 * Po kliknuti je vytvorena nova ziadost.
 * Obsahuje troch observerovn = jeden TextField a 2 Labely
 * @author Daniel
 *
 */
public class RegistraciaOkno extends Application{
	private TextField meno = new TextField();
	private TextField priezvisko = new TextField();
	private TextField pohlavie = new TextField();
	private TextField datumNarodenia = new TextField();
	private TextField cisloOP = new TextField();
	private TextField obcianstvo = new TextField();
	private TextField trvalyPobyt = new TextField();
	private PasswordField heslo = new PasswordField();
	private TextField email = new TextField();
	private Label infoL=new Label("Zadajte vase osobne udaje:");
	private Label menoL = new Label("Meno: ");
	private Label priezviskoL = new Label("Priezvisko: ");
	private Label pohlavieL = new Label("Pohlavie: ");
	private Label datumNarodeniaL = new Label("Datum narodenia: ");
	private Label cisloOPL = new Label("Cislo obcianskeho preukazu: ");
	private Label obcianstvoL = new Label("Obcianstvo: ");
	private Label trvalyPobytL = new Label("Trvaly pobyt: ");
	private Label hesloL = new Label("Heslo: ");
	private Label emailL = new Label("Email: ");
	private Button ziadost = new Button("Podat Ziadost");
	private Button naspat = new Button("Naspat");
	private ScrollPane skrol = new ScrollPane();
	private Separator separator1 = new Separator();
	
	
	
	private Label vyberL = new Label("Vyberte typ vozdila:");
	private ChoiceBox<String> vyber = new ChoiceBox<String>(FXCollections.observableArrayList("Osobne auto", "Kamion", "Motocykel"));	
	private TextField znacka=new TextField();
	private TextField rokVyroby=new TextField();
	private TextField VIN=new TextField();
	private TextField vykon=new TextField();
	private TextField km=new TextField();
	private TextField spz=new TextField();
	private TextField emisie=new TextField();
	
	private RadioButton eu= new RadioButton("Krajina EU");
	private RadioButton mimoEu = new RadioButton("Krajina mimo EU");
	private ToggleGroup group = new ToggleGroup();
	
	private Label info2 = new Label("Zadajte udaje o vasom vozidle: ");
	private Label znackaL=new Label("Znacka Vozidla:");
	private Label rokVyrobyL= new Label("Rok Vyroby:");
	private Label VINL=new Label("VIN:");
	private Label vykonL=new Label("Vykon(kw):");
	private Label kmL=new Label("Najazdene km:");
	private Label krajinaL=new Label("Krajina Povodu:");
	private Label spzL=new Label("SPZ:");
	private Label emisieL=new Label("Miera emisii:");
	//observers
	private HmotnostLabel hmotnostL;
	private ChangingTextfield hmotKateg;
	private KategoriaLabel kategoriaL;
	Registracia registracia = new Registracia();
	
	@Override
	public void start(Stage ziadostOkno) {
		ziadostOkno.setTitle("Ziadost o zaregistrovanie vozidla");
		Pane pane = new FlowPane();
		
		
		
		//Observer
		hmotnostL=new HmotnostLabel("Hmotnost kamionu: ",registracia);
		kategoriaL=new KategoriaLabel("Kategoria motocykla: ",registracia);
		hmotnostL.setVisible(false);
		kategoriaL.setVisible(false);
		hmotKateg=new ChangingTextfield(registracia);
		hmotKateg.setVisible(false);
		registracia.pridajSledovatela(hmotnostL);
		registracia.pridajSledovatela(hmotKateg);
		registracia.pridajSledovatela(kategoriaL);
		//
		
		((FlowPane) pane).setHgap(1000);
        ((FlowPane) pane).setVgap(2);
        pane.setPadding(new Insets(15,15,15,15));
		
        pane.getChildren().add(infoL);
		pane.getChildren().add(menoL);
		pane.getChildren().add(meno);
		pane.getChildren().add(priezviskoL);
		pane.getChildren().add(priezvisko);
		pane.getChildren().add(pohlavieL);
		pane.getChildren().add(pohlavie);
		pane.getChildren().add(datumNarodeniaL);
		pane.getChildren().add(datumNarodenia);
		pane.getChildren().add(cisloOPL);
		pane.getChildren().add(cisloOP);
		pane.getChildren().add(obcianstvoL);
		pane.getChildren().add(obcianstvo);
		pane.getChildren().add(trvalyPobytL);
		pane.getChildren().add(trvalyPobyt);
		pane.getChildren().add(emailL);
		pane.getChildren().add(email);
		pane.getChildren().add(hesloL);
		pane.getChildren().add(heslo);
		pane.getChildren().add(separator1);
		
		pane.getChildren().add(info2);
		pane.getChildren().add(vyberL);
		pane.getChildren().add(vyber);
	
		separator1.setPrefWidth(200);
		
		pane.getChildren().add(hmotnostL);
		pane.getChildren().add(kategoriaL);
		pane.getChildren().add(hmotKateg);
		pane.getChildren().add(znackaL);
		pane.getChildren().add(znacka);
		pane.getChildren().add(rokVyrobyL);
		pane.getChildren().add(rokVyroby);
		pane.getChildren().add(VINL);
		pane.getChildren().add(VIN);
		pane.getChildren().add(vykonL);
		pane.getChildren().add(vykon);
		pane.getChildren().add(kmL);
		pane.getChildren().add(km);
		pane.getChildren().add(krajinaL);
		pane.getChildren().add(eu);
		pane.getChildren().add(mimoEu);
		pane.getChildren().add(spzL);
		pane.getChildren().add(spz);
		pane.getChildren().add(emisieL);
		pane.getChildren().add(emisie);
		pane.getChildren().add(ziadost);
		pane.getChildren().add(naspat);
		
		infoL.setFont(new Font(15));
		info2.setFont(new Font(15));
		
		skrol.setContent(pane);
		eu.setToggleGroup(group);
		mimoEu.setToggleGroup(group);
		eu.setSelected(true);
		vyber.getSelectionModel().selectFirst();
			
		
		vyber.getSelectionModel().selectedIndexProperty().addListener((v, oldIndex, newIndex)->{
			registracia.zmenaKategorie((int) newIndex);
		});
				
		naspat.setOnAction(e->{
			HomeScreen back = new HomeScreen();
			back.start(ziadostOkno);
		});
		
		ziadost.setOnAction(e->{		
			try {
				registracia.nacitaj();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Ziadost ziadost;
			try {
				if(vyber.getSelectionModel().getSelectedItem().equals("Osobne auto")) {
					ziadost=new ZiadostAuto();
					((ZiadostAuto) ziadost).poziadaj(meno.getText(),
							priezvisko.getText(),
							pohlavie.getText(),
							datumNarodenia.getText(),
							cisloOP.getText(),
							trvalyPobyt.getText(),
							obcianstvo.getText(), 
							email.getText(),
							heslo.getText(),
							znacka.getText(),
							Integer.parseInt(rokVyroby.getText()),
							VIN.getText(),
							Integer.parseInt(vykon.getText()), 
							Integer.parseInt(km.getText()),
							eu.isSelected(),
							spz.getText(), 
							Integer.parseInt(emisie.getText()));
					//POLYMORFIZMUS
					registracia.setZiadost(ziadost);
				}
				
				if(vyber.getSelectionModel().getSelectedItem().equals("Kamion")) {
					ziadost=new ZiadostKamion();
					((ZiadostKamion) ziadost).poziadaj(meno.getText(),
							priezvisko.getText(),
							pohlavie.getText(),
							datumNarodenia.getText(),
							cisloOP.getText(),
							trvalyPobyt.getText(),
							obcianstvo.getText(), 
							email.getText(),
							heslo.getText(),
							znacka.getText(),
							Integer.parseInt(rokVyroby.getText()),
							VIN.getText(),
							Integer.parseInt(vykon.getText()), 
							Integer.parseInt(km.getText()),
							eu.isSelected(),
							spz.getText(), 
							Integer.parseInt(emisie.getText()),
							Integer.parseInt(hmotKateg.getText()));
					//POLYMORFIZMUS
					registracia.setZiadost(ziadost);
						
				}
				if(vyber.getSelectionModel().getSelectedItem().equals("Motocykel")) {
					ziadost=new ZiadostMotocykel();
					((ZiadostMotocykel) ziadost).poziadaj(meno.getText(),
							priezvisko.getText(),
							pohlavie.getText(),
							datumNarodenia.getText(),
							cisloOP.getText(),
							trvalyPobyt.getText(),
							obcianstvo.getText(), 
							email.getText(),
							heslo.getText(),
							znacka.getText(),
							Integer.parseInt(rokVyroby.getText()),
							VIN.getText(),
							Integer.parseInt(vykon.getText()), 
							Integer.parseInt(km.getText()),
							eu.isSelected(),
							spz.getText(), 
							Integer.parseInt(emisie.getText()),
							hmotKateg.getText());
					//POLYMORFIZMUS
					registracia.setZiadost(ziadost);

				}
				
				try {
					registracia.uloz();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Alert a = new Alert(AlertType.CONFIRMATION);
				a.setTitle("Ziadost bola podana");
				a.setContentText("Ziadost bola uspesne podana");
				a.showAndWait(); 
				
				HomeScreen home = new HomeScreen();
				home.start(ziadostOkno);		
				
			} catch (ChybnyVstupException e1){

			}
			catch (NumberFormatException ex) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Chyba");
				a.setContentText("Zadajte spravne udaje!");
				a.showAndWait();
			}

		});
		ziadostOkno.setScene(new Scene(skrol, 1000, 500));
		ziadostOkno.show();
	}
}
