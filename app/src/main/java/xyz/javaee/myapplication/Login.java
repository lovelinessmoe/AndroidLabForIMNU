package xyz.javaee.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        EditText username_input = findViewById(R.id.username_input);
        EditText password_input = findViewById(R.id.password_input);
        Button login_button = findViewById(R.id.login);

        final String usernameStatic = "admin";
        final String passwordStatic = "123456";

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable usernameText = username_input.getText();
                Editable passwordText = password_input.getText();
                String username = usernameText.toString();
                String password = passwordText.toString();
                TextView warning = findViewById(R.id.warning);

                if (usernameStatic.equals(username)
                        && passwordStatic.equals(password)) {
                    warning.setText("用户" + username + "登陆成功，欢迎您！");
                } else {
                    warning.setText("登陆失败，用户名或密码错误");
                }

                System.out.println(usernameText.toString());
                System.out.println(passwordText.toString());

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
