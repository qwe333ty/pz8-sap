package com.aliaksandr.rahavoi.university.controller;

import com.aliaksandr.rahavoi.university.entity.Manufacturer;
import com.aliaksandr.rahavoi.university.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturers() {
        final List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        if (CollectionUtils.isEmpty(manufacturers)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(manufacturers);
    }
}
