package handsOn;

public class InventoryItem {
    static int totalItems;
    String itemName;
    int quantity;

    public InventoryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        updateTotal(this.quantity);
    }

    static void updateTotal(int q){
        totalItems = q;
        System.out.println("new book added and the total is "+totalItems);
    }

    static int getTotalItems(){
        return totalItems;
    }
    void addInventory( int quantity){

        this.quantity+=quantity;
        totalItems += quantity;
    }
    void removeFromInventory(int quantity){
        this.quantity -=quantity;
        totalItems-=quantity;
        System.out.println("total quantity = "+totalItems);
    }

    public static void main(String[] args) {
        InventoryItem inventoryItem = new InventoryItem("book",10);
        inventoryItem.addInventory(10);
        inventoryItem.removeFromInventory(5);
        InventoryItem.getTotalItems();

    }

}
