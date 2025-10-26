package code.tiendung.devices;

import code.tiendung.core.Observer;
import code.tiendung.core.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class Device implements Subject {
    protected final String name;
    protected final String brand;
    protected boolean powerOn = false;

    private final List<Observer> observers = new ArrayList<>();

    protected Device(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public void turnOn() { powerOn = true; notifyObservers(); }
    public void turnOff() { powerOn = false; notifyObservers(); }

    public abstract String getStatus();

    public String getName()  { return name; }
    public String getBrand() { return brand; }

    @Override
    public void attach(Observer o) {
        if (o != null && !observers.contains(o)) observers.add(o);
    }

    @Override
    public void detach(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        String status = getStatus();
        for (Observer o : observers) o.update(status);
    }
}
