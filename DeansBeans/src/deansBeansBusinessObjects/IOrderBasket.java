package deansBeansBusinessObjects;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderBasket {
    List<IBasketItem> getBasketItems();
    int getNumberOfProducts();
    BigDecimal getBasketTotal();
    int getNumberOfItems();

    void addItem(IBasketItem basketItem);
    void removeItem(IBasketItem basketItem);
    void clearBasket();
}
