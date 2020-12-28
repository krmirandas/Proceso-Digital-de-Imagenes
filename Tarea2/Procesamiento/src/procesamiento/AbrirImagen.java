/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class AbrirImagen {
    
    private JFileChooser selectorImage;
     /**
      * Muestra un mensaje de error avisando que no se ha podido cargar la imagen
      */
    private void errorImagen(){
        JOptionPane.showMessageDialog(null,"No se pudo cargar la imagen","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    /**
    * Carga el JFIleChooser para seleccionar imagen
    * @return devuelve false si la acción fue cancelada por el usuario y true si
    * ha seleccionado algún archivo
    */
    private boolean abrirJFileChooser(){
        this.selectorImage=new JFileChooser();
        this.selectorImage.setDialogTitle("Elije an image");
        int flag=this.selectorImage.showOpenDialog(null);
        if (flag==JFileChooser.APPROVE_OPTION){
            return true;
        }else{
            return false;
        }
    }
    
     /**
      * Muestra un cuadro de diálogo para abrir una imagen desde archivo
      * @return devuelve la imagen seleccionada o null si no se pudo cargar
      */
    public BufferedImage abrirImagenLocal(){
        BufferedImage imagenRetorno=null;
        if(this.abrirJFileChooser()==true){
            try {
                imagenRetorno = ImageIO.read(this.selectorImage.getSelectedFile());
            } catch (Exception e) {
                errorImagen();
            }
        }        
        return imagenRetorno;
    }
}
