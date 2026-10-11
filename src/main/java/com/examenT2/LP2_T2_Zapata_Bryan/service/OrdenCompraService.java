package com.examenT2.LP2_T2_Zapata_Bryan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Zapata_Bryan.model.OrdenCompraZapataBryan;
import com.examenT2.LP2_T2_Zapata_Bryan.repository.OrdenCompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    public List<OrdenCompraZapataBryan> getAll() {
        return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
    }

    public OrdenCompraZapataBryan getOne(Integer nroOrden) {
        return ordenCompraRepository.findById(nroOrden).orElse(null);
    }

    public OrdenCompraZapataBryan create(OrdenCompraZapataBryan orden) {
        return ordenCompraRepository.save(orden);
    }

    public void delete(Integer nroOrden) {
        ordenCompraRepository.deleteById(nroOrden);
    }
}