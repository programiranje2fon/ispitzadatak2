package klinika.osoblje;

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
		assertTrue("Atribut imePrezime nije privatan",
				TestUtil.hasFieldModifier(Lekar.class, "imePrezime", Modifier.PRIVATE));
	}

	@Test
	public void atribut_imePrezime_pocetnaVrednost() {
		String expected = "nepoznato";
		String actual = (String) TestUtil.getFieldValue(instance, "imePrezime");
		assertEquals("Atribut imePrezime ima vrednost " + actual + ", a potrebno je da ima vrednost " + expected,
				expected, actual);
	}

	@Test
	public void atribut_datumZaposlenja() {
		assertTrue("U klasi nije definisan atribut datumZaposlenja",
				TestUtil.doesFieldExist(Lekar.class, "datumZaposlenja"));
	}

	@Test
	public void atribut_datumZaposlenja_vidljivost() {
		assertTrue("Atribut datumZaposlenja nije privatan",
				TestUtil.hasFieldModifier(Lekar.class, "datumZaposlenja", Modifier.PRIVATE));
	}

	@Test
	public void atribut_datumZaposlenja_pocetnaVrednost() {
		GregorianCalendar expected = null;
		GregorianCalendar actual = (GregorianCalendar) TestUtil.getFieldValue(instance, "datumZaposlenja");
		assertEquals("Atribut datumZaposlenja ima vrednost " + actual + ", a potrebno je da ima vrednost " + expected,
				expected, actual);
	}

	@Test
	public void atribut_specijajlnost() {
		assertTrue("U klasi nije definisan atribut specijalnost", TestUtil.doesFieldExist(Lekar.class, "specijalnost"));
	}

	@Test
	public void atribut_specijalnost_vidljivost() {
		assertTrue("Atribut specijalnost nije privatan",
				TestUtil.hasFieldModifier(Lekar.class, "specijalnost", Modifier.PRIVATE));
	}

	@Test
	public void atribut_specijalnost_pocetnaVrednost() {
		String expected = "nepoznato";
		String actual = (String) TestUtil.getFieldValue(instance, "specijalnost");
		assertEquals("Atribut specijalnost ima vrednost " + actual + ", a potrebno je da ima vrednost " + expected,
				expected, actual);
	}

	@Test
	public void metoda_setImePrezime_vidljivost() {
		assertTrue("Metoda setImePrezime nije javna", TestUtil.hasMethodModifier(Lekar.class, "setImePrezime",
				new Class<?>[] { String.class }, Modifier.PUBLIC));
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setImePrezime_null() {
		String arg = null;
		instance.setImePrezime(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
				+ ", metoda setImePrezime ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setImePrezime_prazanString() {
		String arg = "";
		instance.setImePrezime(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
				+ ", metoda setImePrezime ne baca neproveravani izuzetak", false);
	}

	@Test
	public void metoda_getImePrezime_vidljivost() {
		assertTrue("Metoda getImePrezime nije javna",
				TestUtil.hasMethodModifier(Lekar.class, "getImePrezime", null, Modifier.PUBLIC));
	}

	@Test
	public void metoda_setDatumZaposlenja_vidljivost() {
		assertTrue("Metoda setDatumZaposlenja nije javna", TestUtil.hasMethodModifier(Lekar.class, "setDatumZaposlenja",
				new Class<?>[] { GregorianCalendar.class }, Modifier.PUBLIC));
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setDatumZaposlenja_null() {
		GregorianCalendar arg = null;
		instance.setDatumZaposlenja(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg.toString() + "\"")
				+ ", metoda setDatumZaposlenja ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setDatumZaposlenja_trenutniDatum() {
		GregorianCalendar arg = new GregorianCalendar();
		instance.setDatumZaposlenja(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg.getTime().toString() + "\"")
				+ ", metoda setDatumZaposlenja ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setDatumZaposlenja_buduciDatum() {
		GregorianCalendar arg = new GregorianCalendar(new GregorianCalendar().get(GregorianCalendar.YEAR) + 1, 1, 1);
		instance.setDatumZaposlenja(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg.getTime().toString() + "\"")
				+ ", metoda setDatumZaposlenja ne baca neproveravani izuzetak", false);
	}

	@Test
	public void metoda_setDatumZaposlenja_prosliDatum() {
		GregorianCalendar arg = new GregorianCalendar(new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1);
		instance.setDatumZaposlenja(arg);
		GregorianCalendar actual = (GregorianCalendar) TestUtil.getFieldValue(instance, "datumZaposlenja");
		assertTrue(
				"Za prosledjeni argument " + (arg == null ? null : "\"" + arg.getTime().toString() + "\"")
						+ ", nakon izvrsenja metode setDatumZaposlenja atribut datumZaposlenja ima vrednost " + actual,
				actual.equals(arg));
	}

	@Test
	public void metoda_getDatumZaposlenja_vidljivost() {
		assertTrue("Metoda getDatumZaposlenja nije javna",
				TestUtil.hasMethodModifier(Lekar.class, "getDatumZaposlenja", null, Modifier.PUBLIC));
	}

	@Test
	public void metoda_setSpecijalnost_vidljivost() {
		assertTrue("Metoda setSpecijalnost nije javna", TestUtil.hasMethodModifier(Lekar.class, "setSpecijalnost",
				new Class<?>[] { String.class }, Modifier.PUBLIC));
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setSpecijalnost_null() {
		String arg = null;
		instance.setSpecijalnost(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
				+ ", metoda setSpecijalnost ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setSpecijalnost_kraciOd3karaktera() {
		String arg = "as";
		instance.setSpecijalnost(arg);
		assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
				+ ", metoda setSpecijalnost ne baca neproveravani izuzetak", false);
	}

	@Test
	public void metoda_setSpecijalnost_3Karaktera() {
		String arg = "adf";
		try {
			instance.setSpecijalnost(arg);
		} catch (RuntimeException e) {
			assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
					+ ", metoda setSpecijalnost baca neproveravani izuzetak", false);
		}
		String actual = (String) TestUtil.getFieldValue(instance, "specijalnost");
		assertTrue(
				"Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
						+ ", nakon izvrsenja metode setSpecijalnost atribut specijalnost ima vrednost " + actual,
				actual.equals(arg));
	}

	@Test
	public void metoda_setSpecijalnost_duziOd3Karaktera() {
		String arg = "Kardiologija";
		try {
			instance.setSpecijalnost(arg);
		} catch (RuntimeException e) {
			assertTrue("Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
					+ ", metoda setSpecijalnost baca neproveravani izuzetak", false);
		}
		String actual = (String) TestUtil.getFieldValue(instance, "specijalnost");
		assertTrue(
				"Za prosledjeni argument " + (arg == null ? null : "\"" + arg + "\"")
						+ ", nakon izvrsenja metode setSpecijalnost atribut specijalnost ima vrednost " + actual,
				actual.equals(arg));
	}

	@Test
	public void metoda_getSpecijalnost_vidljivost() {
		assertTrue("Metoda getSpecijalnost nije javna",
				TestUtil.hasMethodModifier(Lekar.class, "getSpecijalnost", null, Modifier.PUBLIC));
	}

	@Test
	public void metoda_toString() {
		String imePrezime = "Marko Markovic";
		GregorianCalendar datumZaposlenja = new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1);
		String specijalnost = "Kardiologija";
		instance.setImePrezime(imePrezime);
		instance.setDatumZaposlenja(datumZaposlenja);
		instance.setSpecijalnost(specijalnost);
		String result = instance.toString();
		assertTrue("String koji vraca metoda to String ne sadrzi vrednost atributa imePrezime",
				result.indexOf(instance.getImePrezime()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi godinu zaposlenja",
				result.indexOf(((Integer) instance.getDatumZaposlenja().get(GregorianCalendar.YEAR)).toString()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi dan zaposlenja",
				result.indexOf(((Integer) instance.getDatumZaposlenja().get(GregorianCalendar.DAY_OF_MONTH)).toString()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi vrednost atributa specijalnost",
				result.indexOf(instance.getSpecijalnost()) != -1);
	}

}
