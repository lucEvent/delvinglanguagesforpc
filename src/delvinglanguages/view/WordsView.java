package delvinglanguages.view;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.Inflexion;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Word;
import delvinglanguages.kernel.util.Words;
import delvinglanguages.settings.AppSettings;
import delvinglanguages.util.DLHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class WordsView extends javax.swing.JPanel implements DLHandler {

    private DLHandler handler;

    private KernelManager data;
    private Language currentLanguage;
    public Words words;

    public WordsView(DLHandler handler) {
        initComponents();

        btype = new JLabel[]{btypeNN, btypeVB, btypeADJ, btypeADV, btypePHV,
            btypeEXP, btypePREP, btypeCONJ, btypeOTH};

        data = new KernelManager();

        this.handler = handler;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        javax.swing.JScrollPane wordListScrollPane = new javax.swing.JScrollPane();
        wordList = new javax.swing.JList<>();
        addWord = new javax.swing.JButton();
        searchWord = new javax.swing.JTextField();
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        wordName = new javax.swing.JLabel();
        wordPronuntiation = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        inflexionList = new javax.swing.JList<>();
        removeWord = new javax.swing.JButton();
        editWord = new javax.swing.JButton();
        btypeNN = new javax.swing.JLabel();
        btypeVB = new javax.swing.JLabel();
        btypeADJ = new javax.swing.JLabel();
        btypeADV = new javax.swing.JLabel();
        btypePHV = new javax.swing.JLabel();
        btypeEXP = new javax.swing.JLabel();
        btypePREP = new javax.swing.JLabel();
        btypeCONJ = new javax.swing.JLabel();
        btypeOTH = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        wordListScrollPane.setPreferredSize(new java.awt.Dimension(258, 147));

        wordList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        wordList.setCellRenderer(wordListRenderer);
        wordList.setMaximumSize(new java.awt.Dimension(258, 0));
        wordList.setMinimumSize(new java.awt.Dimension(258, 0));
        wordList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wordListMouseClicked(evt);
            }
        });
        wordList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wordListKeyReleased(evt);
            }
        });
        wordListScrollPane.setViewportView(wordList);

        addWord.setFont(AppSettings.FONT_NORMAL);
        addWord.setText("Add word");
        addWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWordActionPerformed(evt);
            }
        });

        searchWord.setFont(AppSettings.FONT_NORMAL);
        searchWord.setToolTipText("Search word");
        searchWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchWordKeyReleased(evt);
            }
        });

        contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        wordName.setFont(AppSettings.FONT_BIG_BOLD);
        wordName.setText("Word name");
        wordName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        wordPronuntiation.setFont(AppSettings.FONT_PRONUNCIATION);
        wordPronuntiation.setText("Pronuntiation");
        wordPronuntiation.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        inflexionList.setBackground(new java.awt.Color(240, 240, 240));
        inflexionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inflexionList.setCellRenderer(inflexionListRenderer);
        jScrollPane1.setViewportView(inflexionList);

        removeWord.setText("Remove word");
        removeWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeWordActionPerformed(evt);
            }
        });

        editWord.setText("Edit Word");
        editWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWordActionPerformed(evt);
            }
        });

        btypeNN.setFont(AppSettings.FONT_NORMAL);
        btypeNN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeNN.setText("NN");
        btypeNN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeNN.setOpaque(true);

        btypeVB.setFont(AppSettings.FONT_NORMAL);
        btypeVB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeVB.setText("VB");
        btypeVB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeVB.setOpaque(true);

        btypeADJ.setFont(AppSettings.FONT_NORMAL);
        btypeADJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeADJ.setText("ADJ");
        btypeADJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeADJ.setOpaque(true);

        btypeADV.setFont(AppSettings.FONT_NORMAL);
        btypeADV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeADV.setText("ADV");
        btypeADV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeADV.setOpaque(true);

        btypePHV.setFont(AppSettings.FONT_NORMAL);
        btypePHV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypePHV.setText("PHV");
        btypePHV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypePHV.setOpaque(true);

        btypeEXP.setFont(AppSettings.FONT_NORMAL);
        btypeEXP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeEXP.setText("EXP");
        btypeEXP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeEXP.setOpaque(true);

        btypePREP.setFont(AppSettings.FONT_NORMAL);
        btypePREP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypePREP.setText("PREP");
        btypePREP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypePREP.setOpaque(true);

        btypeCONJ.setFont(AppSettings.FONT_NORMAL);
        btypeCONJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeCONJ.setText("CONJ");
        btypeCONJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeCONJ.setOpaque(true);

        btypeOTH.setFont(AppSettings.FONT_NORMAL);
        btypeOTH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btypeOTH.setText("OTH");
        btypeOTH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btypeOTH.setMaximumSize(new java.awt.Dimension(59, 23));
        btypeOTH.setMinimumSize(new java.awt.Dimension(59, 23));
        btypeOTH.setOpaque(true);
        btypeOTH.setPreferredSize(new java.awt.Dimension(59, 23));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(btypeNN, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypeVB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypeADJ, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypeADV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypePHV, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypeEXP, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypePREP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypeCONJ, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btypeOTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wordName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wordPronuntiation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(editWord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeWord)))))
                .addContainerGap())
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editWord, removeWord});

        contentPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btypeADJ, btypeADV, btypeCONJ, btypeEXP, btypeNN, btypeOTH, btypePHV, btypePREP, btypeVB});

        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btypeNN)
                    .addComponent(btypeVB)
                    .addComponent(btypeADJ)
                    .addComponent(btypeADV)
                    .addComponent(btypePHV)
                    .addComponent(btypeEXP)
                    .addComponent(btypePREP)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btypeCONJ)
                        .addComponent(btypeOTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordPronuntiation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeWord)
                    .addComponent(editWord))
                .addContainerGap())
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {editWord, removeWord});

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btypeADJ, btypeADV, btypeCONJ, btypeEXP, btypeNN, btypeOTH, btypePHV, btypePREP, btypeVB});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchWord)
                    .addComponent(wordListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wordListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addWord))
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void wordListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wordListKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            displayWord(wordList.getSelectedIndex());
        }
    }//GEN-LAST:event_wordListKeyReleased

    private void wordListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wordListMouseClicked
        if (evt.getClickCount() > 1 && evt.getButton() == MouseEvent.BUTTON1) {
            displayWord(wordList.locationToIndex(evt.getPoint()));
        }
    }//GEN-LAST:event_wordListMouseClicked

    private void addWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWordActionPerformed
        new WordEditFrame(currentLanguage, this).setVisible(true);
    }//GEN-LAST:event_addWordActionPerformed

    private void searchWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchWordKeyReleased
        String search = this.searchWord.getText().toLowerCase();
        Words words = data.getWordsOf(currentLanguage);
        if (search.isEmpty()) {
            displayWordList(words);
            return;
        }
        Words matches = new Words();
        for (Word w : words) {
            if (w.getName().toLowerCase().contains(search)) {
                matches.add(w);
            }
        }
        System.out.println("Found [" + matches.size() + "] containing [" + search + "]");
        displayWordList(matches);
    }//GEN-LAST:event_searchWordKeyReleased

    private void editWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWordActionPerformed
        if (currentWord != null) {
            new WordEditFrame(currentWord, currentLanguage, this).setVisible(true);
        }
    }//GEN-LAST:event_editWordActionPerformed

    private void removeWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeWordActionPerformed
        if (currentWord != null) {
            new ConfirmActionFrame(ConfirmActionFrame.DELETE_WORD, this, currentLanguage, currentWord).setVisible(true);
        }
    }//GEN-LAST:event_removeWordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWord;
    private javax.swing.JLabel btypeADJ;
    private javax.swing.JLabel btypeADV;
    private javax.swing.JLabel btypeCONJ;
    private javax.swing.JLabel btypeEXP;
    private javax.swing.JLabel btypeNN;
    private javax.swing.JLabel btypeOTH;
    private javax.swing.JLabel btypePHV;
    private javax.swing.JLabel btypePREP;
    private javax.swing.JLabel btypeVB;
    private javax.swing.JButton editWord;
    private javax.swing.JList<Inflexion> inflexionList;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeWord;
    private javax.swing.JTextField searchWord;
    private javax.swing.JList<Word> wordList;
    private javax.swing.JLabel wordName;
    private javax.swing.JLabel wordPronuntiation;
    // End of variables declaration//GEN-END:variables

    private Word currentWord;

    public void setLanguage(Language language) {
        if (language != currentLanguage) {
            currentLanguage = language;
            currentWord = null;
        }
        searchWordKeyReleased(null);
//        displayWordList(data.getWordsOf(language));

        //debug
        boolean debug = false;
        if (debug) {
            int[] typecounter = new int[btype.length];

            for (Word w : data.getWordsOf(language)) {
                int wtype = w.getType();
                for (int i = 0; i < typecounter.length; i++) {
                    if (((wtype >> i) & 0x1) == 1) {
                        typecounter[i]++;
                    }
                }
            }
            System.out.println("######################");
            System.out.println(" Nouns: " + typecounter[0]);
            System.out.println(" Verbs: " + typecounter[1]);
            System.out.println(" Adjcs: " + typecounter[2]);
            System.out.println(" Advbs: " + typecounter[3]);
            System.out.println(" Ph.Vs: " + typecounter[4]);
            System.out.println(" Exprs: " + typecounter[5]);
            System.out.println(" Preps: " + typecounter[6]);
            System.out.println(" Conjs: " + typecounter[7]);
            System.out.println(" Othrs: " + typecounter[8]);
            System.out.println("######################");
        }
        //end debug
    }

//<editor-fold defaultstate="collapsed" desc="-> Displays <-">
    private JLabel btype[];

    private void displayWordList(Words words) {
        this.words = words;
        DefaultListModel m = new DefaultListModel();
        for (Word w : words) {
            m.addElement(w);
        }
        wordList.setModel(m);
    }

    private void displayWord(int index) {
        displayWord(index == -1 ? null : words.get(index));
    }

    private void displayWord(Word word) {
        if (word == null) {
            currentWord = null;
            wordName.setText("");
            wordPronuntiation.setText("");
            displayType(0);
            inflexionList.setModel(new DefaultListModel());
        } else {
            currentWord = word;

            wordName.setText(currentWord.getName());
            wordPronuntiation.setText("[" + currentWord.getPronunciation() + "]");
            displayType(currentWord.getType());

            DefaultListModel m = new DefaultListModel();
            for (Inflexion i : currentWord.getInflexions()) {
                m.addElement(i);
            }
            inflexionList.setModel(m);
        }
    }

    private void displayType(int type) {
        System.out.println("Type:" + type);
        for (int i = 0; i < btype.length; i++) {
            if (((type >> i) & 0x1) == 1) {
                System.out.println("Setting color with type:" + Integer.toHexString((type >> i) & 0x1));
                btype[i].setBackground(AppSettings.COLOR_TYPE[i]);
            } else {
                btype[i].setBackground(AppSettings.COLOR_BACKGROUND_DEFAULT);
            }
            //  btype[i].repaint();
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="-> List Renderers <-">
    private ListCellRenderer<Word> wordListRenderer = new ListCellRenderer<Word>() {

        @Override
        public Component getListCellRendererComponent(JList list, Word value,
                int index, boolean isSelected, boolean cellHasFocus) {

            JLabel res = new JLabel((index + 1) + " " + value.getName());
            res.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            res.setOpaque(true);
            if (isSelected) {
                res.setFont(AppSettings.FONT_NORMAL_BOLD);
                res.setBackground(AppSettings.COLOR_SELECTED);
                res.setForeground(Color.BLACK);
            } else {
                res.setFont(AppSettings.FONT_NORMAL);
                res.setBackground(AppSettings.COLOR_NOT_SELECTED);
                switch (value.getType()) {
                    case Word.NOUN:
                        res.setBackground(AppSettings.NOUN);
                        break;
                    case Word.VERB:
                        res.setBackground(AppSettings.VERB);
                        break;
                    case Word.ADJECTIVE:
                        res.setBackground(AppSettings.ADJECTIVE);
                        break;
                    case Word.ADVERB:
                        res.setBackground(AppSettings.ADVERB);
                        break;
                    case Word.PHRASAL_VERB:
                        res.setBackground(AppSettings.PHRASAL_VERB);
                        break;
                    case Word.EXPRESION:
                        res.setBackground(AppSettings.EXPRESION);
                        break;
                    case Word.PREPOSITION:
                        res.setBackground(AppSettings.PREPOSITION);
                        break;
                    case Word.CONJUNTION:
                        res.setBackground(AppSettings.CONJUNTION);
                        break;
                    default:
                        res.setBackground(AppSettings.OTHER);
                }
                res.setForeground(Color.BLACK);
            }
            return res;
        }
    };

    private ListCellRenderer<Inflexion> inflexionListRenderer = new ListCellRenderer<Inflexion>() {
        @Override
        public Component getListCellRendererComponent(JList list, Inflexion value,
                int index, boolean isSelected, boolean cellHasFocus) {
            return new InflexionListView(value, isSelected);
        }
    };
//</editor-fold>

    @Override
    public void reportChange(int change, Object obj) {
        switch (change) {
            case DLHandler.MODIFIED_WORD:
                System.out.println("Getting report of modified word");
                displayWord((Word) obj);
                break;
            case DLHandler.DELETED_WORD:
                displayWord(-1);
        }
        handler.reportChange(change, data);
    }

}
