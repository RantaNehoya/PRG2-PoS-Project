import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        var scanner = new Scanner(System.in);
        Admin admin = new Inventory();
        Customer customer = new User();
        String status = "Currently unavailable";

        System.out.print("Login: ");
        String login = scanner.next();

        while (!login.equalsIgnoreCase("admin") && !login.equalsIgnoreCase("customer")){
            System.out.println("Enter either \"admin\" or \"customer\" ");
            login = scanner.next();
        }

        if (login.equals("admin")){
            System.out.println("Welcome to the Administrative Side");
            admin.alertReorder();
            boolean quit = false;

            while (!quit) {
                System.out.println("Enter a number from 1 to 6. Instructions are as follows:\n" +
                        "Enter 1 to add an item to inventory\nEnter 2 to modify an item in inventory\n" +
                        "Enter 3 to remove an item from inventory\nEnter 4 to enter shipping status\n" +
                        "Enter 5 to output total sales\nEnter 6 to view sold items\nEnter 7 to quit");
                int code = scanner.nextInt();
                while (code < 1 || code > 7) {
                    System.out.println("Enter a number from 1 to 7");
                    code = scanner.nextInt();
                }

                switch (code) {
                    case 1:
                        System.out.println("Enter the product name");
                        String prodName = scanner.nextLine();
                        System.out.println("Enter the product ID");
                        String prodID = scanner.nextLine();
                        System.out.println("Enter the product quantity");
                        int quantity = scanner.nextInt();
                        System.out.println("Enter the product price");
                        double price = scanner.nextDouble();
                        admin.addItems(prodName, prodID, quantity, price);
                        break;

                    case 2:
                        for (int i = 0; i < Inventory.getProductName().size(); i++) {
                            System.out.println("Position\t\tProduct Name\t\t");
                            System.out.println((i + 1) + ".\t\t" + Inventory.getProductName().get(i) + "\t\t" +
                                    Inventory.getProductID().get(i) + "\t\t" + Inventory.getUnitQuantity().get(i) +
                                    "\t\t" + Inventory.getUnitPrice().get(i));
                        }
                        System.out.println("\nEnter the position of the product");
                        int position = scanner.nextInt();
                        System.out.println("Enter the name of the product");
                        prodName = scanner.nextLine();
                        System.out.println("Enter the ID of the product");
                        prodID = scanner.nextLine();
                        System.out.println("Enter the quantity of the product");
                        quantity = scanner.nextInt();
                        System.out.println("Enter the price of the product");
                        price = scanner.nextDouble();
                        admin.modifyItems(position, prodName, prodID, quantity, price);
                        break;

                    case 3:
                        for (int i = 0; i < Inventory.getProductName().size(); i++) {
                            System.out.println("Position\t\tProduct Name\t\t");
                            System.out.println((i + 1) + ".\t\t" + Inventory.getProductName().get(i));
                        }
                        System.out.println("Enter the position of the product to remove");
                        position = scanner.nextInt();
                        while (position >= Inventory.getProductName().size() || position < 1) {
                            System.out.println("Position not on list");
                        }
                        admin.removeItems(position);
                        break;

                    case 4:
                        System.out.println("States of Delivery: \nBooked for Delivery\nIn Transit\nWith Driver\n" +
                                "Delivery Attempted\nCompleted");
                        status = scanner.nextLine();
                        while (!status.equalsIgnoreCase("booked for delivery") && !status.equalsIgnoreCase("in transit") &&
                                !status.equalsIgnoreCase("with driver") && !status.equalsIgnoreCase("delivery attempted") &&
                                !status.equalsIgnoreCase("completed")) {
                            System.out.println("Invalid state of delivery, try again");
                            status = scanner.nextLine();
                        }
                        break;

                    case 5:
                        admin.totalSales();
                        break;

                    case 6:
                        admin.soldItems();
                        break;

                    case 7:
                        quit = true;
                        break;
                }
            }
        }else{
            System.out.println("Welcome to our Store!");

            boolean quit = false;
            while (!quit) {
                System.out.println("Enter a number from 1 to 9. Instructions are as follows:\n" +
                        "Enter 1 to create an account\nEnter 2 to edit account\nEnter 3 to add item to cart" +
                        "Enter 4 to modify cart\nEnter 5 to remove an item from cart\nEnter 6 to view cart\n" +
                        "Enter 7 to view purchase history\nEnter 8 to confirm purchase\nEnter 9 to quit");
                int code = scanner.nextInt();

                while (code < 1 || code > 9) {
                    System.out.println("Enter a number from 1 to 9");
                    code = scanner.nextInt();
                }

                switch (code) {
                    case 1:
                        customer.addCustomer();
                        break;

                    case 2:
                        System.out.println("Please enter a number from 1 to 6. Instructions are as follows:\n" +
                                "Enter 1 to change username\nEnter 2 to change password\nEnter 3 to change email address\n" +
                                "Enter 4 to change phone number\nEnter 5 to change postal address\n" +
                                "Enter 6 to change user ID");
                        code = scanner.nextInt();
                        customer.editCustomer(code);
                        break;

                    case 3:
                        System.out.print("Product to add to cart: ");
                        String product = scanner.nextLine();
                        customer.addItems(product);
                        break;

                    case 4:
                        for (int i=0; i<Cart.getCart().size(); i++){
                            System.out.println("Your Cart:\n" + Cart.getCart().get(i));
                        }
                        System.out.print("\nEnter product to modify: ");
                        String prodName = scanner.nextLine();
                        System.out.print("\nEnter new product: ");
                        String newProd = scanner.nextLine();
                        customer.modifyItems(prodName, newProd);
                        break;

                    case 5:
                        for (int i=0; i<Cart.getCart().size(); i++){
                            System.out.println("Your Cart:\n" + Cart.getCart().get(i));
                        }
                        System.out.print("\nEnter product to remove from cart: ");
                        product = scanner.nextLine();
                        customer.removeItems(product);
                        break;

                    case 6:
                        customer.viewCart();
                        break;

                    case 7:
                        customer.purchaseHistory();
                        break;

                    case 8:
                        customer.verifyTransaction();
                        customer.displayTotal();
                        customer.createOrder();
                        var orderDetails = new OrderDetails();
                        admin.status(status);

                    case 9:
                        quit = true;
                        break;
                }
            }
        }
    }
}