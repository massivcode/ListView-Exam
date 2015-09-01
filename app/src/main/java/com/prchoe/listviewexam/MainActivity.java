
package com.prchoe.listviewexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<People> mData;
    private CustomAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 데이터 준비
        initData();

        // 2. Adapter 준비
        initAdapter();

        // 3. ListView에 Adapter를 장착
        initListView();


    }

    // Data 준비
    private void initData() {
        mData = new ArrayList();

            mData.add(new People(R.drawable.elsa1, "엘사1", "010-1111-1111"));
            mData.add(new People(R.drawable.elsa2, "엘사2", "010-1234-5678"));

        for (int i = 1; i <= 30; i++) {
            mData.add(new People(R.mipmap.ic_launcher, "안드로이드" + i, "1234-5678"));
        }
    }

    // Adapter 준비
    private void initAdapter() {

        // Parameter : Context , 아이템 하나에 대한 레이아웃 , 데이터
        // simple_list_item_1 : 텍스트뷰 하나만 있는 레이아웃
        // getApplicationContext(), Activity.this, this 중에 getApplicationContext()를 권장
        // memory leak를 피하기 위해 권장함. 익명 클래스나 내부 클래스에서는 this가 안됩니당.
//        mAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mData);

        // Parameter : Context, 데이터 객체, 레이아웃, 데이터를 get할 key의 배열들, 데이터를 표시할 레이아웃의 텍스트 1,2
        mAdapter = new CustomAdapter(getApplicationContext(), mData);

    }

    // ListView에 adapter 설정
    private void initListView() {
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 암시적 인텐트
                // Uri uri = Uri.parse("tel:" + mData.get(position).getPhoneNumber());
                // Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                // 명시적 인텐트
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("Data", mData.get(position));
                startActivity(intent);
            }
        });
    }
   
}
