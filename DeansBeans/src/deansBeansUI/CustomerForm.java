package deansBeansUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import deansBeansBusinessObjects.IDeansBeansRepository;
import deansBeansBusinessObjects.MySQLDeansBeansRepository;
import deansBeansDataLayer.SessionFactoryUtil;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.Order;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class CustomerForm extends JFrame {

	/** 
	 * Generate all required fields for the CustomerUI Frame. 
	 */
	private JPanel contentPaneCustomerUI;
	private JLabel lblCustomerID;
	private JLabel lblCustomerName;
	private JLabel lblAddress;
	private JLabel lblPostcode;
	private JLabel lblContactNumber;
	private JLabel lblEmail;
	private JLabel lblSecurityQuestion;
	private JLabel lblSecurityAnswer;
	private JLabel lblCustomerDetails;
	private JLabel lblSelectCustomer;
	private JTextField txtCustomerID;
	private JTextField txtCustomerName;
	private JTextField txtAddressLine1;
	private JTextField txtAddressLine2;
	private JTextField txtAddressLine3;
	private JTextField txtPostCode;
	private JTextField txtPhonetNumber;
	private JTextField txtEmail;
	private JTextField txtSecurityQuestionAnswer;
	private JButton btnTakeOrder;
	private JButton btnExit;
	private JTextArea txtSecurityQuestion;
	public String currentlySelectedCustomerName;
	private IDeansBeansRepository deansBeansRepository;
	private List customerList;
	public Customer selectedCustomer;
	private JScrollPane scrollPane;
	private JTable customerTable;
	private List<Customer> customerNames;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/** 
					 * Instantiate the CustomerUI frame and enable it's visibility 
					 */		
					CustomerForm frame = new CustomerForm();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
					}
				}
		});
	}

	/**
	 * Create and set parameters for the CustomerUI frame.
	 */
	public CustomerForm() {
		
		deansBeansRepository = new MySQLDeansBeansRepository();
		customerList = deansBeansRepository.getCustomers();
		
		setTitle("Customer Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 577);
		contentPaneCustomerUI = new JPanel();
		contentPaneCustomerUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneCustomerUI);
	
		/** 
		 * Create all JLabels on CustomerUI page 
		 */
		lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblPostcode = new JLabel("Post Code:");
		lblPostcode.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblSecurityAnswer = new JLabel("Security Answer:");
		lblSecurityAnswer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		lblSelectCustomer = new JLabel("Select Customer");
		lblSelectCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		
		/** 
		 * Create all JTextFields on CustomerUI page 
		 */
		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtCustomerID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCustomerID.setEditable(false);
		txtCustomerID.setColumns(10);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtCustomerName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCustomerName.setEditable(false);
		txtCustomerName.setColumns(10);
		
		txtAddressLine1 = new JTextField();
		txtAddressLine1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtAddressLine1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddressLine1.setEditable(false);
		txtAddressLine1.setColumns(10);
		
		txtAddressLine2 = new JTextField();
		txtAddressLine2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtAddressLine2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddressLine2.setEditable(false);
		txtAddressLine2.setColumns(10);
		
		txtAddressLine3 = new JTextField();
		txtAddressLine3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtAddressLine3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddressLine3.setEditable(false);
		txtAddressLine3.setColumns(10);
		
		txtPostCode = new JTextField();
		txtPostCode.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPostCode.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPostCode.setEditable(false);
		txtPostCode.setColumns(10);
		
		txtPhonetNumber = new JTextField();
		txtPhonetNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPhonetNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPhonetNumber.setEditable(false);
		txtPhonetNumber.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		
		txtSecurityQuestionAnswer = new JTextField();
		txtSecurityQuestionAnswer.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSecurityQuestionAnswer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSecurityQuestionAnswer.setEditable(false);
		txtSecurityQuestionAnswer.setColumns(10);
		
		
		
		/** 
		 * Create all JButtons on CustomerUI page and call the associated Action Events created below. 
		 */
		btnTakeOrder = new JButton("Take Order");
		btnTakeOrder.setEnabled(false);
		btnTakeOrder.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnTakeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnTakeOrder_actionPerformed(arg0); // Create a new instance of the 'Place Order' frame, enable it's visibility and disable the visibility of the CustomerUI frame.
			}
		});
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnExit_actionPerformed(arg0); // Close the program entirely when the 'Exit' button is pressed.
			}
		});
		
		/** 
		 * Create JTextArea instead of JTextField to allow for the Security Question to be longer than a single line. 
		 */
		txtSecurityQuestion = new JTextArea();
		txtSecurityQuestion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSecurityQuestion.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSecurityQuestion.setEditable(false);
		txtSecurityQuestion.setLineWrap(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.WHITE, null, null));
		GroupLayout gl_contentPaneCustomerUI = new GroupLayout(contentPaneCustomerUI);
		gl_contentPaneCustomerUI.setHorizontalGroup(
			gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectCustomer)
						.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
							.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
							.addGap(46)
							.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
									.addComponent(btnTakeOrder, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblCustomerDetails)
									.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
										.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING)
											.addComponent(lblCustomerName)
											.addComponent(lblCustomerID)
											.addComponent(lblAddress)
											.addComponent(lblPostcode)
											.addComponent(lblContactNumber)
											.addComponent(lblEmail)
											.addComponent(lblSecurityQuestion)
											.addComponent(lblSecurityAnswer))
										.addGap(18)
										.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtPostCode, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtAddressLine1, Alignment.LEADING)
												.addComponent(txtAddressLine2, Alignment.LEADING)
												.addComponent(txtAddressLine3, Alignment.LEADING)
												.addComponent(txtCustomerName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
											.addComponent(txtCustomerID, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtPhonetNumber, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtSecurityQuestion, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))))
								.addComponent(txtSecurityQuestionAnswer, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPaneCustomerUI.setVerticalGroup(
			gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
					.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
							.addGap(72)
							.addComponent(lblCustomerDetails)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
									.addComponent(lblCustomerID)
									.addGap(18)
									.addComponent(lblCustomerName)
									.addGap(15)
									.addComponent(lblAddress)
									.addGap(67)
									.addComponent(lblPostcode))
								.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
									.addComponent(txtCustomerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(txtAddressLine1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAddressLine2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAddressLine3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtPostCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPhonetNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContactNumber))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail))
							.addGap(18)
							.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSecurityQuestion, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSecurityQuestion))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSecurityQuestionAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSecurityAnswer)))
						.addGroup(gl_contentPaneCustomerUI.createSequentialGroup()
							.addGap(20)
							.addComponent(lblSelectCustomer)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPaneCustomerUI.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTakeOrder, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
		);
		
		scrollPane.getViewport().setBackground(scrollPane.getBackground());
		
		customerTable = new JTable();
		customerTable.setBorder(null);
		customerTable.setBackground(Color.WHITE);
		customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Select Customer"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		

		customerTable.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		customerTable.setTableHeader(null);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		//renderer.setHorizontalAlignment(JLabel.WEST);
		
		
		customerTable.getColumnModel().getColumn(0).setCellRenderer(renderer);
		
		customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	customerTableValueChanged(event);	    
	        	
	        }
	    });
		
		customerNames = new ArrayList<Customer>();
		customerNames =	deansBeansRepository.getCustomers();
		populateCustomerTable();
		
		scrollPane.setViewportView(customerTable);
		contentPaneCustomerUI.setLayout(gl_contentPaneCustomerUI);
	}
	 
	 private void populateCustomerTable() {
			DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
			
			customerTableModel.setRowCount(0);
			
			for (int i = 0; i < customerNames.size(); i++) {
				String[] data = new String[1]; // Specify number of columns.
				data[0] = customerNames.get(i).getCustomerName()+"";
	                 
				customerTableModel.addRow(data);
			}
			customerTable.setModel(customerTableModel);
		}

	 private void customerTableValueChanged(ListSelectionEvent evt) {
		 selectedCustomer = (Customer) customerNames.get(customerTable.getSelectedRow());
		 txtCustomerName.setText(" " + selectedCustomer.getCustomerName());
		 txtCustomerID.setText(" " + String.valueOf(selectedCustomer.getCustomerID()));
		 txtAddressLine1.setText(" " + selectedCustomer.getAddressLine1());
		 txtAddressLine2.setText(" " + selectedCustomer.getAddressLine2());
		 txtAddressLine3.setText(" " + selectedCustomer.getAddressLine3());
		 txtPostCode.setText(" " + selectedCustomer.getPostCode());
		 txtPhonetNumber.setText(" " + selectedCustomer.getPhone());
		 txtEmail.setText(" " + selectedCustomer.getEmail());
		 txtSecurityQuestion.setText(" " + selectedCustomer.getSecurityQuestion());
		 txtSecurityQuestionAnswer.setText(" " + selectedCustomer.getSecurityQuestionAnswer());
         btnTakeOrder.setEnabled(true);
	}
	
	protected void do_btnTakeOrder_actionPerformed(ActionEvent arg0) {
	    OrderBasketForm orderBasketForm = OrderBasketForm.orderBasketFormGetInstance(this);
		orderBasketForm.setCurrentCustomer(this);
		orderBasketForm.setVisible(true);
		this.setVisible(false);
	}
	
	protected void do_btnExit_actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}



