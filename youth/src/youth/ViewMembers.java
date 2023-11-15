package youth;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewMembers extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField SearchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMembers frame = new ViewMembers();
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
	public ViewMembers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW MEMBERS");
		lblNewLabel.setBounds(156, 0, 135, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 62, 373, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No","Name", "Age", "Contact"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(77);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

	                Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stmarysmanagement",
	                   "LordJames","#Jamesisaguru254");
	                Statement st=connection.createStatement();
	                String query ="select *from youth";
	              ResultSet rs=  st.executeQuery(query);
	              
	             
	              while(rs.next()) {
	            	String No =String.valueOf(rs.getInt("Youth_Id"));
	            	String  Name =rs.getString("Name");
	            	String Age =String.valueOf(rs.getInt("Age"));
	            	String Contact= rs.getString("Contact");
	            	
	            	String tbData[]= {No,Name,Age,Contact};
	            	DefaultTableModel tbModel = (DefaultTableModel)table.getModel();
	            	tbModel.addRow(tbData);
	            	  
	              }
	              
	              
	                
	                
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
			
			
			
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(178, 189, 89, 23);
		btnNewButton.setBackground(new Color(70, 130, 180)); // Steel Blue button color
        btnNewButton.setForeground(Color.WHITE); // White text color
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard obj = new Dashboard();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnNewButton_1.setBounds(10, 227, 89, 23);
		btnNewButton_1.setBackground(new Color(0, 102, 204)); // Royal Blue button color
        btnNewButton_1.setForeground(Color.WHITE); // White text color
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LogOut");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentication obj = new Authentication();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBackground(new Color(0, 102, 204)); // Royal Blue button color
        btnNewButton_2.setForeground(Color.WHITE); // White text color

		btnNewButton_2.setBounds(335, 228, 89, 23);
		contentPane.add(btnNewButton_2);
		
		SearchTextField = new JTextField();
		SearchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String searchText = SearchTextField.getText().trim();
		        if (!searchText.isEmpty()) {
		            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
		            table.setRowSorter(sorter);

		            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
		            sorter.setRowFilter(rowFilter);
		        }

			}
			@Override
			public void keyReleased(KeyEvent e) {
				String searchText = SearchTextField.getText().trim();
		        if (!searchText.isEmpty()) {
		            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
		            table.setRowSorter(sorter);

		            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
		            sorter.setRowFilter(rowFilter);
		        }
			}
		});
		SearchTextField.setBounds(32, 39, 189, 23);
		contentPane.add(SearchTextField);
		SearchTextField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchText = SearchTextField.getText().trim();
		        if (!searchText.isEmpty()) {
		            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
		            table.setRowSorter(sorter);

		            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
		            sorter.setRowFilter(rowFilter);
		        }
			}
		});
		btnNewButton_3.setBounds(219, 39, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSelectedRow();
			}
		});
		btnNewButton_4.setBounds(178, 228, 89, 23);
		btnNewButton_4.setBackground(new Color(255, 0, 0)); // Red button color
        btnNewButton_4.setForeground(Color.WHITE); // White text color

		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tbModel = (DefaultTableModel) table.getModel();
                tbModel.setRowCount(0); 
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(308, 39, 97, 23);
		contentPane.add(btnNewButton_5);
	}
	// Method to delete the selected row
	private void deleteSelectedRow() {
	    int selectedRow = table.getSelectedRow();

	    if (selectedRow != -1) {
	        int option = JOptionPane.showConfirmDialog(contentPane,
	                "Are you sure you want to remove this member?",
	                "Confirmation", JOptionPane.YES_NO_OPTION);

	        if (option == JOptionPane.YES_OPTION) {
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stmarysmanagement",
	                        "LordJames", "#Jamesisaguru254");
	                Statement st = connection.createStatement();

	                // Get the primary key  from the selected row
	                String idToDelete = (String) table.getValueAt(selectedRow, 0);

	                //  DELETE SQL query
	                String query = "DELETE FROM youth WHERE Youth_Id = '" + idToDelete + "'";

	                // Execute the query to delete the row from the database
	                int rowsAffected = st.executeUpdate(query);

	                if (rowsAffected > 0) {
	                    // Remove the selected row from the table
	                    DefaultTableModel model = (DefaultTableModel) table.getModel();
	                    model.removeRow(selectedRow);
	                    JOptionPane.showMessageDialog(contentPane, "Member Removed");
	                } else {
	                    JOptionPane.showMessageDialog(contentPane, "Failed to delete member");
	                }

	                connection.close();
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(contentPane, "No row selected");
	    }
	}
	}
