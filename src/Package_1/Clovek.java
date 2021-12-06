package Package_1;

public class Clovek {
	protected String meno;
	protected String pohlavie;
	protected boolean overenie = false;
	
	


boolean updateProfil(String newName)	{
	meno = newName;
	return true;
}



public String getMeno() {
	return meno;
}



public void setMeno(String meno) {
	this.meno = meno;
}



public String getPohlavie() {
	return pohlavie;
}



public void setPohlavie(String pohlavie) {
	this.pohlavie = pohlavie;
}



public boolean isOverenie() {
	return overenie;
}



public void setOverenie(boolean overenie) {
	this.overenie = overenie;
}



}