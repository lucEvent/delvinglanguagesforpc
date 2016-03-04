package delvinglanguages.kernel.util;

public class Inflexion {

    public String[] inflexions;

    public String[] translations;

    public int type;

    public Inflexion(String[] inflexions, String[] translations, int type) {
        this.inflexions = inflexions;
        this.translations = translations;
        this.type = type;
    }

    /**
     * Askers
     */
    public boolean hasInflexions() {
        return inflexions.length != 0;
    }

    @Override
    public Inflexion clone() {
        return new Inflexion(inflexions.clone(), translations.clone(), type);
    }

    public String getTranslationsFormated() {
        if (translations.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(translations[0]);
        for (int i = 1; i < translations.length; i++) {
            sb.append(", ").append(translations[i]);
        }
        return sb.toString();
    }

}
