package bll;

import bll.validators.EmailValidator;
import bll.validators.PhoneValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ClientBLL {
    private List<Validator<Client>> validators = new ArrayList<>();;
    private ClientDAO clientDAO= new ClientDAO();
    public ClientBLL(){
        validators.add(new EmailValidator());
        validators.add(new PhoneValidator());
    }
    private void validateClient(Client c){
        for (Validator<Client> arr : validators){
            arr.validate(c);
        }
    }
    public void addClient(Client c) throws IntrospectionException, IllegalAccessException {
            validateClient(c);
            clientDAO.insert(c);
    }
    public void removeClient(Client c) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        validateClient(c);
        clientDAO.delete(c);
    }
    public void updateClient(Client c) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        validateClient(c);
        clientDAO.update(c);
    }
    public Client getClientID(int id){
        Client c = clientDAO.findById(id);
        return  c;
    }
    public Object[][] showAllClients() throws IllegalAccessException {
        Object [][]mat = (Object[][]) clientDAO.createTableData();
        return mat;
    }
    public Client findClientByID( int id){
        Client c = clientDAO.findById(id);
        return c ;
    }

}
