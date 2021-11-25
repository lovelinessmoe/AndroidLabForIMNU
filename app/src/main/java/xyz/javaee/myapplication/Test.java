package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.javaee.myapplication.util.SQLiteUtil;

public class Test extends AppCompatActivity {
    @BindView(R.id.textView_tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        JSON.toJSONString()

        ButterKnife.bind(this);//注意位置 否则报错
        textView.setText("dasjklfksaldjfkl");

        SQLiteUtil sqLiteUtil = new SQLiteUtil(this);
        SQLiteDatabase writableDatabase = sqLiteUtil.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "狗蛋");
        contentValues.put("price", 100);
        long insert_id = writableDatabase.insert("information", null, contentValues);
        writableDatabase.close();
//        SQLiteDatabase readableDatabase = sqLiteUtil.getReadableDatabase();
//        readableDatabase.query("inf")


        /*XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(openFileInput("hello"), "utf-8");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}