package com.eugene.Alcoholic_Library.controller;


import com.eugene.Alcoholic_Library.model.categories.Cognac;
import com.eugene.Alcoholic_Library.service.CognacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cognac")
public class CognacController {

    private final CognacService cognacService;

    @Autowired
    public CognacController(CognacService cognacService) {
        this.cognacService = cognacService;
    }


    @GetMapping
    public String getAllCognacs(Model model){
        List<Cognac> allCognacs = cognacService.getAllCognacs();
        model.addAttribute("allCognacs",allCognacs);

        return "cognac/index_cognac";
    }


}
