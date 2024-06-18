package view.UserView;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import model.Product;
import controller.StoreController;
import controller.UserController;
import model.User;

public class UserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private StoreController storeController;
	private UserController userController;
	private static User user;
	private JPanel productsPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserView(User user) { 
		this.user = user;
		storeController = StoreController.getInstance();
		System.out.println("User View: " + storeController);
		
		userController = new UserController(user,storeController);
	
		System.out.println("User View: " + user);

		String name = user.getName();
		double total_money = user.getTotalMoney();
		
		textField = new JTextField();
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola " + name);
		lblNewLabel.setBounds(40, 6, 200, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("" + total_money);
		lblNewLabel_1.setBounds(240, 6, 61, 16);
		contentPane.add(lblNewLabel_1);
			
		JButton btnNewButton_2 = new JButton("Recargar");
		btnNewButton_2.setBounds(111, 22, 117, 29);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	              updateUserView();
	          }
	     });

		JLabel lblNewLabel_6 = new JLabel("Producto");
		lblNewLabel_6.setBounds(6, 61, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Precio");
		lblNewLabel_7.setBounds(73, 61, 38, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("F. vencimiento");
		lblNewLabel_8.setBounds(121, 61, 100, 16);
		contentPane.add(lblNewLabel_8);
		
		productsPanel = new JPanel();
		productsPanel.setBounds(6, 90, 380, 460);
		contentPane.add(productsPanel);
		productsPanel.setLayout(null);
		
		updateUserView();
	}

	public void updateUserView() {
		productsPanel.removeAll();  // Clear previous content
		
		List<Product> products = storeController.getProducts();
		int yOffset = 0;
		
		for (Product product : products) {
			JLabel nameLabel = new JLabel(product.getName());
			nameLabel.setBounds(10, yOffset, 100, 16);
			productsPanel.add(nameLabel);
			
			JLabel priceLabel = new JLabel(String.valueOf(product.getPrice()));
			priceLabel.setBounds(120, yOffset, 50, 16);
			productsPanel.add(priceLabel);
			
			JLabel dueDateLabel = new JLabel(product.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			dueDateLabel.setBounds(180, yOffset, 100, 16);
			productsPanel.add(dueDateLabel);
			
			JButton buyButton = new JButton("Comprar");
			buyButton.setBounds(290, yOffset, 80, 29);
			buyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Dinero antes de la compra: " + user.getTotalMoney());
					userController.buyProduct(product.getPrice());
					System.out.println("Dinero despues de la compra: " + user.getTotalMoney());
					lblNewLabel_1.setText("" + user.getTotalMoney());
				}
			});
			productsPanel.add(buyButton);
			
			yOffset += 40;  // Adjust the yOffset for the next product
		}
		
		productsPanel.revalidate();
		productsPanel.repaint();
	}
}
