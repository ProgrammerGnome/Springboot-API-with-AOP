package com.jetbrains.kmark7.storages.clone.service;

import com.jetbrains.kmark7.storages.clone.model.Storage;
import org.springframework.stereotype.Service;

@Service
public class StoragesService {

    public Storage save(String fileName, String contentType, byte[] data) {
        Storage storage = new Storage();
        storage.setContentType(contentType);
        storage.setFileName(fileName);
        storage.setData(data);
        StoragesRepository.save(storage);
        return storage;
    }

    private final StoragesRepository StoragesRepository;

    public StoragesService(StoragesRepository photozRepository) {
        this.StoragesRepository = photozRepository;
    }

    public Iterable<Storage> get() {
        return StoragesRepository.findAll();
    }

    public Storage get(Integer id) {
        return StoragesRepository.findById(id).orElse(null);
    }

    public Storage remove(Integer id) {
        StoragesRepository.deleteById(id);
        return null;
    }
}
