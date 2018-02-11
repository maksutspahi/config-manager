package com.ty.configmanager.service;

import com.ty.configmanager.dto.ConfigurationDto;
import com.ty.configmanager.model.Configuration;
import com.ty.configmanager.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    public List<Configuration> findAll() {
        return configurationRepository.findAll();
    }

    public void deleteConfiguration(String id) {
        configurationRepository.delete(id);
    }

    public Configuration createConfiguration(ConfigurationDto configurationDto) {
        Configuration configuration = new Configuration();
        return saveConfiguration(configurationDto, configuration);
    }

    public Configuration updateConfiguration(String id, ConfigurationDto configurationDto) {
        Configuration configuration = configurationRepository.findOne(id);
        return saveConfiguration(configurationDto, configuration);
    }

    private Configuration saveConfiguration(ConfigurationDto configurationDto, Configuration configuration) {
        configuration.setActive(configurationDto.isActive());
        configuration.setApplicationName(configurationDto.getApplicationName());
        configuration.setName(configurationDto.getName());
        configuration.setValue(configurationDto.getValue());
        configuration.setType(configurationDto.getType());
        return configurationRepository.save(configuration);
    }

}
