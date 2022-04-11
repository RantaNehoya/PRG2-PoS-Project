import java.util.ArrayList;

public class Cart {

    private static double total;
    private static ArrayList<String> cart = new ArrayList<>();

    //method to add to user's cart
    public void addItems(String prodName) {
        //find index of product in the store inventory
        int index = Inventory.getProductName().indexOf(prodName);

        if (index<0){//if index search returns -1, product is not sold by store
            System.out.println("Item could not be found");
        }else {
            cart.add(prodName);
            System.out.println(prodName + " was added to your cart");

            //find index of product quantity from store inventory
            int curr_quantity = Inventory.getUnitQuantity().get(index);

            //modify store quantity to decrement by 1
            Inventory.setUnitQuantity(index, (curr_quantity-1));
        }
    }

    //method to modify to user's cart
    public void modifyItems(String prodName, String newProd) {
        //find index of product user's cart
        int index = cart.indexOf(prodName);

        if (index<0){//if index search returns -1, product is not on cart
            System.out.println("Item could not be found");
        }else {//find index of new product in store inventory
            int new_index = Inventory.getProductName().indexOf(newProd);

            if (new_index<0){//if index search returns -1, product is not sold by store
                System.out.println("Item could not be found");
            }else {
                cart.set(index, newProd); //swap old product out for new product

                //index of swapped out product in system
                int swapped_product_position = Inventory.getProductName().indexOf(prodName);
                int old_quantity = Inventory.getUnitQuantity().get(swapped_product_position); //quantity of swapped of item
                Inventory.setUnitQuantity(swapped_product_position, (old_quantity+1)); //increment quantity of swapped item

                //index new product that was swapped in
                int new_product_position = Inventory.getProductName().indexOf(newProd);
                int curr_quantity = Inventory.getUnitQuantity().get(new_product_position); //quantity of swapped in item
                Inventory.setUnitQuantity(new_product_position, (curr_quantity-1)); //decrement quantity of swapped item

                System.out.println(prodName + " was changed to " + newProd);
            }
        }

    }

    public void removeItems(String prodName) {
        //print list of all items on cart
        for (int i=0; i<cart.size(); i++){
            System.out.println("Your Cart:\n" + cart.get(i));
        }
        int index = cart.indexOf(prodName); //find index of product in cart
        if (index<0){
            System.out.println("Item could not be found");
        }else {
            String removedItem = cart.get(index);

            cart.remove(prodName);
            index = Inventory.getProductName().indexOf(prodName); //get index of removed item from inventory
            int new_quantity = Inventory.getUnitQuantity().get(index); //get quantity from inventory
            Inventory.setUnitQuantity(index, (new_quantity + 1)); //increment quantity of item in inventory
            System.out.println(prodName + " was removed from cart");
        }
    }


    public ArrayList<String> displayTotal(){
        //print list of all items and their price on cart
        System.out.println("Product" + "\t\t\t\t" + "Price");
        for (int i=0; i<cart.size(); i++){
                String product = cart.get(i);
                int position = Inventory.getProductName().indexOf(product);
                double price = Inventory.getUnitPrice().get(position);
                System.out.println(product + "\t\t\t\t" + price);
                total += Inventory.getUnitPrice().get(i);
            }
            total = Math.round(total * 100.0) / 100.0; //round to 2 decimal places
            System.out.println("Your total is: N$" + total);
        return null;
    }

    //Getters
    public static double getTotal() {
        return total;
    }

    public static ArrayList<String> getCart() {
        return cart;
    }
}
