public interface Admin {
    public void addItems(String prodName, String prodID, int quantity, double price);
    public void modifyItems(int position, String prodName, String prodID, int quantity, double price);
    public void removeItems(int position);
    public void status(String status);
    public void alertReorder();
    public void soldItems();
    public void totalSales();
}
