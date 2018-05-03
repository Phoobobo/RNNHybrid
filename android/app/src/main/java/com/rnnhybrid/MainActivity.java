package com.rnnhybrid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.react.ReactActivity;

public class MainActivity extends AppCompatActivity{
    Button mBtnGotoReact;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGotoReact = (Button) findViewById(R.id.btn_goto_react);
        mBtnGotoReact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainReactActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("extras", "hello rn");
//                intent.putExtras(bundle);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("rn://rn/home/detail"));
                startActivity(intent);
            }
        });
    }
}
