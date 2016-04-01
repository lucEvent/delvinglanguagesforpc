package delvinglanguages.view;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.DrawerWord;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Theme;
import delvinglanguages.kernel.util.Word;
import delvinglanguages.settings.AppSettings;
import delvinglanguages.util.DLHandler;

public class ConfirmActionFrame extends javax.swing.JFrame {

    public static final int DELETE_LANGUAGE = 0;
    public static final int DELETE_WORD = 1;
    public static final int DELETE_DRAWER = 2;
    public static final int DELETE_THEME = 3;

    private final int action;
    private final DLHandler handler;
    private final Language language;
    private final Object elemOfAction;

    public ConfirmActionFrame(int action, DLHandler handler, Language language, Object elemOfAction) {
        initComponents();

        this.action = action;
        this.handler = handler;
        this.language = language;
        this.elemOfAction = elemOfAction;

        String message = "<html><p>Confirm to delete ";
        String middle = "</p><br><p align=\"center\">";
        switch (action) {
            case DELETE_LANGUAGE:
                message += "language:" + middle + language.name;
                break;
            case DELETE_WORD:
                message += "word:" + middle + ((Word) elemOfAction).getName();
                break;
            case DELETE_DRAWER:
                message += "drawer word:" + middle + ((DrawerWord) elemOfAction).name;
                break;
            case DELETE_THEME:
                message += "theme:" + middle + ((Theme) elemOfAction).name;
        }
        message += "</p></html>";
        outMessage.setText(message);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outMessage = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirm action");
        setResizable(false);

        outMessage.setFont(AppSettings.FONT_XXL_BOLD);
        outMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outMessage.setText("Confirmation message");
        outMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        confirm.setFont(AppSettings.FONT_BIG);
        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        cancel.setFont(AppSettings.FONT_BIG);
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel, confirm});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancel, confirm});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        KernelManager kMan = new KernelManager();
        switch (action) {
            case DELETE_LANGUAGE:
                kMan.deleteLanguage(language);
                handler.reportChange(DLHandler.DELETED_LANGUAGE, language);
                break;
            case DELETE_WORD:
                kMan.deleteWord(language, (Word) elemOfAction);
                handler.reportChange(DLHandler.DELETED_WORD, elemOfAction);
                break;
            case DELETE_DRAWER:
                kMan.deleteDrawerWord(language, (DrawerWord) elemOfAction);
                handler.reportChange(DLHandler.DELETED_DRAWER, elemOfAction);
                break;
            case DELETE_THEME:
                kMan.deleteTheme(language, (Theme) elemOfAction);
                handler.reportChange(DLHandler.DELETED_THEME, elemOfAction);
        }
        dispose();
    }//GEN-LAST:event_confirmActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmActionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmActionFrame(0, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel outMessage;
    // End of variables declaration//GEN-END:variables

}
