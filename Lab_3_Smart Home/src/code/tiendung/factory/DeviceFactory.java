package code.tiendung.factory;

import code.tiendung.devices.Device;

public interface DeviceFactory {
    Device createLight(String name);
    Device createThermostat(String name);
    Device createCamera(String name);
}
