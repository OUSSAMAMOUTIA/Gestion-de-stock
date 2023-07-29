package com.example.gestion_de_stock.service.impl;

import com.example.gestion_de_stock.service.FlickrService;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

public class FlickrServiceImpl implements FlickrService {
    @Value("${flickr.apiKey}")
    private String apiKey;

    @Value("${flickr.apiSecret}")
    private String apiSecret;

    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

    private Flickr flickr;

    public FlickrServiceImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    @SneakyThrows
    public String savePhoto(InputStream photo, String title) {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(title);

        String photoId = flickr.getUploader().upload(photo, uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }


}
