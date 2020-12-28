/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesamiento;


import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 *
 * @author kevin
 */
public class Filtros {
    
    
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
    
    private int calcularMediaColor2(Color color){
        int averageColor;
        averageColor=(int)((color.getRed() * 0.299) + (color.getGreen() *  0.587) + (color.getBlue() * 0.114));
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
        return imagenRetorno;
    }
    
    public BufferedImage brilloImagen(BufferedImage imagen, int brillo){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                int rojo = auxColor.getRed() + brillo;
                int verde = auxColor.getGreen() + brillo;
                int azul = auxColor.getBlue() + brillo;
                int redbrillo = Math.min(rojo,255);
                int greenbrillo = Math.min(verde,255);
                int bluebrillo = Math.min(azul,255);
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(redbrillo, greenbrillo, bluebrillo,auxColor.getAlpha())));
            }
        }
        return imagenRetorno;
    }
    
    public BufferedImage filtroRojo(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
               auxColor=new Color(imagenRetorno.getRGB(i, j));
               mediaColor=this.calcularMediaColor(auxColor);
               imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(mediaColor,0,0,auxColor.getAlpha())));
            }
        }
        return imagenRetorno;
    }
    
     public BufferedImage filtroAzul(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
               auxColor=new Color(imagenRetorno.getRGB(i, j));
               mediaColor=this.calcularMediaColor(auxColor);
               imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(0,0,mediaColor,auxColor.getAlpha())));
            }
        }
        return imagenRetorno;
    }
     
      public BufferedImage filtroVerde(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
               auxColor=new Color(imagenRetorno.getRGB(i, j));
               mediaColor=this.calcularMediaColor(auxColor);
               imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(0,mediaColor,0,auxColor.getAlpha())));
            }
        }
        
        return imagenRetorno;
    }
      
    public BufferedImage altoContraste(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
               auxColor=new Color(imagenRetorno.getRGB(i, j));
               mediaColor=this.calcularMediaColor(auxColor);
               if(mediaColor < 128){
               imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(255,255,255,auxColor.getAlpha())));
               }else{
                   imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(0,0,0,auxColor.getAlpha())));     
               }
            }
        }
        return imagenRetorno;
    }
      
    public BufferedImage rgb(BufferedImage imagen, int r, int g, int b){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                int rojo = auxColor.getRed() & (r);
                int verde = auxColor.getGreen() & (g);
                int azul = auxColor.getBlue() & (b);
                int redrgb = Math.min(rojo,255);
                int greenrgb = Math.min(verde,255);
                int bluergb = Math.min(azul,255);
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(redrgb, greenrgb, bluergb,auxColor.getAlpha())));
            }
        }
        return imagenRetorno;
    }
    
    public BufferedImage gris1(BufferedImage imagen){
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
        return imagenRetorno;
    }
    
    public BufferedImage gris2(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                mediaColor=this.calcularMediaColor2(auxColor);
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(mediaColor,mediaColor,mediaColor,auxColor.getAlpha())));
            }
        }
        return imagenRetorno;
    }
    
     public BufferedImage gris3(BufferedImage imagen){
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        Color auxColor;
        int mediaColor;
        for( int i = 0; i < imagenRetorno.getWidth(); i++ ){
            for( int j = 0; j < imagenRetorno.getHeight(); j++ ){
                auxColor=new Color(imagenRetorno.getRGB(i, j));
                int rojo = (auxColor.getRed());
               
                imagenRetorno.setRGB(i, j,this.colorRGBaSRGB(new Color(rojo,rojo,rojo,auxColor.getAlpha())));
            }
        }
        return imagenRetorno;
    }
      
    public BufferedImage mosaicoFiltro(BufferedImage imagen, int tamx, int tamy){
        Color auxColor;
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        int x = 0, y = 0, r = 0, g = 0, b = 0, m = 0, n = 0;
        while (x < imagenRetorno.getWidth()){
            m = ((x + tamx) < imagenRetorno.getWidth())? tamx : imagenRetorno.getWidth() - x;
             while (y < imagenRetorno.getHeight()){
                  n = ((y + tamy) < imagenRetorno.getHeight())? tamy : imagenRetorno.getHeight() - y;
                  for (int i = 0; i < m; i++) {
                       for (int j = 0; j < n; j++){
                            Color c = new Color(imagenRetorno.getRGB(i + x, j + y));
                            r += c.getRed(); g += c.getGreen(); b += c.getBlue();
                       }
                  }
                  r /= (m * n); 
                  g /= (m * n);
                  b /= (m * n);
                  for (int i = 0; i < m; i++) {
                      for (int j = 0; j < n; j++){
                          auxColor=new Color(imagenRetorno.getRGB(i, j));
                          imagenRetorno.setRGB(i + x, j + y,this.colorRGBaSRGB(new Color(r,g,b, auxColor.getAlpha())));
                      }    
                  }y += n; r = 0; g = 0; b = 0;
             
             }x += m; y = 0;
        }
        return imagenRetorno;
    }
    
    private static int normalize(int n) { return (n < 0)? 0 : ((n < 256)? n : 255);}
    
    /**
     * Filtro de convulsion sobre una imagen con una matriz y factor dados.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @param matriz Es la matriz con la que se aplica el filtro.
     * @param factor Es el factor de contribución en la suma de pixeles.
     * @return Devuelve una imagen con el filtro de convulsion aplicado.
     */
    public BufferedImage convolution(BufferedImage imagen, double[][] matriz, double factor, double bias) {
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        //Se definen las variables auxiliares.
        int w = imagenRetorno.getWidth(), h = imagenRetorno.getHeight(), tam = matriz.length, rad = tam/2;
        double r = 0, g = 0, b = 0;
        // Se guardan los colores originales de los pixeles.
        Color[][] original = new Color[w][h];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) original[x][y] = new Color(imagenRetorno.getRGB(x, y));
        } // Se recorre la matriz para calcular los nuevos colores.
        for (int x = 0; x < w; x++) {
            // Se definen los limites horizontales de la matriz segun la posicion del pixel actual.
            int xi = (x < rad)? rad - x : 0, xf = ((w - x) <= rad)? rad + w - x : tam;
            for (int y = 0; y < h; y++, r = 0, g = 0, b = 0){
                // Se definen los limites verticales de la matriz segun la posicion del pixel actual.
                int yi = (y < rad)? rad - y : 0, yf = ((h - y) <= rad)? rad + h - y : tam;
                for (int i = xi, px = x - rad; i < xf; i++) {
                    for (int j = yi, py = y - rad; j < yf; j++) {
                        double val = matriz[i][j];
                        r += (original[px + i][py + j].getRed() * val);
                        g += (original[px + i][py + j].getGreen() * val);
                        b += (original[px + i][py + j].getBlue() * val);
                    }
                } r = r * factor + bias; g = g * factor + bias; b = b * factor + bias;
                imagenRetorno.setRGB(x, y, new Color(normalize((int)r), normalize((int)g), normalize((int)b)).getRGB());
            }
        } return imagenRetorno;
    }
    
     /**
     * Filtro Blur con una matriz de 3x3.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @return Devuelve una imagen con el filtro Blur aplicado.
     */
    public BufferedImage blur(BufferedImage imagen) {
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        double[][]m = {{0,0,1,0,0},{0,1,1,1,0},{1,1,1,1,1},{0,1,1,1,0},{0,0,1,0,0}};
        return convolution(imagenRetorno, m, 1.0 / 13.0, 0);
    }
    
    /**
     * Filtro que encuentra los bordes con una matriz de 3x3.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @return Devuelve una imagen con los bordes filtrados.
     */
    public BufferedImage findEdges(BufferedImage imagen) {
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        double[][]m = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
        return convolution(imagenRetorno, m, 1, 0);
    }
    
    /**
     * Filtro MotionBlur con una matriz de 5x5.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @return Devuelve una imagen con el filtro MotionBlur aplicado.
     */
    public BufferedImage motionBlur(BufferedImage imagen) {
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        double[][]m = {{1,0,0,0,0,0,0},{0,1,0,0,0,0,0},{0,0,1,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,1,0,0},{0,0,0,0,0,1,0},{0,0,0,0,0,0,1}};
        return convolution(imagenRetorno, m, 1.0 / 7.0 , 0);
    }
    
     /**
     * Filtro de bordes sobre una imagen con una matriz de 3x3.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @return Devuelve una imagen con los bordes remarcados.
     */
    public BufferedImage sharpen(BufferedImage imagen) {
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        double[][]b = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
        return convolution(imagenRetorno, b, 1, 0);
    }
    
     /**
     * Filtro Emboss con una matriz de 3x3.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @param mode Es el tipo de Emboss que se aplica, <0 es horizonatl, 0 es a 45 grados y >0 es vertical.
     * @return Devuelve una imagen con el filtro aplicado.
     */
    public  BufferedImage emboss(BufferedImage imagen, int mode) {
        BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        double[][]eH = {{-1,-1,-1},{0,0,0},{1,1,1}};
        if(mode < 0) return convolution(imagenRetorno, eH, 1, 128);
        double[][]eV = {{-1,0,1},{-1,0,1},{-1,0,1}};
        if(mode > 0) return convolution(imagenRetorno, eV, 1, 128);
        double[][]e45 = {{-1,-1,0},{-1,0,1},{0,1,1}};
        return convolution(imagenRetorno, e45, 1, 128);
    }
    /**
     * Filtro de convolucion mediana de imagen con una matriz de 3x3.
     * @param bi Es el buffer que contiene la imagen a filtrar.
     * @return Devuelve una imagen con el filtro aplicado.
     */
    public  BufferedImage mediana(BufferedImage imagen) {
         BufferedImage imagenRetorno=this.clonarBufferedImage(imagen);
        //Se definen las variables auxiliares.
        int w = imagenRetorno.getWidth(), h = imagenRetorno.getHeight(), tam = 3, rad = tam/2, r[], g[], b[];
        // Se guardan los colores originales de los pixeles.
        Color[][] original = new Color[w][h];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) original[x][y] = new Color(imagenRetorno.getRGB(x, y));
        } // Se recorre la matriz para calcular los nuevos colores.
        for (int x = 0; x < w; x++) {
            // Se definen los limites horizontales de la matriz segun la posicion del pixel actual.
            int xi = (x < rad)? rad - x : 0, xf = ((w - x) <= rad)? rad + w - x : tam;
            for (int y = 0; y < h; y++){
                // Se definen los limites verticales de la matriz segun la posicion del pixel actual.
                int yi = (y < rad)? rad - y : 0, yf = ((h - y) <= rad)? rad + h - y : tam;
                // Se definen los arreglos auxiliares de color para calcular la mediana de cada componente.
                r = new int[(xf - xi) * (yf - yi)]; g = new int[r.length]; b = new int[r.length];
                for (int i = 0, px = x - rad; (i + xi) < xf; i++) {
                    for (int j = 0, py = y - rad; (j + yi) < yf; j++) {
                        r[j + (yf - yi) * i] = original[px + i + xi][py + j + yi].getRed();
                        g[j + (yf - yi) * i] = original[px + i + xi][py + j + yi].getGreen();
                        b[j + (yf - yi) * i] = original[px + i + xi][py + j + yi].getBlue();
                    }
                } imagenRetorno.setRGB(x, y, new Color(mediana(r), mediana(g), mediana(b)).getRGB());
            }
        } return imagenRetorno;
    }
    
    private static int mediana(int ... x) {
        int xn = x.length, m = -1;
        for (int i = 0, j = 0; i <= (xn / 2); i++, j = i) {
            for (int k = i + 1; k < xn; k++) { if(x[j] > x[k]) j = k; }
            m = x[j]; x[j] = x[i]; x[i] = m;
        } if((xn % 2) == 0) return (m + x[xn / 2 - 1]) / 2;
        return m;
    }
    

    
}
