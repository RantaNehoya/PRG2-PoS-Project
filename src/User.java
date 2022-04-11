import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class User implements Customer {

    Scanner user = new Scanner(System.in);
    BankAccountDetails bank_details = new BankAccountDetails();
    Cart cart = new Cart();

    private static String userName;
    private static String password;
    private static String emailAddress;
    private static String phoneNumber;
    private static String postalAddress;
    private static String userID;

    //Overriding Customer interface methods
    @Override
    public void addCustomer(){//method to create account
        System.out.println("Please enter your Username");
        userName = user.nextLine();
        System.out.println("Enter your password");
        password = user.nextLine();

        System.out.println("Enter your email address");
        emailAddress = user.nextLine();

        System.out.println("Enter your phone number");
        phoneNumber = user.nextLine();
        while (phoneNumber.length()!=10){
            System.out.println("Please enter a 10 digit phone number");
            phoneNumber = user.nextLine();
        }

        System.out.println("Enter your postal address");
        postalAddress = user.nextLine();

        System.out.print("Your assigned user ID is: ");
        Random rand = new Random();
        int upperbound = 1001;
        int user_ID = rand.nextInt(upperbound); //generate random int
        userID = String.valueOf(user_ID); //convert to String
    }

    @Override
    public void editCustomer(int code) {//method to edit account
        try{//InputMismatchException
            code = user.nextInt();
        }catch (InputMismatchException e){
            while (code<1 || code>6){
                //check for correct input
                System.out.println("Please enter a number from 1 to 6");
                code = user.nextInt();
            }
        }

        switch (code){
            case 1:
                System.out.println("Enter your new username");
                String new_userName = user.nextLine();
                while(new_userName.equals(userName)){//check to see new is not same as old
                    System.out.println("Please enter a new username");
                    new_userName = user.nextLine();
                }
                break;

            case 2:
                System.out.println("Enter your new password");
                String new_password = user.nextLine();
                while(new_password.equals(password)){//check to see new is not same as old
                    System.out.println("Please enter a new password");
                    new_password = user.nextLine();
                }
                break;

            case 3:
                System.out.println("Enter your new email address");
                String new_email = user.nextLine();
                while(new_email.equals(emailAddress)){//check to see new is not same as old
                    System.out.println("Please enter a new email address");
                    new_email = user.nextLine();
                }
                break;

            case 4:
                System.out.println("Enter your new phone number");
                String new_phoneNumber = user.nextLine();
                while (new_phoneNumber.length()!=10) {//check to make sure phone number has 10 digits
                    System.out.println("Please enter a 10 digit phone number");
                    new_phoneNumber = user.nextLine();
                    while(new_phoneNumber.equals(phoneNumber)){//check to see new is not same as old
                        System.out.println("Please enter a new phone number");
                        new_userName = user.nextLine();
                    }
                }
                break;

            case 5:
                System.out.println("Enter your new postal address");
                String new_address = user.nextLine();
                while(new_address.equals(postalAddress)){//check to see new is not same as old
                    System.out.println("Please enter a new postal address");
                    new_address = user.nextLine();
                }
                break;

            case 6:
                System.out.println("Enter your new user ID");
                String new_id = user.nextLine();
                while(new_id.equals(userID)){//check to see new is not same as old
                    System.out.println("Please enter a new user ID");
                    new_id = user.nextLine();
                }
                break;
        }
    }

    @Override
    public void verifyTransaction() {
        System.out.print("Enter Pin: ");
        String pin = user.nextLine();
        if (pin.equals(BankAccountDetails.getCvvPin())){ //verify pin number
            bank_details.verifyTransaction(); //invoke verifyTransaction method
        }else{
            System.out.println("Incorrect pin, try again");
        }
    }

    //add items to cart
    @Override
    public void addItems(String prodName) {
        cart.addItems(prodName);
    }

    //modify items in cart
    @Override
    public void modifyItems(String prodName, String newProd) {
        cart.modifyItems(prodName, newProd);
    }

    //remove items from cart
    @Override
    public void removeItems(String prodName) {
        cart.removeItems(prodName);
    }

    @Override
    public void displayTotal() {
        cart.displayTotal();
    }

    @Override
    public void createOrder() {
        var order = new Order();
        order.createOrder();
    }

    @Override
    public void purchaseHistory() {
        ArrayList<String> history = cart.displayTotal();
    }

    @Override
    public void viewCart() {
        cart.displayTotal();
    }

    //Getters
    public static String getUserName() {
        return userName;
    }

    public static String getEmailAddress() {
        return emailAddress;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getPostalAddress() {
        return postalAddress;
    }

    public static String getUserID() {
        return userID;
    }

}
