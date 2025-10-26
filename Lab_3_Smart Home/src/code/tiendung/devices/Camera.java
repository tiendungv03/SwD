package code.tiendung.devices;

public final class Camera extends Device {
    private boolean recording = false;

    public Camera(String name, String brand) { super(name, brand); }

    public void startRecording() {
        recording = true;
        powerOn = true;
        notifyObservers();
    }

    public void stopRecording() {
        recording = false;
        notifyObservers();
    }

    @Override
    public String getStatus() {
        return String.format("%s[%s] Camera: %s, recording=%s",
                name, brand, powerOn ? "ON" : "OFF", recording ? "YES" : "NO");
    }
}
