package com.example.mobileapps.weather;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileapps.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    private EditText cityInput;
    private TextView weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityInput = findViewById(R.id.cityInput);
        Button getWeatherButton = findViewById(R.id.getWeatherButton);
        weatherInfo = findViewById(R.id.weatherInfo);

        getWeatherButton.setOnClickListener(v -> {
            String city = cityInput.getText().toString().trim();
            if (TextUtils.isEmpty(city)) {
                Toast.makeText(WeatherActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
            } else {
                fetchWeather(city);
            }
        });
    }

    private void fetchWeather(String city) {
        WeatherService service = ApiClient.getClient().create(WeatherService.class);
        Call<WeatherResponse> call = service.getWeather(city, "d9b60cd6a31ee04a89c737740e6e94cf");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    double temp = response.body().getMain().getTemp() - 273.15;
                    weatherInfo.setText(String.format("Temperature in %s: %.2f°C", city, temp));
                } else {
                    weatherInfo.setText("City not found. Please check the name.");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                weatherInfo.setText("Error: Unable to fetch weather. Please try again.");
            }
        });
    }
}
