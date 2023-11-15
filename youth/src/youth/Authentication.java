package youth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Authentication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertextField;
	private JPasswordField passwordField;
	private Connection connection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication frame = new Authentication();
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
	public Authentication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230)); // Light Blue
     	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ST.MARY'S YOUTH");
		lblNewLabel.setForeground(new Color(0, 0, 128)); // Navy Blue
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBackground(new Color(51, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(154, 11, 153, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(40, 81, 93, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(40, 129, 93, 26);
		contentPane.add(lblNewLabel_2);
		
		usertextField = new JTextField();
		usertextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usertextField.setBounds(177, 85, 175, 22);
		contentPane.add(usertextField);
		usertextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(177, 133, 175, 22);
		contentPane.add(passwordField);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setForeground(new Color(0, 0, 128)); // Navy Blue
       
		loginbtn.addActionListener(new ActionListener() {
	
			
			public void actionPerformed(ActionEvent e) {
				String userName = usertextField.getText();
	             String password =  new String (passwordField.getPassword());
	             try{
	                Class.forName("com.mysql.cj.jdbc.Driver");

	                connection =(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stmarysmanagement",
	                   "LordJames","#Jamesisaguru254");
	                   PreparedStatement st =(PreparedStatement) connection.prepareStatement("Select Username,Pass_Word From admin where Username=? and Pass_Word=?");
	                   st.setString(1,userName);
	                  st.setString(2, password);
	                   ResultSet rs = st.executeQuery();
	                   if(rs.next()){
	                	   new  Dashboard().setVisible(true);
	                	   dispose();
	                   }
	                	   else {
	                		   JOptionPane.showMessageDialog(null, "Invalid Username or Password ");
	                	   }
	                   }
	                   
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Connection error!!!");
			}finally {
			    try {
			        if (connection != null && !connection.isClosed()) {
			            connection.close();
			        }
			    } catch (Exception e2) {
			        e2.printStackTrace();
			    }}
			} });
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		loginbtn.setBounds(183, 215, 89, 23);
		contentPane.add(loginbtn);
		
		JButton signupbtn = new JButton("Signup");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp obj = new SignUp();
				obj.setVisible(true);
				dispose();
			}
		});
		signupbtn.setForeground(new Color(0, 0, 128)); // Navy Blue

		signupbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signupbtn.setBounds(40, 214, 98, 24);
		contentPane.add(signupbtn);
		
		JButton cancelbtn = new JButton("Cancel");
		cancelbtn.setForeground(new Color(0, 0, 128)); // Navy Blue

		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancelbtn.setBounds(315, 214, 93, 24);
		contentPane.add(cancelbtn);
	}
}
