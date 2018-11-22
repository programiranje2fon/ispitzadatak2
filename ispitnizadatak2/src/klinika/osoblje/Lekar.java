package klinika.osoblje;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Lekar implements Serializable {
	
	private String imePrezime = "nepoznato";
	private GregorianCalendar datumZaposlenja;
	private String specijalnost = "nepoznato";
	
	public String getImePrezime() {
		return imePrezime;
	}
	
	public void setImePrezime(String imePrezime) {
		if (imePrezime==null || imePrezime.isEmpty())
			throw new RuntimeException("Ime i prezime ne smeju biti null niti prazni");
		
		this.imePrezime = imePrezime;
	}
	
	public GregorianCalendar getDatumZaposlenja() {
		return datumZaposlenja;
	}
	
	public void setDatumZaposlenja(GregorianCalendar datumZaposlenja) {
		if (datumZaposlenja==null || !datumZaposlenja.before(new GregorianCalendar())) 
			throw new RuntimeException("Datum ne sme biti null i mora se odnosti na proslost");
		
		this.datumZaposlenja = datumZaposlenja;
	}
	
	public String getSpecijalnost() {
		return specijalnost;
	}
	
	public void setSpecijalnost(String specijalnost) {
		if (specijalnost.length()<3)
			throw new RuntimeException("Specijalnost mora da sadrzi bar tri znaka");
		
		this.specijalnost = specijalnost;
	}

	public String toString() {
		return "Lekar [imePrezime=" + imePrezime + ", datumZaposlenja="
				+ datumZaposlenja.getTime().toString() + ", specijalnost=" + specijalnost + "]";
	}

}
