/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Codigo.NodoEquipo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mario A
 */
public class PanelPosiciones extends javax.swing.JPanel {

    /**
     * Creates new form PanelTablaDePosiciones
     */
    public PanelPosiciones() {
        initComponents();
    }

    /**
     * Metodo utilizado para cargar la informacion de la tabla de posiciones, de
     * acuerdo a la informacion de cada equipo
     *
     * @param letraGrupo Letra del Grupo donde se ubican las selecciones
     * @param pEquipos Lista de equipos ordenada de acuerdo a puntos y gol dif.
     */
    public void setEquipos(char letraGrupo, NodoEquipo[] pEquipos) {
        
        // Establece la letra al grupo
        Lbl_LetraDelGrupo.setText("GRUPO " + letraGrupo);

        // Recorre la lista de equipos para insertarlos en la ventana
        for (int i = 0; i < pEquipos.length; i++) {
            // 9 Bandera            
            JLabel bandera = (JLabel) this.getComponent(i * 10 + 9);
            // Cambia el tamaño de la imagen
            ImageIcon imagen = new ImageIcon(getClass().getResource("/ImagenesBanderas/" + 
                    pEquipos[i].getNombreEquipo() + ".png"));
            Image imgEscalada = imagen.getImage().getScaledInstance(46, 29, Image.SCALE_SMOOTH);
            bandera.setIcon(new ImageIcon(imgEscalada));            
            
            // 10 Nombre equipo
            JLabel equipo = (JLabel) this.getComponent(i * 10 + 10);
            //System.out.println(equipo.getText());
            equipo.setText(pEquipos[i].getNombreEquipo());
            
            // 11 Partidos Jugados
            JLabel PJ = (JLabel) this.getComponent(i * 10 + 11);
            PJ.setText(pEquipos[i].getPartidosJugados() + "");
            
            // 12 Partidos Ganados
            JLabel PG = (JLabel) this.getComponent(i * 10 + 12);
            PG.setText(pEquipos[i].getPartidosGanados() + "");
            
            // 13 Partidos Empatados
            JLabel PE = (JLabel) this.getComponent(i * 10 + 13);
            PE.setText(pEquipos[i].getPartidosEmpatados() + "");
            
            // 14 Partidos Perdidos
            JLabel PP = (JLabel) this.getComponent(i * 10 + 14);
            PP.setText(pEquipos[i].getPartidosPerdidos() + "");
            
            // 15 Goles A Favor
            JLabel GF = (JLabel) this.getComponent(i * 10 + 15);
            GF.setText(pEquipos[i].getGolesAFavor() + "");
            
            // 16 Goles En Contra
            JLabel GC = (JLabel) this.getComponent(i * 10 + 16);
            GC.setText(pEquipos[i].getGolesEnContra() + "");
            
            // 17 Gol Diferencia
            JLabel GDif = (JLabel) this.getComponent(i * 10 + 17);
            GDif.setText(pEquipos[i].getGolDiferencia() + "");
            
            // 18 Puntos
            JLabel PTS = (JLabel) this.getComponent(i * 10 + 18);
            PTS.setText(pEquipos[i].getPuntos() + "");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Lbl_Pts = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        Lbl_Pts1 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Lbl_Pts2 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        Lbl_Pts3 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        Lbl_LetraDelGrupo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(531, 267));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipo");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PJ");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(18, 14));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 28, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PG");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 26, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PE");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 25, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PP");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 25, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("GF");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 26, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GC");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 27, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dif");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 26, 20));

        Lbl_Pts.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        Lbl_Pts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Pts.setText("PTS");
        Lbl_Pts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(Lbl_Pts, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 31, 20));

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setPreferredSize(new java.awt.Dimension(46, 29));
        add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel81.setText("Bosnia Herzegovina");
        add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 100, 29));

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel80.setText("PJ");
        add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 26, 29));

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel82.setText("PG");
        add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 22, 29));

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel83.setText("PE");
        add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 21, 29));

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel84.setText("PP");
        add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 21, 29));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel85.setText("GF");
        add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 22, 29));

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel49.setText("GC");
        add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 23, 29));

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel77.setText("G.Dif");
        add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 33, 29));

        Lbl_Pts1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Lbl_Pts1.setText("PTS");
        add(Lbl_Pts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 27, 29));

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setPreferredSize(new java.awt.Dimension(46, 29));
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel52.setText("Bosnia Herzegovina");
        add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, 29));

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel51.setText("PJ");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 27, 29));

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel53.setText("PG");
        add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 22, 29));

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel54.setText("PE");
        add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 21, 29));

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel55.setText("PP");
        add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 21, 29));

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel56.setText("GF");
        add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 22, 29));

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel46.setText("GC");
        add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 23, 29));

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel47.setText("G.Dif");
        add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 33, 29));

        Lbl_Pts2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Lbl_Pts2.setText("PTS");
        add(Lbl_Pts2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 27, 29));

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setPreferredSize(new java.awt.Dimension(46, 29));
        add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel62.setText("Iran");
        add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 100, 29));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel61.setText("PJ");
        add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 27, 29));

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel63.setText("PG");
        add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 22, 29));

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel64.setText("PE");
        add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 21, 29));

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel65.setText("PP");
        add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 21, 29));

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel66.setText("GF");
        add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 22, 29));

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel57.setText("GC");
        add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 23, 29));

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel58.setText("G.Dif");
        add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 33, 29));

        Lbl_Pts3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Lbl_Pts3.setText("PTS");
        add(Lbl_Pts3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 27, 29));

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setPreferredSize(new java.awt.Dimension(46, 29));
        add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel72.setText("Bosnia Herzegovina");
        add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 100, 29));

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel71.setText("PJ");
        add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 27, 29));

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel73.setText("PG");
        add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 22, 29));

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel74.setText("PE");
        add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 21, 29));

        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel75.setText("PP");
        add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 21, 29));

        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel76.setText("GF");
        add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 22, 29));

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel67.setText("GC");
        add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 23, 29));

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel68.setText("G.Dif");
        add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 33, 29));

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel69.setText("PTS");
        add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 27, 29));

        Lbl_LetraDelGrupo.setFont(new java.awt.Font("Lucida Bright", 2, 18)); // NOI18N
        Lbl_LetraDelGrupo.setForeground(new java.awt.Color(51, 51, 51));
        Lbl_LetraDelGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_LetraDelGrupo.setText("Grupo D");
        add(Lbl_LetraDelGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 480, 44));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_LetraDelGrupo;
    private javax.swing.JLabel Lbl_Pts;
    private javax.swing.JLabel Lbl_Pts1;
    private javax.swing.JLabel Lbl_Pts2;
    private javax.swing.JLabel Lbl_Pts3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    // End of variables declaration//GEN-END:variables
}
