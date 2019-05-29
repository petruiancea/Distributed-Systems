import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ShoppingCartImplementation extends UnicastRemoteObject implements IShoppingCart {

    ArrayList<Item> items = new ArrayList<Item>(); //we can only from class Item in the items.
                                                  // Only items from class Item can be passed to the  items.

    protected ShoppingCartImplementation() throws RemoteException{
        super();
    }

    public void addItem(Item i) throws RemoteException{

        items.add(i);
        System.out.println("ItemID" + i.itemID + "ItemName" + i.name + "ItemPrice" + i.price);

    }

    public Item[] getAllItems() throws RemoteException{

        return null;

    }

    /**
     * it returns a item from the item list.
     * Otherwise it returns null if the itemID wasn't found.
     */
    public Item getItem(int itemID) throws RemoteException{

        for (Item item: items){ //going through the item list
            if(item.itemID == itemID) return item;
        }

        return null;

    }

}
