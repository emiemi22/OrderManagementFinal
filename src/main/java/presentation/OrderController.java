package presentation;

import bll.OrderBLL;
import bll.OrderBLL;
import model.Order;
import model.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class OrderController {
    private OrderView OrderView ;
    private bll.OrderBLL OrderBLL = new OrderBLL();
    public OrderController(OrderView view){
        this.OrderView = view;
        OrderView.addEditButtonListener(new OrderController.EditListener());
        OrderView.addDeleteButtonListener(new OrderController.DeleteListener());
        OrderView.addInsertButtonListener(new OrderController.InsertListener());
        OrderView.addViewButtonListener(new OrderController.ViewTableListener());
        OrderView.addBackButtonListener(new OrderController.BackListener());
    }
    class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(OrderView.getIdJT());
            int idClient = Integer.parseInt(OrderView.getClientIdJT());
            int idProduct= Integer.parseInt(OrderView.getProductIDJT()) ;
            int quantity = Integer.parseInt(OrderView.getQuantityJT());

            Order cNew = new Order(id , idClient,idProduct , quantity);
            try {
                OrderBLL.updateOrder(cNew);
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (IntrospectionException introspectionException) {
                introspectionException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
        }
    }
    class DeleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(OrderView.getIdJT());
            try {

                OrderBLL.removeOrder(OrderBLL.getOrderID(id));
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (IntrospectionException introspectionException) {
                introspectionException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
        }
    }
    class InsertListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(OrderView.getIdJT());
            int idClient = Integer.parseInt(OrderView.getClientIdJT());
            int idProduct= Integer.parseInt(OrderView.getProductIDJT()) ;
            int quantity = Integer.parseInt(OrderView.getQuantityJT());
            Order newOrder = new Order(id , idClient , idProduct, quantity);
            try {
                OrderBLL.addOrder(newOrder);
            } catch (IntrospectionException introspectionException) {
                introspectionException.printStackTrace();
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
    class ViewTableListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] mat = OrderBLL.showAllOrders();
                String[] columns = new String[4];
                columns[0] = "id";
                columns[1] = "idClient";
                columns[2] = "idProduct";
                columns[3] = "quantity";
                JTable jTable= new JTable(mat , columns);
                new JTableView(jTable);
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }
    class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new MainController();
            //mainView.dispatchEvent(new WindowEvent(mainView, WindowEvent.WINDOW_CLOSING));
            OrderView.setVisible(false);
            try {
                Log.getInstance().closeFile();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}
