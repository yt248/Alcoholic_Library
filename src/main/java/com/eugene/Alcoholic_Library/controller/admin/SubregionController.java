package com.eugene.Alcoholic_Library.controller.admin;

import com.eugene.Alcoholic_Library.dto.RegionDTO;
import com.eugene.Alcoholic_Library.dto.SubregionAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.dto.SubregionDTO;
import com.eugene.Alcoholic_Library.dto.mappers.MapperRegion;
import com.eugene.Alcoholic_Library.dto.mappers.MapperSubregion;
import com.eugene.Alcoholic_Library.dto.mappers.MapperSubregionAddAndUpdate;
import com.eugene.Alcoholic_Library.service.RegionService;
import com.eugene.Alcoholic_Library.service.SubregionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/subregion")
public class SubregionController {

    private final SubregionService subregionService;
    private final RegionService regionService;

    @Autowired
    public SubregionController(SubregionService subregionService, RegionService regionService) {
        this.subregionService = subregionService;
        this.regionService = regionService;
    }


    @GetMapping()
    public String showAllSubregions(Model model) {
        List<SubregionDTO> subregionDTOList = subregionService.getAllSubregions().stream()
                .map(MapperSubregion::toDto).collect(Collectors.toList());

        model.addAttribute("subregionDTOList", subregionDTOList);
        return "subregion/index_subregion";
    }


    @GetMapping("/add")
    public String showCreatePage(Model model) {
        model.addAttribute("subregionAddAndUpdateDTO", new SubregionAddAndUpdateDTO());

        List<RegionDTO> regionDTOList = regionService.getAllRegions().stream()
                .map(MapperRegion::toDto).collect(Collectors.toList());
        model.addAttribute("regionDTOList", regionDTOList);
        return "subregion/add_subregion_page";
    }

    @PostMapping("/save")
    public String addSubregion(@ModelAttribute("subregionAddAndUpdateDTO") SubregionAddAndUpdateDTO subregionAddAndUpdateDTO) {
        subregionService.create(MapperSubregionAddAndUpdate.toEntity(subregionAddAndUpdateDTO), subregionAddAndUpdateDTO.getIdRegion());
        return "redirect:/subregion";
    }

    @GetMapping("/edit/{id}")
    public String showUpdatePage(@PathVariable("id") Long id, Model model) {
        SubregionAddAndUpdateDTO subregionAddAndUpdateDTO = MapperSubregionAddAndUpdate.toDto(subregionService.getById(id));
        model.addAttribute("subregionAddAndUpdateDTO", subregionAddAndUpdateDTO);

        List<RegionDTO> regionDTOList = regionService.getAllRegions().stream()
                .map(MapperRegion::toDto).collect(Collectors.toList());
        model.addAttribute("regionDTOList", regionDTOList);
        return "subregion/update_subregion_page";
    }

    @PatchMapping("/edit/{id}")
    public String updateSubregion(@PathVariable("id") Long id,
                                  @ModelAttribute("subregionAddAndUpdateDTO") SubregionAddAndUpdateDTO subregionAddAndUpdateDTO) {

        subregionService.update(id, MapperSubregionAddAndUpdate.toEntity(subregionAddAndUpdateDTO), subregionAddAndUpdateDTO.getIdRegion());
        return "redirect:/subregion";
    }




    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        subregionService.delete(id);
        return "redirect:/subregion";
    }
}
