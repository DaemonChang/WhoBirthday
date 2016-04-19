package com.cskaoyan.birthday.whobirthday.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cskaoyan.birthday.whobirthday.R;
import com.cskaoyan.birthday.whobirthday.application.MyApplication;

public class SettingActivity extends AppCompatActivity {

    private String[] settingListText;
    private ListView settingListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        settingListText = new String[]{"我的账号","生日提醒","主题颜色","密码锁","数据同步设置","关于我们"};

        settingListView = (ListView) findViewById(R.id.lv_setting);
        settingListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,settingListText));

        settingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //我的账号
                        break;
                    case 1:
                        //生日提醒
                        break;
                    case 2:
                        //主题颜色
                        break;
                    case 3:
                        //密码锁
                        String pwd = MyApplication.configsp.getString("password", "xxx");
                        if ( ! pwd.equals("xxx"))
                        {
                            //之前设置过密码，进入到输入密码的页面
                            startActivity(new Intent(SettingActivity.this,InputPasswordActivity.class));

                        }else{
                            //之前没有设置过密码，进入到设置密码的页面
                            startActivity(new Intent(SettingActivity.this,SetPasswordActivity.class));
                        }
                        break;
                    case 4:
                        //数据同步设置
                        break;
                    case 5:
                        //关于
                        break;
                    default:
                        break;


                }
            }
        });
    }
}
