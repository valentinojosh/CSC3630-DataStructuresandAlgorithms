public class Inventory_Item_9_2 {
    private String itemName;     // Name of Item
    private double price;        // Charge price
    private double cost;         // Cost to company
    private int numberOnHand;   // How many we have

    //Constructor
    public Inventory_Item_9_2(String itemName, double price, double cost, int numberOnHand) {
        this.itemName = itemName;
        this.price = price;
        this.cost = cost;
        this.numberOnHand = numberOnHand;
    }

    //Getters for the 4 variables
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public double getCost() {
        return cost;
    }

    public int getNumberOnHand() {
        return numberOnHand;
    }

    //Setters for the 4 variables
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setNumberOnHand(int numberOnHand) {
        this.numberOnHand = numberOnHand;
    }

}
