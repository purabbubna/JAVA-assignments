
import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        Calculator service = new CalculatorImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("CalculatorService", service);

        System.out.println("Calculator server started");
    }
}
