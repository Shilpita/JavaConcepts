package Drawing;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
/*
 * Reads an image file and converts it into rasterized image
 */
public class PictureShow {
	private BufferedImage image;       // the rasterized image
    private JFrame frame;                    
    private String filename;           // name of image file
    private  int width, height;        // width and height
    private String title;
	
    public PictureShow(String filename,String title) {
        this.filename = filename;
        this.title = title;
    }
    public PictureShow() { }
    
    public void setImage(BufferedImage image){
    	this.image = image;
    }
    public void createImageFromFile(){
    	try {
            // read from file in working directory
            File file = new File(filename);
            if (file.isFile()) {
                image = ImageIO.read(file);
            }
            // or read from file in same directory as this .class file
            else {
                URL url = getClass().getResource(filename);
                if (url == null) { url = new URL(filename); }
                image = ImageIO.read(url);
            }
            width  = image.getWidth(null);
            height = image.getHeight(null);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not open file: " + filename);
        }
    }
    BufferedImage getImage() { return image;}
    
    public void addImage(BufferedImage image){this.image = image;}
    
    public void show() {
        // create the GUI for viewing the image if needed
        if (frame == null) {
            frame = new JFrame();     
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle(filename);
            
            frame.getContentPane().add(getJLabel());
            
            frame.setSize(300,300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
    
    public JLabel getJLabel() {
        if (image == null) { return null; }         // no image available
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }
	public static void main(String[] args) {
		
		PictureShow app = new PictureShow("mum.jpg","mum");		
		app.createImageFromFile();	
		app.show();
		
		
	
	}
}

