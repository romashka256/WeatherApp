package recoveryproject.com.weatherapp.ui;

import com.arellomobile.mvp.MvpView;

import recoveryproject.com.weatherapp.model.models.Location;
import recoveryproject.com.weatherapp.model.models.currentconditions.CurentContiditions;
import recoveryproject.com.weatherapp.model.models.forecast.DailyForecasts;

public interface IMainActivityView extends MvpView {
    void showCity(Location location);
    void showDailyForecastData(DailyForecasts dailyForecast);
    void showCurrentConditions(CurentContiditions curentContiditions);
}
