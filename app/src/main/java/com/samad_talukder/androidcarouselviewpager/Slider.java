package com.samad_talukder.androidcarouselviewpager;

public class Slider {

    private String title;
    private String slider_image_path;
    private String content_type;

    public Slider(String title, String slider_image_path, String content_type) {
        this.title = title;
        this.slider_image_path = slider_image_path;
        this.content_type = content_type;
    }

    public String getTitle() {
        return title;
    }

    public String getSlider_image_path() {
        return slider_image_path;
    }

    public String getContent_type() {
        return content_type;
    }
}
