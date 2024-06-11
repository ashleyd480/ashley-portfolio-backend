package com.example.portfoliobackend.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    @Autowired
    ModelMapper modelMapper;

    public <E, D> D map(E entity, Class<D> dtoClass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
        return modelMapper.map(entity, dtoClass);
    }
}
