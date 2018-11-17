package recoveryproject.com.weatherapp.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;


@Module
public class CompositeDesposableModule {

    @Singleton
    @Provides
    public MainActivityDisposablesManager provide(){
        return new MainActivityDisposablesManager();
    }

}
