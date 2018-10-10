package com.example.john.prototype24parking;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(AddCardActivity.this);
                builder.setTitle("Повідомлення");
                builder.setMessage("Реєстрацію завершено" +
                        " Ваша картка успішно зареестрована");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(AddCardActivity.this, MapActivity.class);
                        startActivity(intent);
                        AddCardActivity.this.finish();
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                android.app.AlertDialog alertDialog = builder.create();
                alertDialog.show();
                v.setEnabled(true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddCardActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
