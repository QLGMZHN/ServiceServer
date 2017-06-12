package com.example.king.movies_qgmzhn;

/**
 * Created by king on 2017/6/11.
 */
public class movieInfo {
    public movieInfo(String movie_name,String director, String duration, String score,String brief, String price,String image_url){
        this.movie_name = movie_name;
        this.director = director;
        this.duration = duration;
        this.score = score;
        this.brief = brief;
        this.price = price;
        this.image_url = image_url;
    }
        String movie_name;
        //导演名字
        String director;
        //时长
        String duration;
        //评分
        String score;
        //简介
        String brief;
        //价格
        String price;
        //图片地址
        String image_url;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String name) {
        this.movie_name = name;
    }
    public String getDirector() {
        return director;
    }

    public void setDirector(String name) {
        this.director = name;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String name) {
        this.duration = name;
    }
    //score
    public String getScore() {
        return score;
    }

    public void setScore(String name) {
        this.score = name;
    }
    //brief
    public String getBrief() {
        return brief;
    }

    public void setBrief(String name) {
        this.brief = name;
    }
    //price
    public String getPrice() {
        return price;
    }

    public void setPrice(String name) {
        this.price = name;
    }
    //image_url
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String name) {
        this.image_url = name;
    }
}
