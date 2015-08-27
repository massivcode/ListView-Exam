
package com.prchoe.listviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String, String>> mData;
    private SimpleAdapter mAdapter;
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

        for (int i = 1; i <= 100; i++) {
            Map<String, String> data = new HashMap<>();
            data.put("item", "Item " + i);
            data.put("subitem", "Sub Item " + i);
            mData.add(data);
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
        mAdapter = new SimpleAdapter(getApplicationContext(), mData, android.R.layout.simple_list_item_2,
                new String[] {"item", "subitem"},
                new int[] {android.R.id.text1, android.R.id.text2});

    }

    // ListView에 adapter 설정
    private void initListView() {
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

}
