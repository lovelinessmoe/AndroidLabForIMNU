package xyz.javaee.myapplication.ActicityLife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import xyz.javaee.myapplication.R;

public class ActicityLife1 extends AppCompatActivity {

    private final String TAG = "LIFE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"1创建了(create)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acticity_life1);

        Button jump = findViewById(R.id.Jump);
        //重写方法外this指向问题
        Intent intent = new Intent(this, ActicityLife2.class);

        //隐式意图
        Intent intent1 = new Intent();
        intent1.setAction("xyz.javaee.acticityLife2");

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                跳转第二个活动
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"1销毁了(destroy)");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.e(TAG,"1即将可见(start)");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG,"1获取焦点(resume)");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG,"1暂停(pause)");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,"1停止了(stop)");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"1重新调用(restart)");
        super.onRestart();
    }
}