package bll;

import bll.validators.*;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;
import presentation.Log;

import java.beans.IntrospectionException;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class OrderBLL {
    private List<Validator<Order>> validators = new ArrayList<>();
    private OrderDAO orderDAO = new OrderDAO();
    private ProductBLL productBLL = new ProductBLL();
    public OrderBLL(){
        validators.add(new QuantityValidator());
        validators.add(new CheckAvaibleValidator());
        validators.add(new ProductIDValidator());
        validators.add(new ClientIDValidator());

        
    }
    private void validateOrder(Order c){
        for (Validator<Order> arr : validators){
            arr.validate(c);
        }
    }
    public void addOrder(Order c) throws IntrospectionException, IllegalAccessException, InvocationTargetException, FileNotFoundException {
        validateOrder(c);
        String text = "" ;
        orderDAO.insert(c);
        int idClient = c.getClientId();
        int idProduct = c.getProductId();
        Product p = productBLL.getProductID(idProduct);
        text = text + "Client with id:" +idClient + " ordered " + p.getName() + " that costs: " + c.getQuantity()*p.getPrice();
        System.out.println(text);
        Log.getInstance().writeToFile(text);

        p.setQuantity(p.getQuantity()-c.getQuantity());
        productBLL.updateProduct(p);
    }
    public void removeOrder(Order c) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
       // validateOrder(c);
        orderDAO.delete(c);
    }
    public void updateOrder(Order c) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        validateOrder(c);
        orderDAO.update(c);
    }
    public Object[][] showAllOrders() throws IllegalAccessException {
        Object [][]mat = (Object[][]) orderDAO.createTableData();
        return  mat;
    }
    public Order getOrderID(int id){
        Order c = orderDAO.findById(id);
        return  c;
    }
}
