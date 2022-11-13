package com.jetbrains.kmark7.storages.clone.controller;

import com.jetbrains.kmark7.storages.clone.model.Storage;
import com.jetbrains.kmark7.storages.clone.service.StoragesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class StoragesController {

    private final StoragesService storagesService;

    public StoragesController(StoragesService storagesService) {
        this.storagesService = storagesService;
    }

    @GetMapping("/storages")
    public Iterable<Storage> get()
    {
        return storagesService.get();
    }

    @GetMapping("/storages/{id}")
    public Storage get(@PathVariable Integer id) {
        Storage storage = storagesService.get(id);
        if (storage == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return storage;
    }

    @DeleteMapping("/storages/{id}")
    public void delete(@PathVariable Integer id) {
        storagesService.remove(id);
    }

    @PostMapping("/storages")
    public Storage create(@RequestPart("data") MultipartFile file) throws IOException {
        return storagesService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
