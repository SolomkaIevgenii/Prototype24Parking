package com.example.john.prototype24parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ReadyToPayActivity extends AppCompatActivity {
    private int i = 1;
    private TextView textPrice, textCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_to_pay);
        textPrice = findViewById(R.id.textPrice);
        textCurrentTime = findViewById(R.id.textCurrentTime);
        textCurrentTime.setText(""+i);

        if (i==1){
            findViewById(R.id.button5).setEnabled(false);
        }

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==1){
                    Toast.makeText(ReadyToPayActivity.this, "Мінімальний час 1 година", Toast.LENGTH_SHORT).show();
                    findViewById(R.id.button5).setEnabled(false);
                    textPrice.setText("До сплати: "+7*i+" грн.");
                    textCurrentTime.setText(""+i);
                }else if (i>1){
                    i--;
                    textPrice.setText("До сплати: "+7*i+" грн.");
                    textCurrentTime.setText(""+i);
                    findViewById(R.id.button4).setEnabled(true);
                }
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==9){
                    Toast.makeText(ReadyToPayActivity.this, "Максимальний час 1 година", Toast.LENGTH_SHORT).show();
                    findViewById(R.id.button4).setEnabled(false);
                    textPrice.setText("До сплати: "+7*i+" грн.");
                    textCurrentTime.setText(""+i);
                }else if (i<9){
                    i++;
                    textPrice.setText("До сплати: "+7*i+" грн.");
                    textCurrentTime.setText(""+i);
                    findViewById(R.id.button5).setEnabled(true);
                }

            }
        });

        findViewById(R.id.buttonParkPay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadyToPayActivity.this, PayedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ReadyToPayActivity.this, MapActivity.class);
        startActivity(intent);
        finish();

    }
}
