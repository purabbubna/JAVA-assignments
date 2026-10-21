
import java.rmi.*;
import java.rmi.registry.*;

public class TemperatureServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);

        registry.rebind("TemperatureService", new TemperatureImpl());

        System.out.println("Temperature server started");
    }
}
