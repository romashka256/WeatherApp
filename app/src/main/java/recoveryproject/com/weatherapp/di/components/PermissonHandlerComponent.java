package recoveryproject.com.weatherapp.di.components;

import dagger.Component;
import recoveryproject.com.weatherapp.ui.MainActivity;
import recoveryproject.com.weatherapp.di.modules.PermissionModule;

@Component(modules = PermissionModule.class)
public interface PermissonHandlerComponent {

    void inject(MainActivity mainActivity);

}
