package deansBeansBusinessObjects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import deansBeansDataLayer.models.Customer;

public class OrderBasket implements IOrderBasket {

	Customer customer = null;
    private List<IBasketItem> basketItems = new ArrayList<IBasketItem>();

    public OrderBasket(Customer customer) {
    	this.customer = customer;
    }

    public List<IBasketItem> getBasketItems() {
        return basketItems;
    }
    
    private void setBasketItems(List<IBasketItem> basketItems) {
    	this.basketItems = basketItems;
    }

    public int getNumberOfProducts(){
        return  basketItems.size();
    }

    public BigDecimal getBasketTotal() {
    	BigDecimal totalPrice = new BigDecimal(0);
        for (IBasketItem item : basketItems){
        	totalPrice = totalPrice.add(item.getTotalValueOfBasketItem());	
        }
        return totalPrice;
    }

    public int getNumberOfItems(){
        int numberOfBasketItems = 0;
        for (IBasketItem item : basketItems){
            numberOfBasketItems += item.getQuantity();
        }
        return numberOfBasketItems;
    }
    
    public void addItem(IBasketItem basketItem){
    	
		List<IBasketItem> basketItemList = getBasketItems();
		    	IBasketItem matchingProduct = findBasketItem(basketItem);
    	
		    	if (matchingProduct == null) {
		    		basketItems.add(basketItem);
		    	}
		    	else {
		    		int index = basketItems.indexOf(basketItem) + 1;
		    		basketItems.get(index).increaseQuantity(basketItem.getQuantity());
		    	}
//		    	basketItems.add(basketItem);
    }

    public void removeItem(IBasketItem basketItem){
    	IBasketItem matchingItem = findBasketItem(basketItem);
    	
    	if (matchingItem != null) {
    		basketItems.remove(matchingItem);
    	}
    }

    public void clearBasket(){
        basketItems.clear();
    }

   public boolean isProductNameInBasket(String productName)
   {
       for (IBasketItem item : basketItems){
           if (item.getProductName().equals(productName)) {
               return true;
           }
       }
       return false;
   }
    
    private IBasketItem findBasketItem(IBasketItem basketItem)
    {
        for (IBasketItem item : basketItems){
            if (item.getProductID() == basketItem.getProductID() && item.getFormatID() == basketItem.getFormatID() && item.getDegreeOfRoastID() == basketItem.getDegreeOfRoastID() ) {
                return item;
            }
        }
        return null;
    }
}
