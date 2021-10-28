package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //选择图片 requestCode 返回的标识
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT); //"android.intent.action.GET_CONTENT"
        intent.setType("image/*"); //查看类型 String IMAGE_UNSPECIFIED = "image/*";
        Intent wrapperIntent = Intent.createChooser(intent, null);
        int requestCode = 10086;
        Object context = null;
        ((Activity) context).startActivityForResult(wrapperIntent, requestCode);

        System.out.println(context);

    }
}