package code.tiendung.devices;


public final class Thermostat extends Device {
    private int temperature = 24;

    public Thermostat(String name, String brand) { super(name, brand); }

    public void setTemperature(int t) {
        temperature = t;
        notifyObservers();
    }

    @Override
    public String getStatus() {
        return String.format("%s[%s] Thermostat: %s, temp=%d°C",
                name, brand, powerOn ? "ON" : "OFF", temperature);
    }
}

