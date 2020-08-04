package com.example.mianshibaodian.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mianshibaodian.R;

public class AgainLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_again);
        final Button loginBt  = findViewById(R.id.bt_login);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgainLoginActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        final Button loginNewBt = findViewById(R.id.bt_login_new);
        loginNewBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgainLoginActivity.this,NewLoginActivity.class);
                startActivity(intent);
            }
        });
    }

}