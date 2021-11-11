package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.categories.Cognac;
import com.eugene.Alcoholic_Library.repository.CognacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CognacServiceImpl implements CognacService {

    private final CognacRepo cognacRepo;

    @Autowired
    public CognacServiceImpl(CognacRepo cognacRepo) {
        this.cognacRepo = cognacRepo;
    }


    @Override
    public List<Cognac> getAllCognacs() {
        return cognacRepo.findAll();
    }
}
