package zadatak.osoblje;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klinika.osoblje.Lekar;
import test.TestUtil;

public class LekarTest {
	Lekar instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Lekar();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_imePrezime() {
		assertTrue("U klasi nije definisan atribut imePrezime", TestUtil.doesFieldExist(Lekar.class, "imePrezime"));
	}
	
	@Test
	public void atribut_imePrezime_vidljivost() {
		assertTrue("Atribut imePrezime nije privatan", TestUtil.hasFieldModifier(Lekar.class, "imePrezime", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_imePrezime_pocetnaVrednost() {
		String expected = "nepoznato";
		String actual = (String) TestUtil.getFieldValue(instance, "imePrezime");
		assertEquals("Atribut imePrezime ima vrednost "+actual+", a potrebno je da ima vrednost "+expected,expected, actual);
	}
	
	@Test
	public void atribut_datumZaposlenja() {
		assertTrue("U klasi nije definisan atribut datumZaposlenja", TestUtil.doesFieldExist(Lekar.class, "datumZaposlenja"));
	}
	
	@Test
	public void atribut_datumZaposlenja_vidljivost() {
		assertTrue("Atribut datumZaposlenja nije privatan", TestUtil.hasFieldModifier(Lekar.class, "datumZaposlenja", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_datumZaposlenja_pocetnaVrednost() {
		GregorianCalendar expected = null;
		GregorianCalendar actual = (GregorianCalendar) TestUtil.getFieldValue(instance, "datumZaposlenja");
		assertEquals("Atribut datumZaposlenja ima vrednost "+actual+", a potrebno je da ima vrednost "+expected,expected, actual);
	}
	
	@Test
	public void atribut_specijajlnost() {
		assertTrue("U klasi nije definisan atribut specijalnost", TestUtil.doesFieldExist(Lekar.class, "specijalnost"));
	}
	
	@Test
	public void atribut_specijalnost_vidljivost() {
		assertTrue("Atribut specijalnost nije privatan", TestUtil.hasFieldModifier(Lekar.class, "specijalnost", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_specijalnost_pocetnaVrednost() {
		String expected = "nepoznato";
		String actual = (String) TestUtil.getFieldValue(instance, "specijalnost");
		assertEquals("Atribut specijalnost ima vrednost "+actual+", a potrebno je da ima vrednost "+expected,expected, actual);
	}
	
	
}
