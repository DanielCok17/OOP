package Package_1;

import java.util.ArrayList;

public class Uradnik extends Clovek{
	
	int obstadenost = 0;
	ArrayList<Tovar> neprecleny = new ArrayList<Tovar>();
	ArrayList<Tovar> precleny = new ArrayList<Tovar>();
	
	public Uradnik (String meno,String pohlavie,int obsadenost)
	{
		this.meno = meno;
		this.pohlavie = pohlavie;
		this.obstadenost = obsadenost ;
	}
	
	public void over_turistu(Turista turista) {
		if(turista.pas == true) System.out.println("Turista " + turista.meno  +  " ma platny pas");
		else System.out.println("Turista " + turista.meno  +  " ma platny pas");
	}
	
	public void over_tovar(Turista turista) {
		if(turista.moj_tovar.preclene == true)
		{
			precleny.add(turista.moj_tovar);
			System.out.println("Turistov tovar " + turista.moj_tovar.nazov_tovaru  +  " je precleny" );
		}
			
												
		else
		{
			neprecleny.add(turista.moj_tovar);
			System.out.println("Turistov tovar " + turista.moj_tovar.nazov_tovaru  +  " nie je precleny" );
			
		}
			
	}

	public int getObstadenost() {
		return obstadenost;
	}

	public void setObstadenost(int obstadenost) {
		this.obstadenost = obstadenost;
	}
		
	
		
	
	
}
