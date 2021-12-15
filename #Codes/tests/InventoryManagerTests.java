import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class InventoryManagerTests {
    @Test
    public void testBasicInventory(){
        ArrayList<Inventory_Item_9_2> items = new ArrayList<>();
        //Inventory_Item_9_2(String name, double cost, double price, int num(onHand)
        items.add(new Inventory_Item_9_2("Hammer",5.99, 9.99, 10));
        items.add(new Inventory_Item_9_2("Yeet",5.99, 9.99, 11));
        items.add(new Inventory_Item_9_2("Magic",225.99, 449.99, 13));
        InventoryManager_9_2 im = new InventoryManager_9_2(items);
        assertEquals(3, im.getSize());
    }
    @Test
    public void testBestSimple(){
        ArrayList<Inventory_Item_9_2> items = new ArrayList<>();
        //Inventory_Item_9_2(String name, double cost, double price, int num(onHand)
        items.add(new Inventory_Item_9_2("Hammer",9.99, 5.99, 10));
        items.add(new Inventory_Item_9_2("Yeet",5777.99, 79.99, 11));
        items.add(new Inventory_Item_9_2("Magic",233.99, 9.99, 13));
        InventoryManager_9_2 im = new InventoryManager_9_2(items);
        Inventory_Item_9_2 best = im.getBestProfitMargin();

        assertEquals("Yeet", best.getItemName());
    }
    @Test
    public void testTotalInventoryCost1(){
        ArrayList<Inventory_Item_9_2> items = new ArrayList<>();
        //Inventory_Item_9_2(String name, double cost, double price, int num(onHand)
        items.add(new Inventory_Item_9_2("Hammer",9.99, 34.0, 15));
        items.add(new Inventory_Item_9_2("Yeet",5777.99, 44.0, 12));
        items.add(new Inventory_Item_9_2("Magic",233.99, 6.0, 11));
        InventoryManager_9_2 im = new InventoryManager_9_2(items);
        double best = im.getTotalInventoryCost();

        assertEquals(1104.0, best, 0.1);
    }
    @Test
    public void testTotalInventoryCost2(){
        //This is an edge case, because all items have 0 on hand
        ArrayList<Inventory_Item_9_2> items = new ArrayList<>();
        //Inventory_Item_9_2(String name, double cost, double price, int num(onHand)
        items.add(new Inventory_Item_9_2("Hammer",9.99, 1553.0, 0));
        items.add(new Inventory_Item_9_2("Yeet",5777.99, 134.0, 0));
        items.add(new Inventory_Item_9_2("Magic",233.99, 6.0, 0));
        InventoryManager_9_2 im = new InventoryManager_9_2(items);
        double best = im.getTotalInventoryCost();

        assertEquals(0.0, best, 0.1);
    }
    @Test
    public void testTotalInventoryCost3(){
        //This case is testing with the middle item has 0 on hand and the other two items have
        //a very large number of items on hand
        ArrayList<Inventory_Item_9_2> items = new ArrayList<>();
        //Inventory_Item_9_2(String name, double cost, double price, int num(onHand)
        items.add(new Inventory_Item_9_2("Hammer",9.99, 154.0, 10000));
        items.add(new Inventory_Item_9_2("Yeet",5777.99, 15.0, 0));
        items.add(new Inventory_Item_9_2("Magic",233.99, 600.0, 1000000));
        InventoryManager_9_2 im = new InventoryManager_9_2(items);
        double best = im.getTotalInventoryCost();

        assertEquals(601540000.0, best, 0.1);
    }
}
