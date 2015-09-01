package com.prchoe.listviewexam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity implements View.OnClickListener{
    TextView textView1;
    TextView textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.detailImage);
        textView1 = (TextView) findViewById(R.id.detailName);
        textView2 = (TextView) findViewById(R.id.detailPhone);

        textView2.setOnClickListener(this);


        Intent intent = getIntent();

        if (getIntent() != null) {
            People p = (People) intent.getSerializableExtra("data");
            imageView.setImageResource(p.getImageResourceId());
            textView1.setText(p.getName());
            textView2.setText(p.getPhoneNumber());
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detailPhone:
                Uri uri = Uri.parse("tel:" + textView2.getText());
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
        }
    }
}
