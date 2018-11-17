package recoveryproject.com.weatherapp.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Wind {
    @Getter
    @SerializedName("Direction")
    @Expose
    public Direction direction;
    @Getter
    @SerializedName("Speed")
    @Expose
    public WindSpeed speed;
}
