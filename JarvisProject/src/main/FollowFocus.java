package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import java.io.IOException;
import java.net.URISyntaxException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;



public class FollowFocus extends JFrame implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	public static main.cofig cdM;
	private Interface cdI;
	public static String[] name;
	public static String[] path;
	private static JTextField[] marksName;
	private static JTextField[] marksPath;
	static int ii = 0,jj=0;

	static JButton button = new JButton("Save");
	static JButton button1 = new JButton("Cancel");
	static JFrame window = new JFrame("Setting");

	public void nameandpath(String[] name1, String[] path1)
	{
		int l = name1.length;
		name = new String[l];
	 	path = new String[l];
	 	marksName = new JTextField[l];
	 	marksPath = new JTextField[l];       	 	
		for(int i =0;i<l;i++)
		{
			name[i]=name1[i];
		 	path[i]=path1[i];
		}
		ii=1;jj=1;		    
			button.setForeground(Color.black);
			button.setFont(new Font(" ", Font.PLAIN, 10));
	        button.setContentAreaFilled(false); 
	        button.setBorderPainted(true);
	        button.setFocusable(true);	        
	        button.addActionListener(this);
	       
			button1.setForeground(Color.black);
			button1.setFont(new Font(" ", Font.PLAIN, 10));
	        button1.setContentAreaFilled(false); 
	        button1.setBorderPainted(true);
	        button1.setFocusable(true);	
	        button1.addActionListener(this);
	}
	

	
	
public static void main(String[] args) 
  {
			
			JPanel basePanel = new JPanel();  
      		if(ii == 0&&jj==0)
      		{
      		cdM = new cofig();
      		try {cdM.main(ii,jj);} catch (IOException | URISyntaxException e) 
      		{e.printStackTrace();}
      		//System.exit(0);
      		}
	    	
      		int ROWS = 32;//name.length;
      		
		    SwingUtilities.invokeLater(new Runnable() 
		    {		    	
		      public void run() 
		      {  

		    	JPanel content = new JPanel();
		    	basePanel.setLayout(new BoxLayout(basePanel, 1));
			    for (int i = 0; i < ROWS; i++) 
			    {  
		    	content = new JPanel();
		        content.setLayout(new BoxLayout(content, 2));		      
    		     JLabel mLabelname = new JLabel("Name:");
		         JLabel mLabelpath = new JLabel("Path:");
		         if(i==31){
		        	 mLabelname = new JLabel("Resolution(W):");
		        	 mLabelpath = new JLabel("Resolution(H):");
		         }
		         marksName[i] = new JTextField(name[i],JLabel.TRAILING);
		         marksPath[i] = new JTextField(path[i],JLabel.TRAILING);
		         mLabelname.setLabelFor(marksName[i]);
		         mLabelpath.setLabelFor(marksPath[i]);
		         content.add(mLabelname);
		         content.add(marksName[i]);
		         content.add(mLabelpath);
		         content.add(marksPath[i]);
		         basePanel.add(content);
		        }
		         content = new JPanel();
		         content.add(button);
		         content.add(button1);
		         basePanel.add(content);	        
			    
		
		        KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner", new PropertyChangeListener() 
		        {		
		          @Override
		          public void propertyChange(PropertyChangeEvent evt) 
		          {
		            if (!(evt.getNewValue() instanceof JComponent)) 
		            {
		              return;
		            }
		            JComponent focused = (JComponent) evt.getNewValue();
		            if (basePanel.isAncestorOf(focused)) 
		            {
		              focused.scrollRectToVisible(focused.getBounds());
		            }
		          }
		        });		        
		        
		        
		        window.setContentPane(new JScrollPane(basePanel));
		        window.setBounds(100, 100, 1200,900);
		        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        window.setVisible(true);
		      }
		    });

  }
//public void setwh(String name1, String path1)
//{
//	cdI = new Interface();
 //   cdI.setBounds(0, 0, Integer.parseUnsignedInt(name1), Integer.parseUnsignedInt(path1));
  //  cdI.dispose();	
//}


  @SuppressWarnings("static-access")
public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="Save")
	    {	
			for(int i =0;i<32;i++)
			{
				if(!name[i].equalsIgnoreCase(marksName[i].getText()))
				{		
					try {
						cdM.main(1,i,marksName[i].getText());
					} catch (WriteException | BiffException | IOException
							| URISyntaxException e1) 
					{
						e1.printStackTrace();
					}	
				}
				name[i]=marksName[i].getText();
				if(!path[i].equalsIgnoreCase(marksPath[i].getText()))
				{		
					try {
						cdM.main(3,i,marksPath[i].getText());
					} catch (WriteException | BiffException | IOException
							| URISyntaxException e1) 
					{
						e1.printStackTrace();
					}	
				}
				path[i]=marksPath[i].getText();
			}
			
	        cdI = new Interface();
	        cdI.refresh();
	         
	        try {
				cdM.main(0, 1);
			} catch (IOException | URISyntaxException e1) 
	        {
				e1.printStackTrace();
			}	        
	        cdI.main(null);	
	        
			{	
		  		window.dispose();
			}
	    }
  	 if(e.getActionCommand()=="Cancel")
	    {
        cdI = new Interface();
        cdI.refresh();
         
        try {
			cdM.main(0, 1);
		} catch (IOException | URISyntaxException e1) 
        {
			e1.printStackTrace();
		}	        
        cdI.main(null);	
  		window.dispose();
	    }
	}
}