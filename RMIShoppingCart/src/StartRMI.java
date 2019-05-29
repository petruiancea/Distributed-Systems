import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartRMI {

    public static void main (String [] args){

        try {
            LocateRegistry.createRegistry(1099);
            ShoppingCartImplementation shoppingCartImplementation = new ShoppingCartImplementation();
            Naming.rebind("//localhost/boundCart", shoppingCartImplementation);

            System.out.println("RMI registry successfully started!");
            System.out.println("ShoppingCart bound to the Registry!");

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
