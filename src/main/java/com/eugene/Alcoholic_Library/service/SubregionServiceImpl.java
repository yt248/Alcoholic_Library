package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Subregion;
import com.eugene.Alcoholic_Library.repository.SubregionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubregionServiceImpl implements SubregionService {

    private final SubregionRepo subregionRepo;
    private final RegionService regionService;

    @Autowired
    public SubregionServiceImpl(SubregionRepo subregionRepo, RegionService regionService) {
        this.subregionRepo = subregionRepo;
        this.regionService = regionService;
    }


    @Override
    @Transactional
    public void create(Subregion subregion, Long idRegion) {
        Region region = regionService.getById(idRegion);
        subregion.setRegion(region);
        region.getSubregions().add(subregion);

        subregionRepo.save(subregion);
    }

    @Override
    public Subregion getById(Long id) {
        return subregionRepo.getById(id);
    }

    @Override
    @Transactional
    public void update(Long id, Subregion newSubregion, Long idRegion) {
        Region region = regionService.getById(idRegion);
        Subregion updateSubregion = getById(id);

        updateSubregion.getRegion().getSubregions().remove(getById(id));// Правильный ли это подход.

        updateSubregion.setName(newSubregion.getName());
        updateSubregion.setRegion(region);
        region.getSubregions().add(updateSubregion);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        subregionRepo.delete(getById(id));
    }

    @Override
    public List<Subregion> getAllSubregions() {
        return subregionRepo.findAll();
    }
}
