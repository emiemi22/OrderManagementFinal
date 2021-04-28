package bll.validators;

import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Order;

import java.util.NoSuchElementException;

public class ClientIDValidator implements  Validator{
    @Override
    public void validate(Object o) {
        int clientID = ((Order) o).getClientId();
        ClientDAO productDAO = new ClientDAO();
        if(productDAO.findById(clientID)==null){
            throw new IllegalArgumentException("Client ID does note exist!");
        }
    }
}
