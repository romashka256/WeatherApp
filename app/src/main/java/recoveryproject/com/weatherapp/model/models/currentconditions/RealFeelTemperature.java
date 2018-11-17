package recoveryproject.com.weatherapp.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class RealFeelTemperature {

    @Getter
    @SerializedName("Metric")
    @Expose
    public Metric metric;

}
