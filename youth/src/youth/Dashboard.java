package youth;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(173, 216, 230));
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(166, 11, 88, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.setForeground(Color.WHITE); // White text color
        btnNewButton.setBackground(new Color(0, 102, 204)); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentication obj = new Authentication();
				obj.setVisible(true);
				dispose();
						
			}
		});
		btnNewButton.setBounds(132, 227, 144, 23);
		contentPane.add(btnNewButton);
		
		JButton AddmembersButton = new JButton("Add Members");
		AddmembersButton.setForeground(Color.WHITE);
        AddmembersButton.setBackground(new Color(0, 102, 204));
		AddmembersButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		AddmembersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMembers obj = new AddMembers();
				obj.setVisible(true);
				dispose();
				
			}
		});
		AddmembersButton.setBounds(132, 55, 144, 23);
		contentPane.add(AddmembersButton);
		
		JButton Viewbtn = new JButton("View Records");
		Viewbtn.setForeground(Color.WHITE);
        Viewbtn.setBackground(new Color(0, 102, 204));

		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMembers obj = new ViewMembers();
				obj.setVisible(true);
				dispose();
			}
		});
		Viewbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Viewbtn.setBounds(132, 140, 144, 23);
		contentPane.add(Viewbtn);
	}

}
