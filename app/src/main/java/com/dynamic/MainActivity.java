package com.dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dynamic.fragment.ContactFragment;
import com.dynamic.fragment.DynamicFragment;
import com.dynamic.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    private TextView tv_contact;
    private TextView tv_dynamic;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //一开始进入程序,就往容器中替换Fragment
        changeFragment(new MessageFragment(), "messageFragment");
    }

    /**
     * 初始化控件
     */
    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        tv_contact = (TextView) findViewById(R.id.tv_contact);
        tv_dynamic = (TextView) findViewById(R.id.tv_dynamic);
        tv_message = (TextView) findViewById(R.id.tv_message);

        tv_contact.setOnClickListener(this);
        tv_message.setOnClickListener(this);
        tv_dynamic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_contact:
                changeFragment(new ContactFragment(), "contactFragment");
                break;
            case R.id.tv_dynamic:
                changeFragment(new DynamicFragment(), "dynamicFragment");
                break;
            case R.id.tv_message:
                changeFragment(new MessageFragment(), "messageFragment");
                break;
            default:
                break;
        }
    }

    public void changeFragment(Fragment fragment, String tag) {
        // 获取Fragment管理者
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        // 开启事物
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        // 当前要添加的Fragment需要放的容器位置
        // 要替换的fragment
        // 标记
        beginTransaction.replace(R.id.frameLayout, fragment, tag);
        // 提交事物
        beginTransaction.commit();
    }
}
