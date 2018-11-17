package recoveryproject.com.weatherapp.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Direction {

    @Getter
    @SerializedName("Degrees")
    @Expose
    public Integer degrees;
    @Getter
    @SerializedName("Localized")
    @Expose
    public String localized;
    @SerializedName("English")
    @Expose
    public String english;
}
