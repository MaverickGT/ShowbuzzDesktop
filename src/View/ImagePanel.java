package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
private static final long serialVersionUID = 1L;
private Image image = null;


public ImagePanel(Image image)
{
    this.image = image;

}


public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    if (image != null)
    {
       
        g.drawImage(image,0,0,this);
    }
}
}
