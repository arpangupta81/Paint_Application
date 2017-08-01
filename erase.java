import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class erase extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int x1, y1;

  private merase handler3;
  private Graphics g11;

  public erase()
  {
    setBackground( Color.WHITE );
    setSize(800,800 );

    handler3  = new merase();

    this.addMouseListener( handler3 );
    this.addMouseMotionListener( handler3 );
    setVisible(true);
   }
  public void paintComponent(Graphics g11)
  {
	super.paintComponent(g11);
  }

  private void setUpDrawingGraphics()
  {
    g11 = getGraphics();
  }

  
  private class merase extends MouseAdapter
  {
    public void mouseEntered( MouseEvent e )
    {
      x1 = e.getX();
      y1 = e.getY();

      setUpDrawingGraphics();
     
    }

    public void mouseDragged( MouseEvent e )
    {
    	x1 = e.getX();
        y1 = e.getY();
      g11.setColor(Color.WHITE);
      g11.fillOval(x1, y1,20,20);
    }
    public void mouseMoved( MouseEvent e )
    {
   
    }
  }
}
