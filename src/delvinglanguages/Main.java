package delvinglanguages;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Languages;
import delvinglanguages.settings.AppSettings;
import delvinglanguages.util.DLHandler;
import delvinglanguages.view.AddLanguageFrame;
import delvinglanguages.view.ConfirmActionFrame;
import delvinglanguages.view.DrawerView;
import delvinglanguages.view.ThemesView;
import delvinglanguages.view.WordsView;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Main extends javax.swing.JFrame implements DLHandler {

    private KernelManager data;

    private Languages languages;

    private WordsView wordsView;
    private DrawerView drawerView;
    private ThemesView themesView;

    public Main() {
        initComponents();

        data = new KernelManager();
        wordsView = new WordsView(this);
        drawerView = new DrawerView(this);
        themesView = new ThemesView(this);

        languageList.setCellRenderer(languageListRenderer);
        contentPane.addTab("Words", wordsView);
        contentPane.addTab("Drawer", drawerView);
        contentPane.addTab("Themes", themesView);
        //contentPane.addTab("Phrasals",  new LanguageWordsView());
        //contentPane.addTab("Verbs",  new LanguageWordsView());

        displayLanguages(data.getLanguages());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        languageList = new javax.swing.JList<>();
        javax.swing.JLabel langLabel = new javax.swing.JLabel();
        addLanguage = new javax.swing.JButton();
        contentPane = new javax.swing.JTabbedPane();
        javax.swing.JPanel languageInfoPanel = new javax.swing.JPanel();
        languageName = new javax.swing.JLabel();
        editLanguage = new javax.swing.JButton();
        removeLanguage = new javax.swing.JButton();
        exportLanguage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delving Languages v1.1");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(new java.awt.Point(0, 0));

        languageList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        languageList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                languageListMouseClicked(evt);
            }
        });
        languageList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                languageListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(languageList);

        langLabel.setFont(AppSettings.FONT_NORMAL_BOLD);
        langLabel.setLabelFor(languageList);
        langLabel.setText("Languages");
        langLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        addLanguage.setFont(AppSettings.FONT_NORMAL);
        addLanguage.setText("Add Language");
        addLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLanguageActionPerformed(evt);
            }
        });

        contentPane.setFont(AppSettings.FONT_NORMAL);
        contentPane.setName(""); // NOI18N

        languageInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        languageName.setFont(AppSettings.FONT_XXL_BOLD);
        languageName.setText("Language Name");
        languageName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        editLanguage.setText("Edit Language");
        editLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLanguageActionPerformed(evt);
            }
        });

        removeLanguage.setText("Remove Language");
        removeLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLanguageActionPerformed(evt);
            }
        });

        exportLanguage.setText("Export Language");
        exportLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportLanguageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout languageInfoPanelLayout = new javax.swing.GroupLayout(languageInfoPanel);
        languageInfoPanel.setLayout(languageInfoPanelLayout);
        languageInfoPanelLayout.setHorizontalGroup(
            languageInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languageInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(languageInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(languageInfoPanelLayout.createSequentialGroup()
                        .addComponent(languageName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(languageInfoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(languageInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeLanguage, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exportLanguage, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        languageInfoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editLanguage, exportLanguage, removeLanguage});

        languageInfoPanelLayout.setVerticalGroup(
            languageInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languageInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(languageInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageName)
                    .addComponent(editLanguage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeLanguage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportLanguage)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        languageInfoPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {editLanguage, exportLanguage, removeLanguage});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(langLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(languageInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(langLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLanguage))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(languageInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contentPane)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLanguageActionPerformed
        new AddLanguageFrame(this).setVisible(true);
    }//GEN-LAST:event_addLanguageActionPerformed

    private void languageListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_languageListKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            displayLanguage(languageList.getSelectedIndex());
        }
    }//GEN-LAST:event_languageListKeyReleased

    private void languageListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_languageListMouseClicked
        if (evt.getClickCount() > 1 && evt.getButton() == MouseEvent.BUTTON1) {
            displayLanguage(languageList.locationToIndex(evt.getPoint()));
        }
    }//GEN-LAST:event_languageListMouseClicked

    private void editLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLanguageActionPerformed
        if (currentLanguage != null) {
            //TODO    new AddLanguageFrame(this);
        }
    }//GEN-LAST:event_editLanguageActionPerformed

    private void removeLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeLanguageActionPerformed
        if (currentLanguage != null) {
            new ConfirmActionFrame(ConfirmActionFrame.DELETE_LANGUAGE, this, currentLanguage, currentLanguage).setVisible(true);
        }
    }//GEN-LAST:event_removeLanguageActionPerformed

    private void exportLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportLanguageActionPerformed
        if (currentLanguage != null) {
            data.export(currentLanguage);
        }
    }//GEN-LAST:event_exportLanguageActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLanguage;
    private javax.swing.JTabbedPane contentPane;
    private javax.swing.JButton editLanguage;
    private javax.swing.JButton exportLanguage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Language> languageList;
    private javax.swing.JLabel languageName;
    private javax.swing.JButton removeLanguage;
    // End of variables declaration//GEN-END:variables

//<editor-fold defaultstate="collapsed" desc="-> Displays <-">
    private Language currentLanguage;

    private void displayLanguages(Languages languages) {
        this.languages = languages;
        DefaultListModel m = new DefaultListModel();
        for (Language l : languages) {
            m.addElement(l);
        }
        languageList.setModel(m);
    }

    private void displayLanguage(int index) {
        currentLanguage = languages.get(index);
        System.out.println("Selecting " + currentLanguage.name);
        //TODO Update infoPanel
        wordsView.setLanguage(currentLanguage);
        drawerView.setLanguage(currentLanguage);
        themesView.setLanguage(currentLanguage);

        languageName.setText(currentLanguage.name);
        languageName.setIcon(currentLanguage.flag);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="-> List Renderers <-">
    ListCellRenderer<Language> languageListRenderer = new ListCellRenderer<Language>() {
        @Override
        public Component getListCellRendererComponent(JList list, Language value,
                int index, boolean isSelected, boolean cellHasFocus) {

            JLabel res = new JLabel((index + 1) + " " + value.name);

            res.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            res.setOpaque(true);
            if (isSelected) {
                res.setBackground(AppSettings.COLOR_SELECTED);
                res.setFont(AppSettings.FONT_NORMAL_BOLD);
            } else {
                res.setFont(AppSettings.FONT_NORMAL);
                res.setBackground(AppSettings.COLOR_NOT_SELECTED);
            }
            res.setForeground(Color.BLACK);
            return res;
        }
    };
//</editor-fold>

    @Override
    public void reportChange(int change, Object obj) {
        switch (change) {
            case ADDED_LANGUAGE:
            case DELETED_LANGUAGE:
                displayLanguages(data.getLanguages());
                break;
            case ADDED_WORD:
            case DELETED_WORD:
            //TODO   Sumar y actualizar contador
            case MODIFIED_WORD:
                wordsView.setLanguage(currentLanguage);
                break;
            case ADDED_DRAWER:
            case DELETED_DRAWER:
            //TODO   Sumar y actualizar contador
            case MODIFIED_DRAWER:
                drawerView.setLanguage(currentLanguage);
                break;
            case ADDED_THEME:
            case DELETED_THEME:
            //TODO   Sumar y actualizar contador
            case MODIFIED_THEME:
                themesView.setLanguage(currentLanguage);
                break;
        }
    }

}
