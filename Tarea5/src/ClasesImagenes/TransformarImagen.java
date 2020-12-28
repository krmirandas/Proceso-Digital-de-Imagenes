/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesImagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Kevin
 */
public class TransformarImagen extends BaseImagenes{
    
    private int colorRGBaSRGB(Color colorRGB){
        int colorSRGB;
        colorSRGB=(colorRGB.getRed() << 16) | (colorRGB.getGreen() << 8) | colorRGB.getBlue();
        return colorSRGB;
    }
    private BufferedImage clonarBufferedImage(BufferedImage bufferImage){
        BufferedImage copiaImagen=new BufferedImage (bufferImage.getWidth(),bufferImage.getHeight(),bufferImage.getType());
        copiaImagen.setData(bufferImage.getData());
        return copiaImagen;
    }
    private int calcularMediaColor(Color color){
        int averageColor;
        averageColor=(int)((color.getRed()+color.getGreen()+color.getBlue())/3);
        return averageColor;
    }
    private Color chequearUmbral(Color color, int umbral){
        Color colorSalida;
        if (this.calcularMediaColor(color)>=umbral){
            colorSalida=new Color(255,255,255, color.getAlpha());
        }else{
            colorSalida=new Color(0, 0, 0, color.getAlpha());
        }
        return colorSalida;
    }
        
    public BufferedImage blancoNegro(BufferedImage imagen, int umbral){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(this.chequearUmbral(auxColor,umbral)));
            }
        }
        super.actualizarImagen(imagenRetorno,"Transformación: la imagen se ha pasado a blanco y negro. Umbral: "
                + umbral);
        return imagenRetorno;
    }
    
    public BufferedImage escalaGrises(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                mediaColor=this.calcularMediaColor(auxColor);
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(mediaColor,mediaColor,mediaColor,auxColor.getAlpha())));
            }
        }
        super.actualizarImagen(imagenRetorno,"Transformación: la imagen se ha pasado a escala de grises");
        return imagenRetorno;
    }
    
    public BufferedImage invertirImagen(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(255-auxColor.getRed(), 
                        255-auxColor.getGreen(), 255-auxColor.getBlue(),auxColor.getAlpha())));
            }
        }
        super.actualizarImagen(imagenRetorno,"Transformación: la imagen se ha invertido");
        return imagenRetorno;
    }
    
    public BufferedImage filtroSepia(BufferedImage imagen, int depth){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                int rojo = auxColor.getRed() + (depth*2);
                int verde = auxColor.getGreen() + depth;
                int azul = auxColor.getBlue();
                int rr = Math.min(rojo,255);
                int gg = Math.min(verde,255);
                mediaColor=this.calcularMediaColor(auxColor);
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(rr,gg,azul,auxColor.getAlpha())));
            }
        }
        super.actualizarImagen(imagenRetorno,"Transformación: se ha aplicado un filtro sepia la imagen");
        return imagenRetorno;
    }
    
    /**
    * Metodo que calcula el color de mayor frecuencia en una imagen en una vecindad de 7x7
    * de la imagen dada y las coordenadas del centro de la vecindad
    * @param image Es la imagen a busrcar la vecindad
    * @param x Es la coordenada en x del centro de la vecindad
    * @param y Es la coordenada en y del centro de la vecindad
    * @return Es el numero que representa el color mas frecuente en la vecindad
    */
    public static int mayorFrecuenciaC(BufferedImage image, int x, int y){
        Map<Integer,Integer> histograma = new HashMap<Integer,Integer>();
        int width = image.getWidth();        
        int height = image.getHeight();
        Color color;      
        int k,v;
        int mf = 0;
        int c = 0;
        for(int i = x-3; i < x+4; i++){
          for(int j = y-3; j < y+4; j++){
            if((i >= 0 && i < width) && (j >= 0 && j < height)){
              k = image.getRGB(i,j);
              // verificamos si no esta en la lista
              if(histograma.get(k) == null){
                v = 1;
                histograma.put(k,v);
                if(v > mf){
                  mf = v;
                  c = k;
                }
              }else{
                v = histograma.get(k);
                histograma.remove(k);
                v++;
                histograma.put(k,v);
                if(v > mf){
                  mf = v;
                  c = k;
                }
              }
            }
          }
        }
        return c;
    }
    
    public BufferedImage filtroOleo(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        int color = 0;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor = new Color(mayorFrecuenciaC(imagen,i,j));
                color = (auxColor.getRed() << 16)|(auxColor.getGreen() << 8)|auxColor.getBlue();
                mediaColor=this.calcularMediaColor(auxColor);
                imagenRetorno.setRGB(i,j,color);
            }
        }
        super.actualizarImagen(imagenRetorno,"Transformación: se ha aplicado un filtro sepia la imagen");
        return imagenRetorno;
    }
    
    public String stringToBinary(String s){
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes){
          int val = b;
          for (int i = 0; i < 8; i++){
            binary.append((val & 128) == 0 ? 0 : 1);
            val <<= 1;
          }
           binary.append(' ');
        }
        return binary.toString().replace(" ","");
     }
      
    public BufferedImage cifrar(BufferedImage imagen, String mensaje){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        int contador = 0;
        String rbyte;
        String mensajeBin = stringToBinary(mensaje);
        char[] mBin = mensajeBin.toCharArray();
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                int rojo = auxColor.getRed();
                int verde = auxColor.getGreen();
                int azul = auxColor.getBlue();
                String r = Integer.toString(rojo, 2);
                char[] rr = r.toCharArray();
                String g = Integer.toString(verde, 2);
                char[] gg = g.toCharArray();
                String a = Integer.toString(azul, 2);
                char[] aa = a.toCharArray();
                if(contador < mBin.length){
                    if(contador < mBin.length){
                        rr[ (rr.length) -1] = mBin[contador];
                        contador +=1;
                    }
                    if(contador < mBin.length){
                       gg[ (gg.length) -1] = mBin[contador];
                        contador +=1;
                    }
                    if(contador < mBin.length){
                        aa[ (aa.length) -1] = mBin[contador];
                        contador +=1;
                    }
                
                }else{
                    rr[ (rr.length) -1] = '1';
                    gg[ (gg.length) -1] = '1';
                    aa[ (aa.length) -1] = '1';
                }
                rojo = Integer.parseInt(new String(rr), 2);
                verde = Integer.parseInt(new String(gg), 2);
                azul = Integer.parseInt(new String(aa), 2);
                mediaColor=this.calcularMediaColor(auxColor);
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(rojo,verde,azul,auxColor.getAlpha())));
            }
        }
        super.actualizarImagen(imagenRetorno,"Transformación: se ha aplicado un filtro sepia la imagen");
        return imagenRetorno;
    }
    
    public String descifrar(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        int contador = 0;
        String rbyte;
        String mensaje = "";
        String mensajeBin = "";
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                int rojo = auxColor.getRed();
                int verde = auxColor.getGreen();
                int azul = auxColor.getBlue();
                String r = Integer.toString(rojo, 2);
                char[] rr = r.toCharArray();
                String g = Integer.toString(verde, 2);
                char[] gg = g.toCharArray();
                String a = Integer.toString(azul, 2);
                char[] aa = a.toCharArray();
                
                mensajeBin = mensajeBin + rr[(rr.length) -1 ] + gg[(gg.length) -1 ] + aa[(aa.length) -1 ];
                    
            }
        }
        for(int k = 0 ; k < mensajeBin.length(); k +=2 ){
            String sub = mensajeBin.substring(5,10);
            if(sub == "11111111"){
                break;
            }else{
                 mensaje = mensaje + sub;
            }
        }
        
        super.actualizarImagen(imagenRetorno,"Transformación: se ha aplicado un filtro sepia la imagen");
        return mensaje;
    }
    
}
