package recoveryproject.com.weatherapp.di.components;

import dagger.Component;
import recoveryproject.com.weatherapp.di.modules.GeoPositionModule;
import recoveryproject.com.weatherapp.model.LocationService;

@Component(modules = GeoPositionModule.class)
public interface GeoPosComponent {
    void inject(LocationService locationService);
}
