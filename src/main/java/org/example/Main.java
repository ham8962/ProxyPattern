package org.example;

import java.util.ArrayList;

interface Thumbnail{
    void showTitle();
    void showPreview();
}

class RealThumbnail implements Thumbnail{
    private String title;
    private String movieUrl;

    public RealThumbnail(String _title, String _movieUrl){
        title = _title;
        movieUrl = _movieUrl;

        System.out.println(movieUrl + "로부터" + title + "의 영상 데이터 다운");
    }

    public void showTitle(){
        System.out.println("제목" + title);
    }
    public void showPreview(){
        System.out.println(title +"의 프리뷰 재생");
    }

}

class ProxyThumbnail implements Thumbnail{
    private String title;
    private String movieUrl;

    private RealThumbnail realThumbnail;

    public ProxyThumbnail(String _title, String _movieUrl){
        title = _title;
        movieUrl = _movieUrl;
    }
    public void showTitle(){
        System.out.println("제목" + title);
    }
    public void showPreview(){
        if(realThumbnail == null){
            realThumbnail = new RealThumbnail(title,movieUrl);
        }
        realThumbnail.showPreview();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Thumbnail> thumbnails = new ArrayList<>();

        thumbnails.add(new ProxyThumbnail("Git 강좌", "/git.mp4"));
        thumbnails.add(new ProxyThumbnail("Rest API란?", "/rest-api.mp4"));
        thumbnails.add(new ProxyThumbnail("도커 사용법", "/docker.mp4"));
        thumbnails.add(new ProxyThumbnail("객체지향 프로그래밍", "/oodp.mp4"));
        thumbnails.add(new ProxyThumbnail("블록체인의 원리", "/blockchain.mp4"));

        for (Thumbnail thumbnail : thumbnails){
            thumbnail.showTitle();
        }

        thumbnails.get(2).showPreview();
        thumbnails.get(2).showPreview();
        thumbnails.get(4).showPreview();
        thumbnails.get(4).showPreview();

    }
}