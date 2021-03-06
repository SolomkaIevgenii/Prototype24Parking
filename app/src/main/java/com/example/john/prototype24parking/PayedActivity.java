package com.example.john.prototype24parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PayedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payed);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayedActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PayedActivity.this, ReadyToPayActivity.class);
        startActivity(intent);
        finish();
    }
}
