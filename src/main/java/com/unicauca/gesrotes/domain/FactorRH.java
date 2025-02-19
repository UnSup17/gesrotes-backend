package com.unicauca.gesrotes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Entity
@Table(schema = "ACADEMICO", name = "FACTORRH")
@Getter
@Setter
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "bloodTypeCache")
@Cacheable
public class FactorRH {
    @Id
    @Column(name = "OID")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String description;

    @OneToMany(mappedBy = "factorRh")
    @JsonBackReference
    private List<Tercero> terceros;
}
