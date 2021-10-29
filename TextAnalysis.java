import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class TextAnalysis {
    String sourceFileName;
    int maxNoOfWords;

    public TextAnalysis(String sourceFileName, int maxNoOfWords) { //konstruktør for sourceFileName og maxNoOfWords
        this.sourceFileName = sourceFileName;
        this.maxNoOfWords = maxNoOfWords;
    }


    public int wordCount() throws FileNotFoundException {
        Scanner input = new Scanner(new File(sourceFileName));//Konstruerer scanner for vores valgte fil
        ArrayList<String> new_string = new ArrayList<String>();
        while(input.hasNextLine()) { //while-loop som kun er true hvis filen har en ekstra linje
            String line = input.nextLine().toLowerCase();//Gør hele linjen til små bogstaver da vi vil ignorer CapsLock
            String[] tokens = line.split("[^a-zA-Z]+");//opsplitter vores linje til ord som tilføjes til array
            for(String n:tokens) {//for-each loop for tokens som tilføjer de 'Strings' som ikke er tomme til arraylist.
                if(!n.equals("")) {
                    new_string.add(n);
                }
            }
            }
        return new_string.size();//Da alle ord ligger new_string, returnerer vi blot antallet af elementer i den
    }

    public int getNoOfDifferentWords() throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner input = new Scanner(new File(sourceFileName));
        while(input.hasNextLine()) {
            String line = input.nextLine().toLowerCase();
            String[] tokens = line.split("[^a-zA-Z]+");
            for (String n : tokens) { //gennemgår alle ord i tokens og hvis ordet ikke er i arraylist, 'list', bliver
                if (!list.contains(n)) {// det tilføjet til 'list'
                    list.add(n);
                }
            }
        }
        return list.size(); //returnerer antallet af ord vi har tilføjet til vores arraylist, 'list'
    }

    public int getNoOfRepetitions() throws FileNotFoundException {
        Scanner input = new Scanner(new File(sourceFileName));
        ArrayList<String> new_string = new ArrayList<String>();
        String word_before = "";//initialisere string variablen word_before
        int counter = 0;//initialisere en tæller
        while(input.hasNextLine()) {//while og foor-loop som gennemløber hele vores fil og indsætter ordene i vores
            String line = input.nextLine().toLowerCase(); //arraylist, 'new_string' (fjerner også tomme elementer
            String[] tokens = line.split("[^a-zA-Z]+");//undevejs)
            for (String n : tokens) {
                if (!n.equals("")) {
                    new_string.add(n);
                }
            }
        }
            for(String k: new_string) { //For-each loop som gennemløber vores arraylist, 'new_string'
                if(k.equals(word_before)) {//if som checker om vores ord i 'new_string' er lig med ordet fra før
                    counter++; //øger vores tæller, 'counter', med en
                }
                word_before = k;//sætter vores variabel 'word_before' lig med ordet vi lige gennemtjekkede.
            }
        return counter; //returnerer værdien af vores tæller, 'counter'
        }

    }








