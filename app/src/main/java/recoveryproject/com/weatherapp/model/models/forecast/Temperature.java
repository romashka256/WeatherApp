package recoveryproject.com.weatherapp.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Temperature {
    @Getter
    @SerializedName("Minimum")
    @Expose
    public MinimumTemperature minimum;
    @Getter
    @SerializedName("Maximum")
    @Expose
    public MaximumTemperature maximum;
}
