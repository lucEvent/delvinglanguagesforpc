package delvinglanguages.view;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.DrawerWord;
import delvinglanguages.kernel.util.Inflexion;
import delvinglanguages.kernel.util.Inflexions;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Word;
import delvinglanguages.settings.AppSettings;
import delvinglanguages.util.DLHandler;
import delvinglanguages.util.Formater;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

public class WordEditFrame extends JFrame {

    private static final String[] LAB_NN = {"Sg. indefinite:", "Sg. definite:", "Pl. indefinite:", "Pl. definite:", ""};
    private static final String[] LAB_VB = {"Imperativ:", "Infinitiv:", "Presens:", "Preteritum:", "Supinum:"};
    private static final String[] LAB_ADJ = {"Sg. indefinite:", "Sg. indefinite -t:", "Plural:", "Comparativ:", "Superlativ:"};
    private static final String[] LAB_OTH = {"Form 1:", "Form 2:", "Form 3:", "Form 4:", "Form 5:"};

    private static enum Purpose {
        EDIT, ADD_NEW, ADD_FROM_DRAWER
    };

    private class EditData {

        Word editword;
        DrawerWord drawerword;
        Inflexions inflexionscopy;
        Inflexion inflexionModifying;
    }

    private JLabel l_tit[], l_type[];
    private JTextField in_inf[];
    private JCheckBox checks[];

    private final Purpose purpose;
    private EditData tempData;

    private DLHandler handler;
    private Language currentLanguage;

    public WordEditFrame(Language language, DLHandler handler) {
        init("", language, handler);
        this.purpose = Purpose.ADD_NEW;
        setTitle("Add New Word");
    }

    public WordEditFrame(DrawerWord word, Language language, DLHandler handler) {
        init(word.name, language, handler);
        this.purpose = Purpose.ADD_FROM_DRAWER;
        this.tempData.drawerword = word;

        try {
            String searchword = word.name.toLowerCase().replace(" ", "%20");
            if (language.CODE == Language.SV) {

                java.awt.Desktop.getDesktop().browse(new URI("http://ordbok.woxikon.se/sv-es/" + searchword));
                java.awt.Desktop.getDesktop().browse(new URI("https://translate.google.com/#sv/en/" + searchword));
                java.awt.Desktop.getDesktop().browse(new URI("http://folkets-lexikon.csc.kth.se/folkets/#lookup&" + searchword));
                searchword = word.name.toLowerCase().replace(" ", "_");
                java.awt.Desktop.getDesktop().browse(new URI("http://sv.wiktionary.org/wiki/" + searchword));

            } else if (language.CODE == Language.US || language.CODE == Language.UK) {

                java.awt.Desktop.getDesktop().browse(new URI("http://www.wordreference.com/es/translation.asp?tranword=" + searchword));
                //       java.awt.Desktop.getDesktop().browse(new URI("https://translate.google.com/#en/es/" + searchword));
                java.awt.Desktop.getDesktop().browse(new URI("http://dictionary.cambridge.org/dictionary/english-spanish/" + searchword));

            }
        } catch (Exception ex) {
            System.out.println("Error abriendo pagina con: " + word);
            ex.printStackTrace();
        }
    }

    public WordEditFrame(Word word, Language language, DLHandler handler) {
        init(word.getName(), language, handler);
        this.purpose = Purpose.EDIT;
        this.tempData.editword = word;
        this.tempData.inflexionscopy = (Inflexions) word.getInflexions().clone();

        this.inPronuntiation.setText(word.getPronunciation());
        displayInflexionsList();
    }

    public final void init(String word, Language language, DLHandler handler) {
        initComponents();

        this.handler = handler;
        this.currentLanguage = language;

        inflexionsList.setCellRenderer(inflexionsListRenderer);

        l_type = new JLabel[]{lb_noun, lb_verb, lb_adj, lb_adv, lb_phv, lb_exp, lb_prep, lb_conj, lb_oth};
        l_tit = new JLabel[]{lab_1, lab_2, lab_3, lab_4, lab_5};
        in_inf = new JTextField[]{input_1, input_2, input_3, input_4, input_5};
        checks = new JCheckBox[]{check_1, check_2, check_3, check_4, check_5};

        lb_noun.setBackground(AppSettings.NOUN);
        lb_verb.setBackground(AppSettings.VERB);
        lb_adj.setBackground(AppSettings.ADJECTIVE);
        lb_adv.setBackground(AppSettings.ADVERB);
        lb_phv.setBackground(AppSettings.PHRASAL_VERB);
        lb_exp.setBackground(AppSettings.EXPRESION);
        lb_prep.setBackground(AppSettings.PREPOSITION);
        lb_conj.setBackground(AppSettings.CONJUNTION);
        lb_oth.setBackground(AppSettings.OTHER);

        setTitle(word);
        this.inWord.setText(word);

        tempData = new EditData();
        tempData.inflexionscopy = new Inflexions();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inWord = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        input_1 = new javax.swing.JTextField();
        input_2 = new javax.swing.JTextField();
        lb_phv = new javax.swing.JLabel();
        lab_4 = new javax.swing.JLabel();
        input_4 = new javax.swing.JTextField();
        lb_adj = new javax.swing.JLabel();
        input_3 = new javax.swing.JTextField();
        lab_2 = new javax.swing.JLabel();
        lab_3 = new javax.swing.JLabel();
        input_5 = new javax.swing.JTextField();
        lab_1 = new javax.swing.JLabel();
        lb_oth = new javax.swing.JLabel();
        lb_exp = new javax.swing.JLabel();
        lab_5 = new javax.swing.JLabel();
        inTranslation = new javax.swing.JTextField();
        lb_verb = new javax.swing.JLabel();
        lb_noun = new javax.swing.JLabel();
        lb_adv = new javax.swing.JLabel();
        check_1 = new javax.swing.JCheckBox();
        check_2 = new javax.swing.JCheckBox();
        check_3 = new javax.swing.JCheckBox();
        check_4 = new javax.swing.JCheckBox();
        check_5 = new javax.swing.JCheckBox();
        javax.swing.JButton addInflexion = new javax.swing.JButton();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        lb_prep = new javax.swing.JLabel();
        lb_conj = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        inflexionsList = new javax.swing.JList<>();
        inPronuntiation = new javax.swing.JTextField();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JPanel sep = new javax.swing.JPanel();
        reportBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        inWord.setFont(AppSettings.FONT_NORMAL);
        inWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inWord.setMaximumSize(new java.awt.Dimension(1000, 30));
        inWord.setMinimumSize(new java.awt.Dimension(100, 30));
        inWord.setNextFocusableComponent(inPronuntiation);
        inWord.setPreferredSize(new java.awt.Dimension(0, 30));

        save.setFont(AppSettings.FONT_NORMAL);
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setFont(AppSettings.FONT_NORMAL);
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 0)));

        input_1.setFont(AppSettings.FONT_NORMAL);
        input_1.setMaximumSize(new java.awt.Dimension(1000, 30));
        input_1.setMinimumSize(new java.awt.Dimension(100, 30));
        input_1.setNextFocusableComponent(input_2);
        input_1.setPreferredSize(new java.awt.Dimension(0, 30));

        input_2.setFont(AppSettings.FONT_NORMAL);
        input_2.setMaximumSize(new java.awt.Dimension(1000, 30));
        input_2.setMinimumSize(new java.awt.Dimension(100, 30));
        input_2.setNextFocusableComponent(input_3);
        input_2.setPreferredSize(new java.awt.Dimension(0, 30));

        lb_phv.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_phv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_phv.setText("Phv");
        lb_phv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_phv.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_phv.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_phv.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_phv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        lab_4.setFont(AppSettings.FONT_NORMAL_BOLD);

        input_4.setFont(AppSettings.FONT_NORMAL);
        input_4.setMaximumSize(new java.awt.Dimension(1000, 30));
        input_4.setMinimumSize(new java.awt.Dimension(100, 30));
        input_4.setNextFocusableComponent(input_5);
        input_4.setPreferredSize(new java.awt.Dimension(0, 30));

        lb_adj.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_adj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_adj.setText("Adj");
        lb_adj.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_adj.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_adj.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_adj.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_adj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        input_3.setFont(AppSettings.FONT_NORMAL);
        input_3.setMaximumSize(new java.awt.Dimension(1000, 30));
        input_3.setMinimumSize(new java.awt.Dimension(100, 30));
        input_3.setNextFocusableComponent(input_4);
        input_3.setPreferredSize(new java.awt.Dimension(0, 30));

        lab_2.setFont(AppSettings.FONT_NORMAL_BOLD);

        lab_3.setFont(AppSettings.FONT_NORMAL_BOLD);

        input_5.setFont(AppSettings.FONT_NORMAL);
        input_5.setMaximumSize(new java.awt.Dimension(1000, 30));
        input_5.setMinimumSize(new java.awt.Dimension(100, 30));
        input_5.setNextFocusableComponent(inTranslation);
        input_5.setPreferredSize(new java.awt.Dimension(0, 30));

        lab_1.setFont(AppSettings.FONT_NORMAL_BOLD);

        lb_oth.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_oth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_oth.setText("Oth");
        lb_oth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_oth.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_oth.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_oth.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_oth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        lb_exp.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_exp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exp.setText("Exp");
        lb_exp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_exp.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_exp.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_exp.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_exp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        lab_5.setFont(AppSettings.FONT_NORMAL_BOLD);

        inTranslation.setFont(AppSettings.FONT_NORMAL);
        inTranslation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inTranslation.setMaximumSize(new java.awt.Dimension(1000, 30));
        inTranslation.setMinimumSize(new java.awt.Dimension(100, 30));
        inTranslation.setNextFocusableComponent(input_1);
        inTranslation.setPreferredSize(new java.awt.Dimension(0, 30));

        lb_verb.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_verb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_verb.setText("Vb");
        lb_verb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_verb.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_verb.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_verb.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_verb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        lb_noun.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_noun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_noun.setText("Nn");
        lb_noun.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_noun.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_noun.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_noun.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_noun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        lb_adv.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_adv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_adv.setText("Adv");
        lb_adv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_adv.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_adv.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_adv.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_adv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        addInflexion.setFont(AppSettings.FONT_NORMAL);
        addInflexion.setText("Add");
        addInflexion.setMaximumSize(new java.awt.Dimension(51, 30));
        addInflexion.setMinimumSize(new java.awt.Dimension(51, 30));
        addInflexion.setPreferredSize(new java.awt.Dimension(51, 30));
        addInflexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInflexionActionPerformed(evt);
            }
        });

        jLabel4.setFont(AppSettings.FONT_NORMAL_BOLD);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Inflexion");

        lb_prep.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_prep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_prep.setText("Prep");
        lb_prep.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_prep.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_prep.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_prep.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_prep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        lb_conj.setFont(AppSettings.FONT_NORMAL_BOLD);
        lb_conj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_conj.setText("Conj");
        lb_conj.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lb_conj.setMaximumSize(new java.awt.Dimension(40, 28));
        lb_conj.setMinimumSize(new java.awt.Dimension(40, 28));
        lb_conj.setPreferredSize(new java.awt.Dimension(40, 28));
        lb_conj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTypeSelected(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lab_3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lb_noun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_verb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_adj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_adv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_phv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_prep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lb_conj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_oth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lab_5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(input_5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lab_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lab_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(input_1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(input_2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lab_4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(input_4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check_1)
                            .addComponent(check_2)
                            .addComponent(check_3)
                            .addComponent(check_4)
                            .addComponent(check_5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addInflexion, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inTranslation, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inTranslation, jLabel4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lb_adj, lb_adv, lb_conj, lb_exp, lb_noun, lb_oth, lb_phv, lb_prep, lb_verb});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lab_1, lab_2, lab_3, lab_4, lab_5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {input_1, input_2, input_3, input_4, input_5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inTranslation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_noun, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_adj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_adv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_phv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_oth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_verb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_prep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_conj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(input_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check_1)
                    .addComponent(lab_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addInflexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_1, input_1});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_2, input_2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_3, input_3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_4, input_4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_5, input_5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inTranslation, jLabel4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lb_adj, lb_adv, lb_conj, lb_exp, lb_noun, lb_oth, lb_phv, lb_prep, lb_verb});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lab_1, lab_2, lab_3, lab_4, lab_5});

        inflexionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inflexionsList.setToolTipText("");
        inflexionsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inflexionsListMouseClicked(evt);
            }
        });
        inflexionsList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inflexionsListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(inflexionsList);

        inPronuntiation.setFont(AppSettings.FONT_PRONUNCIATION);
        inPronuntiation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inPronuntiation.setMaximumSize(new java.awt.Dimension(1000, 30));
        inPronuntiation.setMinimumSize(new java.awt.Dimension(100, 30));
        inPronuntiation.setNextFocusableComponent(inTranslation);
        inPronuntiation.setPreferredSize(new java.awt.Dimension(0, 30));

        jLabel1.setFont(AppSettings.FONT_NORMAL_BOLD);
        jLabel1.setText("Word:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel2.setFont(AppSettings.FONT_NORMAL_BOLD);
        jLabel2.setText("Pronuntiation:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(AppSettings.FONT_NORMAL_BOLD);
        jLabel3.setText("Inflexions:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        sep.setBackground(new java.awt.Color(0, 0, 0));
        sep.setMaximumSize(new java.awt.Dimension(1, 0));
        sep.setMinimumSize(new java.awt.Dimension(1, 0));
        sep.setPreferredSize(new java.awt.Dimension(1, 0));

        javax.swing.GroupLayout sepLayout = new javax.swing.GroupLayout(sep);
        sep.setLayout(sepLayout);
        sepLayout.setHorizontalGroup(
            sepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        sepLayout.setVerticalGroup(
            sepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        reportBox.setFont(AppSettings.FONT_NORMAL);
        reportBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inWord, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inPronuntiation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel, save});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inPronuntiation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(reportBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inPronuntiation, inWord, jLabel1, jLabel2, jLabel3});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancel, save});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String name = this.inWord.getText();
        if (name.isEmpty()) {
            reportBox.setText("Word is missing");
            return;
        }
        name = Formater.format(name)[0];

        String pronunciation = inPronuntiation.getText();
        if ((currentLanguage.CODE == Language.UK
                || currentLanguage.CODE == Language.US) && pronunciation.isEmpty()) {
            reportBox.setText("Pronunciation is missing");
            return;
        }

        Inflexions inflexions = new Inflexions();
        ListModel<Inflexion> lm = inflexionsList.getModel();
        for (int i = 0; i < lm.getSize(); i++) {
            inflexions.add(lm.getElementAt(i));
        }
        if (inflexions.isEmpty()) {
            reportBox.setText("No inflexions inputed!!!!");
            return;
        }

        KernelManager dataManager = new KernelManager();
        Word word = new Word(name, inflexions, pronunciation, Word.INITIAL_PRIORITY);
        switch (purpose) {
            case ADD_NEW:
                dataManager.addWord(currentLanguage, word);
                handler.reportChange(DLHandler.ADDED_WORD);
                break;
            case ADD_FROM_DRAWER:
                dataManager.addWord(currentLanguage, word, tempData.drawerword);
                handler.reportChange(DLHandler.ADDED_WORD);
                break;
            case EDIT:
                dataManager.editWord(currentLanguage, word, tempData.editword);
                handler.reportChange(DLHandler.MODIFIED_WORD);
        }
        this.dispose();
    }//GEN-LAST:event_saveActionPerformed

    private void onTypeSelected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onTypeSelected
        JLabel clicked = (JLabel) evt.getSource();
        for (int i = 0; i < l_type.length; i++) {
            JLabel label = l_type[i];
            if (label == clicked) {
                label.setOpaque(true);
                displayTitles(1 << i);
                displayCheckBoxes(1 << i);
            } else {
                label.setOpaque(false);
            }
            label.repaint();
        }
    }//GEN-LAST:event_onTypeSelected

    private void addInflexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInflexionActionPerformed
        String translation = inTranslation.getText();
        if (translation.isEmpty()) {
            reportBox.setText("No translations inputed");
            return;
        }
        String[] translations = Formater.format(translation);

        int type = getInflexionType();
        if (type == -1) {
            reportBox.setText("No type selected");
            return;
        }
        ArrayList<String> formsarray = new ArrayList<>();
        for (int i = 0; i < checks.length; i++) {
            if (checks[i].isSelected()) {
                String form = in_inf[i].getText();
                if (form.isEmpty()) {
                    reportBox.setText("Form #" + i + " is empty");
                    return;
                }
                formsarray.add(form);
            }
        }
        String[] inflexions = formsarray.toArray(new String[formsarray.size()]);

        if (tempData.inflexionModifying != null) {
            tempData.inflexionModifying.inflexions = inflexions;
            tempData.inflexionModifying.translations = translations;
            tempData.inflexionModifying.type = type;
            tempData.inflexionModifying = null;
        } else {
            tempData.inflexionscopy.add(new Inflexion(inflexions, translations, type));
        }
        displayInflexionsList();

        inTranslation.setText("");
        displayType(0);
        displayTitles(-1);
        displayInputs(new String[]{"", "", "", "", ""});
        displayCheckBoxes(-1);
    }//GEN-LAST:event_addInflexionActionPerformed

    private void inflexionsListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inflexionsListKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            modifyInflexion((Inflexion) inflexionsList.getSelectedValue());
        }
    }//GEN-LAST:event_inflexionsListKeyReleased

    private void inflexionsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inflexionsListMouseClicked
        if (evt.getClickCount() == 1 && evt.getButton() == MouseEvent.BUTTON1) {
            int index = inflexionsList.locationToIndex(evt.getPoint());
            if (index != -1) {
                modifyInflexion((Inflexion) inflexionsList.getModel().getElementAt(index));
            }
        }
    }//GEN-LAST:event_inflexionsListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JCheckBox check_1;
    private javax.swing.JCheckBox check_2;
    private javax.swing.JCheckBox check_3;
    private javax.swing.JCheckBox check_4;
    private javax.swing.JCheckBox check_5;
    private javax.swing.JTextField inPronuntiation;
    private javax.swing.JTextField inTranslation;
    private javax.swing.JTextField inWord;
    private javax.swing.JList<Inflexion> inflexionsList;
    private javax.swing.JTextField input_1;
    private javax.swing.JTextField input_2;
    private javax.swing.JTextField input_3;
    private javax.swing.JTextField input_4;
    private javax.swing.JTextField input_5;
    private javax.swing.JLabel lab_1;
    private javax.swing.JLabel lab_2;
    private javax.swing.JLabel lab_3;
    private javax.swing.JLabel lab_4;
    private javax.swing.JLabel lab_5;
    private javax.swing.JLabel lb_adj;
    private javax.swing.JLabel lb_adv;
    private javax.swing.JLabel lb_conj;
    private javax.swing.JLabel lb_exp;
    private javax.swing.JLabel lb_noun;
    private javax.swing.JLabel lb_oth;
    private javax.swing.JLabel lb_phv;
    private javax.swing.JLabel lb_prep;
    private javax.swing.JLabel lb_verb;
    private javax.swing.JLabel reportBox;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    private void displayInflexionsList() {
        DefaultListModel m = new DefaultListModel();
        for (Inflexion inf : tempData.inflexionscopy) {
            m.addElement(inf);
        }
        inflexionsList.setModel(m);
    }

    public int getInflexionType() {
        for (int i = 0; i < l_type.length; i++) {
            if (l_type[i].isOpaque()) {
                return 1 << i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WordEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WordEditFrame(new Language(Language.ES, "Svenska", "", 0), null).setVisible(true);
            }
        });
    }

    private void modifyInflexion(Inflexion inflexion) {
        tempData.inflexionModifying = inflexion;

        inTranslation.setText(inflexion.getTranslationsFormated());
        displayType(inflexion.type);
        displayTitles(inflexion.type);
        displayInputs(inflexion.inflexions);
        displayCheckBoxes(inflexion.type);
    }

    private void displayType(int type) {
        for (int i = 0; i < l_type.length; i++) {
            if (((type >> i) & 0x1) == 1) {
                l_type[i].setOpaque(true);
            } else {
                l_type[i].setOpaque(false);
            }
            l_type[i].repaint();
        }
    }

    private void displayTitles(int type) {
        String[] labels = LAB_OTH;

        if (currentLanguage.CODE == Language.SV) {
            switch (type) {
                case Word.NOUN:
                    labels = LAB_NN;
                    break;
                case Word.PHRASAL_VERB:
                case Word.VERB:
                    labels = LAB_VB;
                    break;
                case Word.ADJECTIVE:
                    labels = LAB_ADJ;
                    break;
                case Word.ADVERB:
                    break;
                case Word.EXPRESION:
                    break;
                case Word.OTHER:
                    break;
            }
        }
        for (int i = 0; i < labels.length; i++) {
            l_tit[i].setText(labels[i]);
            l_tit[i].revalidate();
        }
    }

    private void displayCheckBoxes(int type) {
        int num = 0;
        if (currentLanguage.CODE == Language.SV) {
            switch (type) {
                case Word.NOUN:
                    num = 4;
                    break;
                case Word.PHRASAL_VERB:
                case Word.VERB:
                case Word.ADJECTIVE:
                    num = 5;
                    break;
            }
        }
        for (int i = 0; i < num; i++) {
            checks[i].setSelected(true);
            checks[i].revalidate();
        }
        for (int i = num; i < checks.length; ++i) {
            checks[i].setSelected(false);
            checks[i].revalidate();
        }
    }

    private void displayInputs(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            in_inf[i].setText(inputs[i]);
            in_inf[i].revalidate();
        }
    }

//<editor-fold defaultstate="collapsed" desc="-> List Renderers <-">
    ListCellRenderer<Inflexion> inflexionsListRenderer = new ListCellRenderer<Inflexion>() {
        @Override
        public Component getListCellRendererComponent(JList list, Inflexion value,
                int index, boolean isSelected, boolean cellHasFocus) {
            return new InflexionListView(value, isSelected);
        }
    };
//</editor-fold>

}
