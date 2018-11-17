package recoveryproject.com.weatherapp.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.model.LocationService;

@Module
public class LocationModule {

    @Singleton
    @Provides
    public LocationService provideLocationService(){
        return new LocationService();
    }

}
