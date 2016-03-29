package delvinglanguages.io;

import delvinglanguages.io.util.InStream;
import delvinglanguages.io.util.OutStream;
import delvinglanguages.kernel.util.DrawerWord;
import delvinglanguages.kernel.util.DrawerWords;
import delvinglanguages.kernel.util.Inflexion;
import delvinglanguages.kernel.util.Inflexions;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Languages;
import delvinglanguages.kernel.util.Theme;
import delvinglanguages.kernel.util.ThemePair;
import delvinglanguages.kernel.util.ThemePairs;
import delvinglanguages.kernel.util.Themes;
import delvinglanguages.kernel.util.Word;
import delvinglanguages.kernel.util.Words;
import java.io.File;

public class DataManager {

    private static final String EXTENSION = ".dl";

    private File dataFolder, wordsFolder, drawersFolder, themesFolder;

    private File index;

    public DataManager() {
        dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        wordsFolder = new File(dataFolder, "words");
        if (!wordsFolder.exists()) {
            wordsFolder.mkdir();
        }
        drawersFolder = new File(dataFolder, "drawers");
        if (!drawersFolder.exists()) {
            drawersFolder.mkdir();
        }
        themesFolder = new File(dataFolder, "themes");
        if (!themesFolder.exists()) {
            themesFolder.mkdir();
        }
        index = new File(dataFolder, "index" + EXTENSION);
    }

    public Languages readLanguages() {
        Languages res = new Languages();
        try {
            InStream in = new InStream(index);
            int nlangs = in.readInt();
            for (int i = 0; i < nlangs; i++) {
                int code = in.readInt();
                String name = in.readString();
                int settings = in.readInt();
                res.add(new Language(code, name, "", settings));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void saveLanguagesInfo(Languages languages) {
        try {
            OutStream out = new OutStream(index);
            out.writeInt(languages.size());
            for (Language language : languages) {
                out.writeInt(language.CODE);
                out.writeString(language.name);
                out.writeInt(language.settings);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveWords(String language, Words words) {
        try {
            OutStream out = new OutStream(new File(wordsFolder, language + EXTENSION));
            out.writeInt(words.size());
            for (Word word : words) {
                saveWord(out, word);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDrawerWords(String language, DrawerWords drawerwords) {
        try {
            OutStream out = new OutStream(new File(drawersFolder, language + EXTENSION));
            out.writeInt(drawerwords.size());
            for (DrawerWord word : drawerwords) {
                out.writeString(word.name);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveThemes(String language, Themes themes) {
        try {
            OutStream out = new OutStream(new File(themesFolder, language + EXTENSION));
            out.writeInt(themes.size());
            for (Theme theme : themes) {
                ThemePairs pairs = theme.pairs;
                out.writeString(theme.name);
                out.writeInt(pairs.size());
                for (ThemePair pair : pairs) {
                    out.writeString(pair.inDelved);
                    out.writeString(pair.inNative);
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Words readWords(String language) {
        Words res = new Words();
        try {
            InStream in = new InStream(new File(wordsFolder, language + EXTENSION));
            int nwords = in.readInt();
            for (int i = 0; i < nwords; i++) {
                res.add(readWord(in));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public DrawerWords readDrawerWords(String language) {
        DrawerWords drawer = new DrawerWords();
        try {
            InStream in = new InStream(new File(drawersFolder, language + EXTENSION));
            int nwords = in.readInt();
            for (int i = 0; i < nwords; i++) {
                drawer.add(new DrawerWord(in.readString()));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawer;
    }

    public Themes readThemes(String language) {
        Themes res = new Themes();
        try {
            InStream in = new InStream(new File(themesFolder, language + EXTENSION));
            int nthemes = in.readInt();
            for (int i = 0; i < nthemes; i++) {
                String themeName = in.readString();
                int npairs = in.readInt();
                ThemePairs pairs = new ThemePairs();
                for (int p = 0; p < npairs; ++p) {
                    String delv = in.readString();
                    String nativ = in.readString();
                    pairs.add(new ThemePair(delv, nativ));
                }
                res.add(new Theme(themeName, pairs));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private Word readWord(InStream in) throws Exception {
        String word = in.readString();
        String pronunciation = in.readString();
        int priority = in.readInt();
        Inflexions inflexions = new Inflexions(in.readString());
        return new Word(word, inflexions, pronunciation, priority);
    }

    private void saveWord(OutStream out, Word word) throws Exception {
        out.writeString(word.getName());
        out.writeString(word.getPronunciation());
        out.writeInt(word.getPriority());
        out.writeString(word.getInflexionsAsString());
    }

    /**
     * Only for Administrator use. It must only be called inside this class, and
     * not while the main program is running.
     */
    private void backUpFileManagement() {
        Languages languages = new Languages();
        try {
            InStream stream = new InStream(new File(dataFolder, "backup.delv"));

            int nIdiomas = stream.readInt();
            for (int i = 0; i < nIdiomas; i++) {    // Por cada idioma
                int Lcode = stream.readInt();
                String Lname = stream.readString();
                int Lsettings = stream.readInt();
                Language language = new Language(Lcode, Lname, "", Lsettings);
                System.out.println("[Adding Language] " + Lname);
                // Statistics
                stream.readInt();
                stream.readInt();
                stream.readInt();
                stream.readInt();
                stream.readInt();

                //Words
                int debW = 0;
                int nWords = stream.readInt();
                Words words = new Words();
                for (int j = 0; j < nWords; j++) {   // For each WORD of the language
                    Word word = readWord(stream);
                    boolean added = words.add(word);
                    if (!added) {
                        System.out.println(" [Can't add] " + word.getName());
                    }
                    debW++;
                }
                System.out.println("Words added = " + debW + " ó " + words.size());

                //DrawerWords
                int nDrawerWords = stream.readInt();
                DrawerWords drawer = new DrawerWords();
                for (int j = 0; j < nDrawerWords; j++) {    // For each entry of warehouse
                    String note = stream.readString();
                    drawer.add(new DrawerWord(note));
                }

                //Themes
                int nThemes = stream.readInt();
                Themes themes = new Themes();
                for (int j = 0; j < nThemes; j++) { // Por cada theme
                    String thName = stream.readString();
                    ThemePairs thPairs = new ThemePairs();
                    int nthPairs = stream.readInt();
                    for (int k = 0; k < nthPairs; k++) {
                        String thpDelv = stream.readString();
                        String thpNatv = stream.readString();
                        thPairs.add(new ThemePair(thpDelv, thpNatv));
                    }
                    themes.add(new Theme(thName, thPairs));
                }

                int nTests = stream.readInt();
                for (int j = 0; j < nTests; j++) {  // Por cada Test
                    String tName = stream.readString();
                    String tContent = stream.readString();
                }

                language.words = words;
                language.drawer_words = drawer;
                language.themes = themes;
                languages.add(language);
            }
            stream.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString() + "\n\n");
            e.printStackTrace();
            return;
        }

        saveLanguagesInfo(languages);
        for (Language language : languages) {
            saveWords(language.name, language.words);
            saveDrawerWords(language.name, language.drawer_words);
            saveThemes(language.name, language.themes);
        }
    }

    public static void main(String[] args) {
        DataManager dm = new DataManager();
        dm.backUpFileManagement();
    }

    public void export(Languages languages) {
        try {
            OutStream stream = new OutStream(new File(dataFolder, "backup.delv"));

            stream.writeInt(languages.size());  //Num of languages

            for (Language language : languages) {
                stream.writeInt(language.CODE);
                stream.writeString(language.name);
                stream.writeInt(language.settings);

                // Statistics
                stream.writeInt(0);
                stream.writeInt(0);
                stream.writeInt(0);
                stream.writeInt(0);
                stream.writeInt(0);

                //Words
                int debW = 0;
                Words words = readWords(language.name);
                stream.writeInt(words.size());
                for (Word word : words) {
                    debW++;
                    saveWord(stream, word);
                }
                System.out.println("Size: " + words.size() + ", saved:" + debW);

                //Drawer words
                DrawerWords drawer = readDrawerWords(language.name);
                stream.writeInt(drawer.size());
                System.out.println("Drawer size = " + drawer.size());
                for (DrawerWord dw : drawer) {
                    stream.writeString(dw.name);
                }

                //Themes
                Themes themes = readThemes(language.name);
                stream.writeInt(themes.size());
                for (Theme theme : themes) {
                    stream.writeString(theme.name);
                    stream.writeInt(theme.pairs.size());
                    for (ThemePair pair : theme.pairs) {
                        stream.writeString(pair.inDelved);
                        stream.writeString(pair.inNative);
                    }
                }

                //Tests
                stream.writeInt(0);
            }

            stream.close();
        } catch (Exception e) {
            System.out.println("Error during backup [" + e.getMessage() + "]");
            e.printStackTrace();
            return;
        }
        System.out.println("Export done successfully");
    }

}
