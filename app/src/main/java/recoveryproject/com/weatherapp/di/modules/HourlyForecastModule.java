package recoveryproject.com.weatherapp.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.model.HourForecastService;

@Module
public class HourlyForecastModule {

    @Singleton
    @Provides
    public HourForecastService provideHourlyForecastService(){
        return new HourForecastService();
    }

}
