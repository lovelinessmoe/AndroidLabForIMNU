package xyz.javaee.myapplication.ActicityLife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import xyz.javaee.myapplication.R;

public class ActicityLife2 extends AppCompatActivity {

    private final String TAG = "LIFE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"2创建了(create)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acticity_life2);
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"2销毁了(destroy)");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.e(TAG,"2即将可见(start)");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG,"2获取焦点(resume)");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG,"2暂停(pause)");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,"2停止了(stop)");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"2重新调用(restart)");
        super.onRestart();
    }
}