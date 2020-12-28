package javaimagenes;

import ClasesImagenes.AbrirImagen;
import ClasesImagenes.BaseImagenes;
import ClasesImagenes.CambiarFormatos;
import ClasesImagenes.TransformarImagen;
import java.awt.image.BufferedImage;

/**
 *
 * @author Luis Marcos
 */
public class FormPrincipal extends javax.swing.JFrame {
    
    //Creamos los objetos que manejeramos en los eventos de los diferentes controles
    //Los objetos están instanciados
    BaseImagenes ObjBase=new BaseImagenes();
    AbrirImagen ObjAbrir=new AbrirImagen();
    CambiarFormatos ObjCambiarFormat=new CambiarFormatos();
    TransformarImagen ObjTransformaImg=new TransformarImagen();
    
    public FormPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel_Imagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ButtonDeshacer = new javax.swing.JButton();
        ButtonRehacer = new javax.swing.JButton();
        TextField_Info = new javax.swing.JTextField();
        ButtonSepia = new javax.swing.JButton();
        ButtonInvertir = new javax.swing.JButton();
        ButtonAbrir = new javax.swing.JButton();
        ButtonAbrirURL = new javax.swing.JButton();
        TextField_URL = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Imágenes en Java");

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel_Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(jLabel_Imagen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        jSplitPane1.setTopComponent(jPanel1);

        ButtonDeshacer.setText("Deshacer");
        ButtonDeshacer.setToolTipText("");
        ButtonDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeshacerActionPerformed(evt);
            }
        });

        ButtonRehacer.setText("Rehacer");
        ButtonRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRehacerActionPerformed(evt);
            }
        });

        ButtonSepia.setText("Sepia");
        ButtonSepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSepiaActionPerformed(evt);
            }
        });

        ButtonInvertir.setText("Oleo");
        ButtonInvertir.setActionCommand("ujhkj");
        ButtonInvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInvertirActionPerformed(evt);
            }
        });

        ButtonAbrir.setText("Abrir");
        ButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAbrirActionPerformed(evt);
            }
        });

        ButtonAbrirURL.setText("Abrir URL");
        ButtonAbrirURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAbrirURLActionPerformed(evt);
            }
        });

        TextField_URL.setText("https://mott.pe/noticias/wp-content/uploads/2017/10/Conoce-cu%C3%A1les-son-las-mejores-im%C3%A4genes-art%C3%ADsticas-capturadas-a-trav%C3%A9s-de-fotograf%C3%ADas-famosas.jpg");
        TextField_URL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_URLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonAbrir)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_URL, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ButtonAbrirURL)
                        .addGap(0, 111, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TextField_Info, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ButtonDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonRehacer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addComponent(ButtonSepia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(ButtonInvertir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonDeshacer)
                    .addComponent(ButtonRehacer)
                    .addComponent(ButtonSepia)
                    .addComponent(ButtonInvertir)
                    .addComponent(ButtonAbrir)
                    .addComponent(ButtonAbrirURL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_URL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAbrirActionPerformed
        BufferedImage imagen=ObjAbrir.abrirImagenLocal();
        if (imagen!=null){
            jLabel_Imagen.setIcon(ObjCambiarFormat.bufferedImageToIcon(imagen));
        }
    }//GEN-LAST:event_ButtonAbrirActionPerformed

    private void ButtonAbrirURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAbrirURLActionPerformed
        BufferedImage imagen=ObjAbrir.abrirImagenURL(TextField_URL.getText());
        if (imagen!=null){
            jLabel_Imagen.setIcon(ObjCambiarFormat.bufferedImageToIcon(imagen));
        }
    }//GEN-LAST:event_ButtonAbrirURLActionPerformed

    private void ButtonSepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSepiaActionPerformed
        FormSepia b = new FormSepia(this, true);
        b.setVisible(true);
        b.setTitle("Sepia");
        int depth = b.getDepth();
        System.out.println(depth);
        BufferedImage imagen=ObjCambiarFormat.iconToBufferedImage(jLabel_Imagen.getIcon());
        imagen=ObjTransformaImg.filtroSepia(imagen, depth);
        jLabel_Imagen.setIcon(ObjCambiarFormat.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_ButtonSepiaActionPerformed

    private void ButtonInvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInvertirActionPerformed
        BufferedImage imagen=ObjCambiarFormat.iconToBufferedImage(jLabel_Imagen.getIcon());
        imagen = ObjTransformaImg.filtroOleo(imagen);
        jLabel_Imagen.setIcon(ObjCambiarFormat.bufferedImageToIcon(imagen));
    }//GEN-LAST:event_ButtonInvertirActionPerformed

    private void ButtonDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeshacerActionPerformed
        BufferedImage imagen=ObjBase.deshacerImagen();
        if (imagen!=null){
            jLabel_Imagen.setIcon(ObjCambiarFormat.bufferedImageToIcon(imagen));
            TextField_Info.setText(ObjBase.informacionImagenActual());
        }
    }//GEN-LAST:event_ButtonDeshacerActionPerformed

    private void ButtonRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRehacerActionPerformed
        BufferedImage imagen=ObjBase.rehacerImagen();
        if (imagen!=null){
            jLabel_Imagen.setIcon(ObjCambiarFormat.bufferedImageToIcon(imagen));
            TextField_Info.setText(ObjBase.informacionImagenActual());
        }
    }//GEN-LAST:event_ButtonRehacerActionPerformed

    private void TextField_URLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_URLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_URLActionPerformed

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAbrir;
    private javax.swing.JButton ButtonAbrirURL;
    private javax.swing.JButton ButtonDeshacer;
    private javax.swing.JButton ButtonInvertir;
    private javax.swing.JButton ButtonRehacer;
    private javax.swing.JButton ButtonSepia;
    private javax.swing.JTextField TextField_Info;
    private javax.swing.JTextField TextField_URL;
    private javax.swing.JLabel jLabel_Imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
