package com.eugene.Alcoholic_Library.controller.admin;

import com.eugene.Alcoholic_Library.dto.ManufacturerDTO;
import com.eugene.Alcoholic_Library.dto.mappers.MapperManufacturer;
import com.eugene.Alcoholic_Library.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }


    @GetMapping()
    public String showManufacturerList(Model model) {
        List<ManufacturerDTO> manufacturerDTOList = manufacturerService.getAllManufacturers().stream()
                .map(MapperManufacturer::toDto).collect(Collectors.toList());

        model.addAttribute("manufacturerDTOList", manufacturerDTOList);

        return "manufacturer/index_manufacturer";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("manufacturerDTO", new ManufacturerDTO());
        return "manufacturer/add_form_manufacturer";
    }

    @PostMapping("/save")
    public String saveManufacturer(@ModelAttribute("manufacturerDTO") @Valid ManufacturerDTO manufacturerDTO,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "manufacturer/add_form_manufacturer";

        manufacturerService.create(MapperManufacturer.toEntity(manufacturerDTO));
        return "redirect:/manufacturer";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("manufacturerDTO", MapperManufacturer.toDto(manufacturerService.getById(id)));
        return "manufacturer/update_form_manufacturer";
    }


    @PatchMapping("/edit/{id}")
    public String editManufacturer(@PathVariable("id") Long id, @ModelAttribute("manufacturerDTO") @Valid ManufacturerDTO manufacturerDTO,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "manufacturer/update_form_manufacturer";

        manufacturerService.update(id, MapperManufacturer.toEntity(manufacturerDTO));
        return "redirect:/manufacturer";
    }


    @GetMapping("/{id}")
    public String showInfoManufacturerById(@PathVariable("id") Long id, Model model) {
        ManufacturerDTO manufacturerDTO = MapperManufacturer.toDto(manufacturerService.getById(id));
        model.addAttribute("manufacturerDTO", manufacturerDTO);
        return "manufacturer/brands_manufacturer";
    }



}
