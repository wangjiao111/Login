package com.example.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginpage.service.LoginService;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private CheckBox cb;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=(EditText) findViewById(R.id.et_name);
        etPwd=(EditText) findViewById(R.id.et_pwd);
        cb=(CheckBox) findViewById(R.id.cb);
        but=(Button) findViewById(R.id.but_login);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString().trim();
                String pwd=etPwd.getText().toString().trim();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
                    Toast.makeText(MainActivity.this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    //是否保存密码
                    if (cb.isChecked()){
                        //保存密码
                        boolean result=LoginService.saveInfo(MainActivity.this,name,pwd);
                        if(result){
                            Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //登录
                    if (name.equals("jiaojiao")&&pwd.equals("123")){
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "登录失败,用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
