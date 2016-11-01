package com.lstr.weather.app.ui.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lstr.weather.app.R;
import com.lstr.weather.app.datasource.model.ResponseData;
import com.lstr.weather.app.presenter.WeatherPresenter;
import com.lstr.weather.app.view.WeatherView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.BindString;

/**
 * Created by LSTR on 10/30/16.
 */
public class WeatherFragment extends BaseFragment implements WeatherView{

    @BindString(R.string.t_weather) protected String titlebar;
    @Bind(R.id.toolbar) protected Toolbar toolbar;
    @Bind(R.id.ll_root) RelativeLayout ll_root;

    @Bind(R.id.city_field) TextView cityField;
    @Bind(R.id.updated_field) TextView updatedField;
    @Bind(R.id.weather_icon) TextView weatherIcon;
    @Bind(R.id.current_temperature_field) TextView currentTemperatureField;
    @Bind(R.id.details_field) TextView detailsField;
    private Typeface weatherFont;

    private OnListener presenter;
    LayoutInflater inflater;
    private Context context;

    private WeatherPresenter weatherPresenter;

    public static WeatherFragment instance(){
        return new WeatherFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_panel_wheater, container, false);
        injectView(rootView);

        this.inflater = inflater;
        this.context = getContext();

        initialConfig();
        loadPresenter();

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        weatherPresenter.getUpdateWeatherData("Lima");
    }

    private void loadPresenter() {
        weatherPresenter = new WeatherPresenter();
        weatherPresenter.addView(this);
    }

    private void initialConfig() {
        weatherFont = Typeface.createFromAsset(context.getAssets(), "fonts/weather.ttf");

        setToolbar(toolbar, titlebar);
        toolbar.setNavigationIcon(R.mipmap.ic_bar);
        setHasOptionsMenu(true);
        setViewRoot(ll_root);

        weatherIcon.setTypeface(weatherFont);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnListener) {
            presenter = (OnListener) context;
        } else {
            throw new ClassCastException("debe implementar On?Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showResult(ResponseData resultado) {
        cityField.setText(resultado.getSys().getCountry());

        String res = resultado.getWeather().get(0).getDescription().toUpperCase(Locale.US) + "\n" + getResources().getString(R.string.humidity) + resultado.getMain().getHumidity() + "%" +
                "\n" + getResources().getString(R.string.pressure) + resultado.getMain().getPressure() + " hPa";
        detailsField.setText(res);
        currentTemperatureField.setText(String.valueOf(resultado.getMain().getTemp()));
        DateFormat df = DateFormat.getDateTimeInstance();
        String updatedOn = df.format(new Date(resultado.getDt() * 1000));
        updatedField.setText(getResources().getString(R.string.last_update) + updatedOn);

        setWeatherIcon(resultado.getWeather().get(0).getId(), resultado.getSys().getSunrise() * 1000, resultado.getSys().getSunset() * 1000);
    }

    private void setWeatherIcon(int actualId, long sunrise, long sunset) {
        int id = actualId / 100;
        String icon = "";
        if (actualId == 800) {
            long currentTime = new Date().getTime();
            if (currentTime >= sunrise && currentTime < sunset) {
                icon = getActivity().getString(R.string.weather_sunny);
            } else {
                icon = getActivity().getString(R.string.weather_clear_night);
            }
        } else {
            switch (id) {
                case 2:icon = getActivity().getString(R.string.weather_thunder);break;
                case 3:icon = getActivity().getString(R.string.weather_drizzle);break;
                case 7:icon = getActivity().getString(R.string.weather_foggy);break;
                case 8:icon = getActivity().getString(R.string.weather_cloudy);break;
                case 6:icon = getActivity().getString(R.string.weather_snowy);break;
                case 5:icon = getActivity().getString(R.string.weather_rainy);break;
            }
        }
        weatherIcon.setText(icon);
    }

    public interface OnListener{
        void nextActivity();
    }

}