package delvinglanguages.kernel.util;

import delvinglanguages.settings.AppSettings;
import java.util.ArrayList;

public class Word implements Comparable<Word> {

    public static final int INITIAL_PRIORITY = 100;
    public static final int NUMBER_OF_TYPES = 9;

    public final static int NOUN = 1;
    public final static int VERB = 2;
    public final static int ADJECTIVE = 0x04;
    public final static int ADVERB = 0x08;
    public final static int PHRASAL_VERB = 0x10;
    public final static int EXPRESION = 0x20;
    public final static int PREPOSITION = 0x40;
    public final static int CONJUNTION = 0x80;
    public final static int OTHER = 0x100;

    //<public content>
    private String name;
    private Inflexions inflexions;
    private String pronunciation;
    private int priority;
    //</public content>

    public Word(String name, Inflexions inflexions, String pronunciation, int priority) {
        this.name = name;
        this.inflexions = inflexions;
        this.pronunciation = pronunciation;
        this.priority = priority;
    }

    /**
     * ****************************** Getters *******************************
     *
     */
    public String getName() {
        return name;
    }

    public String getTranslationsAsString() {
        return inflexions.getTranslationsAsString();
    }

    public ArrayList<String> getTranslationsAsArray() {
        ArrayList<String> res = new ArrayList<String>();
        for (Inflexion i : inflexions) {
            for (String t : i.translations) {
                res.add(t);
            }
        }
        return res;
    }

    public Inflexions getInflexions() {
        return inflexions;
    }

    public String getInflexionsAsString() {
        return inflexions.toString();
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public int getType() {
        int res = 0;
        for (Inflexion i : inflexions) {
            res |= i.type;
        }
        return res;
    }

    public int getPriority() {
        return priority;
    }

    public Word getInverse() {
        //// TODO: 06/01/2016
        return null;
    }

    /**
     * ****************************** Setters *******************************
     *
     */
    public void setInflexions(Inflexions inflexions) {
        this.inflexions = inflexions;
    }

    public void update(String name, Inflexions inflexions, String pronunciation) {
        this.name = name;
        this.inflexions = inflexions;
        this.pronunciation = pronunciation;
    }

    public void updatePriority(int priority) {
        this.priority = priority;
    }

    /**
     * ************************** Interfaces *******************************
     *
     */
    @Override
    public int compareTo(Word another) {
        return name.compareToIgnoreCase(another.name);
    }

    private static void debug(String text) {
        if (AppSettings.DEBUG) {
            System.out.println("[Word] " + text);
        }
    }

}
