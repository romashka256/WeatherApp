package recoveryproject.com.weatherapp.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.model.DailyForecastService;

@Module
public class DailyForecastServiceModule {

    @Singleton
    @Provides
    public DailyForecastService provideDailyForecastService(){
        return new DailyForecastService();
    }
}
