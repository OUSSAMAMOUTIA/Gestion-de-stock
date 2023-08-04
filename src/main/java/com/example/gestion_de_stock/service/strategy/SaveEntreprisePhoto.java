package com.example.gestion_de_stock.service.strategy;

import com.example.gestion_de_stock.dto.EntrepriseDto;
import com.example.gestion_de_stock.exception.ErrorCodes;
import com.example.gestion_de_stock.exception.InvalidOperationException;
import com.example.gestion_de_stock.service.EntrepriseService;
import com.example.gestion_de_stock.service.FlickrService;
import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("entrepriseStrategy")
@Slf4j
public class SaveEntreprisePhoto implements Strategy<EntrepriseDto> {

    private FlickrService flickrService;
    private EntrepriseService entrepriseService;

    @Autowired
    public SaveEntreprisePhoto(FlickrService flickrService, EntrepriseService entrepriseService) {
        this.flickrService = flickrService;
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        EntrepriseDto entreprise = entrepriseService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'entreprise", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        entreprise.setPhoto(urlPhoto);
        return entrepriseService.save(entreprise);
    }
}
