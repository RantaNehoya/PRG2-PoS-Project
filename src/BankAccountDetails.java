public class BankAccountDetails {

    private static final String userName = User.getUserName();
    private static final  String userID = User.getUserID();
    private static final  String phoneNumber = User.getPhoneNumber();
    private static final  String cardNumber = "4485556604341831";
    private static final  String cardType = "Visa";
    private static final  String cvvPin = "251";
    private static double accBalance = 15_850;

    public void verifyTransaction(){
        if (accBalance<Order.getTotal()){//verify funds in account
            System.out.println("You have insufficient funds to make this purchase");
        }else{
            accBalance -= Order.getTotal(); //subtract cost from bank balance
            System.out.println("You've successfully made a purchase of N$" + Cart.getTotal());
        }
    }

    //Getter
    public static String getCvvPin() {
        return cvvPin;
    }
}
