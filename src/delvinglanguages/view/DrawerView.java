package delvinglanguages.view;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.DrawerWord;
import delvinglanguages.kernel.util.DrawerWords;
import delvinglanguages.kernel.util.Language;
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

public class DrawerView extends javax.swing.JPanel implements DLHandler {

    private DLHandler handler;

    public DrawerView(DLHandler handler) {
        initComponents();

        this.handler = handler;

        data = new KernelManager();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        drawerList = new javax.swing.JList<>();
        input = new javax.swing.JTextField();
        addDrawer = new javax.swing.JButton();

        drawerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        drawerList.setCellRenderer(drawerListRenderer);
        drawerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawerListMouseClicked(evt);
            }
        });
        drawerList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                drawerListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(drawerList);

        input.setFont(AppSettings.FONT_NORMAL);
        input.setMargin(new java.awt.Insets(2, 5, 2, 2));
        input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputKeyReleased(evt);
            }
        });

        addDrawer.setFont(AppSettings.FONT_NORMAL);
        addDrawer.setText("Add");
        addDrawer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDrawerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(input)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addDrawer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDrawer))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addDrawer, input});

    }// </editor-fold>//GEN-END:initComponents

    private void drawerListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_drawerListKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addWord(drawerList.getSelectedIndex());
        }
    }//GEN-LAST:event_drawerListKeyReleased

    private void drawerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawerListMouseClicked
        if (evt.getClickCount() > 1 && evt.getButton() == MouseEvent.BUTTON1) {
            addWord(drawerList.locationToIndex(evt.getPoint()));
        }
    }//GEN-LAST:event_drawerListMouseClicked

    private void addDrawerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDrawerActionPerformed
        String dword = input.getText();
        if (!dword.isEmpty() && currentLanguage != null) {
            data.addDrawerWord(currentLanguage, dword);
            displayDrawerList();
            handler.reportChange(DLHandler.ADDED_DRAWER);

            input.setText("");
        }
    }//GEN-LAST:event_addDrawerActionPerformed

    private void inputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addDrawerActionPerformed(null);
        }
    }//GEN-LAST:event_inputKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDrawer;
    private javax.swing.JList<DrawerWord> drawerList;
    private javax.swing.JTextField input;
    // End of variables declaration//GEN-END:variables

    private KernelManager data;
    private Language currentLanguage;

    public void setLanguage(Language language) {
        currentLanguage = language;
        displayDrawerList();
    }

    private void addWord(int index) {
        DrawerWord dword = currentLanguage.drawer_words.get(index);
        new WordEditFrame(dword, currentLanguage, this).setVisible(true);
    }

//<editor-fold defaultstate="collapsed" desc="-> Displays <-">
    private void displayDrawerList() {
        DrawerWords dWords = data.getDrawerWordsOf(currentLanguage);
        DefaultListModel m = new DefaultListModel();
        for (DrawerWord dw : dWords) {
            m.addElement(dw);
        }
        drawerList.setModel(m);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="-> List Renderers <-">
    private ListCellRenderer<DrawerWord> drawerListRenderer = new ListCellRenderer<DrawerWord>() {
        @Override
        public Component getListCellRendererComponent(JList list, DrawerWord value,
                int index, boolean isSelected, boolean cellHasFocus) {

            JLabel res = new JLabel((index + 1) + " " + value.name);
            res.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            res.setOpaque(true);
            if (isSelected) {
                res.setFont(AppSettings.FONT_NORMAL_BOLD);
                res.setBackground(AppSettings.COLOR_SELECTED);
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
    public void reportChange(int change) {
        switch (change) {
            case ADDED_WORD:
                handler.reportChange(ADDED_WORD);
            case DELETED_DRAWER:
            case MODIFIED_DRAWER:
                displayDrawerList();
                break;
        }
    }

}
