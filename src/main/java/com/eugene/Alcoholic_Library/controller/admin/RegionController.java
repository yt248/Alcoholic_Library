package com.eugene.Alcoholic_Library.controller.admin;

import com.eugene.Alcoholic_Library.dto.CountryDTO;
import com.eugene.Alcoholic_Library.dto.RegionAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.dto.RegionDTO;
import com.eugene.Alcoholic_Library.dto.mappers.MapperRegionAddAndUpdate;
import com.eugene.Alcoholic_Library.dto.mappers.MapperCountry;
import com.eugene.Alcoholic_Library.dto.mappers.MapperRegion;
import com.eugene.Alcoholic_Library.service.CountryService;
import com.eugene.Alcoholic_Library.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("region")
public class RegionController {

    private final RegionService regionService;
    private final CountryService countryService;

    @Autowired
    public RegionController(RegionService regionService, CountryService countryService) {
        this.regionService = regionService;
        this.countryService = countryService;
    }


    @GetMapping()
    public String showRegionsList(Model model) {
        List<RegionDTO> regionDTOList = regionService.getAllRegions().stream()
                .map(MapperRegion::toDto).collect(Collectors.toList());

        model.addAttribute("regionDTOList", regionDTOList);

        return "region/index_region";
    }

    @GetMapping("/add")
    public String showCreatePage(Model model) {
        model.addAttribute("regionAddDTO", new RegionAddAndUpdateDTO());

        List<CountryDTO> countryDTOList = countryService.getAllCountries().stream()
                .map(MapperCountry::toDto).collect(Collectors.toList());

        model.addAttribute("countryDTOList", countryDTOList);

        return "region/add_region_page";
    }

    @PostMapping("/save")
    public String addRegion(@ModelAttribute("regionAddDTO") RegionAddAndUpdateDTO regionAddAndUpdateDTO) {
        regionService.create(MapperRegionAddAndUpdate.toEntity(regionAddAndUpdateDTO), regionAddAndUpdateDTO.getIdCountry());
        return "redirect:/region";
    }

    @GetMapping("/edit/{id}")
    public String showUpdatePage(@PathVariable("id") Long id, Model model) {
        List<CountryDTO> countryDTOList = countryService.getAllCountries().stream()
                .map(MapperCountry::toDto).collect(Collectors.toList());

        model.addAttribute("countryDTOList", countryDTOList);

        RegionAddAndUpdateDTO regionAddAndUpdateDTO = MapperRegionAddAndUpdate.toDto(regionService.getById(id));
        model.addAttribute("regionAndCountryIdDTO", regionAddAndUpdateDTO);
        return "region/update_region_page";
    }

    @PatchMapping("/edit")
    public String updateRegion(@ModelAttribute("regionAndCountryIdDTO") RegionAddAndUpdateDTO regionAddAndUpdateDTO) {
        regionService.update(regionAddAndUpdateDTO.getId(),
                MapperRegionAddAndUpdate.toEntity(regionAddAndUpdateDTO), regionAddAndUpdateDTO.getIdCountry());

        return "redirect:/region";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        regionService.delete(id);
        return "redirect:/region";
    }


}
