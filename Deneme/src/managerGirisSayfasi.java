import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managerGirisSayfasi extends JFrame {

	private JPanel contentPane;
	private JTextField addTasksManagersChoose;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerGirisSayfasi frame = new managerGirisSayfasi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public managerGirisSayfasi() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1071, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 92, 1037, 416);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Management", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 25, 281, 354);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employees List");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(63, 10, 146, 25);
		panel_1.add(lblNewLabel_1);
		
		Vector<String> employees = new Vector<String>(1);
		
		BufferedReader reader = new BufferedReader(new FileReader("Usernames.txt"));
	    String line;
	    while((line = reader.readLine()) != null) {
	    	employees.addElement(line);
	      }
	    reader.close();
	    
		JComboBox comboBox = new JComboBox(employees);
		comboBox.setBounds(42, 45, 198, 21);
		panel_1.add(comboBox);
		
		Vector<String> TasksEmployees = new Vector<String>(1);
		
	    
	    JComboBox employeesSpeciesTasks = new JComboBox(TasksEmployees);
		employeesSpeciesTasks.setBounds(42, 229, 198, 21);
		panel_1.add(employeesSpeciesTasks);
		
		JButton employeeChooseButton = new JButton("Choose");
		employeeChooseButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String Username = (String) comboBox.getItemAt(comboBox.getSelectedIndex());    
		        String enteredEmployeerTaskFile  = Username + "_gorevler.txt";
		        BufferedReader readerrr;
		        try {
		            readerrr = new BufferedReader(new FileReader(enteredEmployeerTaskFile));
		            String lineee;
		            TasksEmployees.clear();
		            while((lineee = readerrr.readLine()) != null) {
		                TasksEmployees.addElement(lineee);
		            }
		            readerrr.close();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }   
		    }
		});

		employeeChooseButton.setBounds(63, 76, 146, 21);
		panel_1.add(employeeChooseButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Employee Tasks");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(63, 194, 146, 25);
		panel_1.add(lblNewLabel_1_2);
		
		
		
		
		test takeUsername = new test();
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(693, 25, 276, 354);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add New Task");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(63, 10, 146, 25);
		panel_2.add(lblNewLabel_1_1);
		
		addTasksManagersChoose = new JTextField();
		addTasksManagersChoose.setBounds(23, 45, 243, 19);
		panel_2.add(addTasksManagersChoose);
		addTasksManagersChoose.setColumns(10);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedUsername = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
		        String enteredEmployeeTaskFile = selectedUsername + "_gorevler.txt";

		        try (BufferedReader reader = new BufferedReader(new FileReader(enteredEmployeeTaskFile))) {
		            String addTask = addTasksManagersChoose.getText();
		            tasksFileOperations writeObject = new tasksFileOperations();

		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(enteredEmployeeTaskFile, true))) {
		                writeObject.fileWriteSpeciesEmployees(addTask, writer);
		                addTasksManagersChoose.setText("");
		                String line;
		                while ((line = reader.readLine()) != null) {
		                    TasksEmployees.addElement(line);
		                }
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		addButton.setBounds(63, 74, 155, 21);
		panel_2.add(addButton);
		
		JLabel lblNewLabel = new JLabel("Hey Boss! Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(281, 39, 427, 43);
		contentPane.add(lblNewLabel);
		
		JLabel imageManagerIconLabel = new JLabel("");
		imageManagerIconLabel.setBounds(947, 10, 100, 100);
		contentPane.add(imageManagerIconLabel);
		imageManagerIconLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Deneme\\src\\manager (2).jpg"));
		
		JButton exitManagerButon = new JButton("Exit");
		exitManagerButon.addActionListener(new ActionListener() {
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
		exitManagerButon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exitManagerButon.setBounds(962, 518, 85, 21);
		contentPane.add(exitManagerButon);
		
	}
}
