package Package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class pastel {
    static int width = 800;
    static int height = 800;
    
    static Color darkgrey = new Color(100,109,115);
    static Color softgrey = new Color(158,161,167);
    static Color red = new Color(139,10,0);
    static Color darkbrown = new Color(146,67,10);
    static Color softbrown = new Color(208,131,68);
    static Color middlebrown = new Color(150,90,40);
    
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
    	drawHorizontalLine(6,11,1,darkgrey);
    	drawHorizontalLine(6,11,2,softgrey);
    	drawHorizontalLine(4,5,2,darkgrey);
    	drawHorizontalLine(4,5,3,softgrey);
    	drawHorizontalLine(2,3,3,darkgrey);
    	drawHorizontalLine(2,3,4,softgrey);
    	drawVerticalLine(4,7,1,darkgrey);
    	drawVerticalLine(4,8,2,softgrey);
    	putPixel(3,6,softgrey);
    	putPixel(3,9,softgrey);
    	drawHorizontalLine(4,5,7,softgrey);
    	putPixel(6,8,softgrey);
    	putPixel(6,10,softgrey);
    	putPixel(7,11,softgrey);
    	putPixel(11,11,softgrey);
    	fillRect(7,8,6,3,softgrey);
    	putPixel(12,7,softgrey);
    	drawVerticalLine(7,9,13,softgrey);
    	drawVerticalLine(6,8,14,softgrey);
    	drawVerticalLine(4,8,15,softgrey);
    	drawVerticalLine(4,7,16,darkgrey);
    	putPixel(14,4,softgrey);
    	drawHorizontalLine(14,15,3,darkgrey);
    	drawHorizontalLine(12,13,3,softgrey);
    	drawHorizontalLine(12,13,2,darkgrey);
    	putPixel(4,4,red);
    	putPixel(7,3,red);
    	putPixel(5,6,red);
    	putPixel(9,5,red);
    	putPixel(9,7,red);
    	putPixel(11,4,red);
    	putPixel(13,5,red);
    	drawVerticalLine(8,11,1,darkbrown);
    	drawVerticalLine(9,11,2,middlebrown);
    	drawHorizontalLine(3,4,10,middlebrown);
    	drawHorizontalLine(3,4,11,softbrown);
    	drawHorizontalLine(2,3,12,darkbrown);
    	drawHorizontalLine(4,5,13,darkbrown);
    	drawHorizontalLine(4,5,12,middlebrown);
    	drawHorizontalLine(5,6,11,middlebrown);
    	drawHorizontalLine(6,11,14,darkbrown);
    	drawHorizontalLine(6,11,13,middlebrown);
    	drawHorizontalLine(6,11,12,softbrown);
    	drawHorizontalLine(8,10,11,middlebrown);
    	drawHorizontalLine(12,14,13,darkbrown);
    	drawHorizontalLine(12,14,12,middlebrown);
    	drawHorizontalLine(12,14,11,softbrown);
    	drawHorizontalLine(13,14,10,softbrown);
    	putPixel(14,9,softbrown);
    	putPixel(15,12,darkbrown);
    	drawVerticalLine(9,11,15,middlebrown);
    	drawVerticalLine(8,11,16,darkbrown);
    	
    	
    	
    
    	
    	
    	
    	
    	
    	//drawHorizontalLine(6, 10, 1, Color.black);
    	//fillRect(1, 9, 13, 6, Color.black);
        //drawVerticalLine(3,16,5,darkOrange);
        //putPixel(9,7,darkBlue);
        drawSquareGrid(PIXEL_SIZE, Color.black);
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("pastel.jpg"));
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