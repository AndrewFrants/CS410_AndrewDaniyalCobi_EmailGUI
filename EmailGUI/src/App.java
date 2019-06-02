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
		
		JLayeredPane pnlCalendarBody = new JLayeredPane();
		pnlCalendarBody.setBounds(20, 72, 654, 329);
		contentPane.add(pnlCalendarBody);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 84, 314, 245);
		pnlCalendarBody.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Select date...");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		panel_1.setBounds(0, 0, 654, 85);
		pnlCalendarBody.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0, 0, 30, 30, 30, 30, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridx = 1;
		gbc_btnRemove.gridy = 0;
		panel_1.add(btnRemove, gbc_btnRemove);
		
		JLabel lblDateAndTime = new JLabel("Date and Time");
		GridBagConstraints gbc_lblDateAndTime = new GridBagConstraints();
		gbc_lblDateAndTime.gridx = 13;
		gbc_lblDateAndTime.gridy = 0;
		panel_1.add(lblDateAndTime, gbc_lblDateAndTime);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(324, 84, 330, 245);
		pnlCalendarBody.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Schedule...");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"EVENT1", "EVENT2", "EVENT3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(list, BorderLayout.CENTER);
		contentPane.add(pnlEmailBody);
		
		JPanel pnlEmailMid = new JPanel();
		pnlEmailMid.setBounds(0, 42, 654, 94);
		pnlEmailBody.add(pnlEmailMid);
		GridBagLayout gbl_pnlEmailMid = new GridBagLayout();
		gbl_pnlEmailMid.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEmailMid.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlEmailMid.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEmailMid.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEmailMid.setLayout(gbl_pnlEmailMid);
		
		JLabel lblTo = new JLabel("To");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 0;
		gbc_lblTo.gridy = 0;
		pnlEmailMid.add(lblTo, gbc_lblTo);
		
		txtTo = new JTextField();
		GridBagConstraints gbc_txtTo = new GridBagConstraints();
		gbc_txtTo.fill = GridBagConstraints.VERTICAL;
		gbc_txtTo.anchor = GridBagConstraints.WEST;
		gbc_txtTo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTo.gridx = 1;
		gbc_txtTo.gridy = 0;
		pnlEmailMid.add(txtTo, gbc_txtTo);
		txtTo.setColumns(40);
		
		JButton btnDirectory = new JButton("Directory");
		btnDirectory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnDirectory = new GridBagConstraints();
		gbc_btnDirectory.insets = new Insets(0, 0, 5, 5);
		gbc_btnDirectory.gridx = 8;
		gbc_btnDirectory.gridy = 0;
		pnlEmailMid.add(btnDirectory, gbc_btnDirectory);
		
		JLabel lblCC = new JLabel("CC");
		GridBagConstraints gbc_lblCC = new GridBagConstraints();
		gbc_lblCC.anchor = GridBagConstraints.EAST;
		gbc_lblCC.insets = new Insets(0, 0, 5, 5);
		gbc_lblCC.gridx = 0;
		gbc_lblCC.gridy = 1;
		pnlEmailMid.add(lblCC, gbc_lblCC);
		
		txtCC = new JTextField();
		GridBagConstraints gbc_txtCC = new GridBagConstraints();
		gbc_txtCC.anchor = GridBagConstraints.WEST;
		gbc_txtCC.insets = new Insets(0, 0, 5, 5);
		gbc_txtCC.gridx = 1;
		gbc_txtCC.gridy = 1;
		pnlEmailMid.add(txtCC, gbc_txtCC);
		txtCC.setColumns(40);
		
		JLabel lblSubject = new JLabel("Subject");
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.anchor = GridBagConstraints.EAST;
		gbc_lblSubject.insets = new Insets(0, 0, 0, 5);
		gbc_lblSubject.gridx = 0;
		gbc_lblSubject.gridy = 2;
		pnlEmailMid.add(lblSubject, gbc_lblSubject);
		
		txtSubject = new JTextField();
		GridBagConstraints gbc_txtSubject = new GridBagConstraints();
		gbc_txtSubject.anchor = GridBagConstraints.WEST;
		gbc_txtSubject.insets = new Insets(0, 0, 0, 5);
		gbc_txtSubject.gridx = 1;
		gbc_txtSubject.gridy = 2;
		pnlEmailMid.add(txtSubject, gbc_txtSubject);
		txtSubject.setColumns(40);
		
		JPanel pnlEmailBottom = new JPanel();
		pnlEmailBottom.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		pnlEmailBottom.setBounds(0, 319, 654, -183);
		pnlEmailBody.add(pnlEmailBottom);
		
		JTextArea txtEmailTextEditor = new JTextArea();
		pnlEmailBody.setLayer(txtEmailTextEditor, 0);
		txtEmailTextEditor.setBounds(0, 136, 654, 193);
		pnlEmailBody.add(txtEmailTextEditor);
		
		JPanel pnlEmailTop = new JPanel();
		pnlEmailTop.setBounds(0, 0, 654, 42);
		pnlEmailBody.add(pnlEmailTop);
		GridBagLayout gbl_pnlEmailTop = new GridBagLayout();
		gbl_pnlEmailTop.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEmailTop.rowHeights = new int[]{0, 0};
		gbl_pnlEmailTop.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEmailTop.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlEmailTop.setLayout(gbl_pnlEmailTop);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 0, 5);
		gbc_btnSend.gridx = 0;
		gbc_btnSend.gridy = 0;
		pnlEmailTop.add(btnSend, gbc_btnSend);
		
		JButton btnSendDraft = new JButton("Save Draft");
		btnSendDraft.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_btnSendDraft = new GridBagConstraints();
		gbc_btnSendDraft.insets = new Insets(0, 0, 0, 5);
		gbc_btnSendDraft.gridx = 5;
		gbc_btnSendDraft.gridy = 0;
		pnlEmailTop.add(btnSendDraft, gbc_btnSendDraft);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_btnPrint = new GridBagConstraints();
		gbc_btnPrint.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrint.gridx = 6;
		gbc_btnPrint.gridy = 0;
		pnlEmailTop.add(btnPrint, gbc_btnPrint);
		
		JButton btnAttachment = new JButton("Attachment");
		btnAttachment.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAttachment = new GridBagConstraints();
		gbc_btnAttachment.insets = new Insets(0, 0, 0, 5);
		gbc_btnAttachment.gridx = 7;
		gbc_btnAttachment.gridy = 0;
		pnlEmailTop.add(btnAttachment, gbc_btnAttachment);
		
		JButton btnFont = new JButton("Font");
		btnFont.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_btnFont = new GridBagConstraints();
		gbc_btnFont.insets = new Insets(0, 0, 0, 5);
		gbc_btnFont.gridx = 8;
		gbc_btnFont.gridy = 0;
		pnlEmailTop.add(btnFont, gbc_btnFont);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 9;
		gbc_btnCancel.gridy = 0;
		pnlEmailTop.add(btnCancel, gbc_btnCancel);
		
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
		
		JPanel pnlTabs = new JPanel();
		pnlTabs.setBounds(10, 11, 664, 50);
		contentPane.add(pnlTabs);
		pnlTabs.setLayout(new GridLayout(0, 6, 0, 0));
		
		JButton btnMain = new JButton("Main");
		pnlTabs.add(btnMain);
		
		JButton btnEmail = new JButton("Email");
		
		pnlTabs.add(btnEmail);
		
		JButton btnCalendar = new JButton("Calendar");
		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlMainBody.setVisible(false);
				pnlEmailBody.setVisible(false);
				pnlCalendarBody.setVisible(true);
			}
		});
		pnlTabs.add(btnCalendar);
		
		JButton btnContacts = new JButton("Contacts");
		pnlTabs.add(btnContacts);
		
		JButton btnAccounts = new JButton("Accounts");
		pnlTabs.add(btnAccounts);
		
		JButton btnSettings = new JButton("Settings");
		pnlTabs.add(btnSettings);
		
		pnlCalendarBody.setVisible(false);
		pnlMainBody.setVisible(true);
		pnlEmailBody.setVisible(false);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		pnlMainBody.setVisible(true);
		pnlEmailBody.setVisible(false);
		pnlCalendarBody.setVisible(false);
	
				
			}
		});
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		pnlMainBody.setVisible(false);
		pnlEmailBody.setVisible(true);
		pnlCalendarBody.setVisible(false);
				
			}
		});
		
		
		
		
	}
}
