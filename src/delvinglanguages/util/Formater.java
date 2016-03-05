package delvinglanguages.util;

import java.util.ArrayList;

public class Formater {
    
    public static String[] format(String string) {
        ArrayList<String> list = new ArrayList<>();

        int indi = 0, caps = 0;
        int indf;
        for (indf = 0; indf < string.length(); ++indf) {
            char car = string.charAt(indf);

            switch (car) {
                case ',':
                    if (caps > 0) {
                        continue;
                    }
                    list.add(string.substring(indi, indf));
                    indi = indf + 1;
                    break;
                case '(':
                case '[':
                case '{':
                    caps++;
                    break;
                case ')':
                case ']':
                case '}':
                    caps--;
                    break;
            }
        }
        if (caps == 0) {
            list.add(string.substring(indi, indf));
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            String temp = list.get(i).trim();
            res[i] = Character.toUpperCase(temp.charAt(0)) + temp.substring(1);
        }
        return res;
    }
    
}
