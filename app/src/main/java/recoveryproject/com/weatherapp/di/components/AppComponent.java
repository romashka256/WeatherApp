package recoveryproject.com.weatherapp.di.components;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import recoveryproject.com.weatherapp.InternetManagerApp;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;
import recoveryproject.com.weatherapp.di.modules.CompositeDesposableModule;
import recoveryproject.com.weatherapp.di.modules.ContextModule;
import recoveryproject.com.weatherapp.di.modules.CurrentConditionsModule;
import recoveryproject.com.weatherapp.di.modules.DailyForecastServiceModule;
import recoveryproject.com.weatherapp.di.modules.HourlyForecastModule;
import recoveryproject.com.weatherapp.di.modules.InternetManagerModule;
import recoveryproject.com.weatherapp.di.modules.LocationModule;
import recoveryproject.com.weatherapp.di.modules.RetrofitModule;
import recoveryproject.com.weatherapp.model.CurrentConditionsService;
import recoveryproject.com.weatherapp.model.DailyForecastService;
import recoveryproject.com.weatherapp.model.HourForecastService;
import recoveryproject.com.weatherapp.model.LocationService;
import recoveryproject.com.weatherapp.presenter.MainActivityPresenter;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {InternetManagerModule.class, CompositeDesposableModule.class,  HourlyForecastModule.class, RetrofitModule.class, ContextModule.class, LocationModule.class, DailyForecastServiceModule.class, CurrentConditionsModule.class})
public interface AppComponent {

    Retrofit getRetrofit();
    Context getApplicationContext();
    LocationService getLocationService();
    DailyForecastService getDailyForecastService();
    CurrentConditionsService getCurrentConditionsService();
    HourForecastService getHourForecastService();
    MainActivityDisposablesManager getMainActivityDisposablesManager();
    InternetManagerApp getInternetManger();

    void inject(MainActivityPresenter mainActivityPresenter);

}
