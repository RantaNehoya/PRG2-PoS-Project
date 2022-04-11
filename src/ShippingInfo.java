import java.util.ArrayList;

public class ShippingInfo {
    Cart cart = new Cart();

    private static final String shippingID = "ZhvJc0aU";
    private static final String shippingAddress = User.getPostalAddress();
    private final ArrayList<String> order = cart.displayTotal();

    public void status(String status){
        if (status.equalsIgnoreCase("booked for delivery")){
            System.out.println("Your order is being packed and should be collected soon for delivery");
        }else if (status.equalsIgnoreCase("in transit")){
            System.out.println("Your parcel has been picked up and is on it's way to a local depot");
        }else if (status.equalsIgnoreCase("with driver")){
            System.out.println("Good news, a local driver has your parcel on board for delivery shortly!");
        }else if (status.equalsIgnoreCase("delivery attempted")){
            System.out.println("The driver attempted to deliver but missed you," +
                    " perhaps you were not home at the time of delivery.");
        }else{
            System.out.println("The driver marked your delivery as completed.");
        }
    }

    //Getters
    public void getShippingID() {
        System.out.println(shippingID);
    }

    public void getShippingAddress() {
        System.out.println(shippingAddress);
    }

    public void getOrder() {
        System.out.println(order);
    }
}
