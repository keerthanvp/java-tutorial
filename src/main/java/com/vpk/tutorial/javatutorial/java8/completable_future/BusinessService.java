package com.vpk.tutorial.javatutorial.java8.completable_future;

import java.util.concurrent.CompletableFuture;

public class BusinessService {

    private final ImageService imageService;

    public BusinessService() {
        this.imageService = new ImageServiceImpl();
    }

    public void uploadImage(){
        imageService.uploadImage();
    }

    public String uploadThumbnail(){
        return imageService.uploadThumbnail();
    }
}
