package recoveryproject.com.weatherapp.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import recoveryproject.com.weatherapp.App;
import recoveryproject.com.weatherapp.Constants;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;
import recoveryproject.com.weatherapp.model.api.HourForecastAPI;
import recoveryproject.com.weatherapp.model.models.hourlyforecast.HourlyForecast;
import recoveryproject.com.weatherapp.presenter.listeners.On12HourForecastLoadedListener;
import retrofit2.Retrofit;
import timber.log.Timber;

public class HourForecastService {
    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public HourForecastService() {
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
        retrofit = App.getsAppComponent().getRetrofit();
    }

    public void get12HourForecast(String locationkey, final On12HourForecastLoadedListener on12HourForecastLoadedListener){
        Disposable disposable = retrofit.create(HourForecastAPI.class).get12HoursForecast(locationkey,Constants.APIKEY,Constants.LANGUAGE,"true","true")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HourlyForecast>() {
                    @Override
                    public void accept(HourlyForecast hourlyForecast) throws Exception {
                        on12HourForecastLoadedListener.On12HourForecastLoaded(hourlyForecast);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Timber.e(throwable,throwable.getMessage());
                    }
                });
        mainActivityDisposablesManager.getCollection().add(disposable);
    }
}
