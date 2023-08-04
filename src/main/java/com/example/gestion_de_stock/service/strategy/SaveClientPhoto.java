package com.example.gestion_de_stock.service.strategy;

import com.example.gestion_de_stock.dto.ClientDto;
import com.example.gestion_de_stock.exception.ErrorCodes;
import com.example.gestion_de_stock.exception.InvalidOperationException;
import com.example.gestion_de_stock.entity.Client;
import com.example.gestion_de_stock.service.ClientService;
import com.example.gestion_de_stock.service.FlickrService;
import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("clientStrategy")
@Slf4j
public class SaveClientPhoto implements Strategy<ClientDto> {

    private FlickrService flickrService;
    private ClientService clientService;

    public SaveClientPhoto(FlickrService flickrService, ClientService clientService) {
        this.flickrService = flickrService;
        this.clientService = clientService;
    }

    @Override
    public ClientDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        ClientDto client = clientService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo du client", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        client.setPhoto(urlPhoto);
        return clientService.save(client);
    }
}
