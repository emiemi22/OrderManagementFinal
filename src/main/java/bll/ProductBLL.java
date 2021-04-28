package bll;

import bll.validators.ProductIDValidator;
import bll.validators.QuantityValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ProductBLL {
    private List<Validator<Product>> validators = new ArrayList<>();
    private ProductDAO productDAO = new ProductDAO();
    public ProductBLL (){
        validators.add(new QuantityValidator());
    }
    private void validateproduct(Product p){
        for (Validator<Product> arr : validators){
            arr.validate(p);
        }
    }
    public void addProduct(Product p) throws IntrospectionException, IllegalAccessException {
        validateproduct(p);
        productDAO.insert(p);
    }
    public void removeProduct(Product c) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        validateproduct(c);
        productDAO.delete(c);
    }
    public void updateProduct(Product c) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        validateproduct(c);
        productDAO.update(c);
    }
    public Object[][] showAllProducts() throws IllegalAccessException {
        Object [][]mat = (Object[][]) productDAO.createTableData();
        return mat;
    }
    public Product getProductID(int id){
        Product c = productDAO.findById(id);
        return  c;
    }
}
