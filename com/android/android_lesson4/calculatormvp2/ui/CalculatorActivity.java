package com.android.android_lesson4.calculatormvp2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.android_lesson4.R;
import com.android.android_lesson4.calculatormvp2.domain.CalculatorImpl;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultText;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultText = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        findViewById(R.id.key_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.keyOnePressed();
            }
        });

        findViewById(R.id.key_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.keyTwoPressed();

            }
        });


        findViewById(R.id.key_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.keyThreePressed();

            }
        });

        findViewById(R.id.key_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.keyPlusPressed();

            }
        });

    }

    @Override
    public void showResult(String result) {
        resultText.setText(result);
    }
}