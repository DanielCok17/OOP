package akcie;
//OBSERVER
/**
 * Rozhranie vzoru Observer. 
 * @author Daniel
 *
 */
public interface SledovatelRegistracie {
	/**
	 * Toto rozhranie predpisuje pouzitie metody upovedom.
	 * @param n Je to cislo vybraneho typu vozidla v ChoiceBoxe(0 = Auto, 1 = Kamion, 2 = Motocykel)
	 */
	public void upovedom(int n);
}
