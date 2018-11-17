package recoveryproject.com.weatherapp;

import android.app.Application;

import recoveryproject.com.weatherapp.di.components.AppComponent;
import recoveryproject.com.weatherapp.di.components.DaggerAppComponent;
import recoveryproject.com.weatherapp.di.modules.ContextModule;

public class App extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();

    }

    public static AppComponent getsAppComponent() {
        return sAppComponent;
    }
}
