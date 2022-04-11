public class OrderDetails extends Cart{
    public OrderDetails() {
        String userName = User.getUserName();
        String orderID = Order.getOrderID();
        String emailAddress = User.getEmailAddress();
        String postalAddress = User.getPostalAddress();
        String phoneNumber = User.getPhoneNumber();

        //Print out order details
        System.out.println("Order ID: " + orderID + "\nUsername: " + userName + "\nPhone Number: " +
                phoneNumber + "\nEmail Address: " + emailAddress + "Postal Address: " + postalAddress);
        System.out.println("Order status is:");

    }
}
