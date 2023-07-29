package com.example.gestion_de_stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT)
@RestController
public class PhotoController {
    //    private StrategyPhotoContext strategyPhotoContext;
//
//    public PhotoController(StrategyPhotoContext strategyPhotoContext) {
//        this.strategyPhotoContext = strategyPhotoContext;
//    }
//    @Override
//    public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException {
//        return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
//    }
}
