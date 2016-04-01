package delvinglanguages.util;

public interface DLHandler {

    int ADDED_LANGUAGE = 0;
    int ADDED_WORD = 1;
    int ADDED_DRAWER = 2;
    int ADDED_THEME = 3;

    int MODIFIED_LANGUAGE = 4;
    int MODIFIED_WORD = 5;
    int MODIFIED_DRAWER = 6;
    int MODIFIED_THEME = 7;

    int DELETED_LANGUAGE = 8;
    int DELETED_WORD = 9;
    int DELETED_DRAWER = 10;
    int DELETED_THEME = 11;

    void reportChange(int change, Object obj);

}
