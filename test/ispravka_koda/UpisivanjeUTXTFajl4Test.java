package ispravka_koda;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ispravka_koda.UpisivanjeUTXTFajl4;
import test.TestUtil;

public class UpisivanjeUTXTFajl4Test {
	@Before
	public void setUp() throws Exception {
		UpisivanjeUTXTFajl4.upisiArmstrongoveBrojeve();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void metoda_upisiArmstrongoveBrojeve_vidljivost() {
		assertTrue("Metoda upisiArmstrongoveBrojeve nije javna", TestUtil.hasMethodModifier(UpisivanjeUTXTFajl4.class, "upisiArmstrongoveBrojeve", null, Modifier.PUBLIC));
	}
	
	private static List<Integer> amstrongovi(){
		List<Integer> list = new LinkedList<>();
		for (int i = 100; i <= 999; i++) {
			int zbirKubova = 0, pom = i;
			while (pom > 0) {
				zbirKubova = zbirKubova + (pom % 10) * (pom % 10) * (pom % 10);
				pom = pom / 10;
			}
			if (zbirKubova == i)
				list.add(i);
		}
		return list;
	}
	
	@Test
	public void metoda_upisiArmstrongoveBrojeve() {
		Scanner input = null;
		try {
			input = new Scanner(new File("brojevi4.txt"));
		} catch (FileNotFoundException e) {
			assertTrue("Ne postoji fajl brojevi4.txt",false);
		}
		List<Integer> actual = new LinkedList<>();
		while(input.hasNextInt()) {
			actual.add(input.nextInt());
		}
		input.close();
		List<Integer> expected = amstrongovi();
		for(Integer i : expected) {
			assertTrue("U fajl nije upisan broj "+i,actual.contains(i));
		}
		if(expected.size() != actual.size()) {
			for(Integer i : actual) {
				assertTrue("U fajl je upisan broj "+i+" koji ne ispunjava zadati uslov", !expected.contains(i));
			}
		}
	}
}
