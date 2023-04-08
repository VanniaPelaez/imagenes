package Package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class rab {
    static int width = 800;
    static int height = 800;
    
    static Color softgrey = new Color(131,130,130); //softgrey
    static Color darkgrey = new Color(89,86,86); //darkgrey
    static Color pink = new Color(217,150,150);
    
    static Graphics2D g;

    static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // Definimos el tamaÃ±o del pixel y la matriz de colores
    private final static int PIXEL_SIZE = 40;
    private final static Color[][] PIXELS = {
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}
    };
    
    public static void paint() {
    	drawBackground(PIXEL_SIZE, Color.white);  
    	putPixel(5,2,darkgrey);
    	fillRect(4, 3, 3, 8, darkgrey);
    	putPixel(7,10,darkgrey);
    	fillRect(8, 6, 3, 8, darkgrey);
    	putPixel(9,2,darkgrey);
    	fillRect(4, 11, 7, 5, darkgrey);
    	drawVerticalLine(12,14,3,darkgrey);
    	fillRect(8, 3, 3, 3, darkgrey);
    	drawVerticalLine(12,14,11,darkgrey);
    	drawHorizontalLine(4,10,15, darkgrey);
    	drawHorizontalLine(5,9,16, darkgrey);
    	drawHorizontalLine(4,10,17, darkgrey);
    	drawHorizontalLine(3,11,18, darkgrey);
    	drawHorizontalLine(3,11,19, darkgrey);
    	drawVerticalLine(3,8,5,pink);
    	drawVerticalLine(3,8,9,pink);
    	fillRect(5, 13, 5, 3, softgrey);
    	drawHorizontalLine(6, 8, 16, softgrey);
    	fillRect(5, 11, 2, 2, Color.white);
    	fillRect(8, 11, 2, 2, Color.white);
    	drawVerticalLine(11,12,6, Color.black);
    	drawVerticalLine(11,12,9, Color.black);
    	putPixel(7,14,pink);
    	fillRect(6, 18, 3, 2, Color.white);
        //fillRect(1, 9, 13, 6, Color.black);
        //drawVerticalLine(3,16,5,darkOrange);
        //putPixel(9,7,darkBlue);
        drawSquareGrid(PIXEL_SIZE, Color.black);
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("conejo.jpg"));
            System.out.println("EXITO !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void drawVerticalLine(int a, int b, int x, Color c){
    	for(int i=a;i<=b;i++){
     	   g.setColor(c);
           g.fillRect(x * PIXEL_SIZE, i * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void drawHorizontalLine(int a, int b, int y, Color c){
        for(int i=a;i<=b;i++){
     	   g.setColor(c);
           g.fillRect(i * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void putPixel(int x, int y, Color c){       
	   g.setColor(c);
	   g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);    
    }
    
    private static void fillRect(int x, int y, int width, int height, Color c){
    	g.setColor(c);
    	g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, width*PIXEL_SIZE, height*PIXEL_SIZE);
    }
    
    private static void drawSquareGrid(int size, Color c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                
                g.setColor(c);
                g.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }
    private static void drawBackground(int size, Color c) {
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.setColor(c);
                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
            }
        }
    }
    
    
    public static void main(String[] args) {
        g = image.createGraphics();        
        paint();
    }
}