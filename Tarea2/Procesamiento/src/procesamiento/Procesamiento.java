/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import java.awt.image.BufferedImage;

/**
 *
 * @author kevin
 */
public class Procesamiento extends javax.swing.JFrame {
    
    AbrirImagen img=new AbrirImagen();
    CambiarFormatos formats=new CambiarFormatos();
    Filtros filtros=new Filtros();

    /**
     * Creates new form Procesamiento
     */
    public Procesamiento() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Brillo = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        RGB = new javax.swing.JMenuItem();
        AltoContraste = new javax.swing.JMenuItem();
        Mosaico = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        gris1 = new javax.swing.JMenuItem();
        gris2 = new javax.swing.JMenuItem();
        gris3 = new javax.swing.JMenuItem();
        Blur = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        Emboss = new javax.swing.JMenuItem();
        Mediana = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setAutoscrolls(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setAutoscrolls(true);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMenu1.setText("Abrir");

        jMenuItem1.setText("Seleccionar Archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Filtros");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Invertido");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        Brillo.setText("Brillo");
        Brillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrilloActionPerformed(evt);
            }
        });
        jMenu2.add(Brillo);

        jMenuItem4.setText("Rojo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Azul");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Verde");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        RGB.setText("RGB");
        RGB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGBActionPerformed(evt);
            }
        });
        jMenu2.add(RGB);

        AltoContraste.setText("AltoContraste");
        AltoContraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltoContrasteActionPerformed(evt);
            }
        });
        jMenu2.add(AltoContraste);

        Mosaico.setText("Mosaico");
        Mosaico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MosaicoActionPerformed(evt);
            }
        });
        jMenu2.add(Mosaico);

        jMenu3.setText("Escala de Grises");

        gris1.setText("Gris 1");
        gris1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gris1ActionPerformed(evt);
            }
        });
        jMenu3.add(gris1);

        gris2.setText("Gris2");
        gris2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gris2ActionPerformed(evt);
            }
        });
        jMenu3.add(gris2);

        gris3.setText("Gris3");
        gris3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gris3ActionPerformed(evt);
            }
        });
        jMenu3.add(gris3);

        jMenu2.add(jMenu3);

        Blur.setText("Blur");
        Blur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlurActionPerformed(evt);
            }
        });
        jMenu2.add(Blur);

        jMenuItem3.setText("Bordes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem7.setText("BlurMotion");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Sharpen");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        Emboss.setText("Emboss");
        Emboss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmbossActionPerformed(evt);
            }
        });
        jMenu2.add(Emboss);

        Mediana.setText("Mediana");
        Mediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedianaActionPerformed(evt);
            }
        });
        jMenu2.add(Mediana);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        BufferedImage imagen=img.abrirImagenLocal();
        if (imagen!=null){
            jLabel1.setIcon(formats.bufferedImageToIcon(imagen));
            jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.invertirImagen(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void BrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrilloActionPerformed
        Brillo b = new Brillo(this, true);
        b.setVisible(true);
        b.setTitle("Brillo");
        int brillo = b.getBrillo();
        System.out.println(brillo);
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.brilloImagen(imagen, brillo);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
        
        
    }//GEN-LAST:event_BrilloActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.filtroRojo(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.filtroAzul(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.filtroVerde(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void RGBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGBActionPerformed
        RGB rgb = new RGB(this, true);
        rgb.setVisible(true);
        rgb.setTitle("RGB");
        int r = rgb.getRojo();
        int g = rgb.getVerde();
        int b = rgb.getAzul();
        
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.rgb(imagen, r,g,b);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_RGBActionPerformed

    private void AltoContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltoContrasteActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.altoContraste(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_AltoContrasteActionPerformed

    private void MosaicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MosaicoActionPerformed
        Mosaico m = new Mosaico(this, true);
        m.setVisible(true);
        m.setTitle("MOSAICO");
        int x = m.getX();
        int y = m.getY();
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.mosaicoFiltro(imagen, x, y);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
        
        
    }//GEN-LAST:event_MosaicoActionPerformed

    private void gris2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gris2ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.gris2(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_gris2ActionPerformed

    private void gris1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gris1ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.gris1(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_gris1ActionPerformed

    private void gris3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gris3ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.gris3(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_gris3ActionPerformed

    private void BlurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlurActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.blur(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_BlurActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.findEdges(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.motionBlur(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.sharpen(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void EmbossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmbossActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.emboss(imagen, 5);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_EmbossActionPerformed

    private void MedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedianaActionPerformed
        BufferedImage imagen= formats.iconToBufferedImage(jLabel1.getIcon());
        imagen= filtros.mediana(imagen);
        jLabel2.setIcon(formats.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_MedianaActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Procesamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Procesamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Procesamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Procesamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Procesamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AltoContraste;
    private javax.swing.JMenuItem Blur;
    private javax.swing.JMenuItem Brillo;
    private javax.swing.JMenuItem Emboss;
    private javax.swing.JMenuItem Mediana;
    private javax.swing.JMenuItem Mosaico;
    private javax.swing.JMenuItem RGB;
    private javax.swing.JMenuItem gris1;
    private javax.swing.JMenuItem gris2;
    private javax.swing.JMenuItem gris3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
