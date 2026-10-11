package com.examenT2.LP2_T2_Zapata_Bryan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Zapata_Bryan.model.RubroZapataBryan;
import com.examenT2.LP2_T2_Zapata_Bryan.repository.RubroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroService {

    private final RubroRepository rubroRepository;

    public List<RubroZapataBryan> getAll() {
        return rubroRepository.findAll();
    }

    public RubroZapataBryan getOne(Integer id) {
        return rubroRepository.findById(id).orElse(null);
    }

    public RubroZapataBryan create(RubroZapataBryan rubro) {
        return rubroRepository.save(rubro);
    }

    public void delete(Integer id) {
        rubroRepository.deleteById(id);
    }
}