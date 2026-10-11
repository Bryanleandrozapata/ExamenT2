package com.examenT2.LP2_T2_Zapata_Bryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examenT2.LP2_T2_Zapata_Bryan.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("proveedor")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping("listado")
    public String listado(Model model) {
        model.addAttribute("lstProveedores", proveedorService.getAll());
        return "proveedor/listado";
    }
}