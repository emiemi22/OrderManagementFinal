package presentation;

import bll.ClientBLL;
import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class ClientController {
    private ClientView clientView ;
    private ClientBLL clientBLL = new ClientBLL();
    public  ClientController(ClientView clientView){
        this.clientView = clientView ;
        clientView.addEditButtonListener(new EditListener());
        clientView.addDeleteButtonListener(new DeleteListener());
        clientView.addInsertButtonListener(new InsertListener());
        clientView.addViewButtonListener(new ViewTableListener());
        clientView.addBackButtonListener(new BackListener());
    }
    class EditListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(clientView.getIdJT());
            String name = clientView.getNameJT();
            String email = clientView.getEmailJT();
            String telephone = clientView.getTelephoneJT();
            String address = clientView.getAddressJT();
            Client cNew = new Client(id , name , email , telephone , address );
            try {
                clientBLL.updateClient(cNew);
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
            int id = Integer.parseInt(clientView.getIdJT());
            try {
                clientBLL.removeClient(clientBLL.getClientID(id));
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
             int id = Integer.parseInt(clientView.getIdJT());
             String name = clientView.getNameJT();
             String email = clientView.getEmailJT();
             String telephone = clientView.getTelephoneJT();
             String address = clientView.getAddressJT();
             Client newClient = new Client(id , name , email, telephone , address);
            try {
                clientBLL.addClient(newClient);
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
                Object[][] mat = clientBLL.showAllClients();
                String[] columns = new String[5];
                columns[0] = "id";
                columns[1] = "name";
                columns[2] = "email";
                columns[3] = "telephone";
                columns[4] = "address";
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
            clientView.setVisible(false);
        }
    }
}
