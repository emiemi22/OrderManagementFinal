package bll.validators;

import model.Order;
import model.Product;

public class QuantityValidator implements Validator{

    @Override
    public void validate(Object o) {
        if (o instanceof Order){
            if (((Order) o).getQuantity() <= 0){
                throw new IllegalArgumentException("Quantity cannot be <=0.");
            }
        }
        else{
            if (o instanceof Product){
            if (((Product) o).getQuantity() <= 0){
                throw new IllegalArgumentException("No left product");
            }
            }
        }
    }
}
