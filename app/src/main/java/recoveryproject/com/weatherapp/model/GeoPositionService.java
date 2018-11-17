package recoveryproject.com.weatherapp.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import recoveryproject.com.weatherapp.App;

public class GeoPositionService {

    private LocationManager locationManager;
    private Context context;

    public GeoPositionService() {
        context = App.getsAppComponent().getApplicationContext();
    }

    @SuppressLint("MissingPermission")
    public String getLongitudeAndLatitude() {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location == null) {
            location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if (location == null) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
        }
        return 41 + "," + 29;
      //  return location.getLatitude() + "," + location.getLongitude();
    }
}
