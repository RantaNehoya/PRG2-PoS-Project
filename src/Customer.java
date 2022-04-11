import java.text.ParseException;

public interface Customer {
    public void addCustomer();
    public void editCustomer(int code);
    public void purchaseHistory();
    public void verifyTransaction();
    public void viewCart();
    public void addItems(String prodName);
    public void modifyItems(String prodName, String newProd);
    public void removeItems(String prodName);
    public void displayTotal();
    public void createOrder();

}
