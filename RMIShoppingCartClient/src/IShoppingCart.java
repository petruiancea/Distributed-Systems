import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IShoppingCart extends Remote {

    void addItem(Item i) throws RemoteException;

    Item[] getAllItems() throws RemoteException;

    Item getItem(int itemID) throws RemoteException;

}
