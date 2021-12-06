package Package_1;

public  class Tovar {
	protected String nazov_tovaru;
	boolean preclene = false;
	int clo = 0;
	
	
	public String getNazov_tovaru() {
		return nazov_tovaru;
	}


	public void setNazov_tovaru(String nazov_tovaru) {
		this.nazov_tovaru = nazov_tovaru;
	}


	public boolean isPreclene() {
		return preclene;
	}


	public void setPreclene(boolean preclene) {
		this.preclene = preclene;
	}


	public Tovar(String nazov_tovaru,boolean preclene, int clo2)
	{
		this.nazov_tovaru = nazov_tovaru;
		this.preclene = preclene;
		
	}
	
	public void plateni_cla(int clo) {
		clo = 0;
		System.out.println("Clo sa neplatí");
	}

}
