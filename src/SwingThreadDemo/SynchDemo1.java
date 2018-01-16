package SwingThreadDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class SynchDemo1 extends JFrame {
 
   private static JButton ok = new JButton("OK");
   private static JButton show = new JButton("Show");
   private static JTextField tf = new JTextField (10);
   private static JLabel label = new JLabel("Ready",JLabel.CENTER);
  
    public static void main(String [] args){
 
      JFrame mainFrame = new JFrame();
      JPanel panel = new JPanel();
      panel.add(ok);
      panel.add(show);
      panel.add(tf);
      Container c = mainFrame.getContentPane();
      c.setLayout(new BorderLayout());
      c.add(panel,BorderLayout.CENTER);
      c.add(label,BorderLayout.SOUTH);
 
     // Add Listeners
 
      ok.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent event){
              label.setText("Working ...");
 
              ok.setEnabled(false);
 
                // We are going to do something that takes a long time.
                                    // So, we will spin off a thread and update the display
                                    // when we are done
 
              Thread aWorker = new Thread() {
 
                public void run(){
                  
                                    // Do something that takes a long time
             
                try{ Thread.sleep(1000); }
                catch(InterruptedException ex){}
 
              // Report the result using invokeLater()
 
                SwingUtilities.invokeLater( new Runnable(){
                  
                  public void run(){
                	  tf.setText("Show invoke Later");
                    label.setText("Ready");
                    ok.setEnabled(true);
                  }
                 });// End of SwingUtilities.invokeLater
                }
                };// anonymous-class for aWorker
 
                 aWorker.start();  // So we don't hold up the event dispatch thread
 
          }//end of actionPerformed
          });// end ok.addActionListener() and the anonymous class
         
             
          show.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event){
                   tf.setText("Show");
             
             }                         
          });// end show.addActionListener() and the anonymous class
         
                mainFrame.setSize(300,200);
                mainFrame.setVisible(true);
 
        }// end  main
 
}