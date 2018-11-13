import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;



public class ATM_GUI {

	private JFrame frame;
	//SCB varables 
	//time currentTime
	private int Timer;
	private static final int MaxALLowableWithdraw = 500;
	private int AmountToWithdraw;
	//statuses 
	private boolean BillsDisburseDriver = true;
	private boolean BillStorageStatus = true;
	private boolean MonitorStatus = true;
	private boolean CardScannerStatus = true;
	private boolean BullsDisburserStatus = true;

	private boolean CardInserted;
	
	private boolean DataEntered;
	private Vector<Integer> Data = new Vector<Integer>();
	
	//this is the systems state varaible
	private int PN = 0;
	
	private boolean EnterKeyPressed;
	private boolean CancelkeyPressed;
	private boolean EjectCard;
	//signals are not included 
	
	//For system to write to user
	private JLabel mainTextBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM_GUI window = new ATM_GUI();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void Welcome() {
		mainTextBox.setText("Welcome! Please enter Your card");
		if(MonitorStatus == false) {
			//throw exception 
		}
		if(CardScannerStatus == false) {
			//throw exception 
		}
		
	}
	private void addData(int dataValue) {
		if(Data.size() == 4) {
			DataEntered = true;
		}
		Data.add(dataValue);
	}
	/**
	 * Create the application.
	 */
	public ATM_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1117, 703);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel keyPad_Panel = new JPanel();
		keyPad_Panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "keyPad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		keyPad_Panel.setBounds(107, 412, 327, 163);
		frame.getContentPane().add(keyPad_Panel);
		keyPad_Panel.setLayout(null);
		
		JButton keyPad_1 = new JButton("1");
		keyPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addData(1);
			}
		});
		keyPad_1.setBounds(6, 18, 97, 25);
		keyPad_Panel.add(keyPad_1);
		
		JButton keyPad_4 = new JButton("4");
		keyPad_4.setBounds(6, 55, 97, 25);
		keyPad_Panel.add(keyPad_4);
		
		JButton keyPad_7 = new JButton("7");
		keyPad_7.setBounds(6, 93, 97, 25);
		keyPad_Panel.add(keyPad_7);
		
		JButton keyPad_2 = new JButton("2");
		keyPad_2.setBounds(115, 18, 97, 25);
		keyPad_Panel.add(keyPad_2);
		
		JButton keyPad_5 = new JButton("5");
		keyPad_5.setBounds(115, 55, 97, 25);
		keyPad_Panel.add(keyPad_5);
		
		JButton keyPad_8 = new JButton("8");
		keyPad_8.setBounds(115, 93, 97, 25);
		keyPad_Panel.add(keyPad_8);
		
		JButton keyPad_3 = new JButton("3");
		keyPad_3.setBounds(224, 18, 97, 25);
		keyPad_Panel.add(keyPad_3);
		
		JButton keyPad_6 = new JButton("6");
		keyPad_6.setBounds(224, 55, 97, 25);
		keyPad_Panel.add(keyPad_6);
		
		JButton keyPad_9 = new JButton("9");
		keyPad_9.setBounds(224, 93, 97, 25);
		keyPad_Panel.add(keyPad_9);
		
		JButton keyPad_Left = new JButton("<");
		keyPad_Left.setBounds(6, 131, 97, 25);
		keyPad_Panel.add(keyPad_Left);
		
		JButton keyPad_0 = new JButton("0");
		keyPad_0.setBounds(115, 131, 97, 25);
		keyPad_Panel.add(keyPad_0);
		
		JButton keyPad_Right = new JButton(">");
		keyPad_Right.setBounds(224, 131, 97, 25);
		keyPad_Panel.add(keyPad_Right);
		
		JLabel lblGroupAtm = new JLabel("Group 3 ATM");
		lblGroupAtm.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGroupAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupAtm.setBounds(12, 22, 1071, 29);
		frame.getContentPane().add(lblGroupAtm);
		
		mainTextBox = new JLabel("New label");
		mainTextBox.setVerticalAlignment(SwingConstants.TOP);
		mainTextBox.setHorizontalAlignment(SwingConstants.LEFT);
		mainTextBox.setForeground(Color.WHITE);
		mainTextBox.setBackground(Color.BLACK);
		mainTextBox.setBounds(115, 135, 314, 263);
		frame.getContentPane().add(mainTextBox);
		keyPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		keyPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Welcome();
		//CreditCard();
	}
}
