
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class dollarbill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dollarbill frame = new dollarbill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dollarbill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 553);
		contentPane = new JPanel();

		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C:\\pictures\\dollarbill.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			getContentPane().add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
		Random r = new Random();
		 int x = r.nextInt(d.height - getHeight());
		 int y = r.nextInt(d.width - getWidth());
		 
		this.setLocation(y, x);
		
	}

}
