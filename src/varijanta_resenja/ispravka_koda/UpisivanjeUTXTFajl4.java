package varijanta_resenja.ispravka_koda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpisivanjeUTXTFajl4 {
	public static void upisiArmstrongoveBrojeve() {
		try {
			PrintWriter out = new PrintWriter(
					new FileWriter("brojevi4.txt"));
			for (int i = 100; i <= 999; i++)
				if (i == ((i / 100) * (i / 100) * (i / 100)) +
						((i % 10) * (i % 10) * (i % 10)) +
						(i / 10 % 10) * (i / 10 % 10) * (i / 10 % 10)) 
					out.println(i);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
