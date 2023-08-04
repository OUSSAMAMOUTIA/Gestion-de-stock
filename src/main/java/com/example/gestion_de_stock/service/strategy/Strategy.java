package com.example.gestion_de_stock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;

public interface Strategy<T> {

    T savePhoto(Integer id, InputStream photo, String titre) throws FlickrException;

}
