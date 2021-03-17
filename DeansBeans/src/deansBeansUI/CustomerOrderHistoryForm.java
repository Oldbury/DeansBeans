package deansBeansUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import deansBeansBusinessObjects.IDeansBeansRepository;
import deansBeansBusinessObjects.MySQLDeansBeansRepository;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CustomerOrderHistoryForm extends JFrame {
	private JPanel contentPaneOrderHistory;
	private JLabel lblOrders;
	private JScrollPane scrollPaneOrders;
	private JTable tableOrders;
	private JSeparator separatorOrderHistory;
	private JLabel lblOrderItems;
	private JScrollPane scrollPaneOrderItems;
	private JTable tableOrderItems;
	private JButton btnClose;
	private JLabel lblOrderHistory;

	private IDeansBeansRepository deansBeansRepository = new MySQLDeansBeansRepository();
	private List<Order> orders = new ArrayList<Order>();
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	private Order selectedOrder;
	private CustomerForm customerForm;
	
	List<Format> formats;
	List<DegreesOfRoast> degreesOfRoast;
	
	public CustomerOrderHistoryForm(CustomerForm customerForm) {
		this.customerForm = customerForm;
		setTitle("Customer Order History Form");
		setFont(new Font("Segoe UI", Font.PLAIN, 16));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerOrderHistoryForm.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 582);
		contentPaneOrderHistory = new JPanel();
		contentPaneOrderHistory.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneOrderHistory);
		
		separatorOrderHistory = new JSeparator();
		
		scrollPaneOrders = new JScrollPane();
		scrollPaneOrders.setBackground(Color.WHITE);
		
		scrollPaneOrderItems = new JScrollPane();
		scrollPaneOrderItems.setBackground(Color.WHITE);
				
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0); // Closes the OrderHistoryWindow and returns the user to the CustomerUI frame.
			}
		});
		
		lblOrders = new JLabel("Orders");
		lblOrders.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		
		lblOrderItems = new JLabel("Order Items");
		lblOrderItems.setFont(new Font("Segoe UI", Font.PLAIN, 22));
				
		lblOrderHistory = new JLabel("Order History");
		lblOrderHistory.setFont(new Font("Segoe UI", Font.PLAIN, 34));
		GroupLayout gl_contentPaneOrderHistory = new GroupLayout(contentPaneOrderHistory);
		gl_contentPaneOrderHistory.setHorizontalGroup(
			gl_contentPaneOrderHistory.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneOrderHistory.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneOrderHistory.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOrderHistory)
						.addComponent(lblOrders)
						.addComponent(scrollPaneOrders, GroupLayout.PREFERRED_SIZE, 951, GroupLayout.PREFERRED_SIZE)
						.addComponent(separatorOrderHistory, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrderItems)
						.addComponent(scrollPaneOrderItems, GroupLayout.PREFERRED_SIZE, 949, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClose, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		
		/** 
		 * Set contentPane parameters for OrderHistoryWindow page.
		 */
		gl_contentPaneOrderHistory.setVerticalGroup(
			gl_contentPaneOrderHistory.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneOrderHistory.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOrderHistory)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOrders)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneOrders, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separatorOrderHistory, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOrderItems)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneOrderItems, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addGap(12))
		);
		
		tableOrderItems = new JTable();
		tableOrderItems.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tableOrderItems.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tableOrderItems.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Order ID", "Product ID", "Quantity", "Product Price", "Format", "Roast"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableOrderItems.setShowGrid(false);
		scrollPaneOrderItems.setViewportView(tableOrderItems);
		
		tableOrders = new JTable();
		tableOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_tableOrders_mouseClicked(arg0);
			}
		});
		tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOrders.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tableOrders.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tableOrders.setShowGrid(false);
		tableOrders.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Order ID", "Order Date", "Order Status", "Order Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	
		orders = deansBeansRepository.getOrdersForCustomer(customerForm.selectedCustomer.getCustomerID());
		this.setTitle("Current Customer: " + customerForm.selectedCustomer.getCustomerName());
		populateOrderTable();
		
		scrollPaneOrders.setViewportView(tableOrders);
		contentPaneOrderHistory.setLayout(gl_contentPaneOrderHistory);
		scrollPaneOrders.getViewport().setBackground(scrollPaneOrders.getBackground());
		scrollPaneOrderItems.getViewport().setBackground(scrollPaneOrderItems.getBackground());
		
		//Preload Formats and RoastTypes
		formats = deansBeansRepository.getFormats();
		degreesOfRoast = deansBeansRepository.getDegreesOfRoast();
	}
	
	private void populateOrderTable() {
		DefaultTableModel orderTableModel = (DefaultTableModel) tableOrders.getModel();
		
		orderTableModel.setRowCount(0);
		
		for (int i = 0; i < orders.size(); i++) {
			String[] data = new String[4]; // Specify number of columns.
			data[0] = orders.get(i).getOrderID()+"";
			data[1] = orders.get(i).getOrderDate()+"";
			data[2] = orders.get(i).getOrderStatus()+"";
			data[3] = "£ " + orders.get(i).getOrderTotal()+"";
                 
			orderTableModel.addRow(data);
		}
   
		tableOrders.setModel(orderTableModel);
	}

	protected void do_tableOrders_mouseClicked(MouseEvent arg0) {
		DefaultTableModel orderItemTableModel = (DefaultTableModel) tableOrderItems.getModel();
		
		orderItemTableModel.setRowCount(0);
		
		selectedOrder = (Order) orders.get(tableOrders.getSelectedRow());
		int selectedOrderId = selectedOrder.getOrderID();
		orderItems = deansBeansRepository.getOrderItemsForOrder(selectedOrderId);
		
		for (int i = 0; i < orderItems.size(); i++) {
			int formatID = orderItems.get(i).getFormatID();
			int roastID = orderItems.get(i).getRoastID();
			Format format = formats.stream().filter(f -> f.getFormatID() == formatID).findFirst().orElse(null);
			DegreesOfRoast degreeOfRoast = degreesOfRoast.stream().filter(r -> r.getDegreesOfRoastID() == roastID).findFirst().orElse(null);
			
			String[] data = new String[6]; // Specify number of columns.
			data[0] = orderItems.get(i).getOrder().getOrderID()+"";
			data[1] = orderItems.get(i).getProduct().getProductID()+"";
			data[2] = orderItems.get(i).getQuantity()+"";
			data[3] = "£ " + orderItems.get(i).getPurchasePrice()+"";
			data[4] = format.getFormatDescription()+"";
			data[5] = degreeOfRoast.getRoastType()+"";
                 
			orderItemTableModel.addRow(data);
		}
   
		tableOrderItems.setModel(orderItemTableModel);
	} 
	
	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		customerForm.setVisible(true);
		this.dispose();	
	}
}
