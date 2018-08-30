package com.example.shfwk.autoscroll;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    TextView title_view;
    AutoScrollViewPager autoViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

        title_view=(TextView)findViewById(R.id.title_view);
        final ArrayList<Integer> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        autoViewPager = (AutoScrollViewPager)findViewById(R.id.autoViewPager);
        data.add(R.drawable.ad1);
        data.add(R.drawable.ad2);
        data.add(R.drawable.ad3);
        data.add(R.drawable.ad4);
        Adapter scrollAdapter = new Adapter(this,data);
        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(2000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작

        autoViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
if(position<data.size()){
    autoViewPager.setCurrentItem(position+data.size(),false);
}
else if(position>=data.size()*2){
    autoViewPager.setCurrentItem(position-data.size(),false);
}
position=position%data.size();
                    if (position == 0){  // 첫 페이지
                        title_view.setText("● ○ ○ ○");

                    } else if (position == 1){   //두번째 페이지
                        title_view.setText("○ ● ○ ○");

                    }else if(position==2){
                        title_view.setText("○ ○ ● ○");
                    }
                    else if(position==3){
                        title_view.setText("○ ○ ○ ●");
                    }


                }





            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
