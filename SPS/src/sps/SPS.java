/*
* Student: An Siong Han
* Onderwerp: Inleding programeren
 */
package sps;
import java.util.Random;
import javax.swing.JOptionPane;

class Overloading{
    static String overloading(String inzet){
        String inleg1 = "\u20ac 100";
        return inleg1;
    }  
    static String overloading(String teken, String inzet){
        String inleg2 = "\u20ac"+inzet;
        return inleg2;
    }  
}

public class SPS {   
//eerste method de Main method
    public static void main(String[] args)    {

        double startInzet = 100.0 ;
//tweede method waarbij de speler de spelregels krijgt uitgelegd
        start(startInzet);
/* Derde method hier krijgt de tegenstander elke keer een willekeurige kaart.
*  Het maakt namelijk niet uit of de tegenstander 6 of 1 kaart trekt, aangezien hij toch maar één kaart kan kiezen en deze blindelings is, maar wel een voorkeur heeft
*/
        String tegenstander;
//vierde method hier krijgt de speler een drietal kaarten en kan hieruit een kaart kiezen
        String mijnKant;
        for (int rondje=1;rondje<7;rondje++){
            if (rondje== 6){
                                String keuzeOptie;
                String inzet = "100,00"; 
                String teken = "\u20ac";
                String inleg1 = Overloading.overloading(inzet);
                String inleg2 = Overloading.overloading(teken, inzet);
                inzet = "100,00"; 
                teken = "\u20ac";
                inleg1 = Overloading.overloading(inzet);
                inleg2 = Overloading.overloading(teken, inzet);
                String[] keuze = { "De kaarten zijn van tevoren al uitgekozen/gestoken. Ik zet " + inleg1 +  " in.", "Sommmige Kaarten komen vaker voor dan anderen ik zet " + inleg2 + " in.", "Ik weet het niet ik zet niets in." };
                String selection = (String)JOptionPane.showInputDialog(null,
                    "Je hebt gewonnen \n Waarom verlies je bijna altijd?",
                    "Steen Papier Schaar", JOptionPane.QUESTION_MESSAGE, null, keuze,
                    keuze[0]);
                if ( selection == null){
                   selection = (String)JOptionPane.showInputDialog(null,
                    "weet je het heel zeker? \n Indien je nog eens op cancel klikt stopt het spel en heb je automatisch verloren. \n Maak nu een keuze",
                    "Steen Papier Schaar", JOptionPane.QUESTION_MESSAGE, null, keuze,
                    keuze[0]);
                    if ( selection ==  null){
                        JOptionPane.showMessageDialog(null, "U heeft verloren!");
                        System.exit(0);
                    }
                }
                if (selection.equals(keuze[1])){
                    startInzet = startInzet + 100.0;
                    keuzeOptie = "Correct. \n U heeft dit spel gewonnen. \n Wilt u nog een keer spelen?";
                }   else if (selection.equals(keuze[2])){
                    startInzet = startInzet + 0.0;
                    keuzeOptie = "U weet het niet? \n Wilt U doorgaan met een nieuwe poging?";
                } else {
                    startInzet = startInzet - 100.0;
                    keuzeOptie = "U heeft verloren en nog " +startInzet + " over. \n De kaarten worden niet uitgekozen door de tegenstander, maar echt random uitgedeeld. \n Wilt U doorgaan met een nieuwe poging?";
                }
                int result = JOptionPane.showOptionDialog(null, keuzeOptie , " Papier Steen Schaar",
                        JOptionPane.YES_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);
// hier kan de gebruiker kiezen om door te gaan of te stoppen (cancel is 0)
// helaas kan joptionpane geen boolean waarde aan als veriable)
// zodat variable rondje weer op 0 komt en een nieuw spel kan gaan beginnen
                    if (result == JOptionPane.YES_OPTION){
                        rondje = 0;
                    } else {
                        System.exit(0);
                    }
            } else {
                tegenstander = tegenStanderKeuze();
                mijnKant = mijnKeuzeMethod();
                if (mijnKant != null)        {
                    JOptionPane.showMessageDialog(null, "Je tegenstander heeft in beurt " + rondje + " de keuze geaakt voor " + tegenstander + ".");
                    winnaarMethod(tegenstander, mijnKant);
                }
            }
        }
    System.exit(0);
    }

    public static void start(double startInzet){
        String startInzetDisplay = String.format ("%.2f", startInzet);
        JOptionPane.showMessageDialog(null, "Dit is het spel Papier Steen Schaar?\" \n "
                + "Maar wel een speciale! "
                + "\n Een spelletje van 5 rondes waarbij je uit moet vinden waarom je (te) vaak verliest."
                + "\n In ronde 6 zal u gevraagd worden of u weet waar er gesjoemeld wordt."
                + "\n Het gaat er dus niet om de rondes te winnen, maar om uit te vinden hoe er vals gespeeld wordt"
                + "\n Om het spel een beetje leuker te maken hebben we er ook een weddenschap bij gedaan."
                + "\n U begint met \u20ac" + startInzetDisplay + ", en kan aan het eind \u20ac 100,00 inzetten (of niet).");
    }

    public static String tegenStanderKeuze() {
        String tegenstander;
        byte tegenstanderKeuze;
        Random willekeurigeKeuze = new Random();
        tegenstanderKeuze = (byte)(willekeurigeKeuze.nextInt(8) + 1);
        switch (tegenstanderKeuze) {
            case 1:
                tegenstander = "steen";
                break;
            case 2:
                tegenstander = "papier";
                break;
            default:
                tegenstander = "schaar";
                break;
        }
        return tegenstander;
    }

    public static String mijnKeuzeMethod() {
         String mijnHand[] = new String[3];
        for (int loop = 0; loop<3;loop++){
            byte mijnKeuze;
            Random willekeurigeKeuze = new Random();
            mijnKeuze = (byte)(willekeurigeKeuze.nextInt(6) + 1);
            switch (mijnKeuze) {
                case 1:
                    mijnHand[loop] = "steen";
                    break;
                case 2:
                    mijnHand[loop] = "schaar";
                    break;
                default:
                    mijnHand[loop] = "papier";
                    break;
            }
        }
        String mijnKeuze = (String)JOptionPane.showInputDialog(null,
            "Wat is je keuze?", " Papier Steen Schaar",
            JOptionPane.QUESTION_MESSAGE, null, mijnHand,
            mijnHand[0]);
        if ( mijnKeuze ==  null){
            mijnKeuze = (String)JOptionPane.showInputDialog(null,
            "weet je het heel zeker? \n Indien je NOG eens op cancel klikt stopt het spel en heb je automatisch verloren" ,  "Papier Steen Schaar",
            JOptionPane.QUESTION_MESSAGE, null, mijnHand, mijnHand[0]);
            if ( mijnKeuze ==  null){
                JOptionPane.showMessageDialog(null, "U heeft verloren!");
                System.exit(0);
            }
        }
        return mijnKeuze;
    }

    public static void winnaarMethod(String tegenstander, String mijnKant) {
        if (tegenstander.equals(mijnKant)) {
            JOptionPane.showMessageDialog(null, "De uitslag is gelijk. Niets gewonnen, niets verloren.", "Papier Steen Schaar",JOptionPane.PLAIN_MESSAGE);
        } else if (tegenstander.equalsIgnoreCase("steen") && mijnKant.equalsIgnoreCase("papier")) {
            JOptionPane.showMessageDialog(null, "Gewonnen! Papier bedekt steen. ", "Papier Steen Schaar",JOptionPane.PLAIN_MESSAGE);
        } else if (tegenstander.equalsIgnoreCase("steen") && mijnKant.equalsIgnoreCase("schaar")) {
            JOptionPane.showMessageDialog(null, "Verloren! Steen  breekt schaar.", "Papier Steen Schaar",JOptionPane.ERROR_MESSAGE);
        } else if (tegenstander.equalsIgnoreCase("papier") && mijnKant.equalsIgnoreCase("steen")) {
            JOptionPane.showMessageDialog(null, "Verloren! Papier bedekt steen.", "Papier Steen Schaar",JOptionPane.ERROR_MESSAGE);
        } else if (tegenstander.equalsIgnoreCase("papier") && mijnKant.equalsIgnoreCase("schaar")) {
            JOptionPane.showMessageDialog(null, "Gewonnen! Schaar knipt papier.", "Papier Steen Schaar",JOptionPane.PLAIN_MESSAGE);
        } else if (tegenstander.equalsIgnoreCase("schaar") && mijnKant.equalsIgnoreCase("steen")) {
            JOptionPane.showMessageDialog(null, "Gewonnen! Steen breekt schaar.", "Papier Steen Schaar",JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Verloren! Schaar knipt papier.", "Papier Steen Schaar",JOptionPane.ERROR_MESSAGE);
        }
    }
}


