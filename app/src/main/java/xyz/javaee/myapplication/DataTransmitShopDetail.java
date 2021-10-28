package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataTransmitShopDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transmit_shop_detail);

        CheckBox apple = findViewById(R.id.Apple);
        CheckBox banana = findViewById(R.id.Banana);
        CheckBox grapefruit = findViewById(R.id.Grapefruit);
        CheckBox grape = findViewById(R.id.Grape);
        ArrayList<String> list = new ArrayList<>();

        Intent intent = getIntent();
        String shop_name = intent.getStringExtra("shop_name");

        TextView shop_name_tv = findViewById(R.id.shop_name_tv);
        shop_name_tv.setText("当前超市是:" + shop_name);

        Button buy = findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apple.isChecked()) {
                    list.add(apple.getText().toString());
                }
                if (banana.isChecked()) {
                    list.add(banana.getText().toString());
                }
                if (grapefruit.isChecked()) {
                    list.add(grapefruit.getText().toString());
                }
                if (grape.isChecked()) {
                    list.add(grape.getText().toString());
                }

                intent.putExtra("buy_detail", list);
                setResult(1, intent);
                finish();
            }
        });
    }
}