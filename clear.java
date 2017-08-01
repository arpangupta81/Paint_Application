import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class clear extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3267271017943162034L;
	private mclear handler3;
  private Graphics g10;

  public clear()
  {
    setBackground( Color.WHITE );
    setSize(800,800 );

    handler3  = new mclear();

    this.addMouseListener( handler3 );
    this.addMouseMotionListener( handler3 );
    setVisible(true);
   }
  public void paintComponent(Graphics g10)
  {
	super.paintComponent(g10);
  }

  private void setUpDrawingGraphics()
  {
    g10 = getGraphics();
  }

  
  private class mclear extends MouseAdapter
  {

    public void mouseEntered( MouseEvent e )
    {
        e.getX();
        e.getY();

        setUpDrawingGraphics();
      g10.setColor(Color.WHITE);
      g10.fillRect(5,0, 800, 800);
     
    }
  }
}
