package delvinglanguages.kernel.util;

import java.util.ArrayList;

public class Inflexions extends ArrayList<Inflexion> {

    private static final String SEP = "%I";

    public Inflexions() {
        super();
    }

    public Inflexions(int size) {
        super(size);
    }

    public Inflexions(String wrapper) {
        super();
        String[] parts = wrapper.split(SEP);

        int index = 1;
        int num = Integer.parseInt(parts[0]);
        for (int i = 0; i < num; i++) {
            int nInfs = Integer.parseInt(parts[index++]);
            String[] inflexions = new String[nInfs];
            for (int j = 0; j < nInfs; j++) {
                inflexions[j] = parts[index++];
            }

            int nTrans = Integer.parseInt(parts[index++]);
            String[] translations = new String[nTrans];
            for (int j = 0; j < nTrans; j++) {
                translations[j] = parts[index++];
            }

            int type = Integer.parseInt(parts[index++]);

            this.add(new Inflexion(inflexions, translations, type));
        }
    }

    public Inflexions(ArrayList<Inflexion> value) {
        super(value);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder().append(this.size());

        for (Inflexion inf : this) {

            res.append(SEP).append(inf.inflexions.length);
            for (String s : inf.inflexions) {
                res.append(SEP).append(s);
            }

            res.append(SEP).append(inf.translations.length);
            for (String s : inf.translations) {
                res.append(SEP).append(s);
            }

            res.append(SEP).append(inf.type);
        }
        return res.toString();
    }

    public String getTranslationsAsString() {
        StringBuilder res = new StringBuilder();
        boolean first = true;
        for (Inflexion i : this) {
            for (String t : i.translations) {
                if (!first) {
                    res.append(", ").append(t);
                } else {
                    res.append(t);
                    first = false;
                }
            }
        }
        return res.toString();
    }

    @Override
    public Inflexions clone() {
        Inflexions clone = new Inflexions(this.size());
        for (Inflexion inflexion : this) {
            clone.add(inflexion.clone());
        }
        return clone;
    }

}
