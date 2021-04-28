package presentation;

import bll.ProductBLL;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class ProductController {
    private ProductView ProductView ;
    private ProductBLL ProductBLL = new ProductBLL();
    public  ProductController(ProductView ProductView){
        this.ProductView = ProductView ;
        ProductView.addEditButtonListener(new ProductController.EditListener());
        ProductView.addDeleteButtonListener(new ProductController.DeleteListener());
        ProductView.addInsertButtonListener(new ProductController.InsertListener());
        ProductView.addViewButtonListener(new ProductController.ViewTableListener());
        ProductView.addBackButtonListener(new ProductController.BackListener());
    }
    class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(ProductView.getIdJT());
            String name = ProductView.getNameJT();
            int price = Integer.parseInt(ProductView.getPriceJT());
            int quantity = Integer.parseInt(ProductView.getQuantityJT());

            Product cNew = new Product(id , name , price , quantity  );
            try {
                ProductBLL.updateProduct(cNew);
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
            int id = Integer.parseInt(ProductView.getIdJT());
            try {
                ProductBLL.removeProduct(ProductBLL.getProductID(id));
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
            int id = Integer.parseInt(ProductView.getIdJT());
            String name = ProductView.getNameJT();
            int price = Integer.parseInt(ProductView.getPriceJT());
            int quantity = Integer.parseInt(ProductView.getQuantityJT());
            Product newProduct = new Product(id , name , price, quantity);
            try {
                ProductBLL.addProduct(newProduct);
            } catch (IntrospectionException introspectionException) {
                introspectionException.printStackTrace();
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }
    class ViewTableListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] mat = ProductBLL.showAllProducts();
                String[] columns = new String[4];
                columns[0] = "id";
                columns[1] = "name";
                columns[2] = "price";
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
            ProductView.setVisible(false);
        }
    }
}
