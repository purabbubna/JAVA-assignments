
import java.rmi.*;
import java.rmi.server.*;

public class TemperatureImpl extends UnicastRemoteObject
        implements Temperature {

    public TemperatureImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double c) {
        return (c * 9.0 / 5.0) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9.0;
    }
}
