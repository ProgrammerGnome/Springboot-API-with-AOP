package com.jetbrains.kmark7.storages.clone.controller;

import com.jetbrains.kmark7.storages.clone.model.Storage;
import com.jetbrains.kmark7.storages.clone.service.StoragesService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DeleteController {

    private final StoragesService storagesService;

    public DeleteController(StoragesService storagesService) {
        this.storagesService = storagesService;
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<byte[]> delete(@PathVariable Integer id) {
        Storage storage = storagesService.remove(id);
        if (storage == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A keresett tétel lehet azért " +
                "nem található, mert már törölte azt.");


        byte[] data = storage.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(storage.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(storage.getFileName())
                .build();
        headers.setContentDisposition(build);


        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}