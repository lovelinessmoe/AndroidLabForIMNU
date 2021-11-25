package xyz.javaee.myapplication.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xyz.javaee.myapplication.Adapter.ProductAdapter;
import xyz.javaee.myapplication.R;
import xyz.javaee.myapplication.ShopActivity;
import xyz.javaee.myapplication.entity.People;

public class Lab7DataShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_data_show);

        Intent intent = getIntent();
        ArrayList<Student> students = (ArrayList<Student>) intent.getSerializableExtra("students");

        //配置适配器
        StudentsAdapter adapter = new StudentsAdapter(this, R.layout.lab7_data_show_single, students);
        ListView listView = findViewById(R.id.list_student);
        //将适配器关联到ListView
        listView.setAdapter(adapter);

        Button finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}