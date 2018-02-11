package com.ty.configmanager.dto;

import com.ty.configmanager.model.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigurationDto {

    private String id;

    private String name;

    private String value;

    private Type type;

    private boolean active;

    private String applicationName;
}
