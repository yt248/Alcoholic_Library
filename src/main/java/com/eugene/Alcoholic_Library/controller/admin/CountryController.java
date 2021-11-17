package com.eugene.Alcoholic_Library.controller.admin;

import com.eugene.Alcoholic_Library.dto.CountryDTO;
import com.eugene.Alcoholic_Library.dto.RegionDTO;
import com.eugene.Alcoholic_Library.dto.mappers.MapperCountry;
import com.eugene.Alcoholic_Library.dto.mappers.MapperRegion;
import com.eugene.Alcoholic_Library.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping()
    public String showCountryList(Model model) {
        List<CountryDTO> countryDTOList = countryService.getAllCountries().stream()
                .map(MapperCountry::toDto).collect(Collectors.toList());

        model.addAttribute("countryDTOList", countryDTOList);
        return "country/index_country";
    }

    @GetMapping("/add")
    public String showAddCountryPage(Model model) {
        model.addAttribute("countryDTO", new CountryDTO());
        return "country/add_country_page";
    }

    @PostMapping("/save")
    public String addCountry(@ModelAttribute("countryDTO") @Valid CountryDTO countryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "country/add_country_page";

        countryService.create(MapperCountry.toEntity(countryDTO));
        return "redirect:/country";
    }


    @GetMapping("/{id}")
    public String showInfoByIdPage(@PathVariable("id") Long id, Model model) {
        CountryDTO countryDTO = MapperCountry.toDto(countryService.getById(id));
        model.addAttribute("countryDTO", countryDTO);
        return "country/regions_country";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateCountryPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("countryDTO", MapperCountry.toDto(countryService.getById(id)));
        return "country/update_country_page";
    }

    @PatchMapping("/edit/{id}")
    public String updateCountry(@PathVariable("id") Long id, @ModelAttribute("countryDTO") @Valid CountryDTO countryDTO,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "country/update_country_page";


        countryService.update(id, MapperCountry.toEntity(countryDTO));
        return "redirect:/country";
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        countryService.delete(id);
        return "redirect:/country";
    }
}

