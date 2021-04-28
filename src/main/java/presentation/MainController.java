package presentation;

import model.Client;
import model.Order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainController {

    private MainView mainView ;
    public MainController(){
        mainView = new MainView();
        mainView.addClientButtonListener(new ClientListener());
        mainView.addProductButtonListener(new ProductListener());
        mainView.addOrderButtonListener(new OrderListener());
    }
    class ClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientView clientView = new ClientView();
            new ClientController(clientView);
            mainView.setVisible(false);
        }
    }
    class ProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductView productView = new ProductView();
            new ProductController(productView);
            mainView.setVisible(false);
        }
    }
    class OrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderView orderView = new OrderView();
            new OrderController(orderView);
        }
    }
}
