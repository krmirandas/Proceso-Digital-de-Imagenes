package ClasesImagenes;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Marcos
 */
public class AbrirImagen extends BaseImagenes {
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
        this.selectorImage.setDialogTitle("Choose an image");
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
                if (imagenRetorno!=null){
                    super.actualizarImagen(imagenRetorno, "Imagen abierta desde archivo");
                }else{
                    errorImagen();
                }
            } catch (Exception e) {
                errorImagen();
            }
        }        
        return imagenRetorno;
    }
    
    /**
     * Carga una imagen a partir de una URL de internet
     * @param URLimagen URL de la imagen que se desea abrir
     * @return devuelve la imagen obtenida o null si no se pudo cargar
     */
    public BufferedImage abrirImagenURL(String URLimagen){
        BufferedImage imagenRetorno=null;
        try {
            URL url = new URL(URLimagen);
            imagenRetorno = ImageIO.read(url);
            super.actualizarImagen(imagenRetorno, "Imagen abierta desde URL: " + URLimagen);
        } catch (Exception e) {
            errorImagen();
        }
        return imagenRetorno;
    }
    
}
