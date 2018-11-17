package recoveryproject.com.weatherapp.model;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import recoveryproject.com.weatherapp.App;
import recoveryproject.com.weatherapp.Constants;
import recoveryproject.com.weatherapp.MainActivityDisposablesManager;
import recoveryproject.com.weatherapp.di.components.DaggerGeoPosComponent;
import recoveryproject.com.weatherapp.model.api.LocationAPI;
import recoveryproject.com.weatherapp.model.models.Location;
import recoveryproject.com.weatherapp.presenter.listeners.OnLocationGetSuccess;
import retrofit2.Retrofit;
import timber.log.Timber;

public class LocationService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    @Inject
    GeoPositionService geoPositionService;


    public LocationService() {
        retrofit = App.getsAppComponent().getRetrofit();
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
        DaggerGeoPosComponent.builder()
                .build()
                .inject(this);
    }

    public void getLocation(final OnLocationGetSuccess listener) {
        Disposable disposable = retrofit.create(LocationAPI.class).getLocation(Constants.APIKEY, geoPositionService.getLongitudeAndLatitude(), Constants.LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Location>() {
                    @Override
                    public void accept(Location location) throws Exception {
                        listener.OnLocationFound(location);
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
