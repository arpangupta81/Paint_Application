package PAINT1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class circ extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int x1, y1, x2;
  private mousecirc handler3;
  private Graphics g2;

  public circ()
  {
	  setBackground( Color.WHITE );
    setSize(800,800 );

    handler3  = new mousecirc();

    this.addMouseListener( handler3 );
    this.addMouseMotionListener( handler3 );
    setVisible(true);
  }
  public void paintComponent(Graphics g2)
  {
    super.paintComponent(g2);
  }

  private void setUpDrawingGraphics()
  {
    g2 = getGraphics();
  }

  
  private class mousecirc extends MouseAdapter
  {
    public void mousePressed( MouseEvent e )
    {
      x1 = e.getX();
      y1 = e.getY();

      setUpDrawingGraphics();

      x2=x1;
    }

    public void mouseReleased( MouseEvent e )
    {
      x2 = e.getX();
      if(frame.checkc.isSelected())
      {
    	  g2.setColor(frame.co);
    	  g2.fillOval(x1+1, y1+1, x2-x1-1, x2-x1-1);
      }
      g2.drawOval(x1, y1, x2-x1, x2-x1);
     
    }
  }
}                                                                                                                                       
