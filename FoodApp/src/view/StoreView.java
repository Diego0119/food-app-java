package view;
import model.Product;
import controller.UserController;
import view.UserView.UserView;
import controller.StoreController;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StoreView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_10; 
    private JLabel lblNewLabel_10_1;
    private JLabel lblNewLabel_10_2;
    private JTable table;
    private StoreController storeController;
    private UserView userView;
    


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StoreView frame = new StoreView();
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
    public StoreView() {
        storeController = StoreController.getInstance();
        System.out.println("Store View: " + storeController);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Ingrese el codigo del producto");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre del producto");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Ingrese la fecha de vencimiento del producto");
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Ingrese la cantidad del producto");
        
        JLabel lblNewLabel_4 = new JLabel("Ingrese el precio del producto");
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        
        JButton btnNewButton = new JButton("Publicar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String code = textField_1.getText();
                String name = textField.getText();
                LocalDate due_date = LocalDate.parse(textField_2.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int quantity = Integer.parseInt(textField_3.getText());
                double price = Double.parseDouble(textField_4.getText());
                storeController.addProduct(name, code, due_date, quantity, price);
                updateTable();
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
            }
        });
        
        lblNewLabel_5 = new JLabel("Ingresar un producto");
        
        lblNewLabel_6 = new JLabel("Estadisticas");
        
        JSeparator separator = new JSeparator();
        
        JLabel lblNewLabel_7 = new JLabel("Productos en venta:");
        
        JLabel lblNewLabel_8 = new JLabel("Ganancias:");
        
        JLabel lblNewLabel_9 = new JLabel("Productos vendidos: ");
    
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
       
        	},

            new String[] {
                "Codigo", "Nombre", "Fecha Vencimiento", "Cantidad", "Precio"
            }
        ));
       
        JScrollPane scrollPane = new JScrollPane(table);
	
		lblNewLabel_10 = new JLabel("0");
				
        lblNewLabel_10_1 = new JLabel("0");
       
        lblNewLabel_10_2 = new JLabel("0");
        
        JButton btnNewButton_1 = new JButton("Recargar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateStats();
        	}
        });
       

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_1)
        						.addComponent(lblNewLabel_3)
        						.addComponent(lblNewLabel_4)
        						.addComponent(lblNewLabel)
        						.addComponent(lblNewLabel_2))
        					.addGap(25)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(92)
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblNewLabel_7)
        								.addComponent(lblNewLabel_8)
        								.addComponent(lblNewLabel_9))
        							.addGap(50)
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblNewLabel_10_2)
        								.addComponent(lblNewLabel_10_1)
        								.addComponent(lblNewLabel_10)
        								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(325)
        					.addComponent(btnNewButton))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 860, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(24, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(btnNewButton_1))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(108)
        					.addComponent(lblNewLabel_5)
        					.addPreferredGap(ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
        					.addComponent(lblNewLabel_6)))
        			.addGap(176))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_5)
        						.addComponent(lblNewLabel_6))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_7)
        						.addComponent(lblNewLabel_10))
        					.addGap(8)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_8)
        						.addComponent(lblNewLabel_10_1))
        					.addGap(10)))
        			.addGap(7)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_2)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_9)
        				.addComponent(lblNewLabel_10_2))
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_3)
        						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_4)
        						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(16)
        					.addComponent(btnNewButton))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(25)
        					.addComponent(btnNewButton_1)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(48, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
    
	private void updateTable() {
	
		List<Product> products = storeController.getProducts();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	
		System.out.println("Numero de productos en la tienda: " + storeController.getNumberOfProducts());
		lblNewLabel_10.setText(String.valueOf(storeController.getNumberOfProducts()));

		for(Product product : products) {
			model.addRow(new Object[] {
					 product.getCode(),
		             product.getName(),
		             product.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
		             product.getQuantity(),
		             product.getPrice()
			});
		}
		
	}
	
	private void updateStats() {
		lblNewLabel_10_1.setText(String.valueOf(storeController.getProfits()));
		lblNewLabel_10_2.setText(String.valueOf(storeController.getCountOfPurchasedProducts()));

	}

}

