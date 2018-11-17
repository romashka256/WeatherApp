package recoveryproject.com.weatherapp.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Temperature {
    @Getter
    @SerializedName("Metric")
    @Expose
    public Metric metric;

}
