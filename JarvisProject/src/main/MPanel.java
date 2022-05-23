package main;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MPanel extends JPanel 
{

	private ImageIcon imageIcon;

	public MPanel(URL imgUrl) 
	{
		super();
		setLayout(new GridBagLayout());
		imageIcon = new ImageIcon(imgUrl);
		setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Image image = imageIcon.getImage();
		g.drawImage(image, 0, 0, null);
	}

}
