package delvinglanguages.kernel.util;

import java.util.Locale;
import delvinglanguages.settings.AppSettings;
import javax.swing.ImageIcon;

public class Language {

    private static final Character CAPS[][] = {
        /**
         * UK *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
        /**
         * US *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
        /**
         * SV *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ä', 'Ö', 'Å'},
        /**
         * FI *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ä', 'Ö', 'Å'},
        /**
         * ES *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
        /**
         * CA *
         */
        {'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}, // CA
        /**
         * BA *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
        /**
         * CZ *
         */
        {'A', 'B', 'C', 'Č', 'D', 'Ď', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ň', 'O', 'P', 'Q', 'R', 'Ř', 'S', 'Š', 'T', 'Ť', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ž'},
        /**
         * DA *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'},
        /**
         * DU *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
        /**
         * EST *
         */
        {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'Š', 'Z', 'Ž', 'T', 'U', 'V', 'Õ', 'Ä', 'Ö', 'Ü'},
        /**
         * FR *
         */
        {'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}, // CA
        /**
         * GE *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
        /**
         * GR *
         */
        {'Α', 'Β', 'Γ', 'Δ', 'Ε', 'Ζ', 'Η', 'Θ', 'Ι', 'Κ', 'Λ', 'Μ', 'Ν', 'Ξ', 'Ο', 'Π', 'Ρ', 'Σ', 'Τ', 'Υ', 'Φ', 'Χ', 'Ψ', 'Ω'},
        /**
         * IT *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'Z'},
        /**
         * NO *
         */
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'},
        /**
         * PO *
         */
        {'A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł', 'M', 'N', 'Ń', 'O', 'Ó', 'P', 'R', 'S', 'Ś', 'T', 'U', 'W', 'Y', 'Z', 'Ź', 'Ż'},
        /**
         * RU *
         */
        {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'}
    };

    private static final String[] LANGUAGE_BY_CODE = new String[]{
        "English UK", "English US", "Swedish", "Finnish", "Spanish", "Catalan",
        "Basque", "Czech", "Danish", "Dutch", "Estonian", "French", "German",
        "Greek", "Italian", "Norwegian", "Portuguese", "Russian"};

    // Language CODE
    public static final int UK = 0;
    public static final int US = 1;
    public static final int SV = 2;
    public static final int FI = 3;
    public static final int ES = 4;
    public static final int CA = 5;
    public static final int BA = 6;
    public static final int CZ = 7;
    public static final int DA = 8;
    public static final int DU = 9;
    public static final int EST = 10;
    public static final int FR = 11;
    public static final int GE = 12;
    public static final int GR = 13;
    public static final int IT = 14;
    public static final int NO = 15;
    public static final int PO = 16;
    public static final int RU = 17;

    // Setting masks
    public static final int MASK_PH = 0x1;
    public static final int MASK_ADJ = 0x2;
    public static final int MASK_ESP_CHARS = 0x4;

    private Locale locale;

    //<public content>
    public int CODE;

    public String name;
    public String native_name;
    public ImageIcon flag;

    public Words words;
    public DrawerWords drawer_words;
    //   public Tests tests;
    public Themes themes;

    public int settings;
    //</public content>

    public Language(int code, String delved_name, String native_name, int settings) {
        this.CODE = code;
        this.name = delved_name;
        this.native_name = native_name;
        this.settings = settings;
        this.flag = new ImageIcon("data/icon/" + LANGUAGE_BY_CODE[code] + ".png");
        setLocale();
    }

    private void setLocale() {
        switch (CODE) {
            case UK:
                locale = new Locale("en", "GB");
                break;
            case US:
                locale = new Locale("en", "US");
                break;
            case SV:
                locale = new Locale("sv", "SE", "SE");
                break;
            case ES:
                locale = new Locale("es", "ES", "ES");
                break;
            case FI:
                locale = new Locale("fi", "FI", "FI");
                break;
            default:
                locale = new Locale("en", "GB");
        }
    }

    /**
     * ********************** Getters ***********************
     *
     */
    public Word getWord(String searchTerm) {
        /*    Word bait = new Word(word, null, "", 0);
        Word prey = words.ceiling(bait);

        if (bait.compareTo(prey) == 0) {
            return prey;
        }
         */

        for (Word w : words) {
            if (searchTerm.equalsIgnoreCase(w.getName())) {
                return w;
            }
        }
        return null;
    }

    public boolean contains(Word word) {
        return words.contains(word);
    }

    public Character[] getDictionaryIndexes() {
        return CAPS[CODE];
    }

    public boolean getSettings(int mask) {
        boolean res;
        if ((settings & mask) != 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public Locale getLocale() {
        return locale;
    }

    /**
     * ********************** Setters ***********************
     *
     */
    public void setSettings(boolean state, int mask) {
        if (state) {
            this.settings |= mask;
        } else if ((this.settings & mask) != 0) {
            this.settings ^= mask;
        }
    }

    public static int configure(boolean phrasal, boolean adjective, boolean specialCharacters) {
        int settings = 0;
        if (phrasal) {
            settings |= MASK_PH;
        }
        if (adjective) {
            settings |= MASK_ADJ;
        }
        if (specialCharacters) {
            settings |= MASK_ESP_CHARS;
        }
        return settings;
    }

    public void updateCode(int code) {
        this.CODE = code;
        setLocale();
    }

    private void debug(String text) {
        if (AppSettings.DEBUG) {
            System.out.println("[Language] " + text);
        }
    }

}
