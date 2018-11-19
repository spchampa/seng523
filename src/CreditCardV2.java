import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

public class CreditCardV2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreditCardV2() {
		setBackground(new Color(178, 34, 34));
		setForeground(Color.RED);
		setLayout(null);
		
		JLabel lblDividend = new JLabel("Dividend");
		lblDividend.setBounds(335, 13, 56, 16);
		add(lblDividend);
		
		JLabel label = new JLabel("4555     8909     7665     1225");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(69, 101, 277, 33);
		add(label);
		
		JLabel lblRealPersonTotally = new JLabel("REAL PERSON TOTALLY");
		lblRealPersonTotally.setBounds(12, 147, 143, 16);
		add(lblRealPersonTotally);
		
		JLabel lblExpires = new JLabel("expires 04/23");
		lblExpires.setBounds(69, 126, 86, 16);
		add(lblExpires);
		
		JLabel lblVisa = new JLabel("VISA");
		lblVisa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVisa.setBounds(324, 145, 56, 16);
		add(lblVisa);
		
		JLabel lblCibc = new JLabel("CIBC");
		lblCibc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCibc.setBounds(12, 13, 56, 33);
		add(lblCibc);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCardV2 frame = new CreditCardV2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
