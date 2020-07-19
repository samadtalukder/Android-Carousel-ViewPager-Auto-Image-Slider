package com.samad_talukder.androidcarouselviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public final static float FRONT_IMAGE_SCALE = 0.8f;
    public final static float SIDE_IMAGE_SCALE = 0.6f;
    public final static float DIFF_SCALE = FRONT_IMAGE_SCALE - SIDE_IMAGE_SCALE;
    private Context context;
    private ArrayList<Slider> mSliderArrayList;
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

        float scale = FRONT_IMAGE_SCALE;

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
    public Object instantiateItem(@NonNull ViewGroup viewGroup, final int position) {
        final int i2 = position % mSliderArrayList.size();


        View inflate = LayoutInflater.from(context).inflate(R.layout.item_image_slider, viewGroup, false);

        TextView tvTitle = inflate.findViewById(R.id.tv_slider_content_title);
        ImageView ivSliderImage = inflate.findViewById(R.id.iv_slider_content_poster_image);
        TextView tvType = inflate.findViewById(R.id.tv_slider_content_type);

        String strTitle = mSliderArrayList.get(i2).getTitle();
        String strType = mSliderArrayList.get(i2).getContent_type();
        String strImage = mSliderArrayList.get(i2).getSlider_image_path();

        tvTitle.setText(strTitle);

        tvType.setText(strType);

        Glide.with(context)
                .load(strImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new FitCenter(), new RoundedCorners(25))
                .into(ivSliderImage);

        ivSliderImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position: "+position, Toast.LENGTH_SHORT).show();
            }
        });

        CarouselLinearLayout rootCarouselLinearLayout = inflate.findViewById(R.id.root_container);

        if (position == 0) {
            mScale = FRONT_IMAGE_SCALE;
        } else {
            mScale = SIDE_IMAGE_SCALE;
        }

        rootCarouselLinearLayout.setScaleBoth(mScale);
        viewGroup.addView(inflate, 0);

        return inflate;
    }
}
