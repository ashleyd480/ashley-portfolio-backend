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

// We are mapping the entity to a DTO to render get-mapping
/* Essentially, this is looking through the attributes of the DTO and matching it to the attributes of the entity and then mapping the entity attribute's values to the respective attribute in the DTO */