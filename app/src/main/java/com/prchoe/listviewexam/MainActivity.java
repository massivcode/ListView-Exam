
package com.prchoe.listviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mData;
    private ArrayAdapter<String> mAdapter;
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
            mData.add("Item " + i);
        }
    }

    // Adapter 준비
    private void initAdapter() {

        // Parameter : Context , 아이템 하나에 대한 레이아웃 , 데이터
        // simple_list_item_1 : 텍스트뷰 하나만 있는 레이아웃
        // getApplicationContext(), Activity.this, this 중에 getApplicationContext()를 권장
        // memory leak를 피하기 위해 권장함. 익명 클래스나 내부 클래스에서는 this가 안됩니당.
        mAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mData);

    }

    // ListView에 adapter 설정
    private void initListView() {
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

}
