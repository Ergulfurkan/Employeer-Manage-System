import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class test extends JFrame {

	private JPanel contentPane;
	private JPasswordField employeePassword;
	private JPasswordField managerUsername;
	private JPasswordField managerPassword;
	private String tempEnteredName;
	private static test instance;
	private JTextField employeeUsername;

    
    	public String getEnteredName() {
		return tempEnteredName;
	}
	public void setEnteredName(String tempEnteredNamee) {
		tempEnteredName = tempEnteredNamee;
	}
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public test() throws IOException {
		String adminPassword = "admin";
		String adminUsername = "admin";

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File file = new File("UsernamesAndPassword.txt");
		FileWriter valuesWriter = new FileWriter(file,false);
		BufferedWriter vWriter = new BufferedWriter(valuesWriter);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME PLEASE LOGIN YOUR INFORMATIONS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(37, 29, 390, 53);
		contentPane.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 94, 481, 201);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		tabbedPane.addTab("EMPLOYEE", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("USERNAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 10, 74, 27);
		panel.add(lblNewLabel_1_1);
		
		JLabel employeePasswordLabel = new JLabel("PASSWORD");
		employeePasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		employeePasswordLabel.setBounds(10, 59, 74, 27);
		panel.add(employeePasswordLabel);
		
		JLabel enterLabel = new JLabel("");
		enterLabel.setBounds(98, 93, 232, 13);
		panel.add(enterLabel);
		
		
		JButton buttonEmployeeLogin = new JButton("LOG IN");
		buttonEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeesEntered = employeeUsername.getText();
				if(employeePassword.getText().length() == 0 || employeeUsername.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "You have to fill all blanks!!");
				}
				else {
					file_operations read = new file_operations();
					String checkPassword = new String(employeePassword.getPassword());
					try {
						if(read.fileRead(checkPassword) == true) {
							tasksFileOperations employeesTasks = new tasksFileOperations();
							employeesTasks.fileCreateSpeciesEmployees(employeesEntered);
							System.out.println(employeesEntered);
							enterLabel.setText("Enter successful");
							girisSayfasi gir = new girisSayfasi(employeesEntered);
							String userName = employeeUsername.getText();
							
							dispose();
							gir.setVisible(true);
							
							System.out.println(getEnteredName());
						}
						else {
							enterLabel.setText("Username or Password incorrect");
						}
					}  catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		buttonEmployeeLogin.setBounds(98, 129, 111, 35);
		panel.add(buttonEmployeeLogin);
		
		JButton buttonEmployeeRegister = new JButton("REGISTER");
		buttonEmployeeRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(employeePassword.getText().length() == 0 || employeeUsername.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "You have to fill all blanks!!");
				}
				else
				{
					String writePassword = new String(employeePassword.getPassword());
				file_operations passwordFile = new file_operations(); 
				 
				String writeUsername = new String(employeeUsername.getText());
				file_operations usernameFile = new file_operations();
				try {
					
					
					if(usernameFile.fileRead(writeUsername)== false) {
						enterLabel.setText("");
						usernameFile.fileWrite(writeUsername);
						passwordFile.fileWrite(writePassword);
						usernameFile.fileWriteUsernames(writeUsername);
						usernameFile.fileWrite("\n");
						enterLabel.setText("Register done with successfuly");
						employeeUsername.setText("");
						employeePassword.setText("");
					}
					else {
						enterLabel.setText("This username have been taken already :(");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				}
				
			}
			
		});
		buttonEmployeeRegister.setBounds(219, 129, 111, 35);
		panel.add(buttonEmployeeRegister);
		
		employeePassword = new JPasswordField();
		employeePassword.setBounds(94, 64, 244, 19);
		panel.add(employeePassword);
		
		employeeUsername = new JTextField();
		employeeUsername.setBounds(94, 15, 236, 19);
		panel.add(employeeUsername);
		employeeUsername.setColumns(10);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		tabbedPane.addTab("MANAGER", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("USERNAME");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(10, 10, 74, 27);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 59, 74, 27);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel managerLabel = new JLabel("");
		managerLabel.setBounds(94, 93, 244, 26);
		panel_1.add(managerLabel);
		
		JButton managerLoginButton = new JButton("LOG IN");
		managerLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(managerPassword.getText().length() == 0 || managerUsername.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "You have to fill all blanks!!");
				}
				else {
					file_operations read = new file_operations();
					String checkUsername = new String(managerPassword.getPassword());
					try {
						if(read.fileReadForManagers(checkUsername) == true) {
							String employeesEntered = employeeUsername.getText();
							managerLabel.setText("Enter successful");
							managerGirisSayfasi managerEnter = new managerGirisSayfasi();
							managerEnter.setVisible(true);
							dispose();
						}
						else {
							managerLabel.setText("Incorrect username or password ");
						}
					}   catch (IOException e1) {
							e1.printStackTrace();
					}
				}
			}
		});
		managerLoginButton.setBounds(94, 129, 244, 35);
		panel_1.add(managerLoginButton);
		
		managerUsername = new JPasswordField();
		managerUsername.setBounds(94, 15, 244, 19);
		panel_1.add(managerUsername);
		
		managerPassword = new JPasswordField();
		managerPassword.setBounds(94, 64, 244, 19);
		panel_1.add(managerPassword);
		
	}
	
}
