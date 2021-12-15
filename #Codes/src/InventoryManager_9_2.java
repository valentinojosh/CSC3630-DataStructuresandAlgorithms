import java.util.ArrayList;

public class InventoryManager_9_2 {
    ArrayList<Inventory_Item_9_2> items;

    public InventoryManager_9_2(ArrayList<Inventory_Item_9_2> items){
        this.items = items;
    }
    public int getSize() {
        return items.size();
    }

    public Inventory_Item_9_2 getBestProfitMargin() {
        Inventory_Item_9_2 bestItem = null;
        double bestProfitMargin = Double.MIN_VALUE;
        for(Inventory_Item_9_2 item : items){
            double profitMargin = item.getPrice() - item.getCost();
            if(profitMargin > bestProfitMargin){
                bestItem = item;
                bestProfitMargin = profitMargin;
            }
        }
        return bestItem;
    }

    public double getTotalInventoryCost() {
        // Total Cost is the sum of the costs of each item * number on hand
        double totalCost = 0;
        for(Inventory_Item_9_2 item : items){
            totalCost += (item.getCost() * item.getNumberOnHand());
        }
        return totalCost;
    }
}
