package bll.validators;

import bll.ClientBLL;
import model.Client;

import java.util.regex.Pattern;

public class PhoneValidator implements Validator<Client> {
    private static final String TELEPHONE_PATTERN = "(\\+4)?07[0-9]{8}";

    @Override
    public void validate(Client client) {
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        if(!pattern.matcher(client.getTelephone()).matches()){
            throw new IllegalArgumentException("Not a valid telephone number!");
        }
    }
}
