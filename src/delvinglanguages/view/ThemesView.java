package delvinglanguages.view;

import delvinglanguages.kernel.KernelManager;
import delvinglanguages.kernel.util.Language;
import delvinglanguages.kernel.util.Theme;
import delvinglanguages.kernel.util.ThemePair;
import delvinglanguages.kernel.util.ThemePairs;
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

public class ThemesView extends javax.swing.JPanel implements DLHandler {

    private DLHandler handler;
    private KernelManager data;

    private Language currentLanguage;
    private Theme currentTheme;

    public ThemesView(DLHandler handler) {
        initComponents();

        this.handler = handler;
        this.data = new KernelManager();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        themeList = new javax.swing.JList<>();
        addTheme = new javax.swing.JButton();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        themeName = new javax.swing.JLabel();
        removeTheme = new javax.swing.JButton();
        editTheme = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        pairsTable = new javax.swing.JTable();

        themeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        themeList.setCellRenderer(themeListRenderer);
        themeList.setMaximumSize(new java.awt.Dimension(258, 0));
        themeList.setMinimumSize(new java.awt.Dimension(258, 0));
        themeList.setPreferredSize(new java.awt.Dimension(258, 0));
        themeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeListMouseClicked(evt);
            }
        });
        themeList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                themeListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(themeList);

        addTheme.setText("Add Theme");
        addTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addThemeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        themeName.setFont(AppSettings.FONT_BIG_BOLD);
        themeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        themeName.setText("List name");
        themeName.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        removeTheme.setText("Remove Theme");
        removeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeThemeActionPerformed(evt);
            }
        });

        editTheme.setText("Edit Theme");
        editTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editThemeActionPerformed(evt);
            }
        });

        pairsTable.setAutoCreateRowSorter(true);
        pairsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pairsTable.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(pairsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(themeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editTheme, removeTheme});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeTheme)
                    .addComponent(editTheme)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {editTheme, removeTheme});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(addTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addTheme, jScrollPane1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTheme))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void themeListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_themeListKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            displayTheme(themeList.getSelectedIndex());
        }
    }//GEN-LAST:event_themeListKeyReleased

    private void themeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeListMouseClicked
        if (evt.getClickCount() > 1 && evt.getButton() == MouseEvent.BUTTON1) {
            displayTheme(themeList.locationToIndex(evt.getPoint()));
        }
    }//GEN-LAST:event_themeListMouseClicked

    private void addThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addThemeActionPerformed
        new ThemeEditFrame(currentLanguage, this).setVisible(true);
    }//GEN-LAST:event_addThemeActionPerformed

    private void editThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editThemeActionPerformed
        if (currentTheme != null) {
            new ThemeEditFrame(currentTheme, currentLanguage, this).setVisible(true);
        }
    }//GEN-LAST:event_editThemeActionPerformed

    private void removeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeThemeActionPerformed
        if (currentTheme != null) {
            new ConfirmActionFrame(ConfirmActionFrame.DELETE_THEME, this, currentLanguage, currentTheme).setVisible(true);
        }
    }//GEN-LAST:event_removeThemeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTheme;
    private javax.swing.JButton editTheme;
    private javax.swing.JTable pairsTable;
    private javax.swing.JButton removeTheme;
    private javax.swing.JList<Theme> themeList;
    private javax.swing.JLabel themeName;
    // End of variables declaration//GEN-END:variables

    public void setLanguage(Language language) {
        if (language != currentLanguage) {
            currentLanguage = language;
            currentTheme = null;
        }
        displayThemes();
    }

//<editor-fold defaultstate="collapsed" desc="-> Displays <-">
    private void displayThemes() {
        DefaultListModel m = new DefaultListModel();
        for (Theme t : data.getThemesOf(currentLanguage)) {
            m.addElement(t);
        }
        themeList.setModel(m);
    }

    private void displayTheme(int index) {
        if (index == -1) {
            currentTheme = null;
            themeName.setText("");
            displayPairs(new ThemePairs());
        } else {
            currentTheme = currentLanguage.themes.get(index);
            themeName.setText(currentTheme.name);
            displayPairs(currentTheme.pairs);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="-> List Renderers <-">
    private ListCellRenderer<Theme> themeListRenderer = new ListCellRenderer<Theme>() {
        @Override
        public Component getListCellRendererComponent(JList list, Theme value,
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

    private void displayPairs(ThemePairs pairs) {
        String[][] pairsModel = new String[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            ThemePair pair = pairs.get(i);
            pairsModel[i][0] = pair.inDelved;
            pairsModel[i][1] = pair.inNative;
        }

        pairsTable.setModel(new javax.swing.table.DefaultTableModel(
                pairsModel, new String[]{currentLanguage.name, AppSettings.NATIVE_NAME}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    @Override
    public void reportChange(int change, Object obj) {
        switch (change) {
            case DLHandler.MODIFIED_THEME:
                displayTheme(currentLanguage.themes.size() - 1);
                break;
            case DLHandler.DELETED_THEME:
                displayTheme(-1);
        }
        handler.reportChange(change, obj);
    }

}
