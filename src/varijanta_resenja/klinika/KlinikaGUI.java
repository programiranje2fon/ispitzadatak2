package varijanta_resenja.klinika;

import varijanta_resenja.klinika.osoblje.Lekar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class KlinikaGUI extends JFrame {
    private JPanel mojPanel;
    private JTextField textFieldImePrezime;
    private JTextField textFieldDatumZaposlenja;
    private JComboBox comboBoxSpecijalnost;
    private JTextArea textArea1;
    private JButton unesiButton;
    private JButton prikaziButton;
    private JButton izvestajButton;

    private LinkedList<Lekar> lekari = new LinkedList<Lekar>();

    public KlinikaGUI(){
        setContentPane(mojPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("Klinika");
        unesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lekar l = new Lekar();
                l.setImePrezime(textFieldImePrezime.getText());
                l.setSpecijalnost((String)(comboBoxSpecijalnost.getSelectedItem()));

                //Ako je datum unet kao String u formatu "dd.mm.gggg"
                //onda se dan, mesec i godina moraju posebno izvuci
                //iz tog stringa i pretvoriti u cele brojeve pa tek
                //onda uneti u GregorianCalendar.
                String datumString = textFieldDatumZaposlenja.getText();

                int dan = Integer.parseInt(datumString.substring(0,2));
                int mesec= Integer.parseInt(datumString.substring(3,5))-1;
                int godina= Integer.parseInt(datumString.substring(6));

                LocalDate datumZaposlenja = LocalDate.of(godina, mesec, dan);

                l.setDatumZaposlenja(datumZaposlenja);

                //Provera da li se taj lekar vec nalazi  listi preko contains metode
                //je moguca samo ako postoji equals metoda u okviru klase Lekar,
                //a inace mora rucno. Ovde nije data equals metoda u okviru klase Lekar.
                for(int i=0;i<lekari.size();i++)
                    if (lekari.get(i).getImePrezime().equals(l.getImePrezime())&&
                            lekari.get(i).getSpecijalnost().equals(l.getSpecijalnost())&&
                            lekari.get(i).getDatumZaposlenja().equals(l.getDatumZaposlenja())){
                        textArea1.setText("Greska, taj lekar je vec unet");
                        return;
                    }

                lekari.add(l);
            }
        });
        prikaziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=lekari.size()-1;i>=0;i--)
                    textArea1.append(lekari.get(i).toString()+System.lineSeparator());
            }
        });
        izvestajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ObjectOutputStream out =
                            new ObjectOutputStream(
                                    new BufferedOutputStream(
                                            new FileOutputStream("izvestaj.out")));

                    //Prolazi se kroz listu i traze se parovi lekara gde je ime
                    //isto ali je specijalnost drugacija. Ako se takvi nadju,
                    //oba lekara se serijalizuju u fajl.
                    for(int i=0;i<lekari.size()-1;i++) {
                        boolean upisanIti = false;
                        for(int j=i+1;j<lekari.size();j++)
                            if (lekari.get(i).getImePrezime().equals(lekari.get(j).getImePrezime()) &&
                                    !lekari.get(i).getSpecijalnost().equals(lekari.get(j).getSpecijalnost())){
                                if (!upisanIti) out.writeObject(lekari.get(i));
                                out.writeObject(lekari.get(j));
                            }
                    }

                    out.close();
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new KlinikaGUI().setVisible(true);
    }
}
