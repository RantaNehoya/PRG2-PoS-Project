import java.util.Date;

public class Order {
    private static final String orderID = "RYe77";
    private static final double total = Cart.getTotal();
    private static final Date orderDate = new Date();
    private static ShippingInfo shippingInfo;

    public void createOrder(){
        shippingInfo.getShippingID();
        shippingInfo.getShippingAddress();
        shippingInfo.getOrder();
        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Order Date: ", orderDate); //format date = Month Day, Year
    }

    //Getters
    public static String getOrderID() {
        return orderID;
    }

    public static double getTotal() {
        return total;
    }
}
