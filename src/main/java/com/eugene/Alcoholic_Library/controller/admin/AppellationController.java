package com.eugene.Alcoholic_Library.controller.admin;

import com.eugene.Alcoholic_Library.dto.AppellationAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.dto.AppellationDTO;
import com.eugene.Alcoholic_Library.dto.RegionDTO;
import com.eugene.Alcoholic_Library.dto.SubregionAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.dto.mappers.MapperAppellation;
import com.eugene.Alcoholic_Library.dto.mappers.MapperAppellationAddAndUpdate;
import com.eugene.Alcoholic_Library.dto.mappers.MapperRegion;
import com.eugene.Alcoholic_Library.dto.mappers.MapperSubregionAddAndUpdate;
import com.eugene.Alcoholic_Library.service.AppellationService;
import com.eugene.Alcoholic_Library.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("appellation")
public class AppellationController {

    private final AppellationService appellationService;
    private final RegionService regionService;

    @Autowired
    public AppellationController(AppellationService appellationService, RegionService regionService) {
        this.appellationService = appellationService;
        this.regionService = regionService;
    }

    @GetMapping()
    public String showAllAppellations(Model model) {
        List<AppellationDTO> appellationDTOList = appellationService.getAllAppellations().stream()
                .map(MapperAppellation::toDto).collect(Collectors.toList());
        model.addAttribute("appellationDTOList", appellationDTOList);

        return "appellation/index_appellation";
    }

    @GetMapping("/add")
    public String showCreatePage(Model model) {
        List<RegionDTO> regionDTOList = regionService.getAllRegions().stream()
                .map(MapperRegion::toDto).collect(Collectors.toList());

        model.addAttribute("regionDTOList", regionDTOList);
        model.addAttribute("appellationAddAndUpdateDTO", new AppellationAddAndUpdateDTO());

        return "appellation/add_appellation_page";
    }

    @PostMapping("/save")
    public String addSubregion(@ModelAttribute("appellationAddAndUpdateDTO") AppellationAddAndUpdateDTO appellationAddAndUpdateDTO) {
        appellationService.create(MapperAppellationAddAndUpdate.toEntity(appellationAddAndUpdateDTO), appellationAddAndUpdateDTO.getIdRegion());
        return "redirect:/appellation";
    }


    @GetMapping("/edit/{id}")
    public String showUpdatePage(@PathVariable("id") Long id, Model model) {
        AppellationAddAndUpdateDTO appellationAddAndUpdateDTO = MapperAppellationAddAndUpdate.toDto(appellationService.getById(id));
        model.addAttribute("appellationAddAndUpdateDTO", appellationAddAndUpdateDTO);

        List<RegionDTO> regionDTOList = regionService.getAllRegions().stream()
                .map(MapperRegion::toDto).collect(Collectors.toList());
        model.addAttribute("regionDTOList", regionDTOList);
        return "appellation/update_appellation_page";
    }

    @PatchMapping("/edit/{id}")
    public String updateSubregion(@PathVariable("id") Long id,
                                  @ModelAttribute("appellationAddAndUpdateDTO") AppellationAddAndUpdateDTO appellationAddAndUpdateDTO) {

        appellationService.update(id, MapperAppellationAddAndUpdate.toEntity(appellationAddAndUpdateDTO), appellationAddAndUpdateDTO.getIdRegion());
        return "redirect:/appellation";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        appellationService.delete(id);
        return "redirect:/appellation";
    }
}
