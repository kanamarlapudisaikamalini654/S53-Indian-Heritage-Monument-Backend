package com.heritage.india.service;

import com.heritage.india.entity.Monument;
import com.heritage.india.repository.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonumentService {
    @Autowired
    private MonumentRepository monumentRepository;

    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }

    public Monument addMonument(Monument monument) {
        return monumentRepository.save(monument);
    }
}