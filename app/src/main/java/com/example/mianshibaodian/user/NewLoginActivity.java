package com.example.mianshibaodian.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mianshibaodian.R;
import com.example.mianshibaodian.utils.EditTextCheck;

public class NewLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        initView();

    }
    EditText phone;
    TextView getVerifyNum;
    EditText password;
    EditText verifyNum;
    EditText nickName;
    Button loginOK;
    RadioButton radioBoy;
    RadioButton radioGirl;
    private void initView(){
        phone = findViewById(R.id.et_user_phone);
        getVerifyNum = findViewById(R.id.tv_get_verify_num);
        verifyNum = findViewById(R.id.et_user_verify_num);
        nickName = findViewById(R.id.et_user_nick_name);
        password = findViewById(R.id.et_user_password);

        radioBoy = findViewById(R.id.radio_boy);
        radioGirl = findViewById(R.id.radio_girl);
        loginOK = findViewById(R.id.bt_login);

        EditTextCheck.etcPhone(phone,NewLoginActivity.this);
        EditTextCheck.etcText(nickName,NewLoginActivity.this);
        EditTextCheck.etcPassword(password,NewLoginActivity.this);
        
        getVerifyNum.setOnClickListener(new MyOnClick());
        loginOK.setOnClickListener(new MyOnClick());
        radioBoy.setOnClickListener(new MyOnClick());
        radioGirl.setOnClickListener(new MyOnClick());
    }
    String radioSex = "男";
    private class MyOnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_get_verify_num:

                    break;
                case R.id.radio_boy:
                    radioSex="男";
                    break;
                case R.id.radio_girl:
                    radioSex="女";
                    break;
                case R.id.bt_login:
                    String phoneStr = phone.getText().toString();
                    String passwordStr = password.getText().toString();
                    String verifyNumStr = verifyNum.getText().toString();
                    String nickNameStr = nickName.getText().toString();
                    break;
            }
        }
    }
}