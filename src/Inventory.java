import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Inventory implements Admin{

    //ArrayList to declare class variables
    private static ArrayList<String> productName = new ArrayList<>(Arrays.asList("Greeting Cards", "Women's Jewelry",
            "Men's Jewelry", "Novelty Gifts", "Children's Clothes", "Women's Clothes", "Men's Clothes"));

    private static ArrayList<String> productID = new ArrayList<>(Arrays.asList("Zd-Mp", "JIP50",
            "ECeLf", "XtJ_s", "WfsPS", "Oyjj5", "bURR7"));

    private static ArrayList<Integer> unitQuantity = new ArrayList<>(Arrays.asList(50, 20, 20, 30, 20, 50, 50));

    private static ArrayList<Double> unitPrice = new ArrayList<>(Arrays.asList(10.00, 30.00, 25.99, 59.98,
            20.00, 80.00, 60.00));

    //ArrayList variables for sales report
    private static ArrayList<String> prev_month = new ArrayList<>();
    private static final ArrayList<String> curr_month = Cart.getCart();

    //Overriding Admin interface methods
    @Override
    public void addItems(String prodName, String prodID, int quantity, double price) {//method to add to inventory
        productName.add(prodName);
        productID.add(prodID);
        unitQuantity.add(quantity);
        unitPrice.add(price);
        System.out.println(prodName + " was successfully added to the inventory");
    }

    @Override
    public void modifyItems(int position, String prodName, String prodID, int quantity, double price) {//method to modify inventory items
        //Subtract 1 from position entered by user because the program starts counting from 0,
        //while humans start counting from 1
        String modifiedItem = productName.get((position-1));
        productName.set((position-1), prodName);
        productID.set((position-1), prodID);
        unitQuantity.set((position-1), quantity);
        unitPrice.set((position-1), price);
        System.out.println(modifiedItem + " at position " + position + " was modified to " + prodName);
    }

    @Override
    public void removeItems(int position) {//method to remove from inventory
        //Subtract 1 from position entered by user because the program starts counting from 0,
        //while humans start counting from 1
        String removedItem = productName.get((position-1));
        productName.remove((position-1));
        productID.remove((position-1));
        unitQuantity.remove((position-1));
        unitPrice.remove((position-1));
        System.out.println(removedItem + " at position " + position + " was removed");
    }

    @Override
    public void status(String status) {
        //var = Shorter way to declare ShippingInfo shippingInfo = new ShippingInfo()
        var shippingInfo = new ShippingInfo();
        //status method from ShippingInfo class
        shippingInfo.status(status);
    }

    @Override
    public void alertReorder(){
        for (int i=0; i<unitQuantity.size(); i++){
            if (unitQuantity.get(i)<=5){
                System.out.println("Alert! Order more " + productName.get(i) + ", only " + unitQuantity.get(i) +
                        " units left.");
            }
        }
    }

    @Override
    public void totalSales(){
        try{ //IO Exception handler
            //output "record.txt" file to specified directory
            FileWriter record = new FileWriter("Record.txt");

            System.out.print("Last month's sales");
            for (int i=0; i<prev_month.size(); i++){
                record.write(prev_month.get(i));
            }

            System.out.print("\nThis month's sales");
            for (int i=0; i<curr_month.size(); i++){
                record.write(curr_month.get(i));
            }
            record.close();
        }catch (IOException e){
            System.out.println("Error! Could not save file");
        }
        prev_month = curr_month; //update previous month with this month's report
    }

    @Override
    public void soldItems(){
        try{//IO Exception handler
            //read "record.txt" file from specified directory
            BufferedReader record = new BufferedReader(
                    new FileReader("Record.txt"));

            String line;

            //while loop to print every individual line of the specified .txt file to console
            while((line = record.readLine()) != null){
                System.out.println(line);
            }
            record.close();
        }catch (IOException e){
            System.out.println("Error! Could not view file");
        }
    }

    //Getters
    public static ArrayList<String> getProductName() {
        return productName;
    }

    public static ArrayList<String> getProductID() {
        return productID;
    }

    public static ArrayList<Double> getUnitPrice() {
        return unitPrice;
    }

    public static ArrayList<Integer> getUnitQuantity() {
        return unitQuantity;
    }

    //Setter
    public static void setUnitQuantity(int index, int i) {
        unitQuantity.set(index, i);
    }
}
