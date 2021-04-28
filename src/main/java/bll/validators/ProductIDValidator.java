package bll.validators;

import dao.ProductDAO;
import model.Order;
import model.Product;

public class ProductIDValidator implements Validator{
    @Override
    public void validate(Object o) {
        int productID = ((Order) o).getProductId();
        ProductDAO productDAO = new ProductDAO();
        if(productDAO.findById(productID)==null){
            throw new IllegalArgumentException("Product ID does note exist!");

        }
    }
}
