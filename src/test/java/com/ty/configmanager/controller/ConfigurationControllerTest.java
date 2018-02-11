package com.ty.configmanager.controller;

import com.ty.configmanager.dto.ConfigurationDto;
import com.ty.configmanager.model.Configuration;
import com.ty.configmanager.service.ConfigurationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConfigurationControllerTest {

    @InjectMocks
    private ConfigurationController configurationController;

    @Mock
    private ConfigurationService configurationService;

    @Test
    public void shouldCreateConfiguration() {
        ConfigurationDto configurationDto = ConfigurationDto.builder()
                .name("name")
                .build();

        Configuration configuration = new Configuration();
        when(configurationService.createConfiguration(configurationDto)).thenReturn(configuration);

        ResponseEntity<Configuration> result = configurationController.createConfiguration(configurationDto);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(result.getBody(), equalTo(configuration));

        verify(configurationService).createConfiguration(configurationDto);
    }


    @Test
    public void shouldUpdateConfiguration() {
        ConfigurationDto configurationDto = ConfigurationDto.builder()
                .name("name")
                .build();

        Configuration configuration = new Configuration();
        when(configurationService.updateConfiguration("id1", configurationDto)).thenReturn(configuration);

        ResponseEntity<Configuration> result = configurationController.updateConfiguration("id1", configurationDto);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(result.getBody(), equalTo(configuration));

        verify(configurationService).updateConfiguration("id1", configurationDto);
    }

    @Test
    public void shouldDeleteConfiguration() {
        ResponseEntity<Void> result = configurationController.deleteConfiguration("id1");

        assertThat(result.getStatusCode(), equalTo(HttpStatus.NO_CONTENT));

        verify(configurationService).deleteConfiguration("id1");
    }

}