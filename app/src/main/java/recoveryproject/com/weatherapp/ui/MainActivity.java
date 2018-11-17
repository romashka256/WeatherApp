package recoveryproject.com.weatherapp.ui;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import recoveryproject.com.weatherapp.PermissionHandlerAndroid;
import recoveryproject.com.weatherapp.R;
import recoveryproject.com.weatherapp.di.components.DaggerPermissonHandlerComponent;
import recoveryproject.com.weatherapp.di.modules.PermissionModule;
import recoveryproject.com.weatherapp.model.models.Location;
import recoveryproject.com.weatherapp.model.models.currentconditions.CurentContiditions;
import recoveryproject.com.weatherapp.model.models.forecast.DailyForecasts;
import recoveryproject.com.weatherapp.presenter.MainActivityPresenter;

public class MainActivity extends MvpAppCompatActivity implements IMainActivityView,
                                                                  SearchView.OnQueryTextListener {

    @BindView(R.id.main_text_weather)
    TextView mIconPhrase;
    @BindView(R.id.main_temp_image)
    ImageView mImageView;
    @BindView(R.id.main_temperture)
    TextView mMainTemperature;
    @BindView(R.id.main_text_date)
    TextView mMainDate;
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    TextView mNavTemperature;
    TextView mNavCity;
    SearchView mSearchView;

    @BindView(R.id.nvView)
    NavigationView navigationView;

    ActionBarDrawerToggle mDrawerToggle;

    @InjectPresenter
    MainActivityPresenter mainActivityPresenter;

    @Inject
    PermissionHandlerAndroid permissionHandlerAndroid;

    @SuppressLint({"MissingPermission", "CheckResult"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);

        ButterKnife.bind(this);

        View headerView = navigationView.getHeaderView(0);

        mNavCity = headerView.findViewById(R.id.nav_view_header_city);
        mSearchView = headerView.findViewById(R.id.nav_view_header_search);
        mNavTemperature = headerView.findViewById(R.id.nav_view_header_temp);

        mSearchView.setBackgroundResource(R.drawable.searchviewbackground);
        mSearchView.setOnQueryTextListener(this);

        EditText searchEditText = (EditText) mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
      //  int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
       // TextView textView = mSearchView.findViewById(id);
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
      //  searchEditText.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorWhite, null));

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        DaggerPermissonHandlerComponent.builder()
                .permissionModule(new PermissionModule(this))
                .build()
                .inject(this);

        permissionHandlerAndroid.getPermissions();

        mainActivityPresenter.OnCreate();

        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public void showCity(Location location) {
        getSupportActionBar().setTitle(location.getLocalizedName());
        mNavCity.setText(location.getLocalizedName());
    }

    @Override
    public void showDailyForecastData(DailyForecasts dailyForecast) {
        mMainDate.setText(dailyForecast.getDailyForecasts().get(0).getDate());
      }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    public void showCurrentConditions(CurentContiditions curentContiditions) {
        //   Glide.with(this).load(curentContiditions.getImageUrl()).into(mImageView);
        mNavTemperature.setText(curentContiditions.getTemperature().getMetric().getValue().toString());
        mMainTemperature.setText(curentContiditions.getTemperature().getMetric().getValue().toString());
        mIconPhrase.setText(curentContiditions.getWeatherText());
        mMainDate.setText(curentContiditions.getDate());
        //mMainMaxTemperature.setText(curentContiditions.);
        //mMainMinTemperature.setText(dailyForecast.getDailyForecasts().get(0).getTemperature().getMinimum().getValue().toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {


        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainActivityPresenter.OnStop();
    }
}

