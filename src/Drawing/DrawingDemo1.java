package Drawing;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*; 
import javax.swing.*;     

class DisplayPanel extends JPanel {
	
	public DisplayPanel(){}
	
	JLabel label = new JLabel();
	
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// draw a 2D ellipse filled with a red yellow gradient
		
		int startPointX = 5;
		int startPointY = 30;
		int endPointX = 45;
		int endPointY = 100;
		Color startColor = Color.blue;
		Color endColor = Color.red;
		boolean isCyclic = true;
		g2d.setPaint(new GradientPaint(startPointX,startPointY,startColor,endPointX,endPointY,endColor,isCyclic));
		
		int nextX = 5;
		int nextY = 30;
		int width = 45;
		int height = 45;
				
		for (int i = 0; i < 3; ++i){
			nextX += width;
			g2d.fill(new Ellipse2D.Double(nextX,nextY,width,height));
		}			
	}
	
	public void draw(){		
		this.add(label);
		
		repaint();			
	}	
}
class ShapesDisplay extends JFrame {
  
  	DisplayPanel display;
  	
   public ShapesDisplay(){
      super( "Some 2D Shapes" );
      
      display = new DisplayPanel();
      Container container = getContentPane();
      container.add(display);
     
      display.draw();
      setSize(450,200);
      this.setDefaultCloseOperation(
  	         JFrame.EXIT_ON_CLOSE );
      setVisible(true);
     
	}	
}
public class DrawingDemo1 {

	// execute application
	   public static void main( String [] args){
	      ShapesDisplay application = new ShapesDisplay();
	      
	   }

}
