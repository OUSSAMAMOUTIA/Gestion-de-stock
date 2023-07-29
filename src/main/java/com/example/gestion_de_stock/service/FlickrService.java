package com.example.gestion_de_stock.service;

import java.io.InputStream;

public interface FlickrService {
    String savePhoto(InputStream photo, String title);

}
