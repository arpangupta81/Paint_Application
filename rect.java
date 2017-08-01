import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class rect extends JPanel
{
    private static final long serialVersionUID = 1L;
	private int x1, y1, x2, y2;
  private mouserect handler3;
  private Graphics g2;

  public rect()
  {
    setBackground( Color.WHITE );
    setSize(800,800 );

    handler3  = new mouserect();

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
  private class mouserect extends MouseAdapter
  {
    public void mousePressed( MouseEvent e )
    {
      x1 = e.getX();
      y1 = e.getY();
      setUpDrawingGraphics();

      x2=x1;
      y2=y1;
    }

    public void mouseReleased( MouseEvent e )
    {
      x2 = e.getX();
      y2 = e.getY();
     if(frame.checkc.isSelected())
      {
    	  g2.setColor(frame.co);
    	  g2.fillRect(x1+1, y1+1, x2-x1-1, y2-y1-1);
      }
      g2.drawRect(x1, y1, x2-x1, y2-y1);
     
    }
  }
}
