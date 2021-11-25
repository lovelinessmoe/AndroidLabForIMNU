package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView_one)
    View textViewOne;

    @BindView(R.id.webView_one)
    WebView webViewOne;

    @OnClick({R.id.button_lab7,R.id.button_json, R.id.button_lab6, R.id.button_one, R.id.button_LOGIN, R.id.button_REGISTER, R.id.button_LIFE, R.id.button_SHOP, R.id.button_TEST})
    public void clickJump(View view) {
        Intent intent = new Intent();

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
            case R.id.button_TEST:
                intent.setAction("xyz.javaee.test");
                startActivity(intent);
                break;
            case R.id.button_lab6:
                intent.setAction("xyz.javaee.lab6");
                startActivity(intent);
                break;
            case R.id.button_json:
                intent.setAction("xyz.javaee.json");
                startActivity(intent);
                break;
                case R.id.button_lab7:
                intent.setAction("xyz.javaee.lab7");
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        webViewOne.getSettings().setJavaScriptEnabled(true);
        webViewOne.setWebViewClient(new WebViewClient());
        webViewOne.loadUrl("http://javaee.xyz");
    }
}