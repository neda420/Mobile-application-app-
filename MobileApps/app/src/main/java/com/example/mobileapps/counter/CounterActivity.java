package com.example.mobileapps.counter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileapps.R;

public class CounterActivity extends AppCompatActivity {

    private TextView textViewCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        textViewCount = findViewById(R.id.text_view_count);
        Button buttonToast = findViewById(R.id.button_toast);
        Button buttonCount = findViewById(R.id.button_count);

        buttonToast.setOnClickListener(v -> {
            Toast.makeText(CounterActivity.this, "Hello Toast!", Toast.LENGTH_SHORT).show();
            count = 0;
            textViewCount.setText(String.valueOf(count));
        });

        buttonCount.setOnClickListener(v -> {
            count++;
            textViewCount.setText(String.valueOf(count));
        });
    }
}
