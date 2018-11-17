package recoveryproject.com.weatherapp.model.models.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Ice  {

    @Getter
    @SerializedName("Value")
    @Expose
    public Integer value;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String unit;
    @SerializedName("UnitType")
    @Expose
    public Integer unitType;
}
