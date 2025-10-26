package code.tiendung.devices;

public final class Light extends Device {
    private int brightness = 50; // 0..100

    public Light(String name, String brand) { super(name, brand); }

    public void setBrightness(int value) {
        brightness = Math.max(0, Math.min(100, value));
        notifyObservers();
    }

    @Override
    public String getStatus() {
        return String.format("%s[%s] Light: %s, brightness=%d",
                name, brand, powerOn ? "ON" : "OFF", brightness);
    }
}
