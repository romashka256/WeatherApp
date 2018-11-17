package recoveryproject.com.weatherapp.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Metric {

    @Getter
    @SerializedName("Value")
    @Expose
    public Float value;
    @SerializedName("Unit")
    @Expose
    public String unit;
    @SerializedName("UnitType")
    @Expose
    public Integer unitType;
}
