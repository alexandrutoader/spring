package com.siit.spring.mapper;

import com.siit.spring.domain.entity.SingerEntity;
import com.siit.spring.domain.model.Singer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SingerToSingerEntityMapper implements Converter<Singer, SingerEntity> {

    @Override
    public SingerEntity convert(Singer source) {
        return SingerEntity.builder()
                           .firstName(source.getFirstName())
                           .birthDate(source.getBirthDate())
                           .build();
    }
}
