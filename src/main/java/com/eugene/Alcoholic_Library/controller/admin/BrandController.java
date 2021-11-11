package com.eugene.Alcoholic_Library.controller.admin;

import com.eugene.Alcoholic_Library.dto.BrandDTO;
import com.eugene.Alcoholic_Library.dto.mappers.MapperBrand;
import com.eugene.Alcoholic_Library.dto.mappers.MapperManufacturer;
import com.eugene.Alcoholic_Library.service.BrandService;
import com.eugene.Alcoholic_Library.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("brand")
public class BrandController {


    private final BrandService brandService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public BrandController(BrandService brandService, ManufacturerService manufacturerService) {
        this.brandService = brandService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String showBrandList(Model model) {
        List<BrandDTO> brandDTOList = brandService.getAllBrands()
                .stream().map(MapperBrand::toDto).collect(Collectors.toList());
        model.addAttribute("brandDTOList", brandDTOList);

        return "brand/index_brand";
    }


    @GetMapping("/add/manufacturer/{id}")
    public String showAddBrandToManufacturerForm(@PathVariable("id") Long id, Model model) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setManufacturerDTO(MapperManufacturer.toDto(manufacturerService.getById(id)));
        model.addAttribute("brandDTO", brandDTO);

        return "brand/add_brand_to_manufacturer";
    }

    @PostMapping("/save")
    public String addBrandToManufacturer(@ModelAttribute("brandDTO") BrandDTO brandDTO) {
        brandService.create(MapperBrand.toEntity(brandDTO), brandDTO.getManufacturerDTO().getId());
        return "redirect:/brand";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("brandDTO", MapperBrand.toDto(brandService.getById(id)));
        return "brand/update_form_brand";
    }

    @PatchMapping("/edit/{id}")
    public String updateBrand(@PathVariable Long id, @ModelAttribute("brandDTO") BrandDTO brandDTO) {
        brandService.update(id, MapperBrand.toEntity(brandDTO));
        return "redirect:/brand";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {
        brandService.delete(id);

        return "redirect:/brand";
    }

}
