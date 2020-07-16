package com.samad_talukder.androidcarouselviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

public class CarouselPagerAdapter extends PagerAdapter implements ViewPager.PageTransformer {

    /*public final static float BIG_SCALE = 0.8f;
    public final static float SMALL_SCALE = 0.8f;*/

    public final static float BIG_SCALE = 0.7f;
    public final static float SMALL_SCALE = 0.4f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
    private Context context;
    private ArrayList<Slider> mSliderArrayList;
    private int pos = 0;
    private float mScale;

    public CarouselPagerAdapter(Context context, ArrayList<Slider> arrayList) {
        this.context = context;
        this.mSliderArrayList = arrayList;
    }


    @Override
    public int getCount() {
        return mSliderArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        CarouselLinearLayout carouselLinearLayout = page.findViewById(R.id.root_container);

        float scale = BIG_SCALE;

        if (position > 0) {
            scale -= position * DIFF_SCALE;
        } else {
            scale += position * DIFF_SCALE;
        }

        if (scale < 0) {
            scale = 0;
        }

        carouselLinearLayout.setScaleBoth(scale);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, final int i) {
        int i2 = i % mSliderArrayList.size();

        View inflate = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.item_cover, viewGroup, false);

        ImageView imageView = inflate.findViewById(R.id.image_cover);

        Glide.with(context)
                .load(mSliderArrayList.get(i2).getSliderImagePath())
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new FitCenter(), new RoundedCorners(25))
                .into(imageView);


        /*if (pos >= mSliderArrayList.size() - 1) {
            pos = 0;
        } else {
            pos++;
        }
*/
        CarouselLinearLayout rootCarouselLinearLayout = inflate.findViewById(R.id.root_container);

        if (i == 0) {
            mScale = BIG_SCALE;
        } else {
            mScale = SMALL_SCALE;
        }

        rootCarouselLinearLayout.setScaleBoth(mScale);
        viewGroup.addView(inflate, 0);
        return inflate;
    }
}
