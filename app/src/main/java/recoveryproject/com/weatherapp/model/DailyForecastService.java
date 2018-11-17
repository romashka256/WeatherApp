package recoveryproject.com.weatherapp.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import recoveryproject.com.weatherapp.App;
import recoveryproject.com.weatherapp.Constants;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;
import recoveryproject.com.weatherapp.model.api.DailyForecastAPI;
import recoveryproject.com.weatherapp.model.models.forecast.DailyForecasts;
import recoveryproject.com.weatherapp.presenter.listeners.OnDailyForcastLoadedListener;
import retrofit2.Retrofit;
import timber.log.Timber;

public class DailyForecastService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public DailyForecastService() {
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
        retrofit = App.getsAppComponent().getRetrofit();
    }

    public void getDailyForecast(String locationkey, final OnDailyForcastLoadedListener onDailyForcastLoadedListener){
        Disposable disposable=  retrofit.create(DailyForecastAPI.class).getDailyForecast(locationkey,Constants.APIKEY, Constants.LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DailyForecasts>() {
                    @Override
                    public void accept(DailyForecasts dailyForecast) throws Exception {
                        onDailyForcastLoadedListener.OnDailyForecastLoaded(dailyForecast);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Timber.e(throwable, throwable.getMessage());
                    }
                });
        mainActivityDisposablesManager.getCollection().add(disposable);
    }
}
