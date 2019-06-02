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
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Settings extends JFrame {

	private JPanel contentPane;
	private JTextField sqlConnectionStringTextBox;
	private JTextField sqlDatabaseName;
	private JTextField currentDataTextBox;
	private JTextField txtSearch;
	private JTextField searchEmailTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
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
	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane Settings_Panel = new JLayeredPane();
		Settings_Panel.setBounds(20, 77, 654, 324);
		contentPane.add(Settings_Panel);
		
		JButton btnNewButton_3 = new JButton("Keyboard Shortcuts");
		btnNewButton_3.setBounds(0, 46, 108, 23);
		Settings_Panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Storage");
		btnNewButton_1.setBounds(0, 23, 108, 23);
		Settings_Panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UI");
		btnNewButton_2.setBounds(0, 0, 107, 23);
		Settings_Panel.add(btnNewButton_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(118, 0, 536, 324);
		Settings_Panel.add(layeredPane);
		
		
		JLayeredPane UISettingsPane = new JLayeredPane();
		UISettingsPane.setBounds(0, 0, 545, 324);
		layeredPane.add(UISettingsPane);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Dark Mode");
		chckbxNewCheckBox.setBounds(0, 0, 100, 23);
		UISettingsPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Show BCC field");
		chckbxNewCheckBox_1.setBounds(0, 23, 130, 23);
		UISettingsPane.add(chckbxNewCheckBox_1);
		
		JPanel StorageSettingsPane = new JPanel();
		StorageSettingsPane.setBounds(0, 0, 545, 324);
		layeredPane.add(StorageSettingsPane);
		StorageSettingsPane.setLayout(null);
		
		sqlDatabaseName = new JTextField();
		sqlDatabaseName.setBounds(192, 109, 265, 20);
		StorageSettingsPane.add(sqlDatabaseName);
		sqlDatabaseName.setColumns(10);
		
		sqlConnectionStringTextBox = new JTextField();
		sqlConnectionStringTextBox.setBounds(192, 140, 265, 20);
		StorageSettingsPane.add(sqlConnectionStringTextBox);
		sqlConnectionStringTextBox.setColumns(10);
		
		JLabel lblSqlConnectionString = new JLabel("SQL connection string");
		lblSqlConnectionString.setBounds(10, 112, 119, 14);
		StorageSettingsPane.add(lblSqlConnectionString);
		
		JLabel lblSqlDatabase = new JLabel("SQL Database");
		lblSqlDatabase.setBounds(10, 143, 119, 14);
		StorageSettingsPane.add(lblSqlDatabase);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UISettingsPane.setVisible(false);
				StorageSettingsPane.setVisible(true);
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UISettingsPane.setVisible(true);
				StorageSettingsPane.setVisible(false);
			}
		});
		
		JTabbedPane navTabPane = new JTabbedPane(JTabbedPane.TOP);
		navTabPane.setBounds(20, 11, 654, 61);
		contentPane.add(navTabPane);
		
		JPanel navMainTab = new JPanel();
		navMainTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Settings_Panel.setVisible(false);
			}
		});

		navTabPane.addTab("Main", null, navMainTab, null);
		
		searchEmailTextField = new JTextField();
		searchEmailTextField.setText("Search email...");
		navMainTab.add(searchEmailTextField);
		searchEmailTextField.setColumns(20);
		
		JButton btnReply = new JButton("Reply");
		navMainTab.add(btnReply);
		
		JButton btnMarkAsRead = new JButton("Mark as Read");
		navMainTab.add(btnMarkAsRead);
		
		JButton btnDelete = new JButton("Delete");
		navMainTab.add(btnDelete);
		
		JPanel navEmailTab = new JPanel();

		navTabPane.addTab("Email", null, navEmailTab, null);
		navEmailTab.setLayout(null);
		
		JLayeredPane writeEmailPane = new JLayeredPane();
		writeEmailPane.setBounds(0, 0, 649, 33);
		navEmailTab.add(writeEmailPane);
		writeEmailPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSend = new JButton("Send");
		writeEmailPane.add(btnSend);
		
		JButton btnSaveDraft = new JButton("Save Draft");
		btnSaveDraft.setEnabled(false);
		writeEmailPane.add(btnSaveDraft);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setEnabled(false);
		writeEmailPane.add(btnPrint);
		
		JButton btnInsert = new JButton("Insert");
		writeEmailPane.add(btnInsert);
		
		JButton btnCancel_1 = new JButton("Cancel");
		writeEmailPane.add(btnCancel_1);
		
		JLayeredPane readEmailPane = new JLayeredPane();
		readEmailPane.setBounds(0, 0, 649, 33);
		navEmailTab.add(readEmailPane);
		readEmailPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_6 = new JButton("Print");
		readEmailPane.add(btnNewButton_6);
		btnNewButton_6.setEnabled(false);
		
		JButton btnNewButton_7 = new JButton("Export");
		readEmailPane.add(btnNewButton_7);
		btnNewButton_7.setEnabled(false);
		
		JButton btnNewButton_8 = new JButton("Move");
		readEmailPane.add(btnNewButton_8);
		btnNewButton_8.setEnabled(false);
		
		JButton btnNewButton_9 = new JButton("Delete");
		readEmailPane.add(btnNewButton_9);
		
		JButton btnReplyClick = new JButton("Reply");
		readEmailPane.add(btnReplyClick);
		
		JPanel navCalendarTab = new JPanel();
		navTabPane.addTab("Calendar", null, navCalendarTab, null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setVerticalAlignment(SwingConstants.TOP);
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		navCalendarTab.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setEnabled(false);
		btnRemove.setHorizontalAlignment(SwingConstants.LEFT);
		navCalendarTab.add(btnRemove);
		
		JButton button_2 = new JButton("Cancel");
		button_2.setVerticalAlignment(SwingConstants.TOP);
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setEnabled(false);
		navCalendarTab.add(button_2);
		
		currentDataTextBox = new JTextField();
		currentDataTextBox.setText("Saturday, June 1 2019");
		currentDataTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		currentDataTextBox.setEditable(false);
		navCalendarTab.add(currentDataTextBox);
		currentDataTextBox.setColumns(25);
		
		JPanel navContacts = new JPanel();
		navTabPane.addTab("Contacts", null, navContacts, null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ascending", "Descending"}));
		comboBox.setSelectedIndex(0);
		navContacts.add(comboBox);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search...");
		navContacts.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Add Favoties");
		btnNewButton_4.setEnabled(false);
		navContacts.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Add contact");
		navContacts.add(btnNewButton_5);
		
		JPanel navAccountTab = new JPanel();
		navTabPane.addTab("Accounts", null, navAccountTab, null);
		
		JButton btnNewButton_10 = new JButton("New button");
		navAccountTab.add(btnNewButton_10);
		
		JPanel navSettingsTab = new JPanel();
		navSettingsTab.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentShown(ComponentEvent e) {
					Settings_Panel.setVisible(true);
				}
			});
		navTabPane.addTab("Settings", null, navSettingsTab, null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setVerticalAlignment(SwingConstants.TOP);
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		navSettingsTab.add(btnSave);
		
		JButton btnNewButton = new JButton("Restore Default");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		navSettingsTab.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setVerticalAlignment(SwingConstants.TOP);
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		navSettingsTab.add(btnCancel);
	}
}
