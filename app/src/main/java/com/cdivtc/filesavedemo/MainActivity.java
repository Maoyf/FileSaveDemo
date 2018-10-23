package com.cdivtc.filesavedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //定义三个变量
    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定变量与控件
        etAccount = findViewById(R.id.et_number);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        //调用fileSaveQQ类中的获取账号和密码的方法，来获取账号和密码
        //Map<String,String> userInfo = FileSaveQQ.getUserInfo(this);
        //调用SPSaveQQ类中的getUserInfo方法，来获取账号和密码
        Map<String,String> userInfo = SPSaveQQ.getUserInfo(this);
        //判断是否有账号和密码
        if (userInfo != null){
            etAccount.setText(userInfo.get("account"));
            etPassword.setText(userInfo.get("password"));
        }
    }

    public void login(View view) {
        //单击登录按钮时，保存QQ账号和密码
        //先通过控件输入的账号和密码来获取账号和密码
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        //检验输入的账号和密码是否为空
        if (TextUtils.isEmpty(account)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        //登录成功
        Toast.makeText(this,"登录成功！",Toast.LENGTH_SHORT).show();

        //保存账号和密码到data.txt文件中
        //定义一个boolean的变量，用来判断是否保存成功
        //通过调用FileSaveQQ中的保存方式来保存数据
       // boolean isSaveSuccess = FileSaveQQ.saveUserInfo(this,account,password);
        //通过调用SPSaveQQ中的saveUserInfo方法来保存账号和密码
        boolean isSaveSuccess = SPSaveQQ.saveUserInfo(this,account,password);
        //判断是否保存成功
        if (isSaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
        }
    }
}
