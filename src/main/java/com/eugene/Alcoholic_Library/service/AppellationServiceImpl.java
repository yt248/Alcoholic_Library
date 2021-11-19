package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Appellation;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;
import com.eugene.Alcoholic_Library.repository.AppellationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppellationServiceImpl implements AppellationService {

    private final AppellationRepo appellationRepo;
    private final RegionService regionService;

    @Autowired
    public AppellationServiceImpl(AppellationRepo appellationRepo, RegionService regionService) {
        this.appellationRepo = appellationRepo;
        this.regionService = regionService;
    }

    @Override
    @Transactional
    public void create(Appellation appellation, Long idRegion) {
        Region region = regionService.getById(idRegion);
        appellation.setRegion(region);
        region.getAppellations().add(appellation);

        appellationRepo.save(appellation);

    }

    @Override
    @Transactional
    public void update(Long id, Appellation newAppellation, Long idRegion) {
        Region region = regionService.getById(idRegion);
        Appellation updateAppellation = getById(id);

        updateAppellation.getRegion().getAppellations().remove(getById(id));

        updateAppellation.setName(newAppellation.getName());
        updateAppellation.setRegion(region);

        appellationRepo.save(updateAppellation);
    }

    @Override
    public Appellation getById(Long id) {
        return appellationRepo.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        appellationRepo.delete(getById(id));
    }

    @Override
    public List<Appellation> getAllAppellations() {
        return appellationRepo.findAll();
    }
}
