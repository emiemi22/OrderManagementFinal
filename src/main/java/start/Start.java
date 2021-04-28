package start;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.Order;
import model.Product;
import presentation.MainController;
import presentation.MainView;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException, IllegalAccessException, IntrospectionException, InvocationTargetException {

		ClientDAO clientDAO = new ClientDAO();
		ProductDAO productDAO = new ProductDAO();
		OrderDAO orderDAO = new OrderDAO();
	
		ClientBLL clientBLL = new ClientBLL();
		ProductBLL productBLL = new ProductBLL();
		OrderBLL orderBLL = new OrderBLL();

		//orderDAO.findAll();
		//List<Product> pr = new ArrayList<>();
		clientBLL.showAllClients();
		productBLL.showAllProducts();
		orderBLL.showAllOrders();



		/*List<Client> cl = new ArrayList<>();
		cl=clientDAO.findAll();
		if (cl == null)
			System.out.println("cl null");
		else
			for(Client c : cl){
				System.out.println(c.toString());
			}
		/// FIND by ID
		Client cl1 = clientDAO.findById(2);
		System.out.println("index" + cl1.toString());
		/// INSERT
		Client newClient = new Client(9 , "Andra" , "adnra@yahoo.com" , "0752342322", "Memo");
		//clientDAO.insert(newClient);

		newClient.setName("Bianca");
		clientDAO.update(newClient);
		clientDAO.delete(newClient);
		clientDAO.createTableData();
		*/
		new MainController();
		//orderBLL.getOrderID(2);
	}

}
