package recoveryproject.com.weatherapp.di.modules;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.InternetManagerApp;

@Module
public class InternetManagerModule {
    @Provides
    public InternetManagerApp provideManager() {
        return new InternetManagerApp();
    }
}
