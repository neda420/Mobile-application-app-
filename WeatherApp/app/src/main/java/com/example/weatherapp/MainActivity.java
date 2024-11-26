package com.example.weatherapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText cityInput;
    private TextView weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        cityInput = findViewById(R.id.cityInput);
        Button getWeatherButton = findViewById(R.id.getWeatherButton);
        weatherInfo = findViewById(R.id.weatherInfo);

        // Set click listener on the "Get Weather" button
        getWeatherButton.setOnClickListener(v -> {
            String city = cityInput.getText().toString().trim();
            if (TextUtils.isEmpty(city)) {
                Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
            } else {
                fetchWeather(city);
            }
        });
    }

    private void fetchWeather(String city) {
        // Create WeatherService instance
        WeatherService service = ApiClient.getClient().create(WeatherService.class);
        Call<WeatherResponse> call = service.getWeather(city, "d9b60cd6a31ee04a89c737740e6e94cf"); // Replace with your OpenWeather API key

        // Enqueue the API call
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    double temp = response.body().getMain().getTemp() - 273.15; // Convert Kelvin to Celsius
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
