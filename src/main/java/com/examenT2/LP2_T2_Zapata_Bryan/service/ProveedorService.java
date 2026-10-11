package com.examenT2.LP2_T2_Zapata_Bryan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Zapata_Bryan.model.ProveedorZapataBryan;
import com.examenT2.LP2_T2_Zapata_Bryan.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<ProveedorZapataBryan> getAll() {
        return proveedorRepository.findAll();
    }

    public ProveedorZapataBryan getOne(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public ProveedorZapataBryan create(ProveedorZapataBryan proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void delete(Integer id) {
        proveedorRepository.deleteById(id);
    }
}