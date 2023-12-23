import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class girisSayfasi extends JFrame{

	private JPanel contentPane;
	private JTextField addNewTasks;
	private String enteredEmployeeTaskFile;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisSayfasi frame = new girisSayfasi("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	public girisSayfasi(String isim) throws IOException {
		
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 622);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(176, 224, 230));
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imagePerson = new JLabel("");
		imagePerson.setBounds(902, 10, 103, 96);
		contentPane.add(imagePerson);
		imagePerson.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Deneme\\src\\25054583 (2).jpg"));
		
		test getUsername = new test();
		
		JLabel welcomeLabel = new JLabel("Welcome " + isim  );
		welcomeLabel.setBounds(311, 10, 355, 68);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		contentPane.add(welcomeLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 108, 995, 439);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		tabbedPane.addTab("Tasks", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(169, 169, 169));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(484, 10, 467, 307);
		panel.add(panel_1);
		
		JLabel lblCompletedTasks = new JLabel("Completed Tasks");
		lblCompletedTasks.setForeground(Color.WHITE);
		lblCompletedTasks.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblCompletedTasks.setBackground(Color.WHITE);
		lblCompletedTasks.setBounds(28, 10, 198, 31);
		panel_1.add(lblCompletedTasks);
				
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(169, 169, 169));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 10, 437, 307);
		panel.add(panel_2);
		
		JLabel lblUnfinishedTasks = new JLabel("Unfinished Tasks");
		lblUnfinishedTasks.setForeground(Color.WHITE);
		lblUnfinishedTasks.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblUnfinishedTasks.setBackground(Color.WHITE);
		lblUnfinishedTasks.setBounds(10, 10, 198, 31);
		panel_2.add(lblUnfinishedTasks);
		
		
		
		String enteredEmployeerTaskFile  = isim + "_gorevler.txt";
		System.out.println(enteredEmployeerTaskFile);
		
		Vector<String> Tasks = new Vector<String>(1);

		BufferedReader reader = new BufferedReader(new FileReader(enteredEmployeerTaskFile));
	    String line;
	    while((line = reader.readLine()) != null) {
	    	  Tasks.addElement(line);
	      }
	    reader.close();
		JComboBox unfinishedTasks = new JComboBox(Tasks);
		unfinishedTasks.setBounds(10, 67, 417, 31);
		panel_2.add(unfinishedTasks);

		
		
		addNewTasks = new JTextField();
		addNewTasks.setColumns(10);
		addNewTasks.setBounds(10, 218, 417, 31);
		panel_2.add(addNewTasks);
		
		JButton addNewTasksButon = new JButton("Add New Tasks");
		addNewTasksButon.setBounds(106, 259, 216, 33);
		panel_2.add(addNewTasksButon);
		
		addNewTasks.getText();
		
		addNewTasksButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(addNewTasks.getText().length() != 0) {
					String add = addNewTasks.getText();
					Tasks.addElement(add);
					addNewTasks.setText("");
					tasksFileOperations tasksFile= new tasksFileOperations();
					try {
						tasksFileOperations.fileWriteSpeciesEmployees(add, enteredEmployeerTaskFile);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "You can not add null task");
				}
			}
		});
		
		JButton taskCompletedButon = new JButton("Task Completed");
		taskCompletedButon.setBounds(106, 108, 216, 31);
		panel_2.add(taskCompletedButon);
		
		JLabel lblAddNewTasks = new JLabel("Add New Tasks");
		lblAddNewTasks.setForeground(Color.WHITE);
		lblAddNewTasks.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblAddNewTasks.setBackground(Color.WHITE);
		lblAddNewTasks.setBounds(10, 177, 198, 31);
		panel_2.add(lblAddNewTasks);
		
		
		
		Vector<String> completedTasksComboBox = new Vector<String>(1);

		BufferedReader readerr = new BufferedReader(new FileReader("CompletedTasks.txt"));
		String linee;
		while ((linee = readerr.readLine()) != null) {
		    completedTasksComboBox.addElement(linee);
		}
		readerr.close();

		JComboBox<String> completedTasks = new JComboBox<>(completedTasksComboBox);
		completedTasks.setBounds(10, 66, 447, 31);
		panel_1.add(completedTasks);

		taskCompletedButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int indexTasksCompleted = (int) unfinishedTasks.getSelectedIndex();
				 String selectedString = (String) unfinishedTasks.getItemAt(indexTasksCompleted);
				 completedTasksComboBox.addElement(selectedString);

				 System.out.println(indexTasksCompleted);
				 System.out.println(selectedString);
				 tasksFileOperations objectTasks = new tasksFileOperations();
				 
				 
				 try {
					 objectTasks.fileWriteCompletedTasks(selectedString);
					 objectTasks.fileDeleteCompletedTasks(indexTasksCompleted + 1, enteredEmployeerTaskFile);
					 
				} catch (IOException e1) {
					 e1.printStackTrace();
				}
			}
		});
		
		JButton exitButton = new JButton("Exit account");
		exitButton.setForeground(Color.GRAY);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBounds(869, 557, 136, 21);
		contentPane.add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					test backToLoginPage = new test();
					backToLoginPage.setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
