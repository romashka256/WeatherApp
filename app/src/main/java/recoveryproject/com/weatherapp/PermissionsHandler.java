package recoveryproject.com.weatherapp;

public interface PermissionsHandler {
    boolean checkHasPermission(String Permission);
    void requestPermission(String[] permissions, int requestCode);
}
