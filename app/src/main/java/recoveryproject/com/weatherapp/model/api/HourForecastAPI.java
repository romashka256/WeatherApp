package recoveryproject.com.weatherapp.model.api;

import io.reactivex.Observable;
import recoveryproject.com.weatherapp.model.models.hourlyforecast.HourlyForecast;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HourForecastAPI {

    @GET("forecasts/v1/hourly/12hour/{locationkey}")
    Observable<HourlyForecast> get12HoursForecast (@Path("locationkey") String locationkey, @Query("apikey") String apikey, @Query("language") String language, @Query("details") String details, @Query("metric") String metric);

}
