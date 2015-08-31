
package com.prchoe.listviewexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by massivCode on 2015-08-31.
 */
public class CustomAdapter extends BaseAdapter {

    private List<People> mData;
    // private Context mContext;
    private LayoutInflater inflater;

    /**
     * Activity에서만 R. 으로 리소스에 접근할 수 있어서 context를 받는다.
     * 
     * @param context
     * @param data
     */
    public CustomAdapter(Context context, List<People> data) {
        mData = data;
        // mContext = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 아이템의 갯수
     * 
     * @return
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 해당 포지션에 위치하는 아이템 어댑터 클래스가 여러 타입을 받는다면 Object 기본적으로 Object로 해라
     * 
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    /**
     * 거의 안쓰여서 position을 리턴함 해당 포지션에 위치하는 아이템의 ID
     * 
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 각 아이템의 레이아웃을 결정
     * 
     * @param position 포지션
     * @param convertView 포지션의 View
     * @param parent 부모
     * @return 완성된 레이아웃
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        // 1. 레이아웃 구성

        // convertView 처음 로딩 될 때 초기화 과정을 거쳐서 viewHolder에 저장
        if (convertView == null) {
            // layout을 가져오기
            convertView = inflater.inflate(R.layout.item_people, parent, false);

            // 각 View를 소스로 연결
            ImageView image = (ImageView) convertView.findViewById(R.id.imageId);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);

            // ViewHolder를 생성 후, 가져온 View를 연결
            viewHolder = new ViewHolder();
            viewHolder.image = image;
            viewHolder.name = name;
            viewHolder.phone = phoneNumber;

            // ViewHolder를 convertView의 태그로 저장장
           convertView.setTag(viewHolder);

        } else {
            // convertView가 다시 로딩 될 때에는 viewHolder에서 꺼내와서 재사용
            // 이점 : 속도가 빠르다
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // 2. 레이아웃에 데이터를 바인딩
//        People people1 = mData.get(position); => 직접 접근

        People people = (People)getItem(position); // => 어댑터가 제공해주는 메서드 이용

        viewHolder.image.setImageResource(people.getImageResourceId());
        viewHolder.name.setText(people.getName());
        viewHolder.phone.setText(people.getPhoneNumber());

        // 3. 완성된 View를 리턴
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
