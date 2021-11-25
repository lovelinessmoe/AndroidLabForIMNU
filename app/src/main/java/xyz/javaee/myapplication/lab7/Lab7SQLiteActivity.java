package xyz.javaee.myapplication.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.javaee.myapplication.R;
import xyz.javaee.myapplication.util.SQLiteUtil;

public class Lab7SQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_sqlite);

        Button add = findViewById(R.id.add);
        Button modify = findViewById(R.id.modify);
        Button delete = findViewById(R.id.delete);
        Button select = findViewById(R.id.select);

        add.setOnClickListener(this);
        modify.setOnClickListener(this);
        delete.setOnClickListener(this);
        select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            EditText stuNum_ET = findViewById(R.id.stuNum);
            EditText name_ET = findViewById(R.id.name);
            RadioGroup sex_RG = findViewById(R.id.sex);
            EditText classRoom_ET = findViewById(R.id.classRoom);

            String stuNum = stuNum_ET.getText().toString();
            String name = name_ET.getText().toString();
            String classRoom = classRoom_ET.getText().toString();

            //-1默认未选择
            int sex = -1;
            if (sex_RG.getCheckedRadioButtonId() == R.id.sex_nan) {
                sex = 1;
            } else if (sex_RG.getCheckedRadioButtonId() == R.id.sex_nv) {
                sex = 0;
            }
            Student student = new Student(name, stuNum, sex, classRoom);

            SQLiteUtil sqLiteUtil = new SQLiteUtil(this);
            SQLiteDatabase db = null;
            String sql = "";

            switch (v.getId()) {
                case R.id.add:
                    if ("".equals(student.getStuNum()) || student.getStuNum().length() != 11) {
                        throw new Exception("请输入正确的学号");
                    } else if ("".equals(student.getName()) || student.getName().length() > 10) {
                        throw new Exception("请输入正确的名字,长度不超过10位");
                    } else if ("".equals(student.getClassRoom()) || student.getName().length() > 20) {
                        throw new Exception("请输入正确的班级,长度不超过20位");
                    } else if (student.getSex() == -1) {
                        throw new Exception("请选择性别");
                    }

                    db = sqLiteUtil.getWritableDatabase();
                    sql = "INSERT INTO student " +
                            "(stuNum,name, sex, classRoom)" +
                            " VALUES ("
                            + "'" + student.getStuNum() + "'" + ","
                            + "'" + student.getName() + "'" + ","
                            + student.getSex() + ","
                            + "'" + student.getClassRoom() + "'"
                            + ")";
                    Log.i("sqlINSERT", sql);
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.modify:
                    if ("".equals(student.getStuNum()) || student.getStuNum().length() != 11) {
                        throw new Exception("请输入正确的学号");
                    } else if ("".equals(student.getName()) || student.getName().length() > 10) {
                        throw new Exception("请输入正确的名字,长度不超过10位");
                    } else if ("".equals(student.getClassRoom()) || student.getName().length() > 20) {
                        throw new Exception("请输入正确的班级,长度不超过20位");
                    } else if (student.getSex() == -1) {
                        throw new Exception("请选择性别");
                    }

                    db = sqLiteUtil.getWritableDatabase();
                    sql = "UPDATE student SET " +
                            "name = " + "'" + student.getName() + "'" + "," +
                            "sex = " + student.getSex() + ", " +
                            "classRoom = " + "'" + student.getClassRoom() + "'" +
                            "WHERE stuNum = " + "'" + student.getStuNum() + "'";
                    Log.i("sqlUPDATE", sql);
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.delete:
                    if ("".equals(student.getStuNum()) || student.getStuNum().length() != 11) {
                        throw new Exception("请输入正确的学号");
                    }

                    db = sqLiteUtil.getWritableDatabase();
                    sql = "DELETE FROM student " +
                            "WHERE stuNum = " + "'" + student.getStuNum() + "'";
                    Log.i("sqlDELETE", sql);
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.select:
                    db = sqLiteUtil.getReadableDatabase();
                    /*sql = "SELECT*FROM student WHERE " +
                            "stuNum=" + student.getStuNum() +
                            "AND NAME LIKE" + "%" + student.getName() + "%" +
                            "AND sex=" + student.getSex() +
                            "AND classRoom LIKE" + "%" + student.getClassRoom() + "%";*/
                    sql = "SELECT * FROM student";
                    Log.i("sqlSELECT", sql);
                    Cursor c = db.rawQuery(sql, new String[]{});
                    ArrayList<Student> students = new ArrayList<>();
                    //循环将数据结果保存到list里
                    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                        String stuNum1 = c.getString(c.getColumnIndex("stuNum"));
                        String name1 = c.getString(c.getColumnIndex("name"));
                        String classRoom1 = c.getString(c.getColumnIndex("classRoom"));
                        int sex1 = c.getInt(c.getColumnIndex("sex"));
                        Student student1 = new Student(name1, stuNum1, sex1, classRoom1);
                        students.add(student1);
                    }
                    db.close();
                    Intent intent = new Intent();
                    intent.setAction("xyz.javaee.lab7_data");
                    intent.putExtra("students", students);
                    startActivity(intent);
                    break;
            }
        } catch (SQLiteConstraintException e) {
            //主键重复的异常
            System.out.println(e.getMessage());
            Toast.makeText(getApplicationContext(), "学号重复", Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            System.out.println(e.getMessage());
            Toast.makeText(getApplicationContext(), "数据库错误", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //如果构建学生时出现错误，sql也不执行
            System.out.println(e.getMessage());
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}