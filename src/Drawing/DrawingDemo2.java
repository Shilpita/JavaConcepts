package Drawing;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/* This example shows how two or more shapes can be combined using different operations.
The 2D API supports four different operations to combine the areas of two shapes -
	union, intersection, subtraction and exclusive or.
*/

public class DrawingDemo2 extends JFrame {
	public DrawingDemo2 (String title){
		super(title);
		CombiningShapes cs = new CombiningShapes();
		getContentPane().add( cs, BorderLayout.CENTER );
	
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args) {
    	new DrawingDemo2("CombiningShapesDemo");
    
  }  
	
}
class CombiningShapes extends JPanel {
  
  private Shape mShapeOne, mShapeTwo;
  private JComboBox mOptions;
  
  
  public CombiningShapes() {
  	
    // Create the two shapes, a circle and a square.
    
    double shapeOneX = 40;
    double shapeOneY = 20;
    double shapeOneWidth = 200;
    double shapeOneHeight = 200;
    
    double shapeTwoX = shapeOneX + shapeOneWidth/2;
    double shapeTwoY = shapeOneY + shapeOneHeight/2;
    double shapeTwoWidth = shapeOneWidth;
    double shapeTwoHeight = shapeOneHeight;
     
    // Create an ellipse
    mShapeOne = new Ellipse2D.Double(shapeOneX, shapeOneY, shapeOneWidth, shapeOneHeight);
    
    // create a rectangle
    mShapeTwo = new Rectangle2D.Double(shapeTwoX, shapeTwoY, shapeTwoWidth, shapeTwoHeight);
    
    
    setBackground(Color.white);
    
    setLayout(new BorderLayout());
    
    // Create a panel to hold the combo box.
    JPanel controls = new JPanel();
    // Create the combo box with the names of the area operators.
    mOptions = new JComboBox(
      new String[] { "outline", "add", "intersection",
          "subtract", "exclusive or" }
    );
    // Repaint ourselves when the selection changes.
    mOptions.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent ie) {
        repaint();
      }
    });
    controls.add(mOptions);
    add(controls, BorderLayout.EAST);
  }
  
  public void paintComponent(Graphics g) {
  	super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Retrieve the selection option from the combo box.
    String option = (String)mOptions.getSelectedItem();
    if (option.equals("outline")) {
      // Just draw the outlines and return.
      g2.draw(mShapeOne);
      g2.draw(mShapeTwo);
      return;
    }
    // Create Areas from the shapes.
    Area areaOne = new Area(mShapeOne);
    Area areaTwo = new Area(mShapeTwo);
    // Combine the Areas according to the selected option.
    if (option.equals("add")) areaOne.add(areaTwo);
    else if (option.equals("intersection")) areaOne.intersect(areaTwo);
    else if (option.equals("subtract")) areaOne.subtract(areaTwo);
    else if (option.equals("exclusive or")) areaOne.exclusiveOr(areaTwo);
    
    // Fill the resulting Area.
    g2.setPaint(Color.orange);
    g2.fill(areaOne);
    
    // Draw the outline of the resulting Area.
    g2.setPaint(Color.black);
    g2.draw(areaOne);
  }
}

