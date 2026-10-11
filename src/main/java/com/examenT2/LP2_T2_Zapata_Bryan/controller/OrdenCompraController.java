package com.examenT2.LP2_T2_Zapata_Bryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;

import com.examenT2.LP2_T2_Zapata_Bryan.model.OrdenCompraZapataBryan;
import com.examenT2.LP2_T2_Zapata_Bryan.service.OrdenCompraService;
import com.examenT2.LP2_T2_Zapata_Bryan.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("orden-compra")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final ProveedorService proveedorService;

    @GetMapping("listado")
    public String listado(Model model) {
        model.addAttribute("lstOrdenes", ordenCompraService.getAll());
        return "listadoZapataBryan";
    }

    @GetMapping("nuevo")
    public String nuevo(Model model) {
        model.addAttribute("lstProveedores", proveedorService.getAll());
        model.addAttribute("orden", new OrdenCompraZapataBryan());

        return "nuevoZapataBryan";
    }
    
    @GetMapping("edicion/{id}")
    public String edicion(@PathVariable Integer id, Model model,
                          RedirectAttributes flash) {
        var orden = ordenCompraService.getOne(id);

        if (orden == null) {
            flash.addFlashAttribute("mensaje",
                    "No se encontró la orden de compra.");
            return "redirect:/orden-compra/listado";
        }

        model.addAttribute("orden", orden);
        model.addAttribute("lstProveedores", proveedorService.getAll());

        return "edicionZapataBryan";
    }
    

    @PostMapping("registrar")
    public String registrar(
            @RequestParam Integer idProveedor,
            OrdenCompraZapataBryan orden,
            RedirectAttributes flash) {

        var proveedor = proveedorService.getOne(idProveedor);

        if (proveedor == null) {
            flash.addFlashAttribute("mensaje",
                    "No se encontró el proveedor seleccionado.");

            return "redirect:/orden-compra/nuevo";
        }

        orden.setProveedor(proveedor);
        orden.setEstado("P");

        var registrado = ordenCompraService.create(orden);

        flash.addFlashAttribute("mensaje",
                "Orden de compra Nro. " + registrado.getNroOrden()
                + " registrada.");

        return "redirect:/orden-compra/listado";
    }
    
    @PostMapping("actualizar")
    public String actualizar(
            @RequestParam Integer idProveedor,
            OrdenCompraZapataBryan orden,
            RedirectAttributes flash) {

        var proveedor = proveedorService.getOne(idProveedor);

        if (proveedor == null) {
            flash.addFlashAttribute("mensaje",
                    "No se encontró el proveedor seleccionado.");
            return "redirect:/orden-compra/listado";
        }

        orden.setProveedor(proveedor);
        ordenCompraService.create(orden);

        flash.addFlashAttribute("mensaje",
                "Orden de compra Nro. " + orden.getNroOrden()
                + " actualizada.");

        return "redirect:/orden-compra/listado";
    }
}