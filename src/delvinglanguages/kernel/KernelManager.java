package delvinglanguages.kernel;

import delvinglanguages.io.DataManager;
import delvinglanguages.kernel.util.DrawerWord;
import delvinglanguages.kernel.util.DrawerWords;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Languages;
import delvinglanguages.kernel.util.Theme;
import delvinglanguages.kernel.util.Themes;
import delvinglanguages.kernel.util.Word;
import delvinglanguages.kernel.util.Words;
import delvinglanguages.settings.AppSettings;

public class KernelManager {

    private static DataManager data;

    private static Languages languages;

    public KernelManager() {
        if (data == null) {
            data = new DataManager();
        }
    }

    public Languages getLanguages() {
        if (languages == null) {
            languages = data.readLanguages();
        }
        return languages;
    }

    public Words getWordsOf(Language language) {
        if (language.words == null) {
            language.words = data.readWords(language.name);
        }
        return language.words;
    }

    public DrawerWords getDrawerWordsOf(Language language) {
        if (language.drawer_words == null) {
            language.drawer_words = data.readDrawerWords(language.name);
        }
        return language.drawer_words;
    }

    public Themes getThemesOf(Language language) {
        if (language.themes == null) {
            language.themes = data.readThemes(language.name);
        }
        return language.themes;
    }

    public void addLanguage(int code, String langName, int settings) {
        Language newLang = new Language(code, langName, AppSettings.NATIVE_NAME, settings);

        languages.add(newLang);
        data.saveLanguagesInfo(languages);

        newLang.words = new Words();
        data.saveWords(langName, newLang.words);

        newLang.drawer_words = new DrawerWords();
        data.saveDrawerWords(langName, newLang.drawer_words);

        newLang.themes = new Themes();
        data.saveThemes(langName, newLang.themes);
    }

    public void addDrawerWord(Language language, String dword) {
        language.drawer_words.add(new DrawerWord(dword));
        data.saveDrawerWords(language.name, language.drawer_words);
    }

    public void addWord(Language language, Word word) {
        language.words.add(word);
        data.saveWords(language.name, language.words);
    }

    public void addWord(Language language, Word word, DrawerWord drawerword) {
        addWord(language, word);
        if (language.drawer_words.remove(drawerword)) {
            data.saveDrawerWords(language.name, language.drawer_words);
        }
    }

    public void editWord(Language language, Word replacement, Word old) {
        language.words.remove(old);
        addWord(language, replacement);
    }

    public void addTheme(Language language, Theme theme) {
        language.themes.add(theme);
        data.saveThemes(language.name, language.themes);
    }

    public void editTheme(Language language, Theme theme, Theme tempTheme) {
        language.themes.remove(tempTheme);
        addTheme(language, theme);
    }

    public void deleteLanguage(Language language) {
        if (languages.remove(language)) {
            data.saveLanguagesInfo(languages);
        }
    }

    public void deleteWord(Language language, Word word) {
        if (language.words.remove(word)) {
            data.saveWords(language.name, language.words);
        }
    }

    public void deleteDrawerWord(Language language, DrawerWord drawerWord) {
        if (language.drawer_words.remove(drawerWord)) {
            data.saveDrawerWords(language.name, language.drawer_words);
        }
    }

    public void deleteTheme(Language language, Theme theme) {
        if (language.themes.remove(theme)) {
            data.saveThemes(language.name, language.themes);
        }
    }

    public void exportAll() {
        data.export(getLanguages());
    }

    public void export(Language language) {
        Languages languages = new Languages();
        languages.add(language);
        data.export(languages);
    }

}
