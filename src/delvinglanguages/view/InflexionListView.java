package delvinglanguages.view;

import delvinglanguages.kernel.util.Inflexion;
import delvinglanguages.kernel.util.Word;
import delvinglanguages.settings.AppSettings;
import java.util.Arrays;

public final class InflexionListView extends javax.swing.JPanel {

    public InflexionListView(Inflexion inflexion, boolean isSelected) {
        initComponents();

        translation.setText(Arrays.toString(inflexion.translations));

        StringBuilder sb = new StringBuilder("<html>");
        for (String inf : inflexion.inflexions) {
            sb.append(inf).append("<br>");
        }
        sb.append("</html>");

        inflexions.setText(sb.toString());

        switch (inflexion.type) {
            case Word.NOUN:
                type.setBackground(AppSettings.NOUN);
                break;
            case Word.VERB:
                type.setBackground(AppSettings.VERB);
                break;
            case Word.ADJECTIVE:
                type.setBackground(AppSettings.ADJECTIVE);
                break;
            case Word.ADVERB:
                type.setBackground(AppSettings.ADVERB);
                break;
            case Word.PHRASAL_VERB:
                type.setBackground(AppSettings.PHRASAL_VERB);
                break;
            case Word.EXPRESION:
                type.setBackground(AppSettings.EXPRESION);
                break;
            case Word.PREPOSITION:
                type.setBackground(AppSettings.PREPOSITION);
                break;
            case Word.CONJUNTION:
                type.setBackground(AppSettings.CONJUNTION);
                break;
            case Word.OTHER:
                type.setBackground(AppSettings.OTHER);
                break;
        }

        if (isSelected) {
            setBackground(AppSettings.COLOR_SELECTED);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        translation = new javax.swing.JLabel();
        type = new javax.swing.JPanel();
        inflexions = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();

        translation.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        translation.setText("Translations");

        type.setBackground(new java.awt.Color(255, 204, 0));
        type.setPreferredSize(new java.awt.Dimension(7, 0));

        javax.swing.GroupLayout typeLayout = new javax.swing.GroupLayout(type);
        type.setLayout(typeLayout);
        typeLayout.setHorizontalGroup(
            typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        typeLayout.setVerticalGroup(
            typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        inflexions.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        inflexions.setText("Inflexions");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(inflexions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(translation, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(translation, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inflexions, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel inflexions;
    private javax.swing.JLabel translation;
    private javax.swing.JPanel type;
    // End of variables declaration//GEN-END:variables
}
