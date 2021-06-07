package com.vpk.tutorial.javatutorial.java8.completable_future;

public class ImageServiceImpl implements ImageService {
    @Override
    public void uploadImage() {
        try {
            System.out.println("Uploading Image: "+Thread.currentThread().getId());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void downloadImage() {

    }

    @Override
    public String uploadThumbnail() {
        try {
            System.out.println("Uploading Thumbnail: "+Thread.currentThread().getId());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return "http://localhost:8080/thumbnail1";
    }
}
