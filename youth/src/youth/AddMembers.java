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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AddMembers extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AddNametextField;
	private JTextField AgetextField;
	private JTextField ContacttextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMembers frame = new AddMembers();
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
	public AddMembers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230)); // Light Blue
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD MEMBER'S DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 128)); // Navy Blue
		lblNewLabel.setBounds(134, 11, 181, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 0, 128)); // Navy Blue
		lblNewLabel_1.setBounds(49, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 0, 128)); // Navy Blue
		lblNewLabel_2.setBounds(49, 109, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 0, 128)); // Navy Blue
		lblNewLabel_3.setBounds(49, 162, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard obj = new Dashboard();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(35, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton logoutButton = new JButton("LogOut");
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logoutButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        logoutButton.setForeground(Color.WHITE);

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentication obj = new Authentication();
				obj.setVisible(true);
				dispose();
			}
		});
		logoutButton.setBounds(294, 227, 89, 23);
		contentPane.add(logoutButton);
		
		AddNametextField = new JTextField();
		AddNametextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AddNametextField.setBackground(new Color(240, 248, 255)); // Alice Blue
		AddNametextField.setBounds(209, 58, 174, 20);
		contentPane.add(AddNametextField);
		AddNametextField.setColumns(10);
		
		AgetextField = new JTextField();
		AgetextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AgetextField.setBackground(new Color(240, 248, 255)); 
		AgetextField.setBounds(209, 107, 174, 20);
		contentPane.add(AgetextField);
		AgetextField.setColumns(10);
		
		ContacttextField = new JTextField();
		ContacttextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ContacttextField.setBackground(new Color(240, 248, 255)); //Alice Blue
		ContacttextField.setBounds(209, 160, 174, 20);
		contentPane.add(ContacttextField);
		ContacttextField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sql ="INSERT INTO `youth` (`name`,`age`,`contact`) VALUES( ? ,? ,?)";
				
				
				// Show a confirmation dialog
		        int result = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to add this member?", "Confirmation", JOptionPane.YES_NO_OPTION);

		        // Check the user's choice
		        if (result == JOptionPane.YES_OPTION) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

	                Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stmarysmanagement",
	                   "LordJames","#Jamesisaguru254");
	               
	                PreparedStatement st = connection.prepareStatement(sql);
	                String name = AddNametextField.getText();
	                st.setString(1,name);
	                
	                int age =  Integer.parseInt(AgetextField.getText());
	                
	                st.setInt(2,age);
	                String contact =ContacttextField.getText();
	                st.setString(3,contact);
	                st.executeUpdate();


	               
	              
	            	  JOptionPane.showMessageDialog(contentPane,"Member Added Successfully!" );
	                  // Show a dialog to choose whether to go to the ViewMembers or not
	                  int choice = JOptionPane.showConfirmDialog(contentPane,
	                          "Do you want to view members now?",
	                          "Confirmation", JOptionPane.YES_NO_OPTION);

	                  // Check the user's choice
	                  if (choice == JOptionPane.YES_OPTION) {

	            	  ViewMembers obj = new ViewMembers();
	  				obj.setVisible(true);
	  				dispose();
	            	  
	              }
	                  else {
	                    // Clear text fields
	                    AddNametextField.setText("");
	                    AgetextField.setText("");
	                    ContacttextField.setText("");
	                  }
	                  }
	           

			catch (SQLException ex) {
				JOptionPane.showMessageDialog(btnNewButton_1, "error!!!" + ex.getMessage());
				ex.printStackTrace();
		
				} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}} 
				else {}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(70, 130, 180)); // Steel Blue
        btnNewButton_1.setForeground(Color.WHITE);
 
		btnNewButton_1.setBounds(165, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
