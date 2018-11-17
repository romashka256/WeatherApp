package recoveryproject.com.weatherapp.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import lombok.Getter;
import lombok.Setter;

public class CurentContiditions {

    @Getter
    @SerializedName("LocalObservationDateTime")
    @Expose
    public String localObservationDateTime;
    @Getter
    @SerializedName("EpochTime")
    @Expose
    public Integer epochTime;
    @Getter
    @SerializedName("WeatherText")
    @Expose
    public String weatherText;
    @Getter
    @SerializedName("WeatherIcon")
    @Expose
    public Integer weatherIcon;
    @Getter
    @SerializedName("HasPrecipitation")
    @Expose
    public Boolean hasPrecipitation;
    @Getter
    @SerializedName("PrecipitationType")
    @Expose
    public String precipitationType;
    @Getter
    @SerializedName("IsDayTime")
    @Expose
    public Boolean isDayTime;
    @Getter
    @SerializedName("Temperature")
    @Expose
    public Temperature temperature;
    @Getter
    @SerializedName("RealFeelTemperature")
    @Expose
    public RealFeelTemperature realFeelTemperature;
    @Getter
    @SerializedName("RelativeHumidity")
    @Expose
    public Integer relativeHumidity;
    @Getter
    @SerializedName("Wind")
    @Expose
    public Wind wind;
    @SerializedName("UVIndex")
    @Expose
    public Integer uVIndex;
    @Getter
    @SerializedName("UVIndexText")
    @Expose
    public String uVIndexText;
    @Getter
    @SerializedName("ObstructionsToVisibility")
    @Expose
    public String obstructionsToVisibility;
    @Getter
    @SerializedName("CloudCover")
    @Expose
    public Integer cloudCover;
    @Getter
    @SerializedName("Pressure")
    @Expose
    public Pressure pressure;
    @Getter
    @Setter
    public String date;

    @Getter
    @Setter
    public String imageUrl;

}
