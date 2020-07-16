package com.samad_talukder.androidcarouselviewpager;


import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Slider> sliderArrayList;
    private ViewPager viewPager;
    private Handler handler;
    public final static int FIRST_PAGE = 0  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.activity_main_view_pager);

        sliderArrayList=new ArrayList<>();
        handler=new Handler();

        sliderArrayList.add(new Slider("Mayabini", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8492d950-f49d-11e9-b8d9-a9be9ceefc16-20191022072818277_landscape.jpg"));
        sliderArrayList.add(new Slider("Super Hero", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/6fd7c360-56a3-11e9-9ef7-a14cceff6227-20190915070342617_landscape.jpg"));
        sliderArrayList.add(new Slider("Apon Manush ", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8a129f20-cd64-11e8-bebb-c1d51eb8f63b-20200305120749624_landscape.jpg"));
        sliderArrayList.add(new Slider("Mayabini", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8492d950-f49d-11e9-b8d9-a9be9ceefc16-20191022072818277_landscape.jpg"));
        sliderArrayList.add(new Slider("Apon Manush ", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8a129f20-cd64-11e8-bebb-c1d51eb8f63b-20200305120749624_landscape.jpg"));
        sliderArrayList.add(new Slider("Super Hero", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/6fd7c360-56a3-11e9-9ef7-a14cceff6227-20190915070342617_landscape.jpg"));
        sliderArrayList.add(new Slider("Mayabini", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8492d950-f49d-11e9-b8d9-a9be9ceefc16-20191022072818277_landscape.jpg"));



        CarouselPagerAdapter carouselPagerAdapter = new CarouselPagerAdapter(this, sliderArrayList);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = (metrics.widthPixels / 3);
        viewPager.setPageMargin(-pageMargin);


        viewPager.setAdapter(carouselPagerAdapter);
        viewPager.setPageTransformer(false, carouselPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
        //viewPager.setPageMargin(-100);
    }

    Runnable runnable = new Runnable() {
        public void run() {
            try {

                viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % viewPager.getAdapter().getCount(), false);
            } catch (Exception e) {
                Log.e("TAG", "run: exception: - " + e.toString());
            } catch (Throwable th) {
                startThread(3);
                throw th;
            }
            startThread(3);
        }
    };

    private void startThread(int i) {
        handler.postDelayed(runnable, i * 1000);
    }

    private void stopSchedule() {
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onStart() {
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.post(runnable);
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        stopSchedule();
        super.onStop();
    }
}
