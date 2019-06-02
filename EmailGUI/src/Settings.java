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

public class Settings extends JFrame {

	private JPanel contentPane;
	private JTextField sqlConnectionStringTextBox;
	private JTextField sqlDatabaseName;

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
		
		JPanel Settings_Panel = new JPanel();
		Settings_Panel.setBounds(20, 72, 654, 329);
		contentPane.add(Settings_Panel);
		Settings_Panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Storage");

		btnNewButton_1.setBounds(0, 23, 108, 23);
		Settings_Panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Keyboard Shortcuts");
		btnNewButton_3.setBounds(0, 46, 108, 23);
		Settings_Panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("UI");

		btnNewButton_2.setBounds(0, 0, 108, 23);
		Settings_Panel.add(btnNewButton_2);
		
		JPanel StorageSettings = new JPanel();
		StorageSettings.setBounds(136, 0, 518, 328);
		Settings_Panel.add(StorageSettings);
		StorageSettings.setLayout(null);
		
		sqlDatabaseName = new JTextField();
		sqlDatabaseName.setBounds(192, 109, 265, 20);
		StorageSettings.add(sqlDatabaseName);
		sqlDatabaseName.setColumns(10);
		
		sqlConnectionStringTextBox = new JTextField();
		sqlConnectionStringTextBox.setBounds(192, 140, 265, 20);
		StorageSettings.add(sqlConnectionStringTextBox);
		sqlConnectionStringTextBox.setColumns(10);
		
		JLabel lblSqlConnectionString = new JLabel("SQL connection string");
		lblSqlConnectionString.setBounds(10, 112, 119, 14);
		StorageSettings.add(lblSqlConnectionString);
		
		JLabel lblSqlDatabase = new JLabel("SQL Database");
		lblSqlDatabase.setBounds(10, 143, 119, 14);
		StorageSettings.add(lblSqlDatabase);
		
		JPanel UISettings = new JPanel();
		UISettings.setBounds(136, 0, 518, 328);
		Settings_Panel.add(UISettings);
		UISettings.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Dark Mode");
		chckbxNewCheckBox.setBounds(0, 5, 77, 23);
		UISettings.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Show BCC field");
		chckbxNewCheckBox_1.setBounds(0, 33, 97, 23);
		UISettings.add(chckbxNewCheckBox_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 11, 506, 61);
		contentPane.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Settings", null, panel, null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setVerticalAlignment(SwingConstants.TOP);
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnSave);
		
		JButton btnNewButton = new JButton("Restore Default");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setVerticalAlignment(SwingConstants.TOP);
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnCancel);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UISettings.setVisible(true);
				StorageSettings.setVisible(false);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UISettings.setVisible(false);
				StorageSettings.setVisible(true);
			}
		});
	}
}
