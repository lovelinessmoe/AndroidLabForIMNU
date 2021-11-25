package xyz.javaee.myapplication.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import xyz.javaee.myapplication.R;

public class FileIOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_ioactivity);

        Button save = findViewById(R.id.save_file);
        TextView state = findViewById(R.id.show_state);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText msgInput = findViewById(R.id.msg_input);
                String msg = msgInput.getText().toString();
                boolean succ = true;
                if (msg.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "请输入内容", Toast.LENGTH_LONG).show();
                } else {
                    FileOutputStream fos;
                    try {
                        fos = openFileOutput("loveliness", MODE_PRIVATE);
                        fos.write(msg.getBytes(StandardCharsets.UTF_8));
                        fos.close();
                    } catch (Exception e) {
                        succ = false;
                        e.printStackTrace();
                    } finally {
                        if (succ) {
                            state.setText("保存成功");
                        } else {
                            state.setText("保存失败");
                        }
                    }
                }
            }
        });

        Button read = findViewById(R.id.read_file);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis;
                boolean succ = true;
                byte[] buffer = new byte[1024];
                try {
                    fis = openFileInput("loveliness");
                    int count = 0;
                    StringBuilder msg = new StringBuilder();
                    while ((count = fis.read(buffer)) != -1) {
                        String temp = new String(buffer);
                        msg.append(temp);
                    }
                    TextView showMsg = findViewById(R.id.show_msg);
                    showMsg.setText(msg);
                } catch (Exception e) {
                    succ = false;
                    e.printStackTrace();
                } finally {
                    if (succ) {
                        state.setText("读取成功");
                    } else {
                        state.setText("读取失败");
                    }
                }
            }
        });


    }
}