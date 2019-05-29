import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main (String [] args) {

        try {
            IShoppingCart myCart = (IShoppingCart) Naming.lookup("//localhost/boundCart"); //the returns element are saved in the class IShoppingCart
            Item myItem = new Item();
            myItem.itemID = 1;
            myItem.name = "Item Nr. 1";
            myItem.price = 1.11f;

            myCart.addItem(myItem);

            Item myItem2 = new Item();
            myItem2.itemID = 2;
            myItem2.name = "Item Nr. 2";
            myItem2.price = 2.11f;

            myCart.addItem(myItem2);

            Item returnedItem = myCart.getItem(1);
            System.out.println("ItemID" + returnedItem.itemID + "ItemName" + returnedItem.name + "ItemPrice" + returnedItem.price);

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (NoSuchObjectException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
