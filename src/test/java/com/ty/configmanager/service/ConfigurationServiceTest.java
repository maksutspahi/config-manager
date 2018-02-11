package com.ty.configmanager.service;

import com.ty.configmanager.dto.ConfigurationDto;
import com.ty.configmanager.model.Configuration;
import com.ty.configmanager.model.Type;
import com.ty.configmanager.repository.ConfigurationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConfigurationServiceTest {

    @InjectMocks
    private ConfigurationService configurationService;

    @Mock
    private ConfigurationRepository configurationRepository;

    @Test
    public void shouldDeleteConfiguration() {
        configurationService.deleteConfiguration("id");

        verify(configurationRepository).delete("id");
    }

    @Test
    public void shouldCreateConfiguration() {
        ConfigurationDto configurationDto = ConfigurationDto.builder()
                .name("name")
                .value("val")
                .applicationName("app")
                .type(Type.STRING)
                .build();

        configurationService.createConfiguration(configurationDto);


        ArgumentCaptor<Configuration> captor = ArgumentCaptor.forClass(Configuration.class);
        verify(configurationRepository).save(captor.capture());

        Configuration savedConfig = captor.getValue();
        assertThat(savedConfig.getId(), nullValue());
        assertThat(savedConfig.getName(), equalTo("name"));
        assertThat(savedConfig.getValue(), equalTo("val"));
        assertThat(savedConfig.getApplicationName(), equalTo("app"));
        assertThat(savedConfig.getType(), equalTo(Type.STRING));
    }

    @Test
    public void shouldUpdateConfiguration() {
        ConfigurationDto configurationDto = ConfigurationDto.builder()
                .name("name")
                .value("val")
                .applicationName("app")
                .type(Type.STRING)
                .build();

        Configuration configuration = Configuration.builder()
                .id("id")
                .name("nameOld")
                .value("valOld")
                .applicationName("appOld")
                .type(Type.STRING)
                .build();
        when(configurationRepository.findOne("id")).thenReturn(configuration);

        configurationService.updateConfiguration("id", configurationDto);


        ArgumentCaptor<Configuration> captor = ArgumentCaptor.forClass(Configuration.class);
        verify(configurationRepository).save(captor.capture());

        Configuration savedConfig = captor.getValue();
        assertThat(savedConfig.getId(), equalTo("id"));
        assertThat(savedConfig.getName(), equalTo("name"));
        assertThat(savedConfig.getValue(), equalTo("val"));
        assertThat(savedConfig.getApplicationName(), equalTo("app"));
        assertThat(savedConfig.getType(), equalTo(Type.STRING));
    }

}