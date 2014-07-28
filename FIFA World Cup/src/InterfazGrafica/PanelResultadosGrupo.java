/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazGrafica;

/**
 *
 * @author Mario A
 */
public class PanelResultadosGrupo extends javax.swing.JPanel {

    /**
     * Creates new form GrupoYResultados
     */
    public PanelResultadosGrupo() {
        initComponents();
    }
    
    /**
     * Metodo utilizado para escribir la letra correspondiente del grupo
     * @param pLetra Letra del grupo
     */
    public void setLetraGrupo(char pLetra){
        Lbl_LetraDelGrupo.setText("GRUPO " + pLetra);
    }
    
    /**
     * Metodo para agregar al grupo un nuevo partido
     * @param pEncuentro Encuentro del grupo
     */
    public void agregarPanelResultado(PanelResultadoPartido pEncuentro){
        jPanel1.add(pEncuentro);
        this.repaint();
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lbl_LetraDelGrupo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        Lbl_LetraDelGrupo.setBackground(new java.awt.Color(153, 153, 0));
        Lbl_LetraDelGrupo.setFont(new java.awt.Font("Dotum", 3, 20)); // NOI18N
        Lbl_LetraDelGrupo.setText("GRUPO A");
        Lbl_LetraDelGrupo.setOpaque(true);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_LetraDelGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(Lbl_LetraDelGrupo)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_LetraDelGrupo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
