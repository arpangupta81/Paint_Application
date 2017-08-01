import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class pencil extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int x1, y1, x2, y2;

  private mouseline handler1;
  private Graphics g;

  public pencil()
  {
    setBackground( Color.WHITE );
    setSize(800,800 );

    handler1  = new mouseline();

    this.addMouseListener( handler1 );
    this.addMouseMotionListener( handler1 );
    setVisible(true);
   }
  public void paintComponent(Graphics g)
  {
	super.paintComponent(g);
  }

  private void setUpDrawingGraphics()
  {
    g = getGraphics();
  }

  private class mouseline extends MouseAdapter
  {
	  public void mousePressed( MouseEvent e )
	    {
	      x1 = e.getX();
	      y1 = e.getY();
	      setUpDrawingGraphics();
	      x2=x1;
	      y2=y1;
	    }

	    public void mouseDragged( MouseEvent e )
	    {
	      x1 = e.getX();
	      y1 = e.getY();
	      if(frame.checkc.isSelected())
	      {
	      g.setColor(frame.co);
	      }
	      g.drawLine(x1,y1,x2,y2);

	      x2=x1;
	      y2=y1;

  }
}}
