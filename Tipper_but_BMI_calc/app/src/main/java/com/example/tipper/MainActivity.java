package com.example.tipper;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextHeight;
    private EditText editTextWeight;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.height);
        editTextWeight = findViewById(R.id.weight);
        Button buttonCalculate = findViewById(R.id.calculate);
        textViewResult = findViewById(R.id.result);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateBMI() {
        String heightString = editTextHeight.getText().toString();
        String weightString = editTextWeight.getText().toString();

        if (TextUtils.isEmpty(heightString)) {
            editTextHeight.setError("Please enter your height");
            editTextHeight.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(weightString)) {
            editTextWeight.setError("Please enter your weight");
            editTextWeight.requestFocus();
            return;
        }

        float height = Float.parseFloat(heightString) / 100;
        float weight = Float.parseFloat(weightString);

        float bmi = weight / (height * height);

        String bmiResult = "";

        if (bmi < 18.5) {
            bmiResult = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            bmiResult = "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            bmiResult = "Overweight";
        } else {
            bmiResult = "Obesity";
        }

        textViewResult.setText(String.format("Your BMI is %.2f\n%s", bmi, bmiResult));
    }
}
