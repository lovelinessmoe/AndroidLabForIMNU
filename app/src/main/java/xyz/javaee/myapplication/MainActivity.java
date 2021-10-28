package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View textViewOne = findViewById(R.id.textView_one);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent = new Intent();

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_one:
                        int visibility = textViewOne.getVisibility();
                        if (visibility == View.VISIBLE) {
                            textViewOne.setVisibility(View.INVISIBLE);
                        } else {
                            textViewOne.setVisibility(View.VISIBLE);
                        }
                        break;
                    case R.id.button_LOGIN:
                        intent.setAction("xyz.javaee.login");
                        startActivity(intent);
                        break;
                    case R.id.button_REGISTER:
                        intent.setAction("xyz.javaee.register");
                        startActivity(intent);
                        break;
                    case R.id.button_LIFE:
                        intent.setAction("xyz.javaee.acticityLife1");
                        startActivity(intent);
                        break;
                    case R.id.button_SHOP:
                        intent.setAction("xyz.javaee.shop2");
                        startActivity(intent);
                        break;
                }
            }
        };

        Button buttonOne = findViewById(R.id.button_one);
        buttonOne.setOnClickListener(onClickListener);

        Button login = findViewById(R.id.button_LOGIN);
        login.setOnClickListener(onClickListener);

        Button life = findViewById(R.id.button_LIFE);
        life.setOnClickListener(onClickListener);

        Button register = findViewById(R.id.button_REGISTER);
        register.setOnClickListener(onClickListener);

        Button shop = findViewById(R.id.button_SHOP);
        shop.setOnClickListener(onClickListener);


        WebView webViewOne = findViewById(R.id.webView_one);
        webViewOne.getSettings().setJavaScriptEnabled(true);
        webViewOne.setWebViewClient(new WebViewClient());
        webViewOne.loadUrl("http://javaee.xyz");
    }
}