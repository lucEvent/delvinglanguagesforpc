package delvinglanguages.view;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Theme;
import delvinglanguages.kernel.util.ThemePair;
import delvinglanguages.kernel.util.ThemePairs;
import delvinglanguages.settings.AppSettings;
import delvinglanguages.util.DLHandler;
import java.util.TreeSet;

public class ThemeEditFrame extends javax.swing.JFrame {

    enum Purpose {
        NEW, MODIFY
    }

    private Language currentLanguage;
    private DLHandler handler;

    private Purpose purpose;
    private Theme tempTheme;

    public ThemeEditFrame(Language language, DLHandler handler) {
        init(language, handler);
        this.purpose = Purpose.NEW;
        displayPairs(null);
    }

    public ThemeEditFrame(Theme theme, Language language, DLHandler handler) {
        init(language, handler);
        this.purpose = Purpose.MODIFY;
        inThemeName.setText(theme.name);
        displayPairs(theme.pairs);
    }

    private void init(Language language, DLHandler handler) {
        this.handler = handler;
        this.currentLanguage = language;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inThemeName = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        pairsTable = new javax.swing.JTable();
        javax.swing.JLabel themetitlelabel = new javax.swing.JLabel();
        javax.swing.JPanel sep = new javax.swing.JPanel();
        javax.swing.JLabel themepairslabel = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        reportBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Theme");
        setResizable(false);

        inThemeName.setFont(AppSettings.FONT_NORMAL);
        inThemeName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inThemeName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(7, 1, 7, 1)));

        pairsTable.setFont(AppSettings.FONT_NORMAL);
        pairsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane1.setViewportView(pairsTable);
        if (pairsTable.getColumnModel().getColumnCount() > 0) {
            pairsTable.getColumnModel().getColumn(0).setHeaderValue(currentLanguage.name);
            pairsTable.getColumnModel().getColumn(1).setHeaderValue(AppSettings.NATIVE_NAME);
        }

        themetitlelabel.setFont(AppSettings.FONT_NORMAL_BOLD);
        themetitlelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        themetitlelabel.setLabelFor(inThemeName);
        themetitlelabel.setText("Theme title");
        themetitlelabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 5, 1));

        sep.setBackground(new java.awt.Color(102, 102, 102));
        sep.setMaximumSize(new java.awt.Dimension(32767, 1));
        sep.setMinimumSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout sepLayout = new javax.swing.GroupLayout(sep);
        sep.setLayout(sepLayout);
        sepLayout.setHorizontalGroup(
            sepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        sepLayout.setVerticalGroup(
            sepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        themepairslabel.setFont(AppSettings.FONT_NORMAL_BOLD);
        themepairslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        themepairslabel.setLabelFor(pairsTable);
        themepairslabel.setText("Theme pairs");
        themepairslabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 5, 1));

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

        clear.setFont(AppSettings.FONT_NORMAL);
        clear.setText("Clear fields");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        reportBox.setFont(AppSettings.FONT_NORMAL);
        reportBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(inThemeName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(themetitlelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themepairslabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel, clear, save});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themetitlelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inThemeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(themepairslabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel)
                    .addComponent(clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancel, clear, save});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String thName = inThemeName.getText();
        if (thName.isEmpty()) {
            reportBox.setText("Theme name missing");
            return;
        }
        ThemePairs pairs = getPairsFromTable();
        if (pairs.isEmpty()) {
            reportBox.setText("There are no word added to the theme");
            return;
        }
        KernelManager kman = new KernelManager();
        if (purpose == Purpose.NEW) {
            kman.addTheme(currentLanguage, new Theme(thName, pairs));
            handler.reportChange(DLHandler.ADDED_THEME);
        } else if (purpose == Purpose.MODIFY) {
            kman.editTheme(currentLanguage, new Theme(thName, pairs), tempTheme);
            handler.reportChange(DLHandler.MODIFIED_THEME);
        }
        dispose();
    }//GEN-LAST:event_saveActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        inThemeName.setText("");
        displayPairs(null);
    }//GEN-LAST:event_clearActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="Look & Feel">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemeEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemeEditFrame(new Language(0, "Hodor", "Nativo", 0), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    private javax.swing.JTextField inThemeName;
    private javax.swing.JTable pairsTable;
    private javax.swing.JLabel reportBox;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    private ThemePairs getPairsFromTable() {
        TreeSet<ThemePair> pairs = new TreeSet<ThemePair>();
        for (int i = 0; i < pairsTable.getRowCount(); i++) {
            Object inDelv = pairsTable.getValueAt(i, 0);
            Object inNativ = pairsTable.getValueAt(i, 1);

            if (inDelv != null && inNativ != null) {
                pairs.add(new ThemePair((String) inDelv, (String) inNativ));
            }
        }
        return new ThemePairs(pairs);
    }

    private void displayPairs(ThemePairs pairs) {
        String[][] pairsModel;
        if (pairs == null) {
            pairsModel = new String[][]{
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}, {null, null}
            };
        } else {
            pairsModel = new String[pairs.size()][2];
            for (int i = 0; i < pairs.size(); i++) {
                ThemePair pair = pairs.get(i);
                pairsModel[i][0] = pair.inDelved;
                pairsModel[i][1] = pair.inNative;
            }
        }

        pairsTable.setModel(new javax.swing.table.DefaultTableModel(
                pairsModel, new String[]{currentLanguage.name, AppSettings.NATIVE_NAME}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        });
    }

}
