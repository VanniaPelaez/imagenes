package Package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class pingu {
    static int width = 800;
    static int height = 800;
    
    static Color pink = new Color(255,204,204); //rosa
    static Color blue = new Color(177,223,249); //azul
    static Color yellow = new Color(255,230,153); //amarillo
    
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
    	fillRect(7, 1, 7, 15, Color.black);
    	drawVerticalLine(2,15,6, Color.black);
    	drawVerticalLine(2,15,14, Color.black);
    	drawVerticalLine(3,14,5, Color.black);
    	drawVerticalLine(3,14,15, Color.black);
    	drawVerticalLine(7,13,4, Color.black);
    	drawVerticalLine(7,13,16, Color.black);
    	drawHorizontalLine(2,3,10, Color.black);
    	drawHorizontalLine(17,18,10, Color.black);
    	putPixel(3,9,Color.black);
    	putPixel(17,9,Color.black);
    	fillRect(7, 3, 7, 11, Color.white);
    	drawHorizontalLine(8,12,14, Color.white);
    	drawVerticalLine(4,13,6, Color.white);
    	drawVerticalLine(4,13,14, Color.white);
    	drawVerticalLine(8,12,5, Color.white);
    	drawVerticalLine(8,12,15, Color.white);
    	putPixel(10,3,Color.black);
    	putPixel(8,6,Color.black);
    	putPixel(12,6,Color.black);
    	drawHorizontalLine(6,7,7, pink);
    	drawHorizontalLine(13,14,7, pink);
    	drawHorizontalLine(9,11,8, yellow);
    	putPixel(10,7,yellow);
    	drawHorizontalLine(6,7,16, yellow);
    	drawHorizontalLine(13,14,16, yellow);
    	drawHorizontalLine(5,8,17, yellow);
    	drawHorizontalLine(12,15,17, yellow);
    	drawHorizontalLine(8,12,16, Color.black);
        //drawHorizontalLine(6, 10, 1, Color.black);
    	//fillRect(1, 9, 13, 6, Color.black);
        //drawVerticalLine(3,16,5,darkOrange);
        //putPixel(9,7,darkBlue);
        drawSquareGrid(PIXEL_SIZE, Color.black);
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("pingu.jpg"));
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