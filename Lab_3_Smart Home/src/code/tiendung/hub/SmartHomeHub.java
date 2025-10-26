package code.tiendung.hub;

import code.tiendung.devices.Device;
import code.tiendung.factory.DeviceFactory;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class SmartHomeHub {
    private SmartHomeHub() {}

    private static class Holder { private static final SmartHomeHub INSTANCE = new SmartHomeHub(); }
    public static SmartHomeHub getInstance() { return Holder.INSTANCE; }

    private final Map<String, DeviceFactory> factories = new HashMap<>();

    public void registerFactory(String brand, DeviceFactory f) {
        if (brand == null || f == null) return;
        factories.put(normalize(brand), f);
        System.out.println("[Hub] Registered factory: " + brand);
    }

    public Device createDevice(String type, String brand) {
        String name = normalize(type) + "-" + brand;
        return createDevice(type, brand, name);
    }

    public Device createDevice(String type, String brand, String name) {
        DeviceFactory f = factories.get(normalize(brand));
        if (f == null) {
            throw new IllegalArgumentException("No factory for brand: " + brand +
                    ". Registered: " + factories.keySet());
        }
        switch (normalize(type)) {
            case "light":       return f.createLight(name);
            case "thermostat":  return f.createThermostat(name);
            case "camera":      return f.createCamera(name);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type +
                        " (use: light | thermostat | camera)");
        }
    }

    private static String normalize(String s) {
        return (s == null) ? "" : s.trim().toLowerCase(Locale.ROOT);
    }
}
