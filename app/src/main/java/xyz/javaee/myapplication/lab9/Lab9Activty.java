package xyz.javaee.myapplication.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.*;


import java.nio.charset.StandardCharsets;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import xyz.javaee.myapplication.R;

public class Lab9Activty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab9_activty);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://javaee.xyz/img.json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody, StandardCharsets.UTF_8);
                //FastJson
                System.out.println(json);
                List<ImgEntity> imgs = JSON.parseArray(json, ImgEntity.class);

                System.out.println(imgs);
                //配置适配器
                ImgAdapter adapter = new ImgAdapter(getApplicationContext(), R.layout.lab9_data_show_single, imgs);
                ListView listView = findViewById(R.id.LV_Lab9);
                //将适配器关联到ListView
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.err.println("shibai");
            }
        });
    }
}
