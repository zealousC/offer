package com.example.mianshibaodian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mianshibaodian.fragment.CollectionFragment;
import com.example.mianshibaodian.fragment.MessageFragment;
import com.example.mianshibaodian.fragment.SearchFragment;
import com.example.mianshibaodian.fragment.UserFragment;
import com.example.mianshibaodian.user.NewLoginActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
    }

    private SearchFragment searchFragment=null;
    private MessageFragment messageFragment=null;
    private CollectionFragment collectionFragment=null;
    private UserFragment userFragment=null;
    private void initFragment(){
        searchFragment = new SearchFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, searchFragment).commit();
    }

    Drawable dSearch;
    Drawable dMessage;
    Drawable dCollection;
    Drawable dUser;
    private void barShow(){
        dSearch = getResources().getDrawable(R.mipmap.search);
        dMessage = getResources().getDrawable(R.mipmap.message);
        dCollection = getResources().getDrawable(R.mipmap.collection);
        dUser = getResources().getDrawable(R.mipmap.user);

        dSearch.setBounds(0,0,80,80);
        dMessage.setBounds(0,0,80,80);
        dCollection.setBounds(0,0,80,80);
        dUser.setBounds(0,0,80,80);

        tSearch.setCompoundDrawables(null,dSearch,null,null);
        tMessage.setCompoundDrawables(null,dMessage,null,null);
        tCollection.setCompoundDrawables(null,dCollection,null,null);
        tUser.setCompoundDrawables(null,dUser,null,null);
    }

    TextView tSearch;
    TextView tMessage;
    TextView tCollection;
    TextView tUser;
    //初始化布局
    private void initView(){
        tSearch = findViewById(R.id.t_search);
        tMessage = findViewById(R.id.t_message);
        tCollection = findViewById(R.id.t_collection);
        tUser = findViewById(R.id.t_user);
        barShow();
        dfBarShow();
        setListener();
    }
    //默认当前选项
    private void dfBarShow(){
        dSearch = getResources().getDrawable(R.mipmap.search1);
        dSearch.setBounds(0,0,80,80);
        tSearch.setCompoundDrawables(null,dSearch,null,null);
    }
    //初始化点击事件
    private void setListener(){
        OnClick onClick = new OnClick();
        tSearch.setOnClickListener(onClick);
        tMessage.setOnClickListener(onClick);
        tCollection.setOnClickListener(onClick);
        tUser.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            barShow();
            selectTrue();
            FragmentTransaction ftTemp  = getSupportFragmentManager().beginTransaction();
            switch (view.getId()){
                case R.id.t_search:
                    dfBarShow();
                    if (searchFragment==null){
                        searchFragment = new SearchFragment();
                        ftTemp.add(R.id.container, searchFragment);
                    }else {
                        ftTemp.show(searchFragment);
                    }
                    selectTemp=1;
                    break;
                case R.id.t_message:
                    //选中状态消息样式
                    dMessage = getResources().getDrawable(R.mipmap.message1);
                    dMessage.setBounds(0,0,80,80);
                    tMessage.setCompoundDrawables(null,dMessage,null,null);
                    //消息内容显示
                    if (messageFragment==null){
                        messageFragment = new MessageFragment();
                        ftTemp.add(R.id.container, messageFragment);
                    }else {
                        ftTemp.show(messageFragment);
                    }
                    selectTemp=2;
                    break;
                case R.id.t_collection:
                    dCollection = getResources().getDrawable(R.mipmap.collection1);
                    dCollection.setBounds(0,0,80,80);
                    tCollection.setCompoundDrawables(null,dCollection,null,null);
                    if (collectionFragment==null){
                        collectionFragment = new CollectionFragment();
                        ftTemp.add(R.id.container, collectionFragment);
                    }else {
                        ftTemp.show(collectionFragment);
                    }
                    selectTemp=3;
                    break;
                case R.id.t_user:
                    dUser = getResources().getDrawable(R.mipmap.user1);
                    dUser.setBounds(0,0,80,80);
                    tUser.setCompoundDrawables(null,dUser,null,null);
                    if (userFragment==null){
                        userFragment = new UserFragment();
                        ftTemp.add(R.id.container, userFragment);
                    }else {
                        ftTemp.show(userFragment);
                    }
                    selectTemp=4;
                    Intent intent=new Intent(MainActivity.this, NewLoginActivity.class);
                    startActivity(intent);
                    break;
            }
            ftTemp.commit();
        }
    }

    //菜单栏选中状态
    int selectTemp=1;//1发现；2消息；3收藏；4我的
    private void selectTrue(){
        FragmentTransaction ftTemp  = getSupportFragmentManager().beginTransaction();
        //消除上一次选择的状态
        if (selectTemp==1){
            ftTemp.hide(searchFragment);
        }else if (selectTemp==2){
            ftTemp.hide(messageFragment);
        }else if (selectTemp==3){
            ftTemp.hide(collectionFragment);
        }else {
            ftTemp.hide(userFragment);
        }
        ftTemp.commit();
    }


}