package com.example.mobileapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileapps.calculator.CalculatorActivity;
import com.example.mobileapps.counter.CounterActivity;
import com.example.mobileapps.todo.ToDoActivity;
import com.example.mobileapps.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCounter).setOnClickListener(
                v -> startActivity(new Intent(this, CounterActivity.class)));

        findViewById(R.id.btnTodo).setOnClickListener(
                v -> startActivity(new Intent(this, ToDoActivity.class)));

        findViewById(R.id.btnWeather).setOnClickListener(
                v -> startActivity(new Intent(this, WeatherActivity.class)));

        findViewById(R.id.btnCalculator).setOnClickListener(
                v -> startActivity(new Intent(this, CalculatorActivity.class)));
    }
}
