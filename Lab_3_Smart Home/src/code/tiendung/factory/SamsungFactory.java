package code.tiendung.factory;

import code.tiendung.devices.*;

public final class SamsungFactory implements DeviceFactory {
    private static final String BRAND = "Samsung";
    @Override public Device createLight(String name)      { return new Light(name, BRAND); }
    @Override public Device createThermostat(String name) { return new Thermostat(name, BRAND); }
    @Override public Device createCamera(String name)     { return new Camera(name, BRAND); }
}
