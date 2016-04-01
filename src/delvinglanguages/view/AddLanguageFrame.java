package delvinglanguages.view;

import delvinglanguages.util.DLHandler;
import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.settings.AppSettings;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddLanguageFrame extends javax.swing.JFrame {

    private int index = 0;
    private static final String[] LANGUAGES = new String[]{
        "", "Basque", "Catalan", "Czech", "Danish", "Dutch", "English UK",
        "English US", "Estonian", "Finnish", "French", "German", "Greek",
        "Italian", "Norwegian", "Portuguese", "Russian", "Spanish", "Swedish"};
    private static final int[] LANGUAGE_CODES = new int[]{
        -1, 6, 5, 7, 8, 9, 0, 1, 10, 3, 11, 12, 13, 14, 15, 16, 17, 4, 2
    };

    private DLHandler handler;

    private KernelManager data;

    public AddLanguageFrame(DLHandler handler) {
        initComponents();

        reportBox.setVisible(false);

        languageSelector.setModel(new SpinnerListModel(LANGUAGES) {

            @Override
            public Object getNextValue() {
                index--;
                if (index <= 0) {
                    index = LANGUAGES.length - 1;
                }
                return LANGUAGES[index];
            }

            @Override
            public Object getPreviousValue() {
                index++;
                if (index == LANGUAGES.length) {
                    index = 1;
                }
                return LANGUAGES[index];
            }

            @Override
            public Object getValue() {
                return LANGUAGES[index];
            }

        });

        final JLabel jl = new JLabel();
        jl.setFont(AppSettings.FONT_NORMAL);

        languageSelector.setEditor(jl);
        languageSelector.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                String lang = (String) languageSelector.getValue();
                jl.setText(lang);
                jl.setIcon(new ImageIcon("data/icon/" + lang + ".png"));
            }
        });

        this.handler = handler;
        data = new KernelManager();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageSelector = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        enablePHV = new javax.swing.JCheckBox();
        languageName = new javax.swing.JTextField();
        enableINF = new javax.swing.JCheckBox();
        enableSPE = new javax.swing.JCheckBox();
        addLanguage = new javax.swing.JButton();
        clearFields = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        reportBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Language");
        setResizable(false);

        languageSelector.setBorder(null);

        jLabel1.setFont(AppSettings.FONT_NORMAL);
        jLabel1.setLabelFor(languageSelector);
        jLabel1.setText("Language:");

        jLabel2.setFont(AppSettings.FONT_NORMAL);
        jLabel2.setLabelFor(languageName);
        jLabel2.setText("Language name:");

        enablePHV.setFont(AppSettings.FONT_NORMAL);
        enablePHV.setText("Enable Phrasal Verbs");

        languageName.setFont(AppSettings.FONT_NORMAL);

        enableINF.setFont(AppSettings.FONT_NORMAL);
        enableINF.setText("Enable Inflexion Forms");

        enableSPE.setFont(AppSettings.FONT_NORMAL);
        enableSPE.setText("Enable Special Characters");

        addLanguage.setFont(AppSettings.FONT_NORMAL);
        addLanguage.setText("Add Language");
        addLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLanguageActionPerformed(evt);
            }
        });

        clearFields.setFont(AppSettings.FONT_NORMAL);
        clearFields.setText("Clear fields");
        clearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsActionPerformed(evt);
            }
        });

        cancel.setFont(AppSettings.FONT_NORMAL);
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        reportBox.setFont(AppSettings.FONT_NORMAL);
        reportBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enableSPE)
                            .addComponent(languageSelector)
                            .addComponent(languageName)
                            .addComponent(enablePHV, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(enableINF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(addLanguage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearFields, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(reportBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {enableINF, enablePHV, enableSPE});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(languageSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(languageName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(enablePHV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enableINF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enableSPE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addLanguage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearFields)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addGap(9, 9, 9)
                .addComponent(reportBox))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addLanguage, cancel, clearFields, enableINF, enablePHV, enableSPE, jLabel2, languageName, reportBox});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLanguageActionPerformed
        if (index <= 0) {
            report("Language is missing");
            return;
        }
        String langName = languageName.getText();
        if (langName.isEmpty()) {
            report("Language name missing");
            return;
        }
        int phv = enablePHV.isEnabled() ? Language.MASK_PH : 0;
        int inf = enableINF.isEnabled() ? Language.MASK_ADJ : 0;
        int spe = enableSPE.isEnabled() ? Language.MASK_ESP_CHARS : 0;

        Language language = data.addLanguage(LANGUAGE_CODES[index], langName, phv | inf | spe);
        handler.reportChange(DLHandler.ADDED_LANGUAGE, language);
        dispose();
    }//GEN-LAST:event_addLanguageActionPerformed

    private void clearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsActionPerformed
        languageName.setText("");
        enablePHV.setSelected(false);
        enableINF.setSelected(false);
        enableSPE.setSelected(false);
    }//GEN-LAST:event_clearFieldsActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddLanguageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLanguageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLanguageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLanguageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddLanguageFrame(new DLHandler() {
                    @Override
                    public void reportChange(int change, Object obj) {
                    }
                }).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLanguage;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clearFields;
    private javax.swing.JCheckBox enableINF;
    private javax.swing.JCheckBox enablePHV;
    private javax.swing.JCheckBox enableSPE;
    private javax.swing.JTextField languageName;
    private javax.swing.JSpinner languageSelector;
    private javax.swing.JLabel reportBox;
    // End of variables declaration//GEN-END:variables

    private void report(String message) {
        reportBox.setVisible(true);
        reportBox.setText(message);
    }
}
