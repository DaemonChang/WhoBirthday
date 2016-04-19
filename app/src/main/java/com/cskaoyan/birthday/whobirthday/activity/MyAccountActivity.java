package com.cskaoyan.birthday.whobirthday.activity;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cskaoyan.birthday.whobirthday.R;

public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {


    private boolean isEdited;

    private TextView tv_myaccount_username;
    private EditText et_myaccount_phone;
    private EditText et_myaccount_password;
    private Button btn_myaccount_editpassword;
    private Button btn_myaccount_editphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        isEdited = false;
        /**
         * 用户名，密码，手机号
         */
        initView();

        initData();

    }

    private void initView(){

        tv_myaccount_username = (TextView) findViewById(R.id.tv_myaccount_username);
        et_myaccount_phone = (EditText) findViewById(R.id.et_myaccount_phone);
        et_myaccount_password = (EditText) findViewById(R.id.et_myaccount_password);

        btn_myaccount_editpassword = (Button) findViewById(R.id.btn_myaccount_editpassword);
        btn_myaccount_editphone = (Button) findViewById(R.id.btn_myaccount_editphone);

        btn_myaccount_editpassword.setOnClickListener(this);
        btn_myaccount_editphone.setOnClickListener(this);

    }

    private void initData(){
        //从数据库中读出用户名，手机号这些信息，然后让其显示


    }

    private void showDialogInputSafePwd(){



        //弹出一个AlertDialog来输入密码，正确，则可以修改，错误则不能修改

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.edit_account_password, null);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        View confirmBtn = view.findViewById(R.id.bt_myaccount_confirm);
        View cancleBtn = view.findViewById(R.id.bt_myaccount_cancle);
        final EditText pwdEt = (EditText) view.findViewById(R.id.et_myaccount_password);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从数据库中取出账号密码accountPassword
                String pwdInput = pwdEt.getText().toString();
                String accountPassword =  "xxxx";
                if (accountPassword.equals(pwdInput)){

                    /**
                     * 1.密码正确，et_myaccount_password变成可以编辑的状态
                     * 2.“修改” Button 变成 “完成” Button
                     * 3.标志位 isEdited 设为 true
                     */
                    et_myaccount_password.setEnabled(true);
                    btn_myaccount_editpassword.setText("完成");
                    isEdited = true;
                    alertDialog.dismiss();

                }else {
                    Toast.makeText(MyAccountActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();

                }
            }
        });

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {


        switch (((Button)view).getId())
        {
            //修改密码：
            case R.id.btn_myaccount_editpassword:
                if ( !isEdited)
                {
                    //显示密码的EditText不可编辑，弹出Dialog来输入密码
                    showDialogInputSafePwd();

                }else {
                    //拿到EditText中的文本，看是否符合正则表达式，
                    String pwd = et_myaccount_password.getText().toString();
                    if (pwd.matches("\\d{6,10}"))
                    {
                        //设置密码

                    }else {
                        Toast.makeText(MyAccountActivity.this, "密码格式不正确，请输入6-10个数字！", Toast.LENGTH_SHORT).show();
                    }
                }



                break;

            //修改手机号
            case R.id.btn_myaccount_editphone:

                break;

            default:
                break;

        }
    }
}
