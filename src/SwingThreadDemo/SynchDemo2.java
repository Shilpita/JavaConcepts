package SwingThreadDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class SynchDemo2 extends JFrame {
   private static JButton bad1 = new JButton("Bad1");
   private static JButton show = new JButton("Show");
   private static JTextField tf = new JTextField (10);
   private static JLabel label = new JLabel("Ready",JLabel.CENTER);
   
    public static void main(String [] args){
      JFrame mainFrame = new JFrame();
      JPanel panel = new JPanel();
      panel.add(bad1);
      panel.add(show);
      panel.add(tf);
      Container c = mainFrame.getContentPane();
      c.setLayout(new BorderLayout());
      c.add(panel,BorderLayout.CENTER);
      c.add(label,BorderLayout.SOUTH);
 
      bad1.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent event){
 
              label.setText("Working ...");
 
               bad1.setEnabled(false);
              
              // We are not doing this on a separate thread
 
                try{ Thread.sleep(5000); }      // dispatch thread is starving
 
                catch(InterruptedException ex){};
      
                    label.setText("...Ready");
 
                    bad1.setEnabled(true);
 
          }//end of actionPerformed
          });// end bad1.addActionListener() and the anonymous class
                      
          show.addActionListener(new ActionListener() {
 
          public void actionPerformed(ActionEvent event){
 
                   tf.setText("Show");
             
             }                           
          });// end show.addActionListener() and the anonymous class
         
                mainFrame.setSize(300,200);
                mainFrame.setVisible(true);
 
        }// end - main
}