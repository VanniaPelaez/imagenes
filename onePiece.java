package Package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class onePiece {
    static int width = 800;
    static int height = 800;
    
    static Color blue = new Color(39,181,245);
    static Color yellow = new Color(236,220,11);
    static Color red = new Color(220,2,3);
    
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
    	drawBackground(PIXEL_SIZE, blue);  
    	
    	fillRect(6,1,3,2,yellow);
    	putPixel(5,2,yellow);
    	putPixel(9,2,yellow);
    	drawHorizontalLine(5,9,3,red);
    	drawHorizontalLine(2,12,4,yellow);
    	fillRect(3,5,9,4,Color.white);
    	putPixel(4,9,Color.white);
    	putPixel(10,9,Color.white);
    	fillRect(5,9,5,4,Color.white);
    	drawHorizontalLine(6,8,13,Color.white);
    	fillRect(4,6,2,2,Color.black);
    	fillRect(9,6,2,2,Color.black);
    	putPixel(7,8,Color.black);
    	drawHorizontalLine(6,8,11,Color.black);
    	putPixel(5,10,Color.black);
    	putPixel(9,10,Color.black);
    	putPixel(4,3,Color.white);
    	putPixel(3,2,Color.white);
    	putPixel(10,3,Color.white);
    	putPixel(11,2,Color.white);
    	putPixel(3,10,Color.white);
    	putPixel(2,11,Color.white);
    	putPixel(11,10,Color.white);
    	putPixel(12,11,Color.white);
        //drawHorizontalLine(6, 10, 1, Color.black);
       	//fillRect(1, 9, 13, 6, Color.black);
           //drawVerticalLine(3,16,5,darkOrange);
           //putPixel(9,7,darkBlue);
        drawSquareGrid(PIXEL_SIZE, Color.black);
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("onepiece.jpg"));
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