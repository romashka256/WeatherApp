package recoveryproject.com.weatherapp.di.modules;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.model.GeoPositionService;

@Module
public class GeoPositionModule {

    @Provides
    public GeoPositionService provideGeoPosService(){
        return new GeoPositionService();
    }
}
