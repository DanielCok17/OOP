package Package_1;

public class Turista extends Clovek{
	String krajina_povodu;
	boolean pas = false;
	int rodne_cislo;
	protected int konto =100;
	
	Tovar moj_tovar;

	public Turista(String meno,String pohlavie,String krajina_povodu, boolean pas, int rodne_cislo,String nazov_tovaru,boolean preclene,int clo)
	{
		this.krajina_povodu = krajina_povodu;
		this.meno = meno;
		this.pohlavie = pohlavie;
		this.pas = pas;
		this.rodne_cislo = rodne_cislo;
		
		moj_tovar = new Tovar(nazov_tovaru,preclene,clo);
		
		
	}
	
	public Turista(int konto) {
		this.konto = konto;
	}

	public String getKrajina_povodu() {
		return krajina_povodu;
	}

	public void setKrajina_povodu(String krajina_povodu) {
		this.krajina_povodu = krajina_povodu;
	}

	public boolean isPas() {
		return pas;
	}

	public void setPas(boolean pas) {
		this.pas = pas;
	}

	public int getRodne_cislo() {
		return rodne_cislo;
	}

	public void setRodne_cislo(int rodne_cislo) {
		this.rodne_cislo = rodne_cislo;
	}

	public Tovar getMoj_tovar() {
		return moj_tovar;
	}

	public void setMoj_tovar(Tovar moj_tovar) {
		this.moj_tovar = moj_tovar;
	}
	
	public void kontrola_konta(int konto) {
		konto +=0;
		System.out.println("Tvoje konto je :" + konto + " €");
	}
	
}
