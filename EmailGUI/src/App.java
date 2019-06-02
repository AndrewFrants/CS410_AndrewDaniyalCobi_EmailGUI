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
import javax.swing.JLayeredPane;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtTo;
	private JTextField txtCC;
	private JTextField txtSubject;

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
		
		JLayeredPane pnlEmailBody = new JLayeredPane();
		pnlEmailBody.setBounds(20, 72, 654, 329);
		pnlEmailBody.setVisible(false);
		
		JLayeredPane pnlMainBody = new JLayeredPane();
		pnlMainBody.setBounds(20, 72, 654, 329);
		contentPane.add(pnlMainBody);
		pnlMainBody.setLayout(null);
		
		JPanel pnlMainBottom = new JPanel();
		pnlMainBottom.setBounds(0, 86, 654, 243);
		pnlMainBody.add(pnlMainBottom);
		pnlMainBottom.setLayout(null);
		
		JList listFolders = new JList();
		listFolders.setBorder(new LineBorder(new Color(0, 0, 0)));
		listFolders.setBounds(0, 13, 66, 216);
		listFolders.setBackground(UIManager.getColor("Button.background"));
		listFolders.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listFolders.setLayoutOrientation(JList.VERTICAL_WRAP);
		listFolders.setModel(new AbstractListModel() {
			String[] values = new String[] {"Inbox", "Sent", "Spam", "Trash", "Outbox"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pnlMainBottom.add(listFolders);
		
		JList listEmails = new JList();
		listEmails.setBorder(new LineBorder(new Color(0, 0, 0)));
		listEmails.setBackground(UIManager.getColor("Button.background"));
		listEmails.setBounds(76, 0, 149, 243);
		listEmails.setModel(new AbstractListModel() {
			String[] values = new String[] {"From: Sender..................."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pnlMainBottom.add(listEmails);
		
		JTextArea txtEmailMessage = new JTextArea();
		txtEmailMessage.setEditable(false);
		txtEmailMessage.setBounds(235, -4, 419, 247);
		pnlMainBottom.add(txtEmailMessage);
		
		JPanel pnlMainTop = new JPanel();
		pnlMainTop.setBounds(0, 0, 654, 88);
		pnlMainBody.add(pnlMainTop);
		GridBagLayout gbl_pnlMainTop = new GridBagLayout();
		gbl_pnlMainTop.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlMainTop.rowHeights = new int[]{0, 0, 0};
		gbl_pnlMainTop.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlMainTop.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlMainTop.setLayout(gbl_pnlMainTop);
		
		JLabel lblSearch = new JLabel("Search:");
		GridBagConstraints gbc_lblSearch = new GridBagConstraints();
		gbc_lblSearch.anchor = GridBagConstraints.EAST;
		gbc_lblSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearch.gridx = 1;
		gbc_lblSearch.gridy = 0;
		pnlMainTop.add(lblSearch, gbc_lblSearch);
		
		JLabel lblSort = new JLabel("Sort:");
		GridBagConstraints gbc_lblSort = new GridBagConstraints();
		gbc_lblSort.insets = new Insets(0, 0, 5, 5);
		gbc_lblSort.gridx = 4;
		gbc_lblSort.gridy = 0;
		pnlMainTop.add(lblSort, gbc_lblSort);
		
		txtSearch = new JTextField();
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.gridwidth = 2;
		gbc_txtSearch.insets = new Insets(0, 0, 0, 5);
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 1;
		gbc_txtSearch.gridy = 1;
		pnlMainTop.add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);
		
		JComboBox cmbSort = new JComboBox();
		cmbSort.setModel(new DefaultComboBoxModel(new String[] {"Date", "Alphabetically", "Read/Unread"}));
		GridBagConstraints gbc_cmbSort = new GridBagConstraints();
		gbc_cmbSort.insets = new Insets(0, 0, 0, 5);
		gbc_cmbSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSort.gridx = 4;
		gbc_cmbSort.gridy = 1;
		pnlMainTop.add(cmbSort, gbc_cmbSort);
		
		JButton btnReply = new JButton("Reply");
		GridBagConstraints gbc_btnReply = new GridBagConstraints();
		gbc_btnReply.insets = new Insets(0, 0, 0, 5);
		gbc_btnReply.gridx = 9;
		gbc_btnReply.gridy = 1;
		pnlMainTop.add(btnReply, gbc_btnReply);
		
		JButton btnOpen = new JButton("Open");
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpen.gridx = 10;
		gbc_btnOpen.gridy = 1;
		pnlMainTop.add(btnOpen, gbc_btnOpen);
		
		JButton btnMarkRead = new JButton("Mark As read");
		GridBagConstraints gbc_btnMarkRead = new GridBagConstraints();
		gbc_btnMarkRead.insets = new Insets(0, 0, 0, 5);
		gbc_btnMarkRead.gridx = 11;
		gbc_btnMarkRead.gridy = 1;
		pnlMainTop.add(btnMarkRead, gbc_btnMarkRead);
		
		JButton btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 12;
		gbc_btnDelete.gridy = 1;
		pnlMainTop.add(btnDelete, gbc_btnDelete);
		contentPane.add(pnlEmailBody);
		
		JPanel pnlEmailTop = new JPanel();
		pnlEmailTop.setBounds(0, 0, 654, 87);
		pnlEmailBody.add(pnlEmailTop);
		GridBagLayout gbl_pnlEmailTop = new GridBagLayout();
		gbl_pnlEmailTop.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEmailTop.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlEmailTop.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEmailTop.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEmailTop.setLayout(gbl_pnlEmailTop);
		
		JLabel lblTo = new JLabel("To");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 0;
		gbc_lblTo.gridy = 0;
		pnlEmailTop.add(lblTo, gbc_lblTo);
		
		txtTo = new JTextField();
		GridBagConstraints gbc_txtTo = new GridBagConstraints();
		gbc_txtTo.fill = GridBagConstraints.VERTICAL;
		gbc_txtTo.anchor = GridBagConstraints.WEST;
		gbc_txtTo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTo.gridx = 1;
		gbc_txtTo.gridy = 0;
		pnlEmailTop.add(txtTo, gbc_txtTo);
		txtTo.setColumns(30);
		
		JLabel lblCC = new JLabel("CC");
		GridBagConstraints gbc_lblCC = new GridBagConstraints();
		gbc_lblCC.anchor = GridBagConstraints.EAST;
		gbc_lblCC.insets = new Insets(0, 0, 5, 5);
		gbc_lblCC.gridx = 0;
		gbc_lblCC.gridy = 1;
		pnlEmailTop.add(lblCC, gbc_lblCC);
		
		txtCC = new JTextField();
		GridBagConstraints gbc_txtCC = new GridBagConstraints();
		gbc_txtCC.anchor = GridBagConstraints.WEST;
		gbc_txtCC.insets = new Insets(0, 0, 5, 5);
		gbc_txtCC.gridx = 1;
		gbc_txtCC.gridy = 1;
		pnlEmailTop.add(txtCC, gbc_txtCC);
		txtCC.setColumns(30);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 1;
		pnlEmailTop.add(btnCancel, gbc_btnCancel);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridwidth = 3;
		gbc_btnSend.insets = new Insets(0, 0, 5, 5);
		gbc_btnSend.gridx = 5;
		gbc_btnSend.gridy = 1;
		pnlEmailTop.add(btnSend, gbc_btnSend);
		
		JLabel lblSubject = new JLabel("Subject");
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.anchor = GridBagConstraints.EAST;
		gbc_lblSubject.insets = new Insets(0, 0, 0, 5);
		gbc_lblSubject.gridx = 0;
		gbc_lblSubject.gridy = 2;
		pnlEmailTop.add(lblSubject, gbc_lblSubject);
		
		txtSubject = new JTextField();
		GridBagConstraints gbc_txtSubject = new GridBagConstraints();
		gbc_txtSubject.anchor = GridBagConstraints.WEST;
		gbc_txtSubject.insets = new Insets(0, 0, 0, 5);
		gbc_txtSubject.gridx = 1;
		gbc_txtSubject.gridy = 2;
		pnlEmailTop.add(txtSubject, gbc_txtSubject);
		txtSubject.setColumns(30);
		
		JPanel pnlEmailBottom = new JPanel();
		pnlEmailBottom.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		pnlEmailBottom.setBounds(0, 319, 654, -232);
		pnlEmailBody.add(pnlEmailBottom);
		
		JTextArea txtEmailTextEditor = new JTextArea();
		pnlEmailBody.setLayer(txtEmailTextEditor, 0);
		txtEmailTextEditor.setBounds(0, 84, 654, 245);
		pnlEmailBody.add(txtEmailTextEditor);
		
		JPanel pnlTabs = new JPanel();
		pnlTabs.setBounds(10, 11, 664, 50);
		contentPane.add(pnlTabs);
		pnlTabs.setLayout(new GridLayout(0, 6, 0, 0));
		
		JButton btnMain = new JButton("Main");
		pnlTabs.add(btnMain);
		
		JButton btnEmail = new JButton("Email");
		
		pnlTabs.add(btnEmail);
		
		JButton btnCalendar = new JButton("Calendar");
		pnlTabs.add(btnCalendar);
		
		JButton btnContacts = new JButton("Contacts");
		pnlTabs.add(btnContacts);
		
		JButton btnAccounts = new JButton("Accounts");
		pnlTabs.add(btnAccounts);
		
		JButton btnSettings = new JButton("Settings");
		pnlTabs.add(btnSettings);
		
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		pnlMainBody.setVisible(true);
		pnlEmailBody.setVisible(false);
	
				
			}
		});
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		pnlMainBody.setVisible(false);
		pnlEmailBody.setVisible(true);
				
			}
		});
		
		
		
		
	}
}
