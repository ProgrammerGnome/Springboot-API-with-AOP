package com.jetbrains.kmark7.storages.clone.service;

import com.jetbrains.kmark7.storages.clone.model.Storage;
import org.springframework.data.repository.CrudRepository;

public interface StoragesRepository extends CrudRepository<Storage, Integer> {
}
