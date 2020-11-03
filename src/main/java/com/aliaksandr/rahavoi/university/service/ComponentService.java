package com.aliaksandr.rahavoi.university.service;

import com.aliaksandr.rahavoi.university.entity.Component;

import java.util.List;

public interface ComponentService {

    List<Component> getAllComponents();

    Component save(Component component);

    boolean deleteById(Integer id);
}
