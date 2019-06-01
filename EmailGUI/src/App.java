import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTabs = new JPanel();
		pnlTabs.setBounds(10, 11, 664, 50);
		contentPane.add(pnlTabs);
		pnlTabs.setLayout(new GridLayout(0, 6, 0, 0));
		
		JButton btnMain = new JButton("Main");
		pnlTabs.add(btnMain);
		
		JButton btnEmail = new JButton("Email");
		
		pnlTabs.add(btnEmail);
		
		JButton btnNewButton_2 = new JButton("Calendar");
		pnlTabs.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Contacts");
		pnlTabs.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Accounts");
		pnlTabs.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Settings");
		pnlTabs.add(btnNewButton_5);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBounds(20, 72, 654, 329);
		contentPane.add(pnlBody);
		pnlBody.setLayout(null);
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(0, 0, 654, 88);
		pnlBody.add(pnlTop);
		GridBagLayout gbl_pnlTop = new GridBagLayout();
		gbl_pnlTop.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlTop.rowHeights = new int[]{0, 0, 0};
		gbl_pnlTop.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTop.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlTop.setLayout(gbl_pnlTop);
		
		JLabel lblNewLabel = new JLabel("Search:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		pnlTop.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sort:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 0;
		pnlTop.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		pnlTop.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Date", "Alphabetically", "Read/Unread"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		pnlTop.add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_6 = new JButton("Reply");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 9;
		gbc_btnNewButton_6.gridy = 1;
		pnlTop.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Open");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 10;
		gbc_btnNewButton_7.gridy = 1;
		pnlTop.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Mark As read");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_8.gridx = 11;
		gbc_btnNewButton_8.gridy = 1;
		pnlTop.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Delete");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_9.gridx = 12;
		gbc_btnNewButton_9.gridy = 1;
		pnlTop.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(0, 86, 654, 243);
		pnlBody.add(pnlBottom);
		pnlBottom.setLayout(null);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(0, 13, 66, 216);
		list.setBackground(UIManager.getColor("Button.background"));
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Inbox", "Sent", "Spam", "Trash", "Outbox"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pnlBottom.add(list);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setBackground(UIManager.getColor("Button.background"));
		list_1.setBounds(76, 0, 149, 243);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"From: Sender..................."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pnlBottom.add(list_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(235, -4, 419, 247);
		pnlBottom.add(textArea);
		
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		pnlBody.setVisible(true);
	
				
			}
		});
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		pnlBody.setVisible(false);
	
				
			}
		});
		
		
	}
}
