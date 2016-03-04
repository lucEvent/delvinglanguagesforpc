package delvinglanguages.kernel.util;

public class ThemePair implements Comparable<ThemePair> {

    public String inDelved;
    public String inNative;

    public ThemePair(String delved, String nativ) {
        this.inDelved = delved;
        this.inNative = nativ;
    }

    @Override
    public int compareTo(ThemePair o) {
        int res = inDelved.compareTo(o.inDelved);
        return res == 0 ? inNative.compareTo(o.inNative) : res;
    }

}
