package Drawing;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class PolyLineDemo extends JFrame {
   private java.util.List<Integer> xList;  // List of x-coord
   private java.util.List<Integer> yList;  // List of y-coord
   private int [] xvals;
   private int [] yvals;
   private JPanel canvas;
 
   /** Constructor */
   public PolyLineDemo() {
      xList = new ArrayList<Integer>();
      yList = new ArrayList<Integer>();
      
      addPointsFromFile("data.txt");
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(500,500));
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.CENTER);
      
	  draw();
	  pack();
	  this.setLocationRelativeTo(null); 
      this.setVisible(true);    
   }
   /** Add a point to this PolyLine */
   public void addPoint(int x, int y) {
      xList.add(x);
      yList.add(y);
   }
   public void addPointsFromFile(String fileName) {
	   Scanner s = null;	   
	   int x,y;	 
       try {   	 
           s = new Scanner(new BufferedReader(new FileReader(fileName)));
           
           while (s.hasNextLine()){
        	   String line = s.nextLine();
        	 
        	   String [] tokens = line.split("[,\\s]+");
        	   x = Integer.parseInt(tokens[0]);
        	   y = Integer.parseInt(tokens[1]);
        	  
        	   xList.add(x);
        	   yList.add(y);
           }          
           xvals = new int[xList.size()];
           yvals = new int[yList.size()];
           Iterator<Integer> iterator1 = xList.iterator();
           Iterator<Integer> iterator2 = yList.iterator();
           for (int i = 0; i < xvals.length; i++)
           {
               xvals[i] = iterator1.next();
               yvals[i] = iterator2.next();
           }
 
       }
       catch(Exception e){}
       finally {
    	   
           if (s != null) s.close();
       }   	      
   }
   public void draw(){
	   canvas.repaint();
   }
   class DrawCanvas extends JPanel{	   
	   public void paintComponent (Graphics g){
		   super.paintComponent(g);	   
		   Graphics2D g2 = (Graphics2D) g;          
		   draw(g2);	   
	   }
	  
	   public void draw(Graphics2D g) { 
		   g.setColor(Color.BLACK);    // set the drawing color	
		   g.setStroke(new BasicStroke(5));
	       g.drawPolygon( xvals,yvals,4 ); 
	       g.setColor(Color.RED);    // set the drawing color
	       g.setStroke(new BasicStroke(10));
	       g.drawPolyline( xvals,yvals,4 ); 
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolyLineDemo poly = new PolyLineDemo();
		
		
	}

}
