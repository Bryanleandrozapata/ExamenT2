
package com.examenT2.LP2_T2_Zapata_Bryan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.LP2_T2_Zapata_Bryan.model.OrdenCompraZapataBryan;

public interface OrdenCompraRepository
        extends JpaRepository<OrdenCompraZapataBryan, Integer> {

    List<OrdenCompraZapataBryan> findAllByOrderByNroOrdenDesc();

}