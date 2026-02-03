package klinika;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	
	@Test
	public void atribut_naslov() {
		String expected = "Klinika";
		String actual = instance.getTitle().trim();
		assertEquals("Naslov prozora je \""+actual+"\", a potrebno je da bude \""+expected+"\"",expected,actual);
	}
}
