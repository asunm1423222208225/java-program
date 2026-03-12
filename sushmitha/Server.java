import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HelloService", obj);

            System.out.println("Hii sushmitha...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}