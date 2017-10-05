package com.popland.pop.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {
Button btn, btnColor;
    int color =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
         btnColor = (Button) findViewById(R.id.BTNcolor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color == 0) {
                    btnColor.setBackgroundColor(Color.GREEN);
                    color = 1;
                }
                else{
                    btnColor.setBackgroundColor(Color.BLUE);
                    color = 0 ;
                }
            }
        });
        btn = (Button)findViewById(R.id.BTN);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển về Activity chính để app start tại MainActivity
               Intent i = new Intent(getApplicationContext(),MainActivity.class);//2 dòng này chỉ cần từ Activity 3
               startActivity(i);
                //tạo sự kiện close app
               Intent startMain = new Intent(Intent.ACTION_MAIN);
               startMain.addCategory(Intent.CATEGORY_HOME);//return màn hình đầu khi AVD start
               startActivity(startMain);
               finish();//tắt current activity, lùi về activity trước đó
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){//tạo Menu
        super.onCreateOptionsMenu(menu);//super triệu gọi method của lớp cha
        menu.add(0,Menu.FIRST,0,"thoat");//menu thêm item groupId=0, itemId=Menu.FIRST, order=0, title="thoát"
        return true;//để hiện Menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){//bắt sự kiện cho MenuItem
        switch(item.getItemId()){
            case Menu.FIRST:
                finish();//tắt current activity, lùi về activity trước đó
                break;
        }
        return false;
    }
}
