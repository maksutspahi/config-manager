package com.ty.configmanager.controller;

import com.ty.configmanager.dto.ConfigurationDto;
import com.ty.configmanager.model.Configuration;
import com.ty.configmanager.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @PostMapping("/api/create")
    public ResponseEntity<Configuration> createConfiguration(@RequestBody ConfigurationDto configurationDto) {
        Configuration configuration = configurationService.createConfiguration(configurationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(configuration);
    }

    @PostMapping("/api/update/{id}")
    public ResponseEntity<Configuration> updateConfiguration(@PathVariable String id, @RequestBody ConfigurationDto configurationDto) {
        Configuration configuration = configurationService.updateConfiguration(id, configurationDto);
        return ResponseEntity.ok(configuration);
    }

    @PostMapping("/api/delete/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable String id) {
        configurationService.deleteConfiguration(id);
        return ResponseEntity.noContent().build();
    }


}
