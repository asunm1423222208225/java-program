import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Hello obj = (Hello) registry.lookup("HelloService");

            System.out.println(obj.sayHello());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}