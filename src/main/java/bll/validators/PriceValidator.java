package bll.validators;

import model.Product;

public class PriceValidator implements Validator<Product>{
    @Override
    public void validate(Product product) {
        if(product.getPrice() < 0){
            throw new IllegalArgumentException("Not a valide Price");
        }
    }
}
