package klinika;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klinika.KlinikaGUI;
import klinika.osoblje.Lekar;
import test.TestUtil;

public class KlinikaGUITest {
	KlinikaGUI instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new KlinikaGUI();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_title() {
		String expected = "Klinika";
		String actual = (String)instance.getTitle();
		assertTrue("Naslov prozora je \""+actual+"\", a potrebno je da bude \""+expected+"\"",actual.equals(expected));
	}
	
	
	private List<Object> getFiledsByType(Object inst,Class<?> type){
		 Field[] fields =	(inst.getClass()).getDeclaredFields();
		 List<Object> list = new ArrayList<>();
		 for(Field f : fields) {
			 if(f.getType().equals(type)) {
				f.setAccessible(true);
				try {
					list.add(f.get(inst));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		 return list;
	}
	
	//Nije receno kako treba nazvati padajucu listu specijalnosti
	//Pa sam morao na ovaj nacin da uradim
	//Za dugmice nisam uradio, ako treba nije problem da dodam,
	//stvar je u tome da su u resenju ona postavljena na panel
	//koji je vec dodat na contentPane, a moze i na drugi nacin
	//da se resi ispravano
	//Ista je stvar za tekst field-ove posto ih je dva
	//a nisu receni nazivi ne mogu da budem siguran koje od njih
	//nije stavljeno, ako je samo jedno na formi.
	//Resenje bi bilo da se promeni tekst zadatka i da se imenuje svaka
	//komponenta, a onda prolaskom kroz stablo komponenti da se one nadju
	//na osnovu imena.
	//Za event-ove nisam siguran koliko moze da se uradi
	//posto je radjeno preko anonimnih klasa
	@Test(timeout = 2000)
	public void atribut_padajucaLista() {
		JComboBox combo = null;
		try {
			combo = (JComboBox)getFiledsByType(instance, JComboBox.class).get(0);
		} catch (Exception e) {
			assertTrue("Nije definisana padajuca lista specijalnosti",false);
		}
		List<String> itemsActual = new ArrayList<>();
		int countActual = combo.getItemCount();
		String[] itemsExpected = new String[] { "opsta praksa", "oftalmolog", "kardiolog"};
		int countExpected = itemsExpected.length;
		assertTrue("Padajuca list treba da sadrzi "+countExpected+"stavki, a sadrzi"+countActual, countExpected == countActual);
		
		for(int i = 0; i < countActual; i++) {
			itemsActual.add((String)combo.getItemAt(i));
		} 
		
		for(String ex : itemsExpected) {
			assertTrue("Padajuca lista ne sadrzis stavku \""+ex+"\"",itemsActual.contains(ex));
		}
	}
	
	@Test
	public void atribut_lekari() {
		assertTrue("Nije definisan atribut lekari",TestUtil.doesFieldExist(KlinikaGUI.class, "lekari"));
	}
	
	@Test
	public void atribut_lekari_vidljivost() {
		assertTrue("Atribut lekari nije privatan", TestUtil.hasFieldModifier(KlinikaGUI.class, "lekari", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_lekari_pocetnaVrednost() {
		assertTrue("Atribut lekari nije inicijalizovan",TestUtil.getFieldValue(instance, "lekari") != null);
	}
	
	@Test(timeout = 2000)
	public void atribut_editor() {
		JTextArea combo = null;
		try {
			combo = (JTextArea)getFiledsByType(instance, JTextArea.class).get(0);
		} catch (Exception e) {
			assertTrue("Nije definisana editor",false);
		}
	}
	
	@Test
	public void atribut_naslov() {
		String expected = "Klinika";
		String actual = instance.getTitle().trim();
		assertEquals("Naslov prozora je \""+actual+"\", a potrebno je da bude \""+expected+"\"",expected,actual);
	}
}
