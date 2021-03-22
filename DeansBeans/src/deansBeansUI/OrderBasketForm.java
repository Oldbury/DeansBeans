package deansBeansUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import deansBeansBusinessObjects.BasketItem;
import deansBeansBusinessObjects.IBasketItem;
import deansBeansBusinessObjects.IDeansBeansRepository;
import deansBeansBusinessObjects.IOrderBasket;
import deansBeansBusinessObjects.MySQLDeansBeansRepository;
import deansBeansBusinessObjects.OrderBasket;
import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;
import deansBeansDataLayer.models.Product;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import java.awt.Dimension;

public class OrderBasketForm extends JFrame {

	private JPanel contentPane;
	private JComboBox cboProduct;
	private JComboBox cboFormat;
	private JComboBox cboDegreesOfRoast;
	private JLabel lblProductName;
	private JLabel lblDescription;
	private JLabel lblQuantity;
	private JLabel lblFormat;
	private JLabel lblDegreeOfRoast;
	private JLabel lblWholesalePrice;
	private JSpinner spnQuantity;
	private JLabel lblBasket;
	private JScrollPane scrollPaneBasket;
	private JTable basketTable;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnClear;
	private JButton btnCheckOut;
	private JButton btnCancel;
	private JButton btnExit;
	private JLabel lblProducts;
	private JLabel lblItems;
	private JLabel lblTotal;
	private JTextField txtNoProducts;
	private JTextField txtNoItems;
	private JTextField txtTotal;
	private List<Product> productList;
	private List<Format> formatsList;
	private List<DegreesOfRoast> degreesOfRoastList;
	private Product selectedProduct;
	private BasketItem basketItem;
	
	
	private CustomerForm customerForm;
	private JLabel lblOrderPlacement;
	private JTextArea txtDescription;
	private JLabel lblRecommendedRetailPrice;
	private JTextField txtRRP;
	DefaultTableModel basketTableModel;
	
	private IOrderBasket orderBasket;
	private IDeansBeansRepository deansBeansRepository;
	
	/**
	 * Create the Order Placement frame.
	 */
	public OrderBasketForm() {
		this(new MySQLDeansBeansRepository());
	}
	
	public OrderBasketForm(IDeansBeansRepository repository) {
		setTitle("Order Basket Form");

		this.deansBeansRepository = repository;
		productList = deansBeansRepository.getProducts();
		formatsList = deansBeansRepository.getFormats();
		degreesOfRoastList = deansBeansRepository.getDegreesOfRoast();
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(OrderBasketForm.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1145, 704);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("TextField.border"));
		setContentPane(contentPane);
		
		cboProduct = new JComboBox(productList.toArray());
		cboProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_productNameComboBox_itemStateChanged(e);
			}
		});
		cboProduct.setBounds(11, 84, 275, 26);
		cboProduct.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
        
        cboDegreesOfRoast = new JComboBox(degreesOfRoastList.toArray());
        cboDegreesOfRoast.setBounds(862, 84, 114, 26);
        cboDegreesOfRoast.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        cboFormat = new JComboBox(formatsList.toArray());
        cboFormat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cboFormat.setBounds(738, 84, 114, 26);
		
		lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(11, 53, 114, 25);
		lblProductName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(11, 121, 90, 25);
		lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(637, 53, 68, 25);
		lblQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		spnQuantity = new JSpinner();
		spnQuantity.setBounds(637, 84, 90, 26);
		spnQuantity.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		spnQuantity.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		
		scrollPaneBasket = new JScrollPane();
		scrollPaneBasket.setBounds(10, 299, 966, 301);
		scrollPaneBasket.setBackground(Color.WHITE);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(986, 162, 138, 72);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(986, 362, 138, 57);
		btnRemove.setEnabled(false);
		btnRemove.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		
		btnClear = new JButton("Clear Basket");
		btnClear.setBounds(986, 299, 138, 57);
		btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClear_actionPerformed(arg0);
			}
		});
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(986, 453, 138, 87);
		btnCheckOut.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCheckOut_actionPerformed(arg0);
			}
		});
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(986, 551, 138, 49);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(986, 604, 138, 50);
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnExit_actionPerformed(e);
				
			}
		});
		
		lblProducts = new JLabel("No Products:");
		lblProducts.setBounds(10, 627, 115, 25);
		lblProducts.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblItems = new JLabel("No Items:");
		lblItems.setBounds(250, 627, 86, 25);
		lblItems.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(467, 627, 57, 25);
		lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblOrderPlacement = new JLabel("Order Placement");
		lblOrderPlacement.setBounds(10, 0, 514, 46);
		lblOrderPlacement.setFont(new Font("Segoe UI", Font.PLAIN, 34));
		
		lblBasket = new JLabel("Basket");
		lblBasket.setBounds(10, 245, 97, 46);
		lblBasket.setFont(new Font("Segoe UI", Font.PLAIN, 34));
		
        lblFormat = new JLabel("Format");
        lblFormat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblFormat.setBounds(738, 53, 114, 25);
        
        lblDegreeOfRoast = new JLabel("Roast");
        lblDegreeOfRoast.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblDegreeOfRoast.setBounds(862, 53, 80, 25);
        
        lblWholesalePrice = new JLabel("Wholesale Price");
        lblWholesalePrice.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblWholesalePrice.setBounds(296, 53, 163, 25);
		
		lblRecommendedRetailPrice = new JLabel("RRP");
		lblRecommendedRetailPrice.setBounds(471, 53, 32, 25);
		lblRecommendedRetailPrice.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		txtNoProducts = new JTextField();
		txtNoProducts.setBounds(118, 628, 102, 26);
		txtNoProducts.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtNoProducts.setText("");
		txtNoProducts.setEditable(false);
		txtNoProducts.setColumns(10);
		
		txtNoItems = new JTextField();
		txtNoItems.setBounds(331, 628, 93, 26);
		txtNoItems.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtNoItems.setEditable(false);
		txtNoItems.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(516, 628, 102, 26);
		txtTotal.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		
		txtRRP = new JTextField();
		txtRRP.setEditable(false);
		txtRRP.setBounds(464, 84, 163, 26);
		txtRRP.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtRRP.setColumns(10);
        
        txtWholesalePrice = new JTextField();
        txtWholesalePrice.setText("\u00A3null");
        txtWholesalePrice.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        txtWholesalePrice.setEditable(false);
        txtWholesalePrice.setColumns(10);
        txtWholesalePrice.setBounds(296, 84, 163, 26);
        
		basketTable = new JTable(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Product Number", "Product Name", "Wholesale Price", "RRP", "Quantity", "Format", "Roast", "Total Price", "Description"
			}) 
			{
				Class[] columnTypes = new Class[] {
						String.class, String.class, String.class,  String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			}
		);

		basketTable.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		basketTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		basketTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	basketTableValueChanged(event);	    
	        }
	    });
		
		DefaultTableCellRenderer rightBasketRenderer = new DefaultTableCellRenderer();
		rightBasketRenderer.setHorizontalAlignment(JLabel.RIGHT);
		
		DefaultTableCellRenderer leftBasketRenderer = new DefaultTableCellRenderer();
		leftBasketRenderer.setHorizontalAlignment(JLabel.LEFT);
				
		basketTable.getColumnModel().getColumn(0).setCellRenderer(rightBasketRenderer);
		basketTable.getColumnModel().getColumn(1).setCellRenderer(leftBasketRenderer);
		basketTable.getColumnModel().getColumn(2).setCellRenderer(rightBasketRenderer);
		basketTable.getColumnModel().getColumn(3).setCellRenderer(rightBasketRenderer);
		basketTable.getColumnModel().getColumn(4).setCellRenderer(rightBasketRenderer);
		basketTable.getColumnModel().getColumn(5).setCellRenderer(leftBasketRenderer);
		basketTable.getColumnModel().getColumn(6).setCellRenderer(leftBasketRenderer);
		basketTable.getColumnModel().getColumn(7).setCellRenderer(rightBasketRenderer);
		basketTable.getColumnModel().getColumn(8).setCellRenderer(leftBasketRenderer);
		
		scrollPaneBasket.setViewportView(basketTable);
		contentPane.setLayout(null);
		contentPane.add(lblBasket);
		contentPane.add(lblOrderPlacement);
		contentPane.add(lblProductName);
		contentPane.add(cboProduct);
        contentPane.add(lblWholesalePrice);
        contentPane.add(txtWholesalePrice);
		contentPane.add(txtRRP);
		contentPane.add(lblQuantity);
        contentPane.add(lblFormat);
        contentPane.add(cboFormat);
        contentPane.add(lblDegreeOfRoast);
        contentPane.add(cboDegreesOfRoast);
		contentPane.add(spnQuantity);
		contentPane.add(lblRecommendedRetailPrice);
		contentPane.add(btnAdd);
		contentPane.add(lblDescription);
		contentPane.add(btnRemove);
		contentPane.add(btnClear);
		contentPane.add(lblProducts);
		contentPane.add(txtNoProducts);
		contentPane.add(lblItems);
		contentPane.add(txtNoItems);
		contentPane.add(lblTotal);
		contentPane.add(txtTotal);
		contentPane.add(scrollPaneBasket);
		contentPane.add(btnCheckOut);
		contentPane.add(btnExit);
		contentPane.add(btnCancel);
		
		txtDescription = new JTextArea();
		txtDescription.setBounds(14, 157, 962, 77);
		contentPane.add(txtDescription);
		txtDescription.setMaximumSize(new Dimension(51, 22));
		txtDescription.setMinimumSize(new Dimension(51, 22));
		txtDescription.setRows(5);
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtDescription.setWrapStyleWord(true);
		txtDescription.setLineWrap(true);
		txtDescription.setText("");
		scrollPaneBasket.getViewport().setBackground(scrollPaneBasket.getBackground());
		
		setAllTextFieldValues();
		basketTableModel = (DefaultTableModel) basketTable.getModel();
		
        btnCheckOut.setEnabled(false);
        btnClear.setEnabled(false);
        btnRemove.setEnabled(false);
        
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				do_windowClosing(e);
			}
		});
	}

    private static OrderBasketForm orderBasketForm = null;
    private JTextField txtWholesalePrice;

    public static OrderBasketForm orderBasketFormGetInstance(CustomerForm customerForm) {
        if (orderBasketForm == null)
        {
            orderBasketForm = new OrderBasketForm();
            orderBasketForm.setCurrentCustomer(customerForm);
        }
        return orderBasketForm;
    }
		
    public Customer getCurrentCustomer()
    {
        return customerForm.selectedCustomer;
    }
    public void setCurrentCustomer(CustomerForm customerForm) {
        this.customerForm = customerForm;
        orderBasket = new OrderBasket(customerForm.selectedCustomer);
        this.setTitle("Current Customer: " + customerForm.selectedCustomer.getCustomerName());
    }
   
    
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		int quantity;

		Format selectedFormat = (Format) formatsList.get(cboFormat.getSelectedIndex());
		DegreesOfRoast degreesOfRoast = (DegreesOfRoast) degreesOfRoastList.get(cboDegreesOfRoast.getSelectedIndex());
		
		List<IBasketItem> basketItemList = orderBasket.getBasketItems();
		
		if (ProductValidation.ValidateProductName(cboProduct.getSelectedItem().toString().trim())) //Is the product name valid?
        {
            Product product = (Product)cboProduct.getSelectedItem();
                 
            boolean productInBasket = basketItemList.stream().anyMatch(item -> item.getProductName().equals(cboProduct.getSelectedItem().toString()));
            System.out.println("Already in basket? " + productInBasket);
                    
            if (ProductValidation.ValidateQuantity((int)spnQuantity.getValue())) //Is the quantity within the boundaries?
            {
            	// check if the product is already in the basket
            	// if true continue
            	if (productInBasket){
            		System.out.println(cboProduct.getSelectedItem() + " is already in the basket");
                    
                       for (IBasketItem iBasketItem : basketItemList) {
                    	   
                    	   if (iBasketItem.getProductName().equals(cboProduct.getSelectedItem().toString())) {
                    		   int index = orderBasket.getBasketItems().indexOf(iBasketItem);
                               System.out.println("Index of selected product " + index);
                               quantity = (int)spnQuantity.getValue();
                               basketItemList.get(index).increaseQuantity(quantity);
                               basketItemsToListView();
                    		   
                    	   }
                    	    
                    	   else {
                    		   System.out.println("only updating quantity for selected item");
                    	   }
              			
               		}
            		
                    // if product is not in basket add new basket item
        		} else {
        			
        			System.out.println("Product not currently in basket - adding");
        			 quantity = (int)spnQuantity.getValue();
                     IBasketItem basketItem = null;
                     basketItem = new BasketItem(product.getProductID(), product.getProductName(), product.getWholesalePrice(), product.getRecommendedRetailPrice(), quantity, selectedFormat.getFormatID(), degreesOfRoast.getDegreesOfRoastID(), product.getDescription());
                     orderBasket.addItem(basketItem);
                     basketItemsToListView();
        		}
               
            }
            else
            { 
            	JOptionPane.showMessageDialog(null, String.format("Illegal quantity. Value must lie between 1 and {spnQuantity.Maximum}"), "Illegal Quantity",  JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
        	JOptionPane.showMessageDialog(null,"The product name entered is not a valid product name", "Product Name Error", JOptionPane.ERROR_MESSAGE);
            cboProduct.grabFocus();
        }
	}

	protected void do_btnExit_actionPerformed(ActionEvent e) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		if(JOptionPane.showConfirmDialog (null, "Are you sure you want to exit the program completely?","Exit Appn",dialogButton) == JOptionPane.NO_OPTION) {
			return;
		}
		System.exit(0);
	}
	
	protected void do_btnClear_actionPerformed(ActionEvent arg0) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to clear the basket?","Clear Basket",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			clearBasket();
		}
	}

    private void clearBasket()
    {
        orderBasket.clearBasket();
        txtNoItems.setText("");
        basketItemsToListView();
    }
	        
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		
		if (basketTable.getSelectedRowCount() <= 0) 
			return;
		
		//DefaultTableModel basketTableModel = (DefaultTableModel) basketTable.getModel();
		int selectedRowIndex = basketTable.getSelectedRow();
		//basketTableModel.removeRow(selectedRowIndex);
		//basketTable.setModel(basketTableModel);
	
		//List<BasketItem> basketItemList = orderBasket.getBasketItems();
		//basketItemList.remove(basketTable.getSelectedRow()+1);
		
		IBasketItem basketItem = orderBasket.getBasketItems().get(selectedRowIndex);
		orderBasket.removeItem(basketItem);
		
		basketItemsToListView();
		
		btnRemove.setEnabled(false);
	}
	        
			
	protected void do_productNameComboBox_itemStateChanged(ActionEvent event) {
		setAllTextFieldValues();
	}
			
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
        if (orderBasket.getNumberOfItems() > 0) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			if(JOptionPane.showConfirmDialog (null, "Are you sure? Cancelling will mean losing basket content","Confirm Cancellation",dialogButton) == JOptionPane.NO_OPTION) {
				return;
			}
		}
		clearBasket();
		customerForm.setVisible(true);	
		this.dispose();
	}

	protected void do_windowClosing(WindowEvent e) {
		if (this.getOwner() != null)
			this.getOwner().dispatchEvent(new WindowEvent(customerForm, WindowEvent.WINDOW_CLOSING));
	}
		
	private void basketTableValueChanged(ListSelectionEvent event) {
		if (basketTable.getSelectionModel().isSelectionEmpty()) {
			btnRemove.setEnabled(false);
		}
		btnRemove.setEnabled(true);
	}

	protected void do_btnCheckOut_actionPerformed(ActionEvent arg0) {
		if (orderBasket.getBasketItems().size() == 0) {
			int dialogButton = JOptionPane.OK_OPTION;
			JOptionPane.showMessageDialog (this, "The basket is currently empty!","Basket Empty", JOptionPane.ERROR_MESSAGE );
			return;
		}

		int i = deansBeansRepository.saveOrderToDatabase(orderBasket, customerForm.selectedCustomer);
		clearBasket();
		
		CustomerOrderHistoryForm coof = new CustomerOrderHistoryForm(customerForm); 
	
		coof.setVisible(true);
		this.dispose();
	}

	private void setAllTextFieldValues() {
		selectedProduct = (Product) productList.get(cboProduct.getSelectedIndex());

		txtRRP.setText("£" + (String.valueOf(selectedProduct.getRecommendedRetailPrice())));
		txtWholesalePrice.setText("�" + (String.valueOf(selectedProduct.getWholesalePrice())));
		txtDescription.setText(selectedProduct.getDescription());
	}
		
	public void basketItemsToListView() {
		basketTableModel.setRowCount(0);	
			
		txtNoItems.setText(String.valueOf(orderBasket.getNumberOfItems()));
		txtNoProducts.setText(String.valueOf(orderBasket.getNumberOfProducts()));
		txtTotal.setText(NumberFormat.getCurrencyInstance().format( orderBasket.getBasketTotal()));
 
		if (orderBasket.getNumberOfItems() == 0) { 
	        btnCheckOut.setEnabled(false);
	        btnClear.setEnabled(false);
	        btnRemove.setEnabled(false);
	        return;
	    }
		
		List<IBasketItem> basketItemList = orderBasket.getBasketItems();
		
		if (basketItemList.contains(selectedProduct.getProductID())){
			basketItem.increaseQuantity((int) spnQuantity.getValue());
		}else {
			for (int i = 0; i < basketItemList.size(); i++) {
				Format format = deansBeansRepository.getFormatByID(basketItemList.get(i).getFormatID());
				DegreesOfRoast degreesOfRoast = deansBeansRepository.getDegreeOfRoastByID(basketItemList.get(i).getDegreeOfRoastID());
				
				String[] data = new String[10]; // Specify number of columns.
				data[0] = basketItemList.get(i).getProductID()+"";
				data[1] = basketItemList.get(i).getProductName();
				data[2] = "£ " + basketItemList.get(i).getWholesalePrice()+"";
				data[3] = "£ " + basketItemList.get(i).getRecommendedRetailPrice()+"";
				data[4] = basketItemList.get(i).getQuantity()+"";
				data[5] = format.getFormatDescription()+"";
				data[6] = degreesOfRoast.getRoastType()+"";
				data[7] = "£ " + basketItemList.get(i).getTotalValueOfBasketItem().setScale(2, RoundingMode.HALF_EVEN)+"";
				data[8] = basketItemList.get(i).getDescription();
                     
				basketTableModel.addRow(data);
			}
		
			basketTable.setModel(basketTableModel);
			
	        btnCheckOut.setEnabled(true);
	        btnClear.setEnabled(true);
		}
	}
}

	
