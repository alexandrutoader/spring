package com.siit.spring.mapper;

import com.siit.spring.domain.entity.SingerEntity;
import com.siit.spring.domain.model.Singer;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SingerEntityOnlyToSingerMapper implements Converter<SingerEntity, Singer> {
    @Override
    public Singer convert(SingerEntity source) {
        return Singer.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .birthDate(source.getBirthDate())
                .build();
    }
}
