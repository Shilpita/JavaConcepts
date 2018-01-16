package Drawing;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/** An example  to demonstrate various
  * drawing techniques including text, lines,
  * shapes, and filled shapes using Graphics2D.
  * The example in Drawings.java is reworked here
  * using a Graphics2D class.
  * Some of the notable 2D features:
  	 Filling, Fonts, Printing,Shapes, 
  	Strokes and Transformations
 
  */
public class DrawingsDemo3 extends JFrame {
   /** Class constructor method
     */ 
   public DrawingsDemo3( String titleText ) {
      super( titleText );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      DrawingPanel dp = new DrawingPanel();
      getContentPane().add( dp, BorderLayout.CENTER );
      setSize( 500, 500 );
      setVisible( true );
   }

   public class DrawingPanel extends JPanel {
      /** Class constructor
        */
      public DrawingPanel() {
         setBackground( Color.white );
         setBorder( BorderFactory.createTitledBorder(
            "Sample output from drawing methods:" ) );
      }
      /** Draws the text, lines, and shapes in the
        * specified graphics context
        * @param g the component's graphics context
        */
      public void paintComponent( Graphics gp ) {
         
         super.paintComponent(gp);
         
         // Cast the graphics objects to Graphics2D
         Graphics2D g = (Graphics2D) gp;
         
         g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
         g.setStroke(new BasicStroke(5.0f));
         
         double startX = 50;
         double startY = 50;
         double endX  = 100;
         double endY = 50;
         
         // Set the color  
         g.setPaint(Color.blue); 
         
         Line2D line = new Line2D.Double(startX,startY,endX,endY); 
         g.draw(line);
          
         
         startX = endX;
         startY = endY;
         endY += 100;
         g.setPaint(Color.magenta);
         
         Line2D line2 = new Line2D.Double( startX,startY,endX,endY);     
         g.draw(line2);
         
         // Draw a string of text
         
         g.setPaint(Color.blue);  
         Font newFont = new Font("Courier",Font.BOLD,25);         
         g.setFont(newFont);
         g.drawString( "Hello World!", (int)startX, (int)endY+20 );
         
        
         Font cFont = g.getFont();        
         String fontInfo = cFont.getName() + "  " +cFont.getStyle()+" "+cFont.getSize();
         
         g.setPaint(Color.black);
         g.drawString( fontInfo, (int) startX, (int) endY+40 );
         
         newFont = new Font("Vendana",Font.ITALIC,30);
         g.setFont(newFont);
         cFont = g.getFont();
         
         fontInfo = cFont.getName() + "  " +cFont.getStyle()+" "+cFont.getSize();        
         g.drawString( fontInfo, (int) startX, (int) endY+120 );
         
         newFont = new Font("Arial",Font.PLAIN,20);
         g.setFont(newFont);       
         g.setPaint( Color.green );
         
          g.drawString( "A Rectangle", (int) startX, (int) endY+170 );
          double width = 100;
          double height = 80;
          Rectangle2D.Double rectangle = new Rectangle2D.Double(startX, endY+200,width,height);
         g.draw(rectangle);
         
         g.setPaint( Color.blue );
         
         Ellipse2D oval = new Ellipse2D.Double(startX+130, endY+200, 50, 75);
         g.fill(oval);
        
      }
   }

   /** The test method for the class
     */
   public static void main( String[] args ) {
      new DrawingsDemo3( "Drawings2D Sample" );
   }
}
