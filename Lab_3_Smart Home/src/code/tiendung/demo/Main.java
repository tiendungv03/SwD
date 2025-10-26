package code.tiendung.demo;

import code.tiendung.devices.*;
import code.tiendung.factory.*;
import code.tiendung.hub.SmartHomeHub;
import code.tiendung.ui.Dashboard;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = SmartHomeHub.getInstance();

        // Đăng ký 3 hãng
        hub.registerFactory("Philips",  new PhilipsFactory());
        hub.registerFactory("Xiaomi",   new XiaomiFactory());
        hub.registerFactory("Samsung",  new SamsungFactory());

        // Dashboard (Observer)
        Dashboard dashboard = new Dashboard();

        // Tạo thiết bị
        Device light = hub.createDevice("light", "Philips", "LivingRoom-Light");
        Device ac    = hub.createDevice("thermostat", "Xiaomi", "Bedroom-AC");
        Device cam   = hub.createDevice("camera", "Samsung", "FrontDoorCam");

        // Gắn observer
        light.attach(dashboard);
        ac.attach(dashboard);
        cam.attach(dashboard);

        // Demo tương tác
        light.turnOn();
        if (light instanceof Light) ((Light) light).setBrightness(80);

        ac.turnOn();
        if (ac instanceof Thermostat) ((Thermostat) ac).setTemperature(26);

        if (cam instanceof Camera) {
            ((Camera) cam).startRecording();
            ((Camera) cam).stopRecording();
        }

        light.turnOff();
    }
}
