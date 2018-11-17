package recoveryproject.com.weatherapp.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.model.CurrentConditionsService;

@Module
public class CurrentConditionsModule {

    @Singleton
    @Provides
    public CurrentConditionsService provideCurrentCoditions(){
        return new CurrentConditionsService();
    }

}
