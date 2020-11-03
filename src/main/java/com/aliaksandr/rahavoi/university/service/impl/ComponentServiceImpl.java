package com.aliaksandr.rahavoi.university.service.impl;

import com.aliaksandr.rahavoi.university.entity.Component;
import com.aliaksandr.rahavoi.university.repository.ComponentRepository;
import com.aliaksandr.rahavoi.university.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Override
    public List<Component> getAllComponents() {
        return StreamSupport
                .stream(componentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Component save(Component component) {
        return componentRepository.save(component);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean deleteById(Integer id) {
        final boolean exists = componentRepository.existsById(id);
        if (exists) {
            componentRepository.deleteById(id);
        }
        return exists;
    }
}
