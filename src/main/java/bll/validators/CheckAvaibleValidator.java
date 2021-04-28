package bll.validators;

import dao.ProductDAO;
import model.Order;

public class CheckAvaibleValidator implements Validator{

    @Override
    public void validate(Object o) {

        int productID = ((Order) o).getProductId();
        int quantity = ((Order) o).getQuantity();
        ProductDAO productDAO = new ProductDAO();
        if(productDAO.findById(productID).getQuantity() - quantity< 0)
        {
            throw new IllegalArgumentException("Too more products - Order less!");
        }

    }
}
