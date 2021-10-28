package xyz.javaee.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class DataTransmitInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transmit_info);

        Intent intent = getIntent();
        String shop_name = intent.getStringExtra("shop_name");

        TextView shop_tv = findViewById(R.id.shop_tv);
        shop_tv.setText("当前超市：" + shop_name);

        Button buy = findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent();
                detail.setAction("xyz.javaee.detail");
                detail.putExtra("shop_name", shop_name);
                startActivityForResult(detail, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 1 && resultCode == 1) {
                ArrayList<String> buy_detail = (ArrayList<String>) data.getSerializableExtra("buy_detail");

                TextView buyInfo = findViewById(R.id.buyInfo);
                StringBuilder temp = new StringBuilder("您购买的有:\n");
                for (String s : buy_detail) {
                    temp.append(s).append("\n");
                }
                buyInfo.setText(temp);
            }
        }
    }
}