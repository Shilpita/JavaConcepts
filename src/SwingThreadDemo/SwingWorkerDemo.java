package SwingThreadDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SwingWorkerDemo extends JFrame {	 
		   private JButton ok = new JButton("Work");
		   private  JButton show = new JButton("Show");
		   private  JTextField tf = new JTextField (10);
		   private  JTextField resultFld = new JTextField (10);
		   private JLabel label = new JLabel("Ready",JLabel.CENTER);

		  ///CONSTRUCTOR
		    public SwingWorkerDemo(){
		 
		      final JFrame mainFrame = new JFrame();
		      JPanel panel = new JPanel();

		      ////INNER CLASS //////
		      class LongWorker extends SwingWorker<Integer, Integer>
		      {
		          protected Integer doInBackground() throws Exception
		          {
		              // Do a time-consuming task.
		              Thread.sleep(10000);
		              return 100;
		          }

		          protected void done()
		          {
		              try
		              {
		            	  resultFld.setText(get().toString());
		              }
		              catch (Exception e)
		              {
		                  e.printStackTrace();
		              }
		          }
		      }
		      ////ACTION LISTENER FOR OK BUTTON
		      ok.addActionListener(new ActionListener() {
		    	    public void actionPerformed(ActionEvent e)
		    	    {
		    	        new LongWorker().execute();
		    	    }
		    	});
		      ////ACTION LISTENER FOR SHOW BUTTON
		      show.addActionListener(new ActionListener() {
		    	    public void actionPerformed(ActionEvent e)
		    	    {
		    	        tf.setText("Show");
		    	    }
		    	});

		      
		      panel.add(ok);
		      panel.add(show);
		      panel.add(tf);
		      panel.add(resultFld);
		      Container c = mainFrame.getContentPane();
		      c.setLayout(new BorderLayout());
		      c.add(panel,BorderLayout.CENTER);
		      c.add(label,BorderLayout.SOUTH);
		 
		      mainFrame.setSize(300,200);
              mainFrame.setVisible(true);

		 
		        }// end  main
		 
	public static void main(String[] args) {
		
			new SwingWorkerDemo();
	}

}
