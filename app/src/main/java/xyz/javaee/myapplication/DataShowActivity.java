package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import xyz.javaee.myapplication.entity.People;

public class DataShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        Intent intent = getIntent();
        People user = (People) intent.getSerializableExtra("user");

        TextView username_tv = findViewById(R.id.username);
        TextView password_tv = findViewById(R.id.password);
        username_tv.setText("用户名:"+user.getUsername());
        password_tv.setText("密  码:"+user.getPassword());

        Button shop = findViewById(R.id.shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction("xyz.javaee.shop");
                intent1.putExtra("user",user);
                startActivity(intent1);
            }
        });
    }
}