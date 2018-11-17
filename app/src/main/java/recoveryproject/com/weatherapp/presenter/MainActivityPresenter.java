package recoveryproject.com.weatherapp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import recoveryproject.com.weatherapp.App;
import recoveryproject.com.weatherapp.InternetManagerApp;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;
import recoveryproject.com.weatherapp.model.CurrentConditionsService;
import recoveryproject.com.weatherapp.model.DailyForecastService;
import recoveryproject.com.weatherapp.model.HourForecastService;
import recoveryproject.com.weatherapp.model.LocationService;
import recoveryproject.com.weatherapp.model.models.Location;
import recoveryproject.com.weatherapp.model.models.currentconditions.CurentContiditions;
import recoveryproject.com.weatherapp.model.models.forecast.DailyForecasts;
import recoveryproject.com.weatherapp.model.models.hourlyforecast.HourlyForecast;
import recoveryproject.com.weatherapp.presenter.listeners.On12HourForecastLoadedListener;
import recoveryproject.com.weatherapp.presenter.listeners.OnCurrentConditionsLoadedListener;
import recoveryproject.com.weatherapp.presenter.listeners.OnDailyForcastLoadedListener;
import recoveryproject.com.weatherapp.presenter.listeners.OnLocationGetSuccess;
import recoveryproject.com.weatherapp.ui.IMainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<IMainActivityView> {

    @Inject
    LocationService locationService;
    @Inject
    DailyForecastService dailyForecast;
    @Inject
    CurrentConditionsService currentConditionsService;
    @Inject
    HourForecastService hourForecastService;
    @Inject
    MainActivityDisposablesManager mainActivityDisposablesManager;
    @Inject
    InternetManagerApp internetManagerApp;

    @Inject
    public MainActivityPresenter() {
        App.getsAppComponent().inject(this);
    }

    public void OnCreate() {
        locationService.getLocation(new OnLocationGetSuccess() {
            @Override
            public void OnLocationFound(Location location) {
                if (location.getLocalizedName().equals("")) {
                    location.setLocalizedName(location.getEnglishName());
                }
                getViewState().showCity(location);
                dailyForecast.getDailyForecast(location.getKey(), new OnDailyForcastLoadedListener() {
                    @Override
                    public void OnDailyForecastLoaded(DailyForecasts dailyForecast) {
                        getViewState().showDailyForecastData(dailyForecast);
                    }
                });
                currentConditionsService.getCurrentConditions(location.getKey(), new OnCurrentConditionsLoadedListener() {
                    @Override
                    public void OnCurrentConditionsLoaded(CurentContiditions curentContiditions) {
                        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM");
                        curentContiditions.setDate(sdf.format(new Date(curentContiditions.getEpochTime())));
                        curentContiditions.setImageUrl(String.format("https://vortex.accuweather.com/adc2010/images/slate/icons/%d.svg", curentContiditions.getWeatherIcon()));
                        getViewState().showCurrentConditions(curentContiditions);
                    }
                });
                hourForecastService.get12HourForecast(location.getKey(), new On12HourForecastLoadedListener() {
                    @Override
                    public void On12HourForecastLoaded(HourlyForecast hourlyForecast) {
                        hourlyForecast.getCloudCover();
                    }
                });
            }
        });
    }

    public void OnStop() {
        mainActivityDisposablesManager.disposeAll();
    }

}
