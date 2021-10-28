package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import xyz.javaee.myapplication.entity.People;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText username_input = findViewById(R.id.username_input);
        EditText password_input = findViewById(R.id.password_input);
        Button login_button = findViewById(R.id.register);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable usernameText = username_input.getText();
                Editable passwordText = password_input.getText();
                String username = usernameText.toString();
                String password = passwordText.toString();

                People people = new People(1000, 0, 186, username, password);

                Intent intent = new Intent();
                intent.setAction("xyz.javaee.datashow");
                intent.putExtra("user", people);

                startActivity(intent);

                Toast.makeText(getApplicationContext(), usernameText.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Button reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username_input.setText("");
                password_input.setText("");
            }
        });


    }
}