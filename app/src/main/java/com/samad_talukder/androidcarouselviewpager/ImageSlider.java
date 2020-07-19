package com.samad_talukder.androidcarouselviewpager;

import java.util.ArrayList;

public class ImageSlider {

    public static ArrayList<Slider> getImageSlider() {

        ArrayList<Slider> sliderArrayList = new ArrayList<>();

        sliderArrayList.add(new Slider("Mayabini", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8492d950-f49d-11e9-b8d9-a9be9ceefc16-20191022072818277_landscape.jpg", "Movie"));
        sliderArrayList.add(new Slider("Super Hero", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/6fd7c360-56a3-11e9-9ef7-a14cceff6227-20190915070342617_landscape.jpg", "Movie"));
        sliderArrayList.add(new Slider("Apon Manush ", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8a129f20-cd64-11e8-bebb-c1d51eb8f63b-20200305120749624_landscape.jpg", "Movie"));
        sliderArrayList.add(new Slider("Mayabini", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8492d950-f49d-11e9-b8d9-a9be9ceefc16-20191022072818277_landscape.jpg", "Movie"));
        sliderArrayList.add(new Slider("Apon Manush ", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8a129f20-cd64-11e8-bebb-c1d51eb8f63b-20200305120749624_landscape.jpg", "Movie"));
        sliderArrayList.add(new Slider("Super Hero", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/6fd7c360-56a3-11e9-9ef7-a14cceff6227-20190915070342617_landscape.jpg", "Movie"));
        sliderArrayList.add(new Slider("Mayabini", "https://live-technologies-vod.akamaized.net/cinematic/assets/preview/8492d950-f49d-11e9-b8d9-a9be9ceefc16-20191022072818277_landscape.jpg", "Movie"));

        return sliderArrayList;
    }
}
