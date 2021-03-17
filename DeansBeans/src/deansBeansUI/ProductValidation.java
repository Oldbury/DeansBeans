package deansBeansUI;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProductValidation {

    public static boolean ValidateProductName(String productName)
    {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(productName);
        boolean matches = matcher.find();
        
        if (matches)
            return true;

        return false;
    }

    public static boolean ValidateQuantity(int quantity)
    {
        if (quantity >= 1)
            return true;
        
        return false;
    }
}
