package youth;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230)); // Light Blue
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(156, 11, 120, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(56, 48, 103, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = textField.getText();
	             String password =  new String (passwordField.getPassword());
	             Connection connection = null;
	             PreparedStatement psInsert = null;
	             PreparedStatement psCheckUserExists = null;
	             ResultSet resultSet = null;
	             
	             try {
	            	 Class.forName("com.mysql.cj.jdbc.Driver");

		                 connection =(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stmarysmanagement",
		                   "LordJames","#Jamesisaguru254");
		                 psCheckUserExists =(PreparedStatement) connection.prepareStatement("Select Username,Pass_Word From admin where Username=?");
		                 psCheckUserExists.setString(1, UserName);
		                 resultSet = psCheckUserExists.executeQuery();
		                 
		                 
		                 if (resultSet.isBeforeFirst()) {
		                	 JOptionPane.showMessageDialog(contentPane, "User already exists");
		                
		                 } else {
		                	 psInsert = connection.prepareStatement("insert into admin (Username,Pass_Word) values (?,?)");
		                			 psInsert.setString(1,UserName);
		                			 psInsert.setString(2, password);
		                			 psInsert.executeUpdate();
		                			 JOptionPane.showMessageDialog(contentPane, "Account created successfully ");
		                			 new  Dashboard().setVisible(true);
		  	                	   dispose();
		                 }
		                
		                 
	             } catch (SQLException ex2) {
	            	 JOptionPane.showMessageDialog(contentPane, "Connection error!!!");
	            	 ex2.printStackTrace();
	            	 
	            	 
	             } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	             

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(70, 130, 180)); // Steel Blue
		btnNewButton.setForeground(Color.WHITE);

		btnNewButton.setBounds(284, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(70, 130, 180)); // Steel Blue
        btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentication obj = new Authentication();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(56, 215, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(56, 117, 83, 26);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(196, 50, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(196, 120, 203, 20);
		contentPane.add(passwordField);
	}
}
