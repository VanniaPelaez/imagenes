package Package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class zor {
    static int width = 800;
    static int height = 800;
    
    static Color grey = new Color(135,135,135);
    static Color orange = new Color(233,91,43);
    
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
    	drawBackground(PIXEL_SIZE, grey);     
    	fillRect(3, 2, 2, 2, orange);
    	fillRect(12, 2, 2, 2, orange);
    	putPixel(3,1,Color.black);
    	putPixel(13,1,Color.black);
    	fillRect(6, 3, 5, 5, orange);
    	fillRect(4, 4, 2, 3, orange);
    	fillRect(11, 4, 2, 3, orange);
    	drawVerticalLine(6,8,3,orange);
    	putPixel(2,8,orange);
    	drawVerticalLine(6,8,13,orange);
    	putPixel(14,8,orange);
    	fillRect(7,7,3,3,orange);
    	putPixel(8,10,orange);
    	fillRect(1,9,6,2,Color.white);
    	fillRect(4,7,2,2,Color.white);
    	putPixel(6,8,Color.white);
    	putPixel(7,10,Color.white);
    	drawHorizontalLine(3,7,11,Color.white);
    	putPixel(8,11,Color.black);
    	fillRect(10,9,6,2,Color.white);
    	fillRect(11,7,2,2,Color.white);
    	putPixel(10,8,Color.white);
    	putPixel(9,10,Color.white);
    	drawHorizontalLine(9,13,11,Color.white);
    	drawHorizontalLine(5,11,12,Color.white);
    	putPixel(5,9,Color.black);
    	putPixel(11,9,Color.black);
    	fillRect(6,13,5,4,orange);
    	drawVerticalLine(15,16,5,orange);
    	drawVerticalLine(15,16,11,orange);
    	putPixel(12,15,orange);
    	fillRect(12,16,3,2,orange);
    	drawVerticalLine(17,18,15,orange);
    	putPixel(14,18,orange);
    	fillRect(7,14,3,3,Color.white);
    	drawVerticalLine(15,16,7,Color.black);
    	drawVerticalLine(15,16,9,Color.black);
    	
    	//drawHorizontalLine(6, 10, 1, Color.black);
    	//fillRect(1, 9, 13, 6, Color.black);
        //drawVerticalLine(3,16,5,darkOrange);
        //putPixel(9,7,darkBlue);
        drawSquareGrid(PIXEL_SIZE, Color.black);
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("zorrito.jpg"));
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