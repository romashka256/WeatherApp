package recoveryproject.com.weatherapp.presenter.listeners;

import recoveryproject.com.weatherapp.model.models.hourlyforecast.HourlyForecast;

public interface On12HourForecastLoadedListener {
    void On12HourForecastLoaded(HourlyForecast hourlyForecast);
}
