package delvinglanguages.settings;

import java.awt.Color;
import java.awt.Font;

public class AppSettings {

    public static final boolean DEBUG = true;

    public static final String NATIVE_NAME = "Español";

    /**
     * Fonts.
     */
    public static final String FONT_NAME = "Book Antiqua";
    public static final int FONT_SIZE_XXL = 20;
    public static final int FONT_SIZE_XL = 18;
    public static final int FONT_SIZE_BIG = 16;
    public static final int FONT_SIZE_NORMAL = 14;
    public static final int FONT_SIZE_SMALL = 12;

    public static final Font FONT_XXL_BOLD = new Font(FONT_NAME, Font.BOLD, FONT_SIZE_XXL);

    public static final Font FONT_BIG = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_BIG);
    public static final Font FONT_BIG_BOLD = new Font(FONT_NAME, Font.BOLD, FONT_SIZE_BIG);

    public static final Font FONT_NORMAL = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_NORMAL);
    public static final Font FONT_NORMAL_BOLD = new Font(FONT_NAME, Font.BOLD, FONT_SIZE_NORMAL);
    public static final Font FONT_NORMAL_ITALIC = new Font(FONT_NAME, Font.ITALIC, FONT_SIZE_NORMAL);

    public static final Font FONT_SMALL_ITALIC = new Font(FONT_NAME, Font.ITALIC, FONT_SIZE_SMALL);

    public static final Font FONT_PRONUNCIATION = new Font("Arial", Font.ITALIC, FONT_SIZE_NORMAL);

    /**
     * Colors.
     */
    public static final Color COLOR_SELECTED = new Color(0, 200, 100, 150);
    public static final Color COLOR_NOT_SELECTED = new Color(200, 200, 200, 200);

    public static final Color COLOR_BACKGROUND_DEFAULT = new Color(240, 240, 240, 255);

    public static final Color NOUN = new Color(0x0B, 0x80, 0xD6);
    public static final Color VERB = new Color(0xe7, 0x29, 0x0f);
    public static final Color ADJECTIVE = new Color(0x13, 0xb6, 0x77);
    public static final Color ADVERB = new Color(0xbe, 0x86, 0xe4);
    public static final Color PHRASAL_VERB = new Color(0x64, 0x59, 0x47);
    public static final Color EXPRESION = new Color(0x0a, 0x47, 0x37);
    public static final Color PREPOSITION = new Color(0x3c, 0x29, 0x95);
    public static final Color CONJUNTION = new Color(0xa0, 0x07, 0x4a);
    public static final Color OTHER = new Color(0xa9, 0x66, 0x01);

    public static final Color[] COLOR_TYPE = new Color[]{NOUN, VERB, ADJECTIVE,
        ADVERB, PHRASAL_VERB, EXPRESION, PREPOSITION, CONJUNTION, OTHER};

}
