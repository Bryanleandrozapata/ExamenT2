package com.examenT2.LP2_T2_Zapata_Bryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examenT2.LP2_T2_Zapata_Bryan.service.RubroService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("rubro")
@RequiredArgsConstructor
public class RubroController {

    private final RubroService rubroService;

    @GetMapping("listado")
    public String listado(Model model) {
        model.addAttribute("lstRubros", rubroService.getAll());
        return "rubro/listado";
    }
}