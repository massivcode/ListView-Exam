package com.prchoe.listviewexam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = (ImageView)findViewById(R.id.detailImage);
        TextView textView1 = (TextView)findViewById(R.id.detailName);
        TextView textView2 = (TextView)findViewById(R.id.detailPhone);

        Intent intent = getIntent();
        People p = (People)intent.getExtras().getSerializable("Data");
        imageView.setImageResource(p.getImageResourceId());
        textView1.setText(p.getName());
        textView2.setText(p.getPhoneNumber());
    }


}
