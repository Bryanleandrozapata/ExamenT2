package com.examenT2.LP2_T2_Zapata_Bryan.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter
@DynamicInsert
public class OrdenCompraZapataBryan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorZapataBryan proveedor;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "estado")
    private String estado;
}