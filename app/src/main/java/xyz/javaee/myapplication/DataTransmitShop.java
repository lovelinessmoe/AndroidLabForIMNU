package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DataTransmitShop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transmit_shop);

        RadioGroup shop = findViewById(R.id.shop);

        Button queren = findViewById(R.id.queren);
        queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioButtonId = shop.getCheckedRadioButtonId();

                TextView shop_single = findViewById(checkedRadioButtonId);
                String shop_name = shop_single.getText().toString();

                Intent intent = new Intent();
                intent.setAction("xyz.javaee.info");
                intent.putExtra("shop_name",shop_name);
                startActivity(intent);
            }
        });

    }
}