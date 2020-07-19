package com.samad_talukder.androidcarouselviewpager;


import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import static com.samad_talukder.androidcarouselviewpager.ImageSlider.getImageSlider;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Slider> sliderArrayList;
    private ViewPager viewPager;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.activity_main_view_pager);

        sliderArrayList = new ArrayList<>();
        handler = new Handler();

        CarouselPagerAdapter carouselPagerAdapter = new CarouselPagerAdapter(this, getImageSlider());

        /*DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = (metrics.widthPixels / 3);
        viewPager.setPageMargin(-pageMargin);*/


        viewPager.setAdapter(carouselPagerAdapter);
        viewPager.setPageTransformer(false, carouselPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(-150);
    }



    Runnable runnable = new Runnable() {
        public void run() {
            try {
                int numPages = viewPager.getAdapter().getCount();
                int pages = (viewPager.getCurrentItem() + 1) % numPages;

                viewPager.setCurrentItem(pages,true);

            } catch (Throwable th) {

                startSliderThread(3);

                throw th;
            }
            startSliderThread(3);
        }
    };

    private void startSliderThread(int i) {
        handler.postDelayed(runnable, i * 1000);
    }

    private void stopSliderThread() {
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
    protected void onPause() {
        stopSliderThread();
        super.onPause();
    }

}
