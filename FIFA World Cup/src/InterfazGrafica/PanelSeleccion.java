/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazGrafica;

import javax.swing.ImageIcon;

/**
 *
 * @author Mario A
 */
public class PanelSeleccion extends javax.swing.JPanel {

    /**
     * Creates new form PanelEquipos
     */
    public PanelSeleccion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lbl_NombreEquipo = new javax.swing.JLabel();
        Lbl_Bandera = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(330, 54));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_NombreEquipo.setFont(new java.awt.Font("Californian FB", 0, 18)); // NOI18N
        Lbl_NombreEquipo.setForeground(new java.awt.Color(207, 209, 208));
        add(Lbl_NombreEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 12, 180, 30));
        add(Lbl_Bandera, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 70, 46));

        jLabel1.setBackground(new java.awt.Color(38, 40, 52));
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 54));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo utilizado para establecer al panel de la seleccion, el nombre y la 
     * bandera del equipo
     * @param pPais pais a insertar en el panel
     */
    public void setEquipo(String pPais){
        // Se establece la ruta de la bandera del pais ingresado
        String rutaBandera = "/ImagenesBanderas/"+pPais+".png";
        // Se establece la imagen de la bandera y el nombre del pais
        Lbl_Bandera.setIcon(new ImageIcon(getClass().getResource(rutaBandera)));
        Lbl_NombreEquipo.setText(pPais);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_Bandera;
    private javax.swing.JLabel Lbl_NombreEquipo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
