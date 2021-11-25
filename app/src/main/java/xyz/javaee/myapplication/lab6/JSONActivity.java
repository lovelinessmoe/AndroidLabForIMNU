package xyz.javaee.myapplication.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import xyz.javaee.myapplication.R;

/**
 * 请先将两个json文件放到对应应用的file内置存储文件夹里
 * 安装阿里的fastjson    com.alibaba:fastjson:1.2.78
 * 外置存储没写出来
 */
public class JSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonactivity);

        TextView showJosnMsg = findViewById(R.id.show_json_msg);

        View.OnClickListener listener = new View.OnClickListener() {
            //            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                try {
                    //外置存储由于android11，不能申请到权限

                    /*String state = Environment.getExternalStorageState();
                    if (!Environment.MEDIA_MOUNTED.equals(state)) {
                        throw new Exception("外置存储不能用");
                    }
                    File path = Environment.getExternalStorageDirectory();
                    ActivityCompat.requestPermissions(JSONActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.MANAGE_EXTERNAL_STORAGE},
                            1);*/
                    char[] buffer = new char[5];
                    FileInputStream fis;
                    InputStreamReader inputStreamReader;
                    StringBuilder msg;
                    int count = 0;
                    switch (v.getId()) {
                        case R.id.single:
                            fis = openFileInput("json_single.json");
                            inputStreamReader = new InputStreamReader(fis);
                            msg = new StringBuilder();

                            //使用inputStreamReader为了中文不在中间断开
                            while ((count = inputStreamReader.read(buffer)) != -1) {
                                msg.append(new java.lang.String(buffer, 0, count));
                            }

                            inputStreamReader.close();
                            fis.close();

                            //这里使用阿里的fastJSON
                            Lab6_JSON lab6_json = JSON.parseObject(String.valueOf(msg), Lab6_JSON.class);
                            //重写实体的toString方法
                            showJosnMsg.setText(lab6_json.toString());
                            break;
                        case R.id.multiple:
                            fis = openFileInput("json_multiple.json");
                            inputStreamReader = new InputStreamReader(fis);
                            msg = new StringBuilder();

                            while ((count = inputStreamReader.read(buffer)) != -1) {
                                msg.append(new java.lang.String(buffer, 0, count));
                            }

                            inputStreamReader.close();
                            fis.close();

                            //这里使用阿里的fastJSON
                            List<Lab6_JSON> lab6_json_list = JSON.parseArray(String.valueOf(msg), Lab6_JSON.class);
                            StringBuilder temp = new StringBuilder();
                            for (Lab6_JSON lab6Json : lab6_json_list) {
                                //重写实体的toString方法
                                temp.append(lab6Json.toString());
                                temp.append("\n");
                                temp.append("-=-=-=-=-=-=-=-=-");
                                temp.append("\n");
                            }
                            showJosnMsg.setText(temp);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Button single = findViewById(R.id.single);
        Button multiple = findViewById(R.id.multiple);
        //绑定监听器
        single.setOnClickListener(listener);
        multiple.setOnClickListener(listener);
    }
}