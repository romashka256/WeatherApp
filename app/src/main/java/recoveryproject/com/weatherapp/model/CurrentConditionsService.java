package recoveryproject.com.weatherapp.model;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import recoveryproject.com.weatherapp.App;
import recoveryproject.com.weatherapp.Constants;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;
import recoveryproject.com.weatherapp.model.api.CurrentConditionsAPI;
import recoveryproject.com.weatherapp.model.models.currentconditions.CurentContiditions;
import recoveryproject.com.weatherapp.presenter.listeners.OnCurrentConditionsLoadedListener;
import retrofit2.Retrofit;
import timber.log.Timber;

public class CurrentConditionsService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public CurrentConditionsService() {

        retrofit = App.getsAppComponent().getRetrofit();
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
    }

    public void getCurrentConditions(String locationkey, final OnCurrentConditionsLoadedListener onCurrentConditionsLoadedListener) {
        Disposable disposable = retrofit.create(CurrentConditionsAPI.class).getCurrentConditions(locationkey, Constants.APIKEY, Constants.LANGUAGE, "true")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<CurentContiditions>>() {
                    @Override
                    public void accept(List<CurentContiditions> curentContiditions) throws Exception {
                        onCurrentConditionsLoadedListener.OnCurrentConditionsLoaded(curentContiditions.get(0));
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
