package com.aliaksandr.rahavoi.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "component_characteristic")
public class ComponentCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "component_characteristic_seq")
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name = "name")
    private String name;

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "str_value")
    private String strValue;

    @Column(name = "unit")
    private String unit;
}
