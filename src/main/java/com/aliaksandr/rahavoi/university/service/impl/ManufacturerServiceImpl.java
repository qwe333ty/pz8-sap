package com.aliaksandr.rahavoi.university.service.impl;

import com.aliaksandr.rahavoi.university.entity.Manufacturer;
import com.aliaksandr.rahavoi.university.repository.ManufacturerRepository;
import com.aliaksandr.rahavoi.university.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository repository;

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
