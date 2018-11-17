package recoveryproject.com.weatherapp.di.modules;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import recoveryproject.com.weatherapp.PermissionHandlerAndroid;

@Module
public class PermissionModule {

    private AppCompatActivity activity;

    public PermissionModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public PermissionHandlerAndroid getPersmissionHandler(){
        return new PermissionHandlerAndroid(activity);
    }
}
