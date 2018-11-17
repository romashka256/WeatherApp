package recoveryproject.com.weatherapp.model.models.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class RealFeelTemperature {
    @Getter
    @SerializedName("Value")
    @Expose
    public Double value;
    @SerializedName("Unit")
    @Expose
    public String unit;
    @SerializedName("UnitType")
    @Expose
    public Integer unitType;
}
