package recoveryproject.com.weatherapp.presenter.listeners;

import recoveryproject.com.weatherapp.model.models.forecast.DailyForecasts;

public interface OnDailyForcastLoadedListener {
    void OnDailyForecastLoaded(DailyForecasts dailyForecast);
}
