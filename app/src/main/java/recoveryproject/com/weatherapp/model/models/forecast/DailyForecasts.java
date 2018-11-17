package recoveryproject.com.weatherapp.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

public class DailyForecasts {
    @Getter
    @SerializedName("DailyForecasts")
    @Expose
    public List<DailyForecast> dailyForecasts = null;
}
