package com.ty.configmanager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.configmanager.model.Configuration;
import com.ty.configmanager.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class WebController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/")
    public String index(ModelMap modelMap) throws JsonProcessingException {
        List<Configuration> data = configurationService.findAll();
        modelMap.put("configurations", data);
        Map<String, Configuration> map = data.stream().collect(Collectors.toMap(e -> e.getId(), Function.identity()));
        modelMap.put("configurationJson", objectMapper.writeValueAsString(map));
        return "index";
    }
}
