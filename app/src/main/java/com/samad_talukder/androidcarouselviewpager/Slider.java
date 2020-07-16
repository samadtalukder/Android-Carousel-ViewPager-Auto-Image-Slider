package com.samad_talukder.androidcarouselviewpager;

public class Slider {
    private String action_type;
    private String action_type_id;
    private String action_type_link;
    private String content_image_path;
    private String intro;
    private String publish_date;
    private String slider_image_path;
    private String sort_order;
    private String title;



    public Slider(String str2, String str4) {
        this.title = str2;
        this.slider_image_path = str4;
    }

    public String getActionType() {
        return this.action_type;
    }

    public String getActionTypeId() {
        return this.action_type_id;
    }

    public String getSliderImagePath() {
        return this.slider_image_path;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getContent_image_path() {
        return this.content_image_path;
    }

    public String getPublish_date() {
        return this.publish_date;
    }

    public String getSort_order() {
        return this.sort_order;
    }

    public String getActionTypeLink() {
        return this.action_type_link;
    }

    public String toString() {
        return "Slider{action_type='" + this.action_type + '\'' + ", action_type_id='" + this.action_type_id + '\'' + ", slider_image_path='" + this.slider_image_path + '\'' + ", title='" + this.title + '\'' + ", intro='" + this.intro + '\'' + ", content_image_path='" + this.content_image_path + '\'' + ", publish_date='" + this.publish_date + '\'' + ", sort_order='" + this.sort_order + '\'' + ", action_type_link='" + this.action_type_link + '\'' + '}';
    }
}
