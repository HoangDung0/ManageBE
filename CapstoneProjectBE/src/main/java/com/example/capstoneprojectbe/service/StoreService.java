package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.StoreDto;
import com.example.capstoneprojectbe.model.Store;
import com.example.capstoneprojectbe.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public boolean isExisted(String id) {
        return storeRepository.existsById(id);
    }

    public void createStore(StoreDto dto) {
        Store store = new Store();
        store.setStoreID(dto.getStoreID());
        store.setStoreName(dto.getStoreName());
        store.setAddress(dto.getAddress());
        storeRepository.save(store);
    }

    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public void update(StoreDto dto) {
        Store store = new Store();
        store.setStoreID(dto.getStoreID());
        store.setStoreName(dto.getStoreName());
        store.setAddress(dto.getAddress());
        storeRepository.save(store);
    }

    public void delete(String id) {
        storeRepository.deleteById(id);
    }

    public Store getById(String id) {
        return storeRepository.getById(id);
    }
}
