package recoveryproject.com.weatherapp.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class MaximumTemperature{

    @Getter
    @SerializedName("Value")
    @Expose
    public Integer value;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String unit;
    @Getter
    @SerializedName("UnitType")
    @Expose
    public Integer unitType;

}
