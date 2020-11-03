package com.aliaksandr.rahavoi.university.controller;

import com.aliaksandr.rahavoi.university.entity.Component;
import com.aliaksandr.rahavoi.university.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/component")
public class ComponentController {

    private final ComponentService componentService;

    @GetMapping
    public ResponseEntity<List<Component>> getAllComponents() {
        final List<Component> components = componentService.getAllComponents();
        if (CollectionUtils.isEmpty(components)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(components);
    }

    @PostMapping
    public ResponseEntity<Component> createComponent(@RequestBody Component component) {
        final Component savedEntity = componentService.save(component);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteComponent(@PathVariable("id") Integer id) {
        final boolean deleted = componentService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
