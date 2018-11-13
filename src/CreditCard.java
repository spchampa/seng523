import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreditCard extends JComponent {

	private JPanel contentPane;

	  private volatile int screenX = 0;
	  private volatile int screenY = 0;
	  private volatile int myX = 0;
	  private volatile int myY = 0;

	  public CreditCard() {
	    
	    setBackground(Color.WHITE);
	    setBounds(0, 0, 100, 100);
	    setOpaque(false);

	    addMouseListener(new MouseListener() {

	      @Override
	      public void mouseClicked(MouseEvent e) { }

	      @Override
	      public void mousePressed(MouseEvent e) {
	        screenX = e.getXOnScreen();
	        screenY = e.getYOnScreen();

	        myX = getX();
	        myY = getY();
	      }

	      @Override
	      public void mouseReleased(MouseEvent e) { }

	      @Override
	      public void mouseEntered(MouseEvent e) { }

	      @Override
	      public void mouseExited(MouseEvent e) { }

	    });
	    addMouseMotionListener(new MouseMotionListener() {

	      @Override
	      public void mouseDragged(MouseEvent e) {
	        int deltaX = e.getXOnScreen() - screenX;
	        int deltaY = e.getYOnScreen() - screenY;

	        setLocation(myX + deltaX, myY + deltaY);
	      }

	      @Override
	      public void mouseMoved(MouseEvent e) { }

	    });
	  }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCard frame = new CreditCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
